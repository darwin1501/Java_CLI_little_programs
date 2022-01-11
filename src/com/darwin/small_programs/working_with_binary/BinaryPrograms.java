package com.darwin.small_programs.working_with_binary;

import java.util.Scanner;

public class BinaryPrograms {

    public void conversion(){
        Scanner sc = new Scanner(System.in);
        int number;
        int binary;
        int octal;
        String hex;

        System.out.println("Enter a number: ");
        number = sc.nextInt();

//        convert to binary
        binary = Integer.parseInt(Integer.toBinaryString(number));
//        convert to octal
        octal = Integer.parseInt(Integer.toOctalString(number));
//        convert to hexadecimal
        hex = Integer.toHexString(number);
//        convert hex to decimal
    }

    public void hexToOctal(){
        String hex ="c";
        int decimal;
        int octal;
//        convert it first to decimal
        decimal = Integer.parseInt(hex,16);
//        convert decimal to octal
        octal = Integer.parseInt(Integer.toOctalString(decimal));
//          print result
        System.out.println(octal);
    }

    public void octalToHex(){
        int octal = 14;
        String hex;
        int decimal;

//      convert to decimal
        decimal = Integer.parseInt(Integer.toString(octal),8);
//        convert octal to hex
        hex = Integer.toHexString(decimal);
        System.out.println(hex);
    }
}
