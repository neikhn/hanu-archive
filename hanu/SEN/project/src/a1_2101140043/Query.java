package a1_2101140043;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a user's search query, storing a list of keywords.
 */
public class Query {
    String searchPhrase; // store user search phrase
    static List<Word> keyWords = new ArrayList<>(); // store extracted keywords from search phrase
    /**
     * Constructor to create a Query object from raw search phrase.
     * 
     * @param searchPhrase The raw search phrase from the user.
     */
    public Query(String searchPhrase) {
        this.searchPhrase = searchPhrase;
        String[] words = searchPhrase.split("\\s+"); // 1 - many whitespace characters
        for (String word : words) { // iterative append to list
            //keyword will be added in the same order as they appear in @searchPhrase
            if (Word.createWord(word).isKeyword()) {
                // keyWords.add(Word.createWord(word));
                keyWords.add(new Word(word));
            }
        }
    }

    /**
     * Gets a list of the query's keywords in the same order as they appear in the raw search phrase.
     * 
     * @return A list of the query's keywords.
     */
    public List<Word> getKeywords() {
        return keyWords;
    }

    /**
     * Returns a list of matches against the input document.
     * 
     * @param d The document to match against.
     * @return A list of matches sorted by the position where the keyword first appears in the document.
     */
    public List<Match> matchAgainst(Doc d) {
        List<Match> matches = new ArrayList<>(); //store matches
        // store title, body of the document into list of words
        List<Word> wordList = new ArrayList<>();
        wordList.addAll(d.getTitle());
        wordList.addAll(d.getBody());

        for (int i = 0; i < keyWords.size(); i++) {
            int frequency = 0; // match frequency
            int firstIndex = -5; // store the index of first apprance of the keyword
            for (int j = 0; j < wordList.size(); j++) {
                if (keyWords.get(i).equals(wordList.get(j))) {
                    frequency++;
                    if (firstIndex == -5) {
                        firstIndex = j;
                    }
                }
            }

            if (frequency > 0) { // storing match 
                matches.add(new Match(d, keyWords.get(i), frequency, firstIndex));
            }
        }

        Collections.sort(matches);
        return matches;
    }

    public static void main(String[] args) {
        Word.loadStopWords("stopwords.txt");
        Doc d = new Doc("Object-oriented \"design\": with UML's diagrams\n" +
                "Definition: An object-oriented system's context made up of (interacting) objects.");
        Query q = new Query("the <context> of observer: design");

        List<Match> matches = q.matchAgainst(d);
        // String[] matchedWords = {"design", "context"};
        if (matches.size() != 2) {
            System.out.println("Query.matchAgainst(): incorrect matches count (expected: 2)");
        }
        for (Word keyWord : keyWords) {
            System.out.println("[ " + keyWord + " ]");
        }
        for (Match match : matches) {
            System.out.println("Match word: " + match.getWord());
            System.out.println("First index: " + match.getFirstIndex());
            System.out.println("Frequency: " + match.getFreq());

        }
    }
}