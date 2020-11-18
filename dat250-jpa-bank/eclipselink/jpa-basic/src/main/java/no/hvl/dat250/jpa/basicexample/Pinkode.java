package no.hvl.dat250.jpa.basicexample;

import javax.persistence.Embeddable;

@Embeddable
public class Pinkode {
    private String pincode;
    private int count;

    public Pinkode() {

    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

