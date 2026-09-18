package a1_2101140043;

/**
 * Represents a situation in which a Doc contains a Word, including frequency and first position.
 */
public class Match implements Comparable<Match> {
    // store title, body of the document into list of words
    // List<Word> wordList;
    Doc document;
    Word word;
    int frequency, firstIndex;
    
    // constructor
    public Match(Doc d, Word w, int freq, int firstIndex) {
        this.document = d;
        this.word = w;
        this.frequency = freq;
        this.firstIndex = firstIndex;
    }

    // all getters
    public int getFreq() {
        return this.frequency;
    }

    public int getFirstIndex() {
        return this.firstIndex;
    }

    public Word getWord() {
        return this.word;
    }

    /**
     * Compares this Match with another Match object by the first index.
     * 
     * @param o The Match object to compare.
     * @return Negative if this Match is less than the other, zero if they are equal, positive if this Match is greater.
     */

     @Override
     public int compareTo(Match o) {
         // Compare based on the firstIndex
         if (this.firstIndex < o.firstIndex) {
             return -1;
         } else if (this.firstIndex > o.firstIndex) {
             return 1;
         } else {// if firstIndex is the same, moved on comparing frequency
             if (this.frequency < o.frequency) {
                 return -1;
             } else if (this.frequency > o.frequency) {
                 return 1;
             } else {
                 // If firstIndex and frequency are the same, compare based on the Word text
                 return this.word.getText().compareTo(o.word.getText());
             }
         }
     }
     
}
