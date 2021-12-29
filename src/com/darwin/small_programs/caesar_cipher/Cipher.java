package com.darwin.small_programs.caesar_cipher;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Cipher {

    private File file;

    private final Character[] pattern = {
            'a','b','c','d','e',
            'f','g','h','i','j',
            'k','l','m','n','o',
            'p','q','r','s','t','u',
            'v','w','x','y','z'
    };

    private int shift = 3;

    public enum Command {
        ENCRYPT,
        DECRYPT
    }

    public ArrayList<String> getFileToEncrypt(){
        file = new File("src/com/darwin/small_programs/caesar_cipher/text_files/encrypt_this.txt");
        ArrayList<String> textList = new ArrayList<>();

        try{
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                textList.add(sc.nextLine());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return textList;
    }

    public ArrayList<String> getFileToDecrypt(){
        file = new File("src/com/darwin/small_programs/caesar_cipher/text_files/decrypt_this.txt");
        ArrayList<String> textList = new ArrayList<>();

        try{
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                textList.add(sc.nextLine());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return textList;
    }

    public void cypher(ArrayList<String> textList, Command command){

        ArrayList<ArrayList<Character>> charList = new ArrayList<>();
        ArrayList<ArrayList<Character>> processedCharList = new ArrayList<>();

//        create 2D array list of characters
        for (int i = 0; i < textList.size() ; i++) {
            ArrayList<Character> characters = new ArrayList<>();
            for (int j = 0; j < textList.get(i).length() ; j++) {
                characters.add(textList.get(i).charAt(j));
            }
            charList.add(characters);
        }
        // get each character in 2d array list
        for (int i = 0; i < charList.size() ; i++) {
            ArrayList<Character> charToprocess = new ArrayList<>();
            for (int j = 0; j <charList.get(i).size(); j++) {
                char character = charList.get(i).get(j);
                int getIndex;
                boolean isUpperCase = Character.isUpperCase(character);
        // find character in the pattern array
                getIndex = Arrays.asList(pattern).indexOf(character);
        // if the program can't find the character in the pattern array,
        // because the letter is in lower case
                if (getIndex == -1){
        // transform the character into lower case if this is a letter then find again
                    getIndex = Arrays.asList(pattern).indexOf(Character.toLowerCase(character));
        //  if the program can't find the character
                    if (getIndex == -1){
        // the character is not a letter
        // store the characters in array list
                        charToprocess.add(character);
                    }else{
        // store the characters in array list
                        if(command == Command.ENCRYPT){
                            charToprocess.add(addShiftToLetters(getIndex, isUpperCase));
                        }else{
                            charToprocess.add(removeShiftToLetters(getIndex, isUpperCase));
                        }
                    }
                }else{
        // store the characters in array list
                    if(command == Command.ENCRYPT){
                        charToprocess.add(addShiftToLetters(getIndex, isUpperCase));
                    }else{
                        charToprocess.add(removeShiftToLetters(getIndex, isUpperCase));
                    }
                }
            }
        // store the character array list into array list
            processedCharList.add(charToprocess);
        }
//        print the result
        System.out.println(processedCharList);
    }
//    replace the old letter to caesar letter alphabet by adding 3 to each letter
    public char addShiftToLetters(int indexOfLetter, boolean isUpperCase){
        char shiftedLetter = 0;
//        add 3 to the letter
//        e.g A + 3 = D
        int letterIndex = indexOfLetter + shift;

        try{
            shiftedLetter = Arrays.asList(pattern).get(letterIndex);
//       if the index exceed the alphabet length/letters
        }catch (Exception e){
//        then start
//        at the beginning of the alphabet.
//        e.g Y + 3 = B

//          subtract the letterIndex to the total number of characters of the pattern then
//          subtract by one again to get the exact index of the letter from the start of the alphabet
//            e.g
//                      Y will become B
//              letterIndex(27) - alphabet indexes(25) = 2 is B
            int remaining = letterIndex - (pattern.length - 1) -1;
            shiftedLetter  = Arrays.asList(pattern).get(remaining);
        }
        if(isUpperCase){
            return Character.toUpperCase(shiftedLetter);
        }else{
            return shiftedLetter;
        }
    }

    public char removeShiftToLetters(int indexOfLetter, boolean isUpperCase){
        char shiftedLetter = 0;
//        subtract 3 to the letter
//        e.g A + 3 = D
        int letterIndex = indexOfLetter - shift;

        try{
            shiftedLetter = Arrays.asList(pattern).get(letterIndex);
//       if the index exceed the alphabet length/letters
        }catch (Exception e){
//        then start
//        at the beginning of the alphabet.
//        e.g A - 3 = Y

//              letterIndex(27) - alphabet indexes(25) = 2 is B
            int remaining = (letterIndex - (pattern.length - 1) -1) - pattern.length;
            shiftedLetter  = Arrays.asList(pattern).get(remaining);
        }
        if(isUpperCase){
            return Character.toUpperCase(shiftedLetter);
        }else{
            return shiftedLetter;
        }
    }
}
