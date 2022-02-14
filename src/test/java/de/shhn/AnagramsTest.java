package de.shhn;

import org.junit.Assert;
import org.junit.Test;

public class AnagramsTest {
    @Test
    public void trivialTests(){
        Anagrams anagrams = new Anagrams();

        anagrams.printAnagrams("/data/test.txt");
    }
}
