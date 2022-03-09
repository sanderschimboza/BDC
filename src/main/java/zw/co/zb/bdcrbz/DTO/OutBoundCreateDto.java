package zw.co.zb.bdcrbz.DTO;

import zw.co.zb.bdcrbz.model.Trans;

public class OutBoundCreateDto {
    private String originalReference;
    private String bdxName;
    private String bdxBranch;
    private String transactionDate;
    private String clerkUsername;
    private String password;
    private String senderName;
    private String senderNationalId;
    private AddressDto senderAddress;
    private String beneficiaryName;
    private String currencyCode;
    private String destinationCountryCode;
    private String internationalPartnerCode;
    private String destinationCountryName;
    private String internationalPartnerName;
    private String sourceOfFundsCode;
    private String transactionPurposeCode;
    private Long amount;
    private String transferMode;

    public OutBoundCreateDto() {
    }

    public OutBoundCreateDto(Trans trans, String BranchName){

        AddressDto addressDto = new AddressDto();
        addressDto.setSuburb("");
        addressDto.setCity("");
        addressDto.setStreet("");

        this.originalReference = trans.getGZTREF().trim();
        this.bdxName = BranchName.trim();
        this.bdxBranch =trans.getGZAB2().trim();
        this.transactionDate = trans.getSATSTP().trim();
        this.clerkUsername = clerkUsername;
        this.password = password;
        this.senderName = trans.getGZDRF2().trim();
        this.senderNationalId = trans.getGZNR6().trim();
        this.senderAddress = addressDto;
        this.beneficiaryName = beneficiaryName;
        this.currencyCode = trans.getGZCCY2().trim();
        this.destinationCountryCode = destinationCountryCode;
        this.internationalPartnerCode = internationalPartnerCode;
        this.destinationCountryName = destinationCountryName;
        this.internationalPartnerName = internationalPartnerName;
        this.sourceOfFundsCode = sourceOfFundsCode;
        this.transactionPurposeCode = transactionPurposeCode;
        this.amount = Long.parseLong(trans.getGZAMA2().trim());
        this.transferMode = "CASH";
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

    public String getClerkUsername() {
        return clerkUsername;
    }

    public void setClerkUsername(String clerkUsername) {
        this.clerkUsername = clerkUsername;
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

    public String getSenderNationalId() {
        return senderNationalId;
    }

    public void setSenderNationalId(String senderNationalId) {
        this.senderNationalId = senderNationalId;
    }

    public AddressDto getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(AddressDto senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getDestinationCountryCode() {
        return destinationCountryCode;
    }

    public void setDestinationCountryCode(String destinationCountryCode) {
        this.destinationCountryCode = destinationCountryCode;
    }

    public String getInternationalPartnerCode() {
        return internationalPartnerCode;
    }

    public void setInternationalPartnerCode(String internationalPartnerCode) {
        this.internationalPartnerCode = internationalPartnerCode;
    }

    public String getDestinationCountryName() {
        return destinationCountryName;
    }

    public void setDestinationCountryName(String destinationCountryName) {
        this.destinationCountryName = destinationCountryName;
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getTransferMode() {
        return transferMode;
    }

    public void setTransferMode(String transferMode) {
        this.transferMode = transferMode;
    }


}
