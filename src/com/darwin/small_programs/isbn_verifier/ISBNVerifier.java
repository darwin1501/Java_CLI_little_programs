package com.darwin.small_programs.isbn_verifier;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ISBNVerifier {

    private ArrayList<String> getFile(){
        File file = new File("src/com/darwin/small_programs/isbn_verifier/isbn_list/isbn_list.txt");
        ArrayList<String> isbnList = new ArrayList<>();
        try{
            Scanner sc = new Scanner(file);
            while (sc.hasNext()){
//        remove white space and extra spacing at ISBN characters
                String isbn = sc.nextLine();
                isbn = isbn.trim().replaceAll("[ ]","");
                isbnList.add(isbn);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  isbnList;
    }
    public void verifyISBN(){
        ArrayList<String> isbnRaw = getFile();
        ArrayList<String> isbnSanitized = new ArrayList<>();

        for (int i=0;i<isbnRaw.size();i++){
            StringBuilder isbn = new StringBuilder();
            for (int j=0;j<isbnRaw.get(i).length();j++){
//                get the numbers only and ignore letters and special characters
                try{
                    Integer isbnNumber = Integer.parseInt(String.valueOf(isbnRaw.get(i).charAt(j)));
                    isbn.append(isbnNumber);
                }catch (Exception e){
//                    e.printStackTrace();
                }
            }
            isbnSanitized.add(isbn.toString());
        }
//        check if isbn is valid
        for(String isbn:isbnSanitized){
            if(isbn.length() == 10 || isbn.length() == 13){
                System.out.println(isbn+" is valid");
                System.out.println("length: " + isbn.length());
            }else{
                System.out.println(isbn+" is invalid");
                System.out.println("length: " + isbn.length());
            }
        }
    }
}
