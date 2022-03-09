package zw.co.zb.bdcrbz.DTO;

/*
 * This program was developed by Douglas Gweera (douglasgweera@gmail.com ) on Copyright (c) 2021.
 */

public class Sort {
    private Boolean sorted;
    private Boolean  unsorted;
    private Boolean  empty;

    public Sort() {
    }

    public Boolean getSorted() {
        return sorted;
    }

    public void setSorted(Boolean sorted) {
        this.sorted = sorted;
    }

    public Boolean getUnsorted() {
        return unsorted;
    }

    public void setUnsorted(Boolean unsorted) {
        this.unsorted = unsorted;
    }

    public Boolean getEmpty() {
        return empty;
    }

    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }
}
