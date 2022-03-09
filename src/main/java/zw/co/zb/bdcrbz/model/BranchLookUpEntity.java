package zw.co.zb.bdcrbz.model;

/*
 * This program was developed by Douglas Gweera (douglasgweera@gmail.com ) on Copyright (c) 2021.
 */

import javax.persistence.*;

@Entity
@Table(name = "branchLookUp")
public class BranchLookUpEntity {
    private String brcode;
    private String brname;

    @Id
    @Column(name = "BRCODE")
    public String getBrcode() {
        return brcode;
    }

    public void setBrcode(String brcode) {
        this.brcode = brcode;
    }

    @Basic
    @Column(name = "BRNAME")
    public String getBrname() {
        return brname;
    }

    public void setBrname(String brname) {
        this.brname = brname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BranchLookUpEntity that = (BranchLookUpEntity) o;

        if (brcode != null ? !brcode.equals(that.brcode) : that.brcode != null) return false;
        if (brname != null ? !brname.equals(that.brname) : that.brname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = brcode != null ? brcode.hashCode() : 0;
        result = 31 * result + (brname != null ? brname.hashCode() : 0);
        return result;
    }
}
