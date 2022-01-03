package com.darwin.small_programs.string_methods;

import java.util.ArrayList;

public class WorkingWithChars {

    public void StringToChar(String string){
//        abc
        char[] charList = new char[string.length()];
        ArrayList<Character> characterArrayList = new ArrayList<>();

        string.getChars(0,string.length(), charList,0);

//        convert array into array list
        for (char letter:charList){
            characterArrayList.add(letter);
        }

        System.out.println(characterArrayList);
        System.out.println();
        System.out.println(charList);
    }
}
