package com.darwin.small_programs.caesar_cipher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Cipher {

    private File file;

    char[] pattern = {
            'a','b','c','d','e',
            'f','g','h','i','j',
            'k','l','m','n','o',
            'p','q','r','s','t','u',
            'v','w','x','y','z'
    };

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

    public void encrypt(ArrayList<String> textList){

        ArrayList<ArrayList<Character>> charList = new ArrayList<>();

        for (int i = 0; i < textList.size() ; i++) {
            ArrayList<Character> characters = new ArrayList<>();
            for (int j = 0; j < textList.get(i).length() ; j++) {
//                System.out.println(textList.get(i).charAt(j));
                characters.add(textList.get(i).charAt(j));
            }
            charList.add(characters);
        }

        System.out.println(charList);
    }
}
