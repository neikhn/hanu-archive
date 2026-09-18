package a1_2101140043;

import java.util.*;

/**
 * Represents a document with a title and body, composed of Word objects.
 */
public class Doc {
    private List<Word> title;
    private List<Word> body;

    // constructor
    public Doc(String content) {
        // initialize title / body as empty lists
        title = new ArrayList<>();
        body = new ArrayList<>();
        // split content into lines (title / body)
        String[] lines = content.split("\n");

        if (lines.length == 2) {
            // parse lines of text to @Word objects into title and body 
            title = toWords(lines[0]);
            body = toWords(lines[1]);
        }
    }

    private List<Word> toWords(String line) {
        String[] words = line.split("\\s+"); // 1 - many whitespace characters
        List<Word> list = new ArrayList<>(); // list to store words in a line
        for (String word : words) { // iterative append to list
            list.add(Word.createWord(word));
        }
        return list;
    }

    // all getters
    public List<Word> getTitle() {
        return title;
    }

    public List<Word> getBody() {
        return body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true; // same object reference, no need for further comparison
        }

        if (o == null || getClass() != o.getClass()) {
            return false; // object is null / not the same class
        }

        Doc otherDoc = (Doc) o; // cast to @Doc

        // Compare titles and bodies of the two Doc objects.
        return title.equals(otherDoc.getTitle()) && body.equals(otherDoc.getBody());
    }
}
