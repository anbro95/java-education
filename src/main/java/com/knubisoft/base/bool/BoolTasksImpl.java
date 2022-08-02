package com.knubisoft.base.bool;

import java.util.Random;

public class BoolTasksImpl implements BoolTasks {

    @Override
    public Boolean isTrueAutobox(boolean value) {
        Boolean res = value;
        if(res)
            return res;
        else
            return false;
    }  //

    @Override
    public Boolean isFalseAutobox(boolean value) {
        Boolean res = value;
        if(!res)
            return res;
        else
            return true;
    }  //

    @Override
    public boolean isTrueUnbox(Boolean value) {
        boolean res = value;
        if(value)
            return value;
        else
            return false;
    }  //

    @Override
    public Boolean isFalseUnbox(boolean value) {
        boolean res = value;
        if(!res)
            return res;
        else
            return true;
    }   //

    @Override
    public boolean andFunction(int digit, String string) {

        try{
            if (Integer.parseInt(string) == digit)
                return true;
            else
                return false;
        } catch(NumberFormatException e) {
            return false;
        }
    }  //

    @Override
    public boolean orFunction(int digit, String string) {
        if(string == null || string == " ") return false;
        try{
            if (digit == Integer.parseInt(string)) {
                return true;
            } else
                return false;
        } catch(NumberFormatException e) {
            return false;
        }
    }  //

    @Override
    public boolean andComplexFunction(int generatedFirstDigit, double generatedSecondDigit, int range) {
        Random rand = new Random();
        int a = rand.nextInt(range);

        if(generatedFirstDigit == a && Math.floor(generatedSecondDigit) == a) {
            return true;
        } else
            return false;
    }  //

    @Override
    public boolean orComplexFunction(int generatedFirstDigit, double generatedSecondDigit, int generatedThirdDigit, int range) {
        if(generatedFirstDigit == Math.floor(generatedSecondDigit) && generatedFirstDigit == generatedThirdDigit)
            return true;
        else
            return false;
    }  //

    @Override
    public boolean isSameSizeArray(Object[] firstArray, Object... secondArray) {
        if(firstArray == null || secondArray == null) return false;
        if(firstArray.length == secondArray.length)
            return true;
        else
            return false;
    }  //

    @Override
    public boolean isSameCharactersCount(String username, String name, int maxLength) {
        if(username == null || name == null || username.length() == 0 || name.length() == 0 || maxLength == 0 )
            return false;

        if(username.length() == name.length() && name.length() <= maxLength)
            return true;
        else
            return false;
    }  //
}
