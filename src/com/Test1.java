package com;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

public class Test1 {
    public int[] twoSum(int[] nums, int target) {
        int[] t=new int[2];
        for (int i = 0; i < nums.length-1;i++ ) {

            for (int j = i+1; j < nums.length; ++j) {

                if (nums[i]+nums[j]==target) {
                    t[0]=i;
                    t[1]=j;
                    return t;
                }
            }
        }
        return t;
    }
}
