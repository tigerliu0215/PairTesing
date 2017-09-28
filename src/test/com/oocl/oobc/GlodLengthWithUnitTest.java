package com.oocl.oobc;

import org.junit.Assert;
import org.junit.Test;

public class GlodLengthWithUnitTest {

    @Test
    public  void should_equals_when_given_10cm_10cm(){
        GoldLengthWithUnit goldLengthWithUnit1 = new GoldLengthWithUnit(10, "CM");
        GoldLengthWithUnit goldLengthWithUnit2 = new GoldLengthWithUnit(10, "CM");
        Assert.assertEquals(goldLengthWithUnit1, goldLengthWithUnit2);
    }

    @Test
    public  void should_not_equals_when_given_9cm_10cm(){
        GoldLengthWithUnit goldLengthWithUnit1 = new GoldLengthWithUnit(9, "CM");
        GoldLengthWithUnit goldLengthWithUnit2 = new GoldLengthWithUnit(10, "CM");
        Assert.assertNotEquals(goldLengthWithUnit1, goldLengthWithUnit2);
    }

    @Test(expected = RuntimeException.class)
    public  void should_throw_exception_when_given_10m_10cm(){
        GoldLengthWithUnit goldLengthWithUnit1 = new GoldLengthWithUnit(10, "M");
        GoldLengthWithUnit goldLengthWithUnit2 = new GoldLengthWithUnit(10, "CM");
        boolean isEqual = goldLengthWithUnit1.equals(goldLengthWithUnit2);
    }

    @Test(expected = RuntimeException.class)
    public  void should_throw_exception_when_given_negative1cm_negative1cm(){
        GoldLengthWithUnit goldLengthWithUnit1 = new GoldLengthWithUnit(-1, "CM");
        GoldLengthWithUnit goldLengthWithUnit2 = new GoldLengthWithUnit(-1, "CM");

    }
}
