package com.darwin.small_programs.working_with_files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileOperations {

    public void getFile(){
        File textFile = new File("src/com/darwin/small_programs/working_with_files/sample_text_files/items.txt");
        ArrayList<String> items = new ArrayList<>();
        try {
            Scanner sc = new Scanner(textFile);

            while (sc.hasNextLine()){
//                replaces unnecessary character
                items.add(
                        sc.nextLine()
                                .replace("*","")
                                .replace("/","")
                                .replace("_","")
                                .replace("\"","")
                                .replace("-","")
                );
            }

            System.out.println(items);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
