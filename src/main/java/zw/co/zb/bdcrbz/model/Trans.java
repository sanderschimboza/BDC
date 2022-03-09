package zw.co.zb.bdcrbz.model;/*
 * This program was developed by Douglas Gweera (douglasgweera@gmail.com ) on Copyright (c) 2021.
 */

/*
 * This program was developed by Douglas Gweera (douglasgweera@gmail.com ) on Copyright (c) 2021.
 */

import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
public class Trans implements Serializable {

    @Id
    private String GZTREF;
    private String GZAB2;
    private String GZDRF2;
    private String GZNR6;
    private String GZAMA2;
    private String GZCCY2;
    private String SATSTP;
    private String PICKED;
    private String ID;
    private String DESCRIPTION;
    private String STATUSCODE;

    public Trans() {
    }

    public String getSTATUSCODE() {
        return STATUSCODE;
    }

    public void setSTATUSCODE(String STATUSCODE) {
        this.STATUSCODE = STATUSCODE;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getPICKED() {
        return PICKED;
    }

    public void setPICKED(String PICKED) {
        this.PICKED = PICKED;
    }

    public String getSATSTP() {
        return SATSTP;
    }

    public void setSATSTP(String SATSTP) {
        this.SATSTP = SATSTP;
    }

    public String getGZTREF() {
        return GZTREF;
    }

    public void setGZTREF(String GZTREF) {
        this.GZTREF = GZTREF;
    }

    public String getGZAB2() {
        return GZAB2;
    }

    public void setGZAB2(String GZAB2) {
        this.GZAB2 = GZAB2;
    }

    public String getGZDRF2() {
        return GZDRF2;
    }

    public void setGZDRF2(String GZDRF2) {
        this.GZDRF2 = GZDRF2;
    }

    public String getGZNR6() {
        return GZNR6;
    }

    public void setGZNR6(String GZNR6) {
        this.GZNR6 = GZNR6;
    }

    public String getGZAMA2() {
        return GZAMA2;
    }

    public void setGZAMA2(String GZAMA2) {
        this.GZAMA2 = GZAMA2;
    }

    public String getGZCCY2() {
        return GZCCY2;
    }

    public void setGZCCY2(String GZCCY2) {
        this.GZCCY2 = GZCCY2;
    }
}
