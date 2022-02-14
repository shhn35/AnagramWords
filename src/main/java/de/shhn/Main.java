package de.shhn;

public class Main {
    public static void main(String[] args) {
        String fileName="/data/words.txt";

        Anagrams anagrams = new Anagrams();
        anagrams.printAnagrams(fileName);
    }
}
