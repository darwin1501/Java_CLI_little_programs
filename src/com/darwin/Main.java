package com.darwin;

import com.darwin.small_programs.caesar_cipher.Cipher;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Cipher cipher = new Cipher();
        cipher.cypher(cipher.getFileToDecrypt(), Cipher.Command.DECRYPT);

    }
}
