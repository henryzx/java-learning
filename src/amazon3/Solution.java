package amazon3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        String input = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            input = br.readLine();
        } catch (IOException io) {
            io.printStackTrace();
        }

        if (input == null || input.length() == 0 || input.length() > 50 || input.contains("1")) return;

        List<String> possibles = new ArrayList<String>();
        int iterator = (1 << (input.length())) - 1;
        for (int i = 0; i <= iterator; i++) {
            String binaries = String.format("%" + input.length() + "s", Integer.toBinaryString(i)).replace(' ', '0');
            char[] inputCopy = Arrays.copyOf(input.toCharArray(), input.length());
            for (int j = 0; j < inputCopy.length; j++) {
                char c = binaries.charAt(j);
                if (c == '1') {
                    inputCopy[j] = '1';
                }
            }
            String inputCopyString = new String(inputCopy).replaceAll("1", "");
            possibles.add(inputCopyString);
        }

        Collections.sort(possibles);

        System.out.println(possibles.get(possibles.size() - 1));
    }
}