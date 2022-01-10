package com.darwin.small_programs.palindrome_checker;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Palindrome {

    private ArrayList<String> getFile(){
        File file = new File("src/com/darwin/small_programs/palindrome_checker/text_files/palindrome.txt");
        ArrayList<String> textList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNext()){
//                sanitize the input here
                String text = sc.nextLine().trim().replaceAll("[,}?&<>*^_.';$%=\\-/\\[\\] \\\\]","");
                textList.add(text);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return textList;
    }

    public void verify(){
        ArrayList<String> textList = getFile();

        for (int i=0;i< textList.size();i++){
            String reversedText = "";
            for (int j=textList.get(i).length();j>0;j--){
//                get each character from end to beginning of String
                char character = textList.get(i).charAt(j-1);
//                concatenate
                assert false;
                reversedText += character;
            }
            //        check if the reversed string is equal to the original string
            assert false;
            if(Objects.equals(reversedText, textList.get(i))){
                System.out.println(textList.get(i)+" is Palindrome");
            }else{
                System.out.println(textList.get(i)+" is Not Palindrome");
            }
        }
    }
}
