package zw.co.zb.bdcrbz.controller;/*
 * This program was developed by Douglas Gweera (douglasgweera@gmail.com ) on Copyright (c) 2021.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zw.co.zb.bdcrbz.model.Trans;
import zw.co.zb.bdcrbz.payLoad.SearchTransPayload;
import zw.co.zb.bdcrbz.repository.TIPSRepo.BranchcodeRepository;
import zw.co.zb.bdcrbz.repository.TIPSRepo.TIPSRepository;
import zw.co.zb.bdcrbz.repository.TIPSRepo.TransRepository;


import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
public class RestController {


    private static final Logger log = LoggerFactory.getLogger(RestController.class);

    private BranchcodeRepository branchcodeRepository;
    private TransRepository transRepository;
    private TIPSRepository tipsRepository;

    @Autowired
    public RestController(BranchcodeRepository branchcodeRepository, TransRepository transRepository, TIPSRepository tipsRepository) {
        this.branchcodeRepository = branchcodeRepository;
        this.transRepository = transRepository;
        this.tipsRepository = tipsRepository;
    }

    @CrossOrigin()
    @RequestMapping(value = "/getTrans", method = RequestMethod.GET)
    public List<Trans> fetchAllTransactions() throws Exception {
        List<Trans> transList = transRepository.findAll();

        return transList;
    }

    @CrossOrigin()
    @RequestMapping(value = "/getSomeTrans", method = RequestMethod.POST)
    public List<Trans> fetchTransactions(@RequestBody SearchTransPayload search) throws Exception {

        List<Trans> transList = transRepository.findAllBySATSTPBetween(search.getStartDate(), search.getEndDate());
        log.info("Received startDate :::::::" + search.getStartDate() + "endDate is:::::::::" + search.getEndDate() + "    Number od ftransactions:::" + transList.size());
        return transList;
    }


}
