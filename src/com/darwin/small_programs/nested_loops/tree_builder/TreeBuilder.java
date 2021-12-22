package com.darwin.small_programs.nested_loops.tree_builder;

import java.util.Objects;
import java.util.Scanner;

public class TreeBuilder {
    public void buildTree(){
        outer: while (true) {
            Scanner sc = new Scanner(System.in);
            int loopCount;
            String treeTopSpaces = "";
            String treeBottomSpaces = "";

            System.out.print("Enter number: ");
            loopCount = sc.nextInt();
            int standHeigth = Math.round(loopCount / 5);

            //top;
            for (int l = 1; l <= loopCount; l++) {
                treeTopSpaces += " ";
            }
            //bottom;
            for (int l = 1; l < loopCount; l++) {
                treeBottomSpaces += " ";
            }
            System.out.print(treeTopSpaces + "*");
            for (int i = 1; i <= loopCount; i++) {
                String spaces = "";
                int spaceCount = 0;
                spaceCount = loopCount - i;

                for (int k = 1; k <= spaceCount; k++) {
                    spaces += " ";
                }
                System.out.print(spaces);
//			style of the tree
                for (int j = 1; j <= i; j++) {
                    if (i % 2 == 0) {
                        System.out.print(" #");
                    } else {
                        if (j == 1 || j == loopCount) {
                            System.out.print(" ");
                        } else {
                            System.out.print(" *");
                        }
                    }
                }
                System.out.println("");
            }

            for (int m = 1; m <= standHeigth; m++) {
                System.out.println(treeBottomSpaces + "***");
            }

            while (true){
                System.out.print("Do you want to build again? [y] or [n]:");
                String choice = sc.next();
                if(Objects.equals(choice, "y") || Objects.equals(choice, "Y")){
                    break;
                }else if(Objects.equals(choice, "n") || Objects.equals(choice, "N")){
                    break outer;
                }
            }
        }
    }
}
