package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class EmptyRectangle {
    public static void main(String[] args) {

        /*Scanner sc = new Scanner(System.in);
        System.out.print("Please, enter height of rectangle: ");
        int height = sc.nextInt();
        System.out.print("Please, enter width of rectangle: ");
        int width = sc.nextInt();

        drawRectangle(height, width);

        /////////////////////////////////////////////////

        Scanner sc2 = new Scanner(System.in);
        System.out.print("Please, enter any text: ");
        String str = sc2.nextLine();
        int amountOfWords = getWordsAmount(str);

        System.out.println("Amount of words in your text: " + amountOfWords);


        ///////////////////////////////////////////////*/

        /*Scanner sc = new Scanner(System.in);
        System.out.print("Please, enter any words separated by space: ");
        String userInput = sc.nextLine();
        System.out.print("Please, enter minumum word length to filter words: ");
        int minLength = sc.nextInt();

        String[] words = userInput.split("\\s+");
        String[] filteredWords = filterWordsByLength(minLength, words);
        System.out.println(Arrays.toString(filteredWords));*/
        //////////////////////////////////////////////////////////////////////
        /*Scanner sc = new Scanner(System.in);
        System.out.print("Please, enter length of initial array: ");
        int baseArrayLength = sc.nextInt();
        int[] arr = generateRandomArray(baseArrayLength);
        int[] extendedArray = extendArray(arr);
        System.out.println("*** Initial array ***");
        System.out.println(Arrays.toString(arr));
        System.out.println("*** Extended array ***");
        System.out.println(Arrays.toString(extendedArray));*/
        /////////////////////////////////////////////////
        Scanner sc = new Scanner(System.in);
        System.out.print("Please, enter two numbers separated by space: ");
        String userInput = sc.nextLine();

        String[] inputArgumentsArray = userInput.split(" ");
        int number1 = Integer.parseInt(inputArgumentsArray[0]);
        int number2 = Integer.parseInt(inputArgumentsArray[1]);

        System.out.println(gcdRecursive(number1, number2));
    }

    public static String[] filterWordsByLength(int minLength, String[] words) {
        /*String[] filteredArray = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= minLength) {
                filteredArray[i] = words[i];
            }
        }

        filteredArray = filterNulls(filteredArray);

        return filteredArray;*/


        return Arrays.stream(words)
                .filter(s -> s.length() >= minLength)
                .toArray(String[]::new);
    }



    private static String[] filterNulls(String[] arr) {
        int newArraySize = 0;
        for (String word : arr) {
            if (word != null) {
                newArraySize++;
            }
        }

        String[] filteredArray = new String[newArraySize];

        int filteredArrayIndex = 0;
        for (String word : arr) {
            if (word != null) {
                filteredArray[filteredArrayIndex++] = word;
            }
        }

        return filteredArray;
    }

    public static void drawRectangle(int height, int width) {
		for(int i = 0; i< height; i++){
		    for(int j = 0; j<width;j++){
                if (j == 0 || j == width - 1 || i == 0 || i == height -1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
		    System.out.println();
        }
    }
    private static int getWordsAmount(String text) {
        return text.split(" ").length;
    }
    public static String[] filterWordsByLengthStreamApi(int minLength, String[] words) {
        return Arrays.stream(words)
                .filter(s -> s.length() >= minLength)
                .toArray(String[]::new);
    }

    public static int[] extendArray(int[] arr) {
        int[] intArray = new int[arr.length*2];
        for(int i = 0; i<arr.length;i++){
            intArray[i]= arr[i];
            intArray[i+arr.length]= 2*arr[i];
        }
        return intArray;
    }

    public static int[] generateRandomArray(int amountOfElements) {
        int[] intArray = new int[amountOfElements];
        Random random = new Random();
        for(int i = 0; i<amountOfElements;i++){
            intArray[i]= random.nextInt();
        }
        return intArray;
    }

    public static int gcdRecursive(int firstNumber, int secondNumber) {
        while(firstNumber!=secondNumber){
            if(firstNumber>secondNumber){
                firstNumber=firstNumber-secondNumber;
            } else {
                secondNumber=secondNumber-firstNumber;
            }
        }
        return firstNumber;
    }

    public static int sumDigitsInNumber(int number) {
        int sum = 0;
        int num = Math.abs(number);
        while(num>0){
            sum+= num%10;
            num/=10;
        }
        return sum;
    }
}
