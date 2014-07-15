package cc150.chpt6;

import java.util.*;

/**
 * 6.3 Write a method to compute all permutations of a string.
 * Created by zhengxiao on 7/15/14.
 */
public class Q3 {
    public static void main(String[] args) {
        System.out.println("permutes");
        ArrayList<Character> input = new ArrayList<Character>();
        char[] origin = "bb".toCharArray();
        for (char c : origin) {
            input.add(c);
        }
        ArrayList<String> permutes = getPermutes(input);
        Collections.sort(permutes);
        System.out.println(permutes);
        System.out.println(permutes.size());


        System.out.println("choices");
        Set<String> choices = getChoices(new HashSet<Character>(input));
        System.out.println(choices);
        System.out.println(choices.size());
    }

    public static Set<String> getChoices(Set<Character> array) {
        System.out.println("processing " + Arrays.toString(array.toArray(new Character[array.size()])));
        Set<String> perm = new HashSet<String>();
        for (Character head : array) {
            ArrayList<Character> removed = new ArrayList<Character>(array);
            removed.remove(head);
            Set<String> permWithout = getChoices(new HashSet<Character>(removed));
            for (String without : permWithout) {
                perm.add(without.concat(Character.toString(head)));
            }
            perm.add(Character.toString(head));

        }
        System.out.println("returning " + Arrays.toString(perm.toArray(new String[perm.size()])));
        return perm;
    }

    public static ArrayList<String> getPermutes(ArrayList<Character> array) {
        printStackTab();
        System.out.println("processing " + Arrays.toString(array.toArray(new Character[array.size()])));
        stackSize++;

        ArrayList<String> permutes = new ArrayList<String>();
        for (Character c : array) {
            ArrayList<Character> removed = new ArrayList<Character>(array);
            removed.remove(c);
            ArrayList<String> words = getPermutes(removed);
            for (String word : words) {
                permutes.add(word.concat(Character.toString(c)));
            }
            permutes.add(Character.toString(c));
        }

        stackSize--;
        printStackTab();
        System.out.println("returning " + Arrays.toString(permutes.toArray(new String[permutes.size()])));
        return permutes;
    }

    private static int stackSize = 0;

    private static void printStackTab() {
        int oldStackSize = stackSize;
        while (stackSize-- > 0) {
            System.out.print(' ');
        }
        stackSize = oldStackSize;
    }
}
