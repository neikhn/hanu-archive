package a1_2101140043;

import java.io.*;
import java.util.*;

/**
* Represents an individual word.
*/
public class Word {
    // A set of stop words loaded by @loadStopWords() method. 
    public static Set<String> stopWords;
    private String rawText;
    int rawLength;
    private String prefix = "";
    private String text = "";
    private String suffix = "";

    // constructor
    public Word(String rawText) {
        this.rawText = rawText;
        this.rawLength = rawText.length();
        this.snipPrefix();
        this.snipSuffix();
        this.snipText();
    }

    /**
    * Creates a Word object from the given raw text.
    *
    * @param rawText The raw text to create a Word from.
    * @return A Word object created from the raw text.
    */
    public static Word createWord(String rawText) {
        return new Word(rawText);
    }

    // All getters
    public String getPrefix() {
        return this.prefix;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public String getText() {
        return this.text;
    }

    /**
    * Validate @text is a keyword.
    * 
    * @return true if the word is a keyword, false otherwise.
    */
    public boolean isKeyword() {
        if (text == null || text.length() == 0) {
            return false;
        }

        if (!validateText()) {
            return false;
        }

        for (String word : stopWords) {
            if (word.equalsIgnoreCase(text)) {
                return false;
            }
        }

        return true;
    }

    /**
    * Loads stop words into the a set from a text file.
    * 
    * @param fileName name of text file containing stop words.
    * @return true if task completed successfully, otherwise false
    */
    public static boolean loadStopWords(String fileName) {
        stopWords = new HashSet<>(); // Initialize the set
        try (Scanner stopWordSc = new Scanner(new File(fileName))) {
            while (stopWordSc.hasNextLine()) {
                String word = stopWordSc.nextLine();
                stopWords.add(word);
            }
            return true;
        } catch (FileNotFoundException e) {
        }
        return false;
    }

    public boolean validateText() {
        if (rawText == null || rawText.length() == 0 || rawText.contains(" ")) {
            return false;
        }
        // starts with 0 - many non-word characters
        // followed by 1 - many alphabetic characters
        // may have hyphens / apostrophes followed by 1 - many alphabetic characters (zero / more times)
        // ends with 0 - many non-word characters
        String nonWord = "\\W"; // non-word character (not a letter or digit)
        String zeroOrMore = "*"; // 0 - many occurrences of preceding pattern, repeat 0 - many times
        String hyphonAndApostrophy = "[-']"; // matches a hyphen or an apostrophe
        String alphabetics = "[a-zA-Z]+"; // matches 1 - many alphabetic characters     
        String pattern = nonWord + zeroOrMore + alphabetics + "(" +
                hyphonAndApostrophy + alphabetics + ")" + zeroOrMore + nonWord + zeroOrMore;
        return rawText.matches(pattern);
    }

    public void snipPrefix() {
        if (!validateText()) {
            prefix = "";
        } else {
            // find index of first non-alphanumeric / special character
            int index = 0; // start with 0 since @prefix
            while (index < rawLength && !Character.isLetterOrDigit(rawText.charAt(index))) {
                index++;
            }
            // extract prefix
            prefix = rawText.substring(0, index);
        }
    }

    public void snipText() {
        int offsetLeftIndex = prefix.length();
        int offsetRightIndex = rawLength - suffix.length();

        text = rawText.substring(offsetLeftIndex, offsetRightIndex);
    }

    public void snipSuffix() {
        if (!validateText()) {
            prefix = "";
        } else {
            // if @rawText have only one apostrophy in the @prefix, it will cause an 
            // IndexOutOfBound for the @text part, error handling that case here:

            int index = rawLength - 1; // iterate from right to left of @rawText
            // case of suffix = [ 's ]
            boolean existApostrophe = false;
            char[] rawArray = rawText.toCharArray();
            for (char c : rawArray) {
                if (c == '\'')
                    existApostrophe = true;
            }

            if (existApostrophe) { // if exist apostrophe(s)
                while (index >= 0) {
                    // find the last [ ' ], set its index then assign the suffix with that
                    if (rawText.charAt(index) == '\'') {
                        suffix = rawText.substring(index);
                        return;
                    }
                    index--;
                }
            } else { // vast, normal cases
                while (index >= 0 && !Character.isLetterOrDigit(rawText.charAt(index))) {
                    index--;
                }
            }

            // reassign @suffix
            suffix = rawText.substring(index + 1);
        }
    }

    @Override
    public String toString() {
        return getPrefix() + getText() + getSuffix();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true; // same object reference, no need for further comparison
        }

        if (o == null || getClass() != o.getClass()) {
            return false; // object is null / not the same class
        }

        Word otherWord = (Word) o; // cast to Word

        // compare text parts of the two Word objects case-insensitively
        return this.getText().equalsIgnoreCase(otherWord.getText());
    }

}
