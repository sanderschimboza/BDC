package zw.co.zb.bdcrbz.model;

/*
 * This program was developed by Douglas Gweera (douglasgweera@gmail.com ) on Copyright (c) 2021.
 */

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MtaDetails {
    private String transref;
    private String tdate;
    private String sourceOfFunds;
    private String purpose;
    private String recName;
    private String recId;
    private String recGender;
    private String recAddress;
    private String senderName;
    private String reference;
    private String userId;

    @Basic
    @Column(name = "Transref")
    public String getTransref() {
        return transref;
    }

    public void setTransref(String transref) {
        this.transref = transref;
    }

    @Basic
    @Column(name = "Tdate")
    public String getTdate() {
        return tdate;
    }

    public void setTdate(String tdate) {
        this.tdate = tdate;
    }

    @Basic
    @Column(name = "SourceOfFunds")
    public String getSourceOfFunds() {
        return sourceOfFunds;
    }

    public void setSourceOfFunds(String sourceOfFunds) {
        this.sourceOfFunds = sourceOfFunds;
    }

    @Basic
    @Column(name = "Purpose")
    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Basic
    @Column(name = "RecName")
    public String getRecName() {
        return recName;
    }

    public void setRecName(String recName) {
        this.recName = recName;
    }

    @Basic
    @Column(name = "RecID")
    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    @Basic
    @Column(name = "RecGender")
    public String getRecGender() {
        return recGender;
    }

    public void setRecGender(String recGender) {
        this.recGender = recGender;
    }

    @Basic
    @Column(name = "RecAddress")
    public String getRecAddress() {
        return recAddress;
    }

    public void setRecAddress(String recAddress) {
        this.recAddress = recAddress;
    }

    @Basic
    @Column(name = "SenderName")
    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    @Id
    @Column(name = "Reference")
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Basic
    @Column(name = "UserId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
