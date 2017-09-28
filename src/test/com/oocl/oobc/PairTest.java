package com.oocl.oobc;


import org.junit.Assert;
import org.junit.Test;

public class PairTest {
    @Test
    public void test(){
        Assert.assertTrue(1==1);
    }

    @Test
    public void should_return_10_when_given_10(){
        GoldLength length = new GoldLength(10);
        Assert.assertEquals(10,length.getValue());
    }

    @Test
    public void should_equal_when_given_10_10(){
        GoldLength length1 = new GoldLength(10);
        GoldLength length2 = new GoldLength(10);
        Assert.assertEquals(length1,length2);
    }

    @Test
    public void should_not_equal_when_given_9_10(){
        GoldLength length1 = new GoldLength(9);
        GoldLength length2 = new GoldLength(10);
        Assert.assertNotEquals(length1,length2);
    }
}
