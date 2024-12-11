package edu.virginia.cs.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class WordleDictionaryTest {
    private static final String ONE_WORD_DICTIONARY_FILENAME = "/one_word_dictionary.txt";
    WordleDictionary testDictionary;

    @BeforeEach
    public void setupTestDictionary() {
        testDictionary = new WordleDictionary();
    }

    @Test
    public void testOneWordDictionary() {
        InputStream inputStream = WordleDictionaryTest.class.getResourceAsStream(ONE_WORD_DICTIONARY_FILENAME);
        testDictionary.addWordsFromInputStream(inputStream);
        assertEquals(1, testDictionary.getDictionarySize());
        assertTrue(testDictionary.containsWord("BADLY"));
    }
    @Test
    public void testaddwordmethod() {
        testDictionary.addWord("APPLE");
        assertEquals("APPLE", testDictionary.getRandomWord());
    }

    @Test
    public void test_isLegalWordleWord_True_UpperCase(){
        assertTrue(testDictionary.isLegalWordleWord("APPLE"));
    }

    @Test
    public void test_AddWordFromInputStream(){
        InputStream inputStream = WordleDictionaryTest.class.getResourceAsStream(ONE_WORD_DICTIONARY_FILENAME);
        testDictionary.addWordsFromInputStream(inputStream);
        assertEquals("BADLY",testDictionary.getRandomWord());
    }

    @Test
    public void test_isLegalWordleWord_True_LowerCase(){
        assertTrue(testDictionary.isLegalWordleWord("apple"));
    }

    @Test
    public void test_all_possible_conditions_in_containsWord(){
        testDictionary.addWord("APPLE");
        assertTrue(testDictionary.containsWord("APPLE"));
        assertTrue(testDictionary.containsWord("aPPLE"));
        assertTrue(testDictionary.containsWord("apple"));
        assertFalse(testDictionary.containsWord("Badly"));
    }

    @Test
    public void test_all_possible_conditions_in_getDictionarySize(){
        assertEquals(0,testDictionary.getDictionarySize());
        testDictionary.addWord("APPLE");
        assertEquals(1,testDictionary.getDictionarySize());
        testDictionary.addWord("Badly");
        assertEquals(2,testDictionary.getDictionarySize());
    }

    @Test
    public void test_all_possible_conditions_isLegalWordleWord(){
        assertFalse(testDictionary.isLegalWordleWord(null));
        assertFalse(testDictionary.isLegalWordleWord("."));
        assertFalse(testDictionary.isLegalWordleWord("[[]]/"));
        assertFalse(testDictionary.isLegalWordleWord("12345"));
        assertFalse(testDictionary.isLegalWordleWord("a1234"));
    }

    @Test
    public void test_all_possible_conditions_addWord(){
        assertEquals(0,testDictionary.getDictionarySize());
        testDictionary.addWord("APPLE");
        testDictionary.addWord("APPLE");
        assertEquals(1,testDictionary.getDictionarySize());
        try{
            testDictionary.addWord("APPLEaaaaa");
        }
        catch(IllegalWordException ilwe){
            System.out.println(ilwe);
        }
        assertEquals(1,testDictionary.getDictionarySize());
        testDictionary.addWord("LEMON");
        assertEquals(2,testDictionary.getDictionarySize());
    }

}
