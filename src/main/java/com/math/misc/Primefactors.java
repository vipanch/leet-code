package com.math.misc;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Primefactors {
    public List<Integer> getPrimefactors(int N){
        List<Integer> res = new ArrayList<>();
        int i=2;
        while(N>1){
            if(N%i==0){
                res.add(i);
                N = N/i;
            }
            else
                i++;
        }
        res.add(1);
        return res;
    }

    @Test
    public void test(){
        List<Integer> res1 = getPrimefactors(1);
        Assert.assertEquals(res1.size(), 1);
        Assert.assertEquals(res1.get(0), new Integer(1));

        res1 = getPrimefactors(20);
        Assert.assertTrue(res1.contains(5));
        Assert.assertTrue(!res1.contains(4));


    }
}
