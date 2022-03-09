/*
 * Author :Kevin Gombe
 *  2021
 */

package zw.co.zb.bdcrbz.model;

/*
 * This program was developed by Douglas Gweera (douglasgweera@gmail.com ) on Copyright (c) 2021.
 */

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REFERENCENUMBER", nullable = false)
    private Long id;

    @Column(name = "ACCOUNTNUMBER")
    private String accountnumber;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "BRANCHCODE")
    private String branchcode;

    @Column(name = "CAPTURETIME")
    private String capturetime;

    @Column(name = "CHARGERESPONSECODE")
    private String chargeresponsecode;

    @Column(name = "COMMISSION")
    private Double commission;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "CUSTOMERBANKACCOUNT")
    private String customerbankaccount;

    @Column(name = "customerMobile", length = 64)
    private String customerMobile;

    @Column(name = "CUSTOMERNAME")
    private String customername;

    @Column(name = "CUSTOMERUTILITYACCOUNT")
    private String customerutilityaccount;

    @Column(name = "DEPOSITOR", length = 64)
    private String depositor;

    @Column(name = "EMAIL", length = 64)
    private String email;

    @Column(name = "MAINRESPONSECODE")
    private String mainresponsecode;

    @Column(name = "MERCHANTID")
    private String merchantid;

    @Column(name = "METHODOFPAYMENT")
    private String methodofpayment;

    @Column(name = "narrative", length = 600)
    private String narrative;

    @Column(name = "OPERATORID")
    private String operatorid;

    @Column(name = "PAYMENTDATE")
    private String paymentdate;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "TIMESTAMP")
    private String timestamp;

    @Column(name = "REQUESTTIME")
    private Instant requesttime;

    @Column(name = "RESPONSETIME")
    private Instant responsetime;

    @Column(name = "VENDORBRANCH")
    private String vendorbranch;

    @Column(name = "VENDORID")
    private String vendorid;

    @Column(name = "TERMINALID")
    private String terminalid;

    @Column(name = "cashAccount", length = 32)
    private String cashAccount;

    @Column(name = "invoicePeriod")
    private Integer invoicePeriod;

    @Column(name = "customerPaymentDetails1")
    private String customerPaymentDetails1;

    @Column(name = "customerPaymentDetails2")
    private String customerPaymentDetails2;

    @Column(name = "customerPaymentDetails3")
    private String customerPaymentDetails3;

    public String getCustomerPaymentDetails3() {
        return customerPaymentDetails3;
    }

    public void setCustomerPaymentDetails3(String customerPaymentDetails3) {
        this.customerPaymentDetails3 = customerPaymentDetails3;
    }

    public String getCustomerPaymentDetails2() {
        return customerPaymentDetails2;
    }

    public void setCustomerPaymentDetails2(String customerPaymentDetails2) {
        this.customerPaymentDetails2 = customerPaymentDetails2;
    }

    public String getCustomerPaymentDetails1() {
        return customerPaymentDetails1;
    }

    public void setCustomerPaymentDetails1(String customerPaymentDetails1) {
        this.customerPaymentDetails1 = customerPaymentDetails1;
    }

    public Integer getInvoicePeriod() {
        return invoicePeriod;
    }

    public void setInvoicePeriod(Integer invoicePeriod) {
        this.invoicePeriod = invoicePeriod;
    }

    public String getCashAccount() {
        return cashAccount;
    }

    public void setCashAccount(String cashAccount) {
        this.cashAccount = cashAccount;
    }

    public String getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(String terminalid) {
        this.terminalid = terminalid;
    }

    public String getVendorid() {
        return vendorid;
    }

    public void setVendorid(String vendorid) {
        this.vendorid = vendorid;
    }

    public String getVendorbranch() {
        return vendorbranch;
    }

    public void setVendorbranch(String vendorbranch) {
        this.vendorbranch = vendorbranch;
    }

    public Instant getResponsetime() {
        return responsetime;
    }

    public void setResponsetime(Instant responsetime) {
        this.responsetime = responsetime;
    }

    public Instant getRequesttime() {
        return requesttime;
    }

    public void setRequesttime(Instant requesttime) {
        this.requesttime = requesttime;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(String paymentdate) {
        this.paymentdate = paymentdate;
    }

    public String getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(String operatorid) {
        this.operatorid = operatorid;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getMethodofpayment() {
        return methodofpayment;
    }

    public void setMethodofpayment(String methodofpayment) {
        this.methodofpayment = methodofpayment;
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }

    public String getMainresponsecode() {
        return mainresponsecode;
    }

    public void setMainresponsecode(String mainresponsecode) {
        this.mainresponsecode = mainresponsecode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepositor() {
        return depositor;
    }

    public void setDepositor(String depositor) {
        this.depositor = depositor;
    }

    public String getCustomerutilityaccount() {
        return customerutilityaccount;
    }

    public void setCustomerutilityaccount(String customerutilityaccount) {
        this.customerutilityaccount = customerutilityaccount;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerbankaccount() {
        return customerbankaccount;
    }

    public void setCustomerbankaccount(String customerbankaccount) {
        this.customerbankaccount = customerbankaccount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public String getChargeresponsecode() {
        return chargeresponsecode;
    }

    public void setChargeresponsecode(String chargeresponsecode) {
        this.chargeresponsecode = chargeresponsecode;
    }

    public String getCapturetime() {
        return capturetime;
    }

    public void setCapturetime(String capturetime) {
        this.capturetime = capturetime;
    }

    public String getBranchcode() {
        return branchcode;
    }

    public void setBranchcode(String branchcode) {
        this.branchcode = branchcode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}