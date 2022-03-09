package zw.co.zb.bdcrbz.DTO;

import zw.co.zb.bdcrbz.model.MtaDetails;
import zw.co.zb.bdcrbz.model.Trans;
import zw.co.zb.bdcrbz.util.utils;

import java.io.Serializable;
import java.util.Optional;

public class AddRemittanceDto implements Serializable {
    private String bdxName;
    private String bdxBranch;
    private String transactionDate;
    private String apiUsername;
    private String password;
    private String operatorName;
    private String senderName;
    private String clientName;

    private String clientNationalId;
    private String clientGender;
    private AddressDto clientPhysicalAddress;
    private String district;

    private String currencyCode;
    private String sourceCountryCode;
    private String internationalPartnerCode;
    private String sourceCountryName;
    private String internationalPartnerName;
    private String sourceOfFundsCode;
    private String transactionPurposeCode;
    private String transferMode;
    private Long amount;
    private String originalReference;

    public AddRemittanceDto() {
    }


    public AddRemittanceDto(Trans trans, Optional<MtaDetails> mtaDetails, String BranchName) {

        AddressDto addressDto = new AddressDto();
        addressDto.setSuburb(mtaDetails.get().getRecAddress().trim());
        addressDto.setCity(mtaDetails.get().getRecAddress().trim());
        addressDto.setStreet(mtaDetails.get().getRecAddress().trim());


       // this.bdxName = "Test Bureau";//BranchName.trim();
    //    this.bdxBranch = "Newlands HQ";//BranchName.trim();;//trans.getGZAB2().trim();
     //   this.apiUsername = "munashe";
     //   this.password = "Venon?1986";


        this.bdxName = "ZB Bank Ltd";
        this.bdxBranch = "HQ";//BranchName.trim();;//trans.getGZAB2().trim();
        this.apiUsername = "zbadmin";
        this.password = "Admin@2022";

        this.transactionDate = utils.formatDate(trans.getSATSTP().trim());   //"2021-03-15T11:47:21.037000";//trans.getSATSTP().trim(); 2021-03-31 10:56:21.037000
        this.operatorName = mtaDetails.get().getUserId().trim();
        this.senderName = mtaDetails.get().getSenderName().trim();
        this.clientName = mtaDetails.get().getRecName().trim();
        this.clientNationalId = mtaDetails.get().getRecId().trim();
        this.clientGender = (mtaDetails.get().getRecGender() == "F") ? "FEMALE" : "MALE";
        this.clientPhysicalAddress = addressDto;
        this.district = "HARARE";
        this.currencyCode = "USD";
        this.sourceCountryCode = "USA";
        this.sourceCountryName = "United States of America";
        this.sourceOfFundsCode = utils.getPurpose(mtaDetails.get().getSourceOfFunds());
        this.transactionPurposeCode = utils.getPurpose(mtaDetails.get().getPurpose());
        this.transferMode = "CASH";
        this.amount = Long.parseLong(trans.getGZAMA2().trim());
        this.originalReference = trans.getGZTREF().trim();


        if (trans.getGZTREF().startsWith("T")) {

            this.internationalPartnerName = "World Remit";
            this.internationalPartnerCode = "WR";


        } else if (trans.getGZTREF().startsWith("R")) {
            this.internationalPartnerName = "ria";
            this.internationalPartnerCode = "RI";


        } else if (trans.getGZTREF().startsWith("MK")) {
            this.internationalPartnerName = "Mukuru";
            this.internationalPartnerCode = "MK";


        } else {
            this.internationalPartnerName = "MTA";
            this.internationalPartnerCode = "MTA";
        }
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOriginalReference() {
        return originalReference;
    }

    public void setOriginalReference(String originalReference) {
        this.originalReference = originalReference;
    }

    public String getBdxName() {
        return bdxName;
    }

    public void setBdxName(String bdxName) {
        this.bdxName = bdxName;
    }

    public String getBdxBranch() {
        return bdxBranch;
    }

    public void setBdxBranch(String bdxBranch) {
        this.bdxBranch = bdxBranch;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getApiUsername() {
        return apiUsername;
    }

    public void setApiUsername(String apiUsername) {
        this.apiUsername = apiUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientNationalId() {
        return clientNationalId;
    }

    public void setClientNationalId(String clientNationalId) {
        this.clientNationalId = clientNationalId;
    }

    public String getClientGender() {
        return clientGender;
    }

    public void setClientGender(String clientGender) {
        this.clientGender = clientGender;
    }

    public AddressDto getClientPhysicalAddress() {
        return clientPhysicalAddress;
    }

    public void setClientPhysicalAddress(AddressDto clientPhysicalAddress) {
        this.clientPhysicalAddress = clientPhysicalAddress;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getSourceCountryCode() {
        return sourceCountryCode;
    }

    public void setSourceCountryCode(String sourceCountryCode) {
        this.sourceCountryCode = sourceCountryCode;
    }

    public String getInternationalPartnerCode() {
        return internationalPartnerCode;
    }

    public void setInternationalPartnerCode(String internationalPartnerCode) {
        this.internationalPartnerCode = internationalPartnerCode;
    }

    public String getSourceCountryName() {
        return sourceCountryName;
    }

    public void setSourceCountryName(String sourceCountryName) {
        this.sourceCountryName = sourceCountryName;
    }

    public String getInternationalPartnerName() {
        return internationalPartnerName;
    }

    public void setInternationalPartnerName(String internationalPartnerName) {
        this.internationalPartnerName = internationalPartnerName;
    }

    public String getSourceOfFundsCode() {
        return sourceOfFundsCode;
    }

    public void setSourceOfFundsCode(String sourceOfFundsCode) {
        this.sourceOfFundsCode = sourceOfFundsCode;
    }

    public String getTransactionPurposeCode() {
        return transactionPurposeCode;
    }

    public void setTransactionPurposeCode(String transactionPurposeCode) {
        this.transactionPurposeCode = transactionPurposeCode;
    }

    public String getTransferMode() {
        return transferMode;
    }

    public void setTransferMode(String transferMode) {
        this.transferMode = transferMode;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
