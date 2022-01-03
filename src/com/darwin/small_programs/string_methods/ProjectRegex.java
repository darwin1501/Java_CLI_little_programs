package com.darwin.small_programs.string_methods;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProjectRegex {

    public void FindACharacter(){
        Scanner sc = new Scanner(System.in);
        String pattern;
        String sentence;
        Pattern regexPattern;
        Matcher matcher;
        boolean matchFound;
        String newString = null;

        System.out.print("Enter a sentence: ");
        sentence = sc.nextLine();
        System.out.print("Find words in sentence: ");
        pattern = sc.nextLine();

        regexPattern = Pattern.compile("["+pattern+"]");
        matcher = regexPattern.matcher(sentence);
        matchFound = matcher.find();

        if(matchFound){
//          all matching characters in the sentence after performing regex can be replaced by
//          another character
            newString =  sentence.replaceAll("["+pattern+"]","*");
//            solution from stack overflow when replacing all characters
//            String new_s = s.toLowerCase().replaceAll("[ .]", "_");
            System.out.println("The pattern "+pattern+" was Found in the sentence");
            System.out.println();
            System.out.println(newString);
        }else{
            System.out.println("Can't find the "+ pattern);
        }
    }
}
