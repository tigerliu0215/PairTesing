package com.oocl.oobc;

public class GoldLength {


    private int value;

    public GoldLength(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getValue() == ((GoldLength)obj).getValue();
    }

    @Override
    public int hashCode() {
        return this.getValue()*10;
    }
}
