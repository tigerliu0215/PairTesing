package com.oocl.oobc;

public class GoldLengthMultiUnit {

    private int value;
    private String unit;


    public GoldLengthMultiUnit(int value, String unit) {
        if(UnitEnum.valueOf(unit) == null){
            throw new RuntimeException("Unit just support CM,DM,M");
        }
        if(value <= 0 ){
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

        GoldLengthMultiUnit that = (GoldLengthMultiUnit) o;

        int thatValue = transferUnit(that.value, that.unit);
        int thisValue = transferUnit(this.value, this.unit);

        if (thatValue != thisValue) return false;
        return  true;
    }

    @Override
    public int hashCode() {
       return  value * 31;
    }

    private int transferUnit(int value, String unit){
        if(unit.equals(UnitEnum.CM.toString())){
            return value;
        }else if(unit.equals(UnitEnum.DM.toString())){
            return value * 10;
        }else {
            return value * 100;
        }
    }
}
