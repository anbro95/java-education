package com.knubisoft.base.string;

import java.util.*;

public class StringTasksImpl implements StringTasks {

    @Override
    public String reverseString(String original) {
        if(original == null) {
            throw new IllegalArgumentException();
        }
        char[] arr = original.toCharArray();
        char[] resarr = new char[arr.length];
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            resarr[i] = arr[arr.length - 1 - i];
            res += String.valueOf(resarr[i]);
        }

        return res;
    }  //

    @Override
    public String insertStringInMiddle(String original, String toInsert) {
        if(original == null || original.length() == 0 || toInsert == null || toInsert.length() == 0)
            throw new IllegalArgumentException();

        int index = original.length() / 2;
        int secindex = index;
        int toindex = 0;
        char[] res = new char[original.length() + toInsert.length()];
        for (int i = 0; i < res.length; i++) {
            if(i < secindex) {
                res[i] = original.charAt(i);
            } else if(i >= secindex && i < secindex+toInsert.length()) {
                res[i] = toInsert.charAt(toindex);
                toindex++;
            } else if(i == secindex + toInsert.length())
                res[i] = original.charAt(index);
            else if(i > secindex+toInsert.length()) {
                index++;
                res[i] = original.charAt(index);
            }
        }
        return String.valueOf(res);
    }     //

    @Override
    public String insertSymbolInString(String original, char toInsert, int position) {
        if(original == null || original == "" || position > original.length() || position < 0) {
            throw new IllegalArgumentException();
        }

        char[] arr = new char[original.length() + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i == position) {
                arr[i] = toInsert;
            } else if(i > position) {
                arr[i] = original.charAt(i-1);
            }else if(i < position)
                arr[i] = original.charAt(i);
        }

        return String.valueOf(arr);


    }  //

    @Override
    public String appendToString(StringBuilder original, String toAppend) {
        if(original == null || toAppend == null || original.isEmpty()) {
            throw new NoSuchElementException();
        }
        return original + toAppend;
    }  //

    @Override
    public boolean isPalindrome(String palindrome) {
        if(palindrome == null)
            throw new RuntimeException();

        String str = reverseString(palindrome);
        if(str.equals(palindrome))
            return true;
        else
            return false;
    }  //

    @Override
    public boolean hasLowerCase(String str) {
        if(str == null)
            throw new IllegalArgumentException();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= 65 && arr[i] <= 90)
                return false;
        }

        return true;
    }  //

    @Override
    public String uniqueCharacters(String str) {
        if(str == null)
            throw new IllegalArgumentException();
        else if(str == "")
            return str;

        str = str.toLowerCase();

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if(!set.add(String.valueOf(str.charAt(i)))) {
               str = str.replaceAll(String.valueOf(str.charAt(i)), " ");
            }
        }
        str = str.replaceAll(" ", "");
        return str;
    }  //

    @Override
    public String removeAllCharacters(String str, char charToRemove) {
        if(str == null)
            throw new IllegalArgumentException();

        return str.replace(String.valueOf(charToRemove), "" );
    }  //

    @Override
    public String toCamelCase(String str) {
        if(str == null || str == "")
            throw new IllegalArgumentException();
        char[] arr = str.toCharArray();
        String res = "";
        for(int i = 0; i < arr.length; i++) {
            if(arr[0] < 97)
                arr[i] += 32;
            if (arr[i] == '_' || arr[i] == '-' || arr[i] == ' ') {
                if (arr[i + 1] >= 97) {
                    arr[i + 1] -= 32;
                }
                continue;
            }
            res += String.valueOf(arr[i]);
        }
        return res;
    }  //

    @Override
        public String getCountRepeatableString(String str) {
        if(str == null) {
            throw new IllegalArgumentException();
        }

        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], 0);
        }

        for (int i = 0; i < arr.length; i++) {
            if(map.get(arr[i]) == 9) {
                map.put(arr[i], 0);
            }
            map.put(arr[i], 1 + map.get(arr[i]));
            String s = String.valueOf(map.get(arr[i]));
            arr[i] = s.charAt(0);
        }
        return String.valueOf(arr);
        }  //

    @Override
    public String sortStringCharactersAsc(String str) {
        if(str == null)
            throw new IllegalArgumentException();

        char[] arr = str.toCharArray();
        boolean isSorted = false;

        while(!isSorted) {
            isSorted = true;

            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i] > arr[i+1]) {
                    isSorted = false;
                    char temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }

        return String.valueOf(arr);
    }  //
}
