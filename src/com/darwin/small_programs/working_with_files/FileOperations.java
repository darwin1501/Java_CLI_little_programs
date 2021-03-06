package com.darwin.small_programs.working_with_files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileOperations {

    private File textFile;

    public void getFile(){
        textFile = new File("src/com/darwin/small_programs/working_with_files/sample_text_files/items.txt");
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

    public void writeFromFile(){
        textFile = new File("src/com/darwin/small_programs/working_with_files/sample_text_files/items.txt");

        try{
            FileWriter fileWriter = new FileWriter(textFile, true);
            fileWriter.write("\nThis is another Text");
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
