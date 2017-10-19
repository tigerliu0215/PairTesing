package com.oocl.oobc;

public class GoldLengthWithUnit {
    private int value;
    private String unit;

    public GoldLengthWithUnit(int value, String unit) {
        if (value <= 0) {
            throw new RuntimeException("Length cannot be negative.");
        }
        this.value = value;
        this.unit = unit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoldLengthWithUnit that = (GoldLengthWithUnit) o;
        if (!unit.equals(that.unit)) {
            throw new RuntimeException("Can not compare with different unit.");
        }
        if (value != that.value) return false;
        return unit != null ? unit.equals(that.unit) : that.unit == null;
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }
}
