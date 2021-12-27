package com.darwin;

import com.darwin.small_programs.caesar_cipher.Cipher;
import com.darwin.small_programs.nested_loops.tree_builder.TreeBuilder;
import com.darwin.small_programs.working_with_files.FileOperations;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Cipher cipher = new Cipher();
        cipher.encrypt(cipher.getFileToEncrypt());
    }
}
