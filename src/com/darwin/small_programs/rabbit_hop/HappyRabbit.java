package com.darwin.small_programs.rabbit_hop;

import java.util.ArrayList;
import java.util.Arrays;

public class HappyRabbit {
    public  void parse(String data){

        ArrayList<Integer> totalHops = new ArrayList();

        int hop = 0;
        for(int i=0;i<data.length();i++){
            char singleCommand = data.charAt(i);

            switch (singleCommand) {
                case 'i' -> hop += 1;
                case 'I' -> hop += 1;
                case 's' -> hop *= hop;
                case 'S' -> hop *= hop;
                case 'd' -> hop -= 1;
                case 'D' -> hop -= 1;
                case 'o' -> totalHops.add(hop);
                case 'O' -> totalHops.add(hop);
            }
        }
        int[] result = new int[totalHops.size()];

        for (int i = 0; i <totalHops.size() ; i++) {
            result[i] = totalHops.get(i);
        }

        System.out.println(Arrays.toString(result));

    }
}
