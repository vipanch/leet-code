//package com.min.strings;
//
//public class MedianOfSorted {
//    public int getMedian(int[] x, int[] y){
//        //lets say x, y!=null
//        int size1 = x.length;
//        int size2 = y.length;
//
//        //size1+size2 == odd => ans is (size1+size2+1)/2 biggest;  2, 3 --> 3rd biggest
//        //size1+size2 == even => ans is (size1+size2)/2 biggest;    2, 2 --> 2nd biggest
//
//        return getNthBiggest(x, y, 0, size1-1, 0, size2-1,  (size1+size2)/2);
//    }
//
//    private int getNthBiggest(int[] arr1, int[] arr2, int i1, int j1, int i2, int j2, int n){
//        //if i1==j1  => return arr2[i2+n];
//        //if i2==j2  => return arr1[i1+n];
//
//
//        // 3 4 5 6 7 8 9 10 11 12
//        // 10 12 14 16
//
//        int x[] = {2, 4, 5, 6, 8, 9, 10, 12 ,14, 15, 16};  //M
//        int y[] = {3, 7, 13, 17, 5, 12, 21, 22, 24, 26};    //N
//
//
//    }
//}
//
