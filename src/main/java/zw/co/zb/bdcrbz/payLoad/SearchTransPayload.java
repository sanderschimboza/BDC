package zw.co.zb.bdcrbz.payLoad;/*
 * This program was developed by Douglas Gweera (douglasgweera@gmail.com ) on Copyright (c) 2021.
 */

public class SearchTransPayload {

    private String startDate;
    private String endDate;
    private String Merchant;
    private String Branch;
    private String Status;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getMerchant() {
        return Merchant;
    }

    public void setMerchant(String merchant) {
        Merchant = merchant;
    }

    public String getStatus() {
        return Status;
    }

    public void setVendor(String status) {
        Status =  status;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }
}
