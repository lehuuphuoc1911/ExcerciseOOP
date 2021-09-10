package com.classesexcercise;

public class Main {
    public static void main(String[] args){
        Account acc1 = new Account(100);
        Account acc2 = new Account(1000);
        acc1.withdrawMoney(123);
        acc1.sendMoneyToAccount(acc2, 999);
        System.out.println(acc1.toString());
        System.out.println(acc2.toString());
    }
}
