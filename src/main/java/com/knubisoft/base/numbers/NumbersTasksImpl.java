package com.knubisoft.base.numbers;

import java.math.BigInteger;

public class NumbersTasksImpl implements NumbersTasks {

    @Override
    public void swapTwoNumbersWithoutUsingTemporaryVariable(int firstNumber, int secondNumber) {
        firstNumber = firstNumber + secondNumber;
        secondNumber = firstNumber - secondNumber;
        firstNumber = firstNumber - secondNumber;
    }  //

    @Override
    public boolean isUglyInt(int number) {
        if(isPrime(number)){
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if(number % i == 0 && isPrime(i)) {
                if(i != 2 && i != 3 && i != 5) {
                    return false;
                }
            }
        }
        return true;
    }  //

    @Override
    public int addDigits(int number) {

        int sum = number;
        while(sum / 10 >= 1) {
            String str = String.valueOf(sum);
            sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += Integer.parseInt(String.valueOf(str.charAt(i)));
            }
        }

        return sum;
    }  //

    @Override
    public boolean isHarshadNumber(int number) {
        if (number == 0) return false;
        String str = String.valueOf(number);
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        if(number % sum == 0)
            return true;
        else
            return false;
    }  //

    @Override
    public boolean isPrime(int number) {
        for (int i = 2; i <= number/2; i++) {
            if(i == number)
                continue;
            if(number % i == 0)
                return false;
        }

        return true;
    }   //

    @Override
    public boolean isArmstrongNumber(int number) {
        String str = String.valueOf(number);
        if(str.length() == 1)
            return true;

        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            sum += Math.pow(Integer.parseInt(String.valueOf(str.charAt(i))), 3);
        }


        if(sum == number)
            return true;
        else
            return false;
    }  //

    @Override
    public BigInteger factorial(int number) {
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 1; i <= number; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }

        return res;
    }  //

    @Override
    public boolean palindrome(int number) {
        char[] arr = String.valueOf(number).toCharArray();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[arr.length-1 - i];
        }

        int res = Integer.parseInt(String.valueOf(arr));
        if(res == number)
            return true;
        else
            return false;

    }   //

    @Override
    public boolean isAutomorphic(int number) {
        int sq = number * number;
        String n = String.valueOf(number);
        String s = String.valueOf(sq);

        if(s.charAt(s.length()-1) == n.charAt(n.length()-1))
            return true;
        else
            return false;
    }  //
}
