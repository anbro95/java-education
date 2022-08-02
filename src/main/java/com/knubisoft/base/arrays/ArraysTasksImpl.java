package com.knubisoft.base.arrays;

import java.util.*;

public class ArraysTasksImpl implements ArraysTasks {

    @Override
    public int[] reverse(int[] array) {
        int[] res = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            res[i] = array[array.length-1-i];
        }
        return res;
    } //

    @Override
    public int[] mergeArrays(int[] array1, int[] array2) {
        int[] res = new int[array1.length + array2.length];
        for (int i = 0; i < res.length; i++) {
            if(i < array1.length) {
                res[i] = array1[i];
            }
            if(i >= array1.length) {
                res[i] = array2[Math.abs(array1.length - i)];
            }
        }
        return res;
    } //

    @Override
    public int[] findMax3InArray(int[] array) {
        Arrays.sort(array);
        if(array.length < 3) return array;

        int[] res = new int[3];
        res[0] = array[array.length-1];
        res[1] = array[array.length-2];
        res[2] = array[array.length-3];

        return res;
    } //

    @Override
    public int findLongestIncreasingContinuesSubsequence(int[] array) {


        if(array.length == 0)
            return 0;
        else if(array.length == 1)
            return 1;

        int count = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length-1; i++) {
            if(array[i+1] <= array[i]) {
                count = 1;
            }
            if(array[i+1] > array[i]){
                count++;
                list.add(count);
            }
        }

        Collections.sort(list);
        if(list.size() >= 1)
            return list.get(list.size() - 1);
        else
            return 1;
    } //

    @Override
    public int sumOfAllUniqueElements(int[] array) {
        HashSet set = new HashSet();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if(set.add(array[i])) {
                list.add(array[i]);
            }
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    } //

    @Override
    public int[] moveZeroes(int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != 0) {
                if(index == i) {
                    index++;
                    continue;
                }
                array[index] = array[i];
                array[i] = 0;
                index++;
            }
        }
        return array;
    }  //

    @Override
    public int findFinalValue(int[] nums, int original) {
        boolean flag = false;
        do {
            flag = false;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == original) {
                    original *= 2;
                    flag = true;
                }
            }
        } while(flag);
        return original;
    }  //

    @Override
    public String longestCommonPrefix(String[] words) {
        if(words.length == 0) return "";
        String prefix = words[0];
        for(int i = 1; i < words.length; i++){
            while(words[i].indexOf(prefix) !=0)
                prefix = prefix.substring(0, prefix.length()-1);
        }
        return prefix;

    }  //

    @Override
    public int missingNumber(int[] array) {
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        int n = array.length;
        if(array[0] != 0) return 0;
        try{
            for (int i = 0; i < n; i++) {
                if (array[i + 1] - array[i] > 1) {
                    return array[i] + 1;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return n;
        }
        return -1;
    }  //

    @Override
    public boolean containsDuplicate(int[] array) {
        HashSet set = new HashSet();
        for(int el : array) {
            if(!set.add(el)) {
                return true;
            }
        }
        return false;
    }   //
}
