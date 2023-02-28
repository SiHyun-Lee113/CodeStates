package com.example.codestates.Daily_Coding.Sort;

import java.util.Arrays;

public class RadixSort {
    static void countSort(int[] arr,int n,int exp) {
        int buffer[]=new int[n];
        int counting[]=new int[10];

        for(int i=0;i<n;i++) {
            counting[(arr[i]/exp)%10]++;
        }

        for(int i=1;i<=9;i++) counting[i]+=counting[i-1];

        for(int i=n-1;i>=0;i--) {
            int res=arr[i]/exp;
            res%=10;
            int idx=counting[res];
            buffer[idx-1]=arr[i];
            counting[res]--;
        }

        for(int i=0;i<n;i++) {
            arr[i]=buffer[i];
        }
    }

    static void radixSort2(int[] arr,int n) {
        int max=0;
        for(int i=0;i<n;i++) max=Math.max(max,arr[i]);

        for(int i=1; max/i>0;i*=10) {
            System.out.println(i+"의 자리에 대해 정렬합니다.");
            countSort(arr,n,i);
            System.out.println("정렬 결과");
            System.out.println(Arrays.toString(arr));
        }
    }
    public static void main(String[] args) {
        int[] arr= {222,96,123,1,23, 5, 2, 17, 28};
        radixSort2(arr,arr.length);
        System.out.println("최종 정렬 결과");
        System.out.println(Arrays.toString(arr));
    }
}
