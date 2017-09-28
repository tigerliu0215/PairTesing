package com.oocl.oobc;

import org.junit.Assert;
import org.junit.Test;

public class GoldLengthMultiUnitTest {

    @Test
    public void should_equal_when_given_10CM_10CM(){
        GoldLengthMultiUnit goldLengthMultiUnit1 = new GoldLengthMultiUnit(10,"CM");
        GoldLengthMultiUnit goldLengthMultiUnit2 = new GoldLengthMultiUnit(10,"CM");
        Assert.assertEquals(goldLengthMultiUnit1,goldLengthMultiUnit2);
    }
    @Test
    public void should_equal_when_given_10DM_10DM(){
        GoldLengthMultiUnit goldLengthMultiUnit1 = new GoldLengthMultiUnit(10,"DM");
        GoldLengthMultiUnit goldLengthMultiUnit2 = new GoldLengthMultiUnit(10,"DM");
        Assert.assertEquals(goldLengthMultiUnit1,goldLengthMultiUnit2);
    }
    @Test
    public void should_equal_when_given_10M_10M(){
        GoldLengthMultiUnit goldLengthMultiUnit1 = new GoldLengthMultiUnit(10,"M");
        GoldLengthMultiUnit goldLengthMultiUnit2 = new GoldLengthMultiUnit(10,"M");
        Assert.assertEquals(goldLengthMultiUnit1,goldLengthMultiUnit2);
    }

    @Test
    public void should_not_equal_when_given_1CM_1M(){
        GoldLengthMultiUnit goldLengthMultiUnit1 = new GoldLengthMultiUnit(1,"CM");
        GoldLengthMultiUnit goldLengthMultiUnit2 = new GoldLengthMultiUnit(1,"M");
        Assert.assertNotEquals(goldLengthMultiUnit1,goldLengthMultiUnit2);
    }

    @Test
    public void should_not_equal_when_given_1CM_1DM(){
        GoldLengthMultiUnit goldLengthMultiUnit1 = new GoldLengthMultiUnit(1,"CM");
        GoldLengthMultiUnit goldLengthMultiUnit2 = new GoldLengthMultiUnit(1,"DM");
        Assert.assertNotEquals(goldLengthMultiUnit1,goldLengthMultiUnit2);
    }

    @Test
    public void should_not_equal_when_given_1DM_1M(){
        GoldLengthMultiUnit goldLengthMultiUnit1 = new GoldLengthMultiUnit(1,"DM");
        GoldLengthMultiUnit goldLengthMultiUnit2 = new GoldLengthMultiUnit(1,"M");
        Assert.assertNotEquals(goldLengthMultiUnit1,goldLengthMultiUnit2);
    }

    @Test
    public void should_equal_when_given_10CM_1DM(){
        GoldLengthMultiUnit goldLengthMultiUnit1 = new GoldLengthMultiUnit(10,"CM");
        GoldLengthMultiUnit goldLengthMultiUnit2 = new GoldLengthMultiUnit(1,"DM");
        Assert.assertEquals(goldLengthMultiUnit1,goldLengthMultiUnit2);
    }

    @Test
    public void should_equal_when_given_100CM_1M(){
        GoldLengthMultiUnit goldLengthMultiUnit1 = new GoldLengthMultiUnit(100,"CM");
        GoldLengthMultiUnit goldLengthMultiUnit2 = new GoldLengthMultiUnit(1,"M");
        Assert.assertEquals(goldLengthMultiUnit1,goldLengthMultiUnit2);
    }

    @Test
    public void should_equal_when_given_10DM_1M(){
        GoldLengthMultiUnit goldLengthMultiUnit1 = new GoldLengthMultiUnit(10,"DM");
        GoldLengthMultiUnit goldLengthMultiUnit2 = new GoldLengthMultiUnit(1,"M");
        Assert.assertEquals(goldLengthMultiUnit1,goldLengthMultiUnit2);
    }

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_given_negative1CM_negative1CM(){
        GoldLengthMultiUnit goldLengthMultiUnit1 = new GoldLengthMultiUnit(-1,"CM");
        GoldLengthMultiUnit goldLengthMultiUnit2 = new GoldLengthMultiUnit(-1,"CM");
    }

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_given_100MM_100MM(){
        GoldLengthMultiUnit goldLengthMultiUnit1 = new GoldLengthMultiUnit(100,"MM");
        GoldLengthMultiUnit goldLengthMultiUnit2 = new GoldLengthMultiUnit(100,"MM");
    }

}
