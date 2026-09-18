package section4.Exercise6_6;

import java.util.*;

public class TEx6 {

    // Define a class Check with a checker method
    public static class Check {
        public boolean checker(Integer number) {
            return number % 2 != 0;
        }
    }
    
    private static class FilteredGen implements Iterator<Integer> {
        private Iterator<Integer> inputIterator;
        private Check check;

        // Constructor of FilteredGen 
        public FilteredGen(Iterator<Integer> inputIterator, Check check) {
            this.inputIterator = inputIterator;
            this.check = check;
        }
        
        @Override
        public boolean hasNext() {
            return inputIterator.hasNext();
        }

        @Override
        public Integer next() {
            Integer number = inputIterator.next();
            try {
                while (!check.checker(number)) {
                number = inputIterator.next();
            }
            } catch (Exception e) {
            }
            return number;
        }

        public static Iterator<Integer> filter(Iterator<Integer> g, Check x) {
            if (g == null || x == null) {
                throw new NullPointerException();
            }

            return new FilteredGen(g, x);
        }
    }

    public static void main(String[] args) {
        // Create a collection of integers (from 1 to 20) with some null values
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            list.add(i);
        }
        list.add(null);
        
        // Create a Check instance that checks for odd numbers
        Check oddCheck = new Check();

        // Use the filter method to create an iterator for odd numbers
        Iterator<Integer> filteredIterator = FilteredGen.filter(list.iterator(), oddCheck);

        // Print the filtered elements
        while (filteredIterator.hasNext()) {
            System.out.print(filteredIterator.next() + " ");
        }
    }
}
