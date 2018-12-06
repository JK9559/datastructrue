package com.wkang.ds;

import java.util.*;

/**
 * @author kangwei
 * @date 2018/12/3
 */
public class Structure001 {
    public static void main(String[] args) {
        System.out.println("hello world");
        int[] a = {1,2,4};
        int[] b = {4,2,1};
        Arrays.sort(b);
        System.out.println(Arrays.binarySearch(b,4));
        System.out.println(Arrays.equals(a,b));
        HashMap<Integer,String> map = new HashMap<Integer, String>(16);
        map.put(1,"abc");

    }
}
