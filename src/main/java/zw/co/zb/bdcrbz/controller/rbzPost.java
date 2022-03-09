package zw.co.zb.bdcrbz.controller;
/*
 * This program was developed by Douglas Gweera (douglasgweera@gmail.com ) on Copyright (c) 2021.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import zw.co.zb.bdcrbz.DTO.AddRemittanceDto;
import zw.co.zb.bdcrbz.DTO.RestResponse;
import zw.co.zb.bdcrbz.model.BranchLookUpEntity;
import zw.co.zb.bdcrbz.model.MtaDetails;
import zw.co.zb.bdcrbz.model.Payment;
import zw.co.zb.bdcrbz.model.Trans;
import zw.co.zb.bdcrbz.repository.OnlineRepo.OnlineRepository;
import zw.co.zb.bdcrbz.repository.TIPSRepo.BranchcodeRepository;
import zw.co.zb.bdcrbz.repository.TIPSRepo.MTARepository;
import zw.co.zb.bdcrbz.repository.TIPSRepo.TIPSRepository;
import zw.co.zb.bdcrbz.repository.TIPSRepo.TransRepository;
import zw.co.zb.bdcrbz.util.DateParser;

import java.util.List;
import java.util.Optional;

import static zw.co.zb.bdcrbz.util.utils.doPost;

@Controller
@EnableScheduling
public class rbzPost {

    private final BranchcodeRepository branchcodeRepository;
    private final TransRepository transRepository;
    private final TIPSRepository tipsRepository;
    private final OnlineRepository onlineRepository;
    private final MTARepository mtaRepository;

    private static final Logger log = LoggerFactory.getLogger(rbzPost.class);

    Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    @Autowired
    public rbzPost(BranchcodeRepository branchcodeRepository, TransRepository transRepository, TIPSRepository tipsRepository,
                   OnlineRepository onlineRepository, MTARepository mtaRepository) {

        this.branchcodeRepository = branchcodeRepository;
        this.transRepository = transRepository;
        this.tipsRepository = tipsRepository;
        this.onlineRepository = onlineRepository;
        this.mtaRepository = mtaRepository;
    }

    @Scheduled(fixedDelay = 5000)
    void pickAndPostTransactions() throws Exception {

        List<Trans> transactionList = transRepository.findAllByPICKED("N");

        log.info("Picked transactions to RBZ :::::{}", transactionList.size());

        for (Trans trans : transactionList) {

            String branchName = findBranchName(trans.getGZAB2());

            long referenceNumber = Long.parseLong(trans.getGZTREF().trim().substring(4, 12));

            if (trans.getGZTREF().trim().startsWith("T000") || trans.getGZTREF().trim().startsWith("MK") || trans.getGZTREF().trim().startsWith("R")) {

                if (trans.getGZTREF().trim().startsWith("T000")) {

                    try {
                        //   referenceNumber = Long.parseLong(trans.getGZTREF().trim().substring(4, 12));

                        log.info("WORLD REMIT Payment Object REF:::: {}", referenceNumber);

                        Optional<Payment> optionalPayment = onlineRepository.findByIdAndStatusEquals(referenceNumber, "Successful");

                        if (optionalPayment.isPresent()) {

                            log.info("WR DATA FOUND:::::: {}", optionalPayment.get().getId());

                            MtaDetails mtaDetails = new MtaDetails();

                            String purpose = optionalPayment.get().getCustomerPaymentDetails3().split("\\|")[2].trim();
                            String recAdd = optionalPayment.get().getCustomerPaymentDetails3().split("\\|")[3].trim();
                            String gender = optionalPayment.get().getCustomerPaymentDetails3().split("\\|")[0].trim();
                            String senderName = optionalPayment.get().getCustomerPaymentDetails3().split("\\|")[5].trim();
                            String source = optionalPayment.get().getCustomerPaymentDetails3().split("\\|")[1].trim();
                            String date = optionalPayment.get().getTimestamp();

                            mtaDetails.setTransref("T000" + optionalPayment.get().getId());
                            mtaDetails.setPurpose(purpose);
                            mtaDetails.setRecAddress(recAdd);
                            mtaDetails.setRecGender(gender);
                            mtaDetails.setRecId(optionalPayment.get().getCustomerMobile());
                            mtaDetails.setRecName(optionalPayment.get().getCustomername());
                            mtaDetails.setSenderName(senderName);
                            mtaDetails.setSourceOfFunds(source);
                            mtaDetails.setTdate(DateParser.getParsedDate(date));
                            mtaDetails.setUserId(optionalPayment.get().getOperatorid());
                            mtaDetails.setReference("T000" + optionalPayment.get().getId());

                            mtaRepository.save(mtaDetails);

                        }

                    } catch (Exception e) {
                        log.error("There was an error:::: {}", e.getMessage());
                    }

                } else if (trans.getGZTREF().trim().startsWith("R00000")) {

                    try {
                        referenceNumber = Long.parseLong(trans.getGZTREF().trim().substring(6, 14));

                        log.info("RIA Payment Object REF::::: {}", referenceNumber);

                        Optional<Payment> optionalPayment = onlineRepository.findByIdAndStatusEquals(referenceNumber, "Successful");

                        if (optionalPayment.isPresent()) {
                            log.info("RIA DATA FOUND:::::: {}", optionalPayment.get().getId());

                            MtaDetails riaDetails = new MtaDetails();

                            String purpose = optionalPayment.get().getCustomerPaymentDetails1().split("\\|")[2].trim();
                            String gender = optionalPayment.get().getCustomerPaymentDetails1().split("\\|")[3].trim();
                            String senderName = optionalPayment.get().getCustomerPaymentDetails2().split("\\|")[0].trim() + " " + optionalPayment.get().getCustomerPaymentDetails2().split("\\|")[1].trim();
                            String source = optionalPayment.get().getCustomerPaymentDetails1().split("\\|")[1].trim();
                            String date = optionalPayment.get().getTimestamp();

                            riaDetails.setTransref("R00000" + optionalPayment.get().getId());
                            riaDetails.setPurpose(purpose);
                            riaDetails.setRecAddress(optionalPayment.get().getCustomerMobile());
                            riaDetails.setRecGender(gender);
                            riaDetails.setRecId(optionalPayment.get().getCustomerPaymentDetails3());
                            riaDetails.setRecName(optionalPayment.get().getCustomername());
                            riaDetails.setSenderName(senderName);
                            riaDetails.setSourceOfFunds(source);
                            riaDetails.setTdate(DateParser.getParsedDate(date));
                            riaDetails.setUserId(optionalPayment.get().getOperatorid());
                            riaDetails.setReference("R00000" + optionalPayment.get().getId());

                            mtaRepository.save(riaDetails);
                        }

                    } catch (Exception e) {
                        log.error("There was an error trying to locate this RIA trans from Online DB::::::: {}", trans.getGZTREF());
                    }
                }

                Optional<MtaDetails> optionalMtaDetails = tipsRepository.getByTransref(trans.getGZTREF().trim());

                if (optionalMtaDetails.isPresent()) {

                    AddRemittanceDto dto = new AddRemittanceDto(trans, optionalMtaDetails, branchName);

                    String data = gson.toJson(dto);

                    log.info("Going to Post the following : {}", trans.getGZTREF().trim() + "\n" + data);
                    String responseBody = doPost(data);

                    if (responseBody != null) {

                        RestResponse restResponse = gson.fromJson(responseBody, RestResponse.class);
                        trans.setDESCRIPTION(restResponse.getDescription());
                        trans.setSTATUSCODE("" + restResponse.getStatusCode());
                        trans.setID("" + restResponse.getModel().getId());
                        trans.setPICKED("Y");
                    }

                    log.info("RBZ Response Body: {}", responseBody);

                } else {
                    log.info("Failed to Post the following....Mta details not found from TIPS MTA Details Table:::: {}", trans.getGZTREF().trim());
                }
                transRepository.saveAndFlush(trans);

             //   dressFailedTrans(referenceNumber, trans);
            }
        }
    }

    private String findBranchName(String branchCode) {

        Optional<BranchLookUpEntity> branch = this.branchcodeRepository.findById(branchCode);

        if (branch.isPresent()) {
            return branch.get().getBrname();

        } else {
            BranchLookUpEntity branchLookUpEntity = new BranchLookUpEntity();
            branchLookUpEntity.setBrcode(branchCode);
            branchLookUpEntity.setBrname("WEST END");

            branchcodeRepository.save(branchLookUpEntity);
            return branchLookUpEntity.getBrname();
        }
    }

    public void dressFailedTrans(Long ref, Trans tran) {

        Optional<Payment> failedTrans = onlineRepository.findByIdAndStatusEquals(ref, "Failed");

        if (failedTrans.isPresent()) {

            Optional<Trans> trans = transRepository.findById(tran.getGZTREF());

            if (trans.isPresent()) {

                log.info("Updating Failed Transaction:::::: {}", tran.getGZTREF());

                Trans failedTransaction = new Trans();
                failedTransaction.setGZTREF(tran.getGZTREF());
                failedTransaction.setPICKED("YN");
                failedTransaction.setSTATUSCODE("400");
                failedTransaction.setGZAB2(tran.getGZAB2());
                failedTransaction.setGZAMA2(tran.getGZAMA2());
                failedTransaction.setGZCCY2(tran.getGZCCY2());
                failedTransaction.setID(tran.getID());
                failedTransaction.setSATSTP(tran.getSATSTP());
                failedTransaction.setGZNR6(tran.getGZNR6());
                failedTransaction.setGZDRF2(tran.getGZDRF2());
                failedTransaction.setID(tran.getID());
                failedTransaction.setDESCRIPTION("Transaction failed on Online Transaction");

                transRepository.save(failedTransaction);
            }

        }
    }

}



