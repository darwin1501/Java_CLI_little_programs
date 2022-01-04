package com.darwin;

import com.darwin.small_programs.isbn_verifier.ISBNVerifier;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ISBNVerifier isbnVerifier = new ISBNVerifier();
        isbnVerifier.verifyISBN();
    }
}
