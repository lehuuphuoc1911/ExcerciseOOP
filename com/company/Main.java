package com.company;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        System.out.print("Please, enter integer numbers separated by space: ");

        String numbers = sc.nextLine();
        int[] intArray = StrArraytoIntArray(numbers.split(" "));
        int maxInt = findMaxIntInArray(intArray);
        System.out.println("*** Initial Array ***");
        System.out.println(Arrays.toString(intArray));
        System.out.println("*** Max number in array ***");
        System.out.println(maxInt);
    }
    public static int findMaxIntInArray(int[] intArray) {
		int maxInt=0;
		for (int i = 0; i<intArray.length;i++){
		    if(intArray[i]>maxInt){
		        maxInt=intArray[i];
            }
        }
		return  maxInt;
    }
    public static int[] StrArraytoIntArray(String[] strArray){
        int[] intArray = new int[strArray.length];
        for(int i = 0; i<strArray.length; i++){
            intArray[i]= Integer.valueOf(strArray[i]);
        }
        return intArray;
    }
}
