package a1_2101140043;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents the search engine.
 */
public class Engine {
    Doc[] docList;
    /**
     * Loads documents from a specified directory and returns the number of documents loaded.
     * 
     * @param dirname The name of the folder containing documents.
     * @return The number of documents loaded.
     */
    public int loadDocs(String dirname) {
        File folder = new File(dirname);
        File[] files = folder.listFiles();
    
        if (files == null) {
            return 0; // case of directory does not exist or is not a directory
        }
    
        int countLoadedDocs = 0;
        docList = new Doc[55];
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    Doc currentDoc = new Doc(br.readLine() + "\n" + br.readLine());
                    docList[countLoadedDocs] = currentDoc;
                    countLoadedDocs++;
                    br.close();
                } catch(Exception exception) {}
            }
        }
        return countLoadedDocs;
    }

    /**
     * Returns an array of documents in the original order.
     * 
     * @return An array of documents.
     */
    public Doc[] getDocs() {
        return this.docList;
    }

    /**
     * Performs a search using a Query object and returns a list of sorted search results.
     * 
     * @param q The Query object representing the user's search query.
     * @return A list of sorted search results.
     */
    public List<Result> search(Query q) {
        List<Result> results = new ArrayList<>();
        for (Doc doc : docList) {
            if (doc != null) { // Check if doc is not null
                List<Match> matches = q.matchAgainst(doc);
                if (matches.size() > 0) {
                    Result result = new Result(doc, matches);
                    results.add(result);
                }
            }
        }
        Collections.sort(results);
        return results;
    }
    
    /**
     * Converts a list of search results into HTML format.
     * 
     * @param results The list of search results.
     * @return An HTML string representing the search results.
     */
    public String htmlResult(List<Result> results) {
        String result = "";
        for (Result r : results) {
            if (r.htmlHighlight() != null)
            result += r.htmlHighlight();
        }
        return result;
    }
}

    
