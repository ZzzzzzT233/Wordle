package edu.virginia.cs.hw2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultDictionaryFactoryTest {
    DefaultDictionaryFactory testFactory;

    @BeforeEach
    public void setupTestFactory() {
        testFactory = new DefaultDictionaryFactory();
    }

    @Test
    public void testGetDefaultGuessesDictionary() {
        WordleDictionary defaultGuessesDictionary = testFactory.getDefaultGuessesDictionary();
        assertNotNull(defaultGuessesDictionary);
    }

    @Test
    public void testGetDefaultAnswersDitionary(){
        WordleDictionary defaultAnswersDictionary = testFactory.getDefaultAnswersDictionary();
        assertNotNull(defaultAnswersDictionary);
    }

    @Test
    public void testLoadDefaultDictionarys(){
        testFactory.loadDefaultDictionaries();
        assertNotNull(testFactory.getDefaultGuessesDictionary());
        assertNotNull(testFactory.getDefaultAnswersDictionary());
    }

    @Test
    public void testWordleDicionary_method_from_DefaultDicionary(){
        WordleDictionary defaultAnswersDictionary = testFactory.getDefaultAnswersDictionary();
        assertTrue(defaultAnswersDictionary.containsWord("APPLE"));
    }
}
