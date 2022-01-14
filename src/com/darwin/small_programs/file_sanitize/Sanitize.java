package com.darwin.small_programs.file_sanitize;

import java.io.File;
import java.util.Scanner;

public class Sanitize {

    public void sanitizeText(){
        File file = new File("src/com/darwin/small_programs/file_sanitize/text_files/message.txt");
        String message = "";
        try{
            Scanner sc = new Scanner(file);

            while (sc.hasNext()){
                String text = sc.nextLine();

                for (int i = 0; i <text.length() ; i++) {
                    char character = text.charAt(i);
                    String characterSpaceCheck = Character.toString(text.charAt(i));
                    if(Character.isAlphabetic(character) || characterSpaceCheck.isBlank()){
//                        concatenate the letter to the message
                       message += text.charAt(i);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
// display message
        System.out.println(message);
    }
}
