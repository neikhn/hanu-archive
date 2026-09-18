package a1_2101140043;

import java.util.*;

/**
 * Represents a related document found during a search, including matches and derived properties.
 */
public class Result implements Comparable<Result> {
    List<Match> matches = new ArrayList<>();
    Doc document;
    // 3 derived properties
    int totalFrequency = 0;

    /**
     * Constructor to initialize a Result object with the related document and matches.
     * 
     * @param d       The related document.
     * @param matches The list of matches in the document.
     */
    public Result(Doc d, List<Match> matches) {
        this.document = d;
        this.matches = matches;
        this.totalFrequency = getTotalFrequency();
    }

    public Doc getDoc() {
        return this.document;
    }

    /**
     * Gets the list of matches in the document.
     * 
     * @return The list of matches.
     */
    public List<Match> getMatches() {
        return this.matches;
    }

    /**
     * Gets the total frequency of matches in the document.
     * 
     * @return The total frequency.
     */
    public int getTotalFrequency() {
        int totalFrequency = 0;
        for (Match match : matches) {
            totalFrequency += match.getFreq();
        }
        return totalFrequency;
    }

    /**
     * Gets the average first index of matches in the document.
     * 
     * @return The average first index.
     */
    public double getAverageFirstIndex() {
        double averageFirstIndex = 0.0;
        for (Match match : matches) {
            averageFirstIndex += match.getFirstIndex();
        }
        averageFirstIndex /= matches.size();
        return averageFirstIndex;
    }

    /**
     * Highlight the matched words in the document using HTML markups.
     * 
     * @return An HTML string with matched words highlighted.
     */
    public String htmlHighlight() {
        // return attributes
        StringBuilder hightLightedTitle = new StringBuilder();
        StringBuilder hightLightedBody = new StringBuilder();
        List<Word> title = document.getTitle();
        List<Word> body = document.getBody();

        // building @highLightedTitle
        titleLoop:
        for (Word word : title) {
            for (Match match : matches) {
                if (word.equals(match.getWord())) {
                    hightLightedTitle.append(
                            String.format("%s<u>%s</u>%s ", word.getPrefix(), word.getText(), word.getSuffix()));
                    continue titleLoop;
                }
            }
            hightLightedTitle.append( String.format("%s%s%s ", word.getPrefix(), word.getText(), word.getSuffix()));
        }
        hightLightedTitle.insert(0, "<h3>");
        // Replace last space with </h3>
        hightLightedTitle.replace(hightLightedTitle.lastIndexOf(" "), hightLightedTitle.length(), "</h3>");


        // building @highLightedBody
        bodyLoop:
        for (Word word : body) {
            for (Match match : matches) {
                if (word.equals(match.getWord())) {
                    hightLightedBody.append(
                            String.format("%s<b>%s</b>%s ", word.getPrefix(), word.getText(), word.getSuffix()));
                    continue bodyLoop;
                }
            }
            hightLightedBody.append( String.format("%s%s%s ", word.getPrefix(), word.getText(), word.getSuffix()));
        }
        hightLightedBody.insert(0, "<p>");
        // Replace last space with </h3>
        hightLightedBody.replace(hightLightedBody.lastIndexOf(" "), hightLightedBody.length(), "</p>");


        String highLighted = hightLightedTitle.toString() + hightLightedBody.toString();
        return highLighted;
    }

    /**
     * Compares this Result with another Result object.
     * 
     * @param o The Result object to compare.
     * @return Negative if this Result is less than the other, zero if they are equal, positive if this Result is greater.
     */
    @Override
    public int compareTo(Result o) {
        // ===DESCENDING ORDER===
        // based on match count
        int matchCountComparison = Integer.compare(o.getMatches().size(), this.getMatches().size());

        if (matchCountComparison != 0) {
            return matchCountComparison;
        }
        // the case of equal match counts ,then compare based on total frequency
        int totalFrequencyComparison = Integer.compare(o.getTotalFrequency(), this.getTotalFrequency());

        if (totalFrequencyComparison != 0) {
            return totalFrequencyComparison;
        }
        // the case of equal total frequencies, compare based on average first index (ascending order)
        double averageFirstIndexDifference = this.getAverageFirstIndex() - o.getAverageFirstIndex();

        if (averageFirstIndexDifference > 0) {
            return 1;
        } else if (averageFirstIndexDifference < 0) {
            return -1;
        } else {
            return 0;
        }
    }

}