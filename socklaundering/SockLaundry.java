package socklaundering;

import socklaundering.exception.*;
import java.util.*;
import java.util.stream.Collectors;

public class SockLaundry {

    //Do not delete or edit this method, you can only modify the block
    public int getMaximumPairOfSocks(int noOfWashes, int[] cleanPile, int[] dirtyPile) {
        int max = 0;

        // Sanitize inputs
        try {
            sanitize(cleanPile, dirtyPile, noOfWashes);
        } catch (OutOfRangeException|EmptyStackException e) {
            System.out.println("Oops! " + e.getMessage());
            return -1; // returns -1 to show exception.
        }

        // Avoidable 'stream' operations if we use class object for the array types to improve performance.
        List<Integer> cleanPileList = Arrays.stream(cleanPile).boxed().collect(Collectors.toList());
        List<Integer> dirtyPileList = Arrays.stream(dirtyPile).boxed().collect(Collectors.toList());
        cleanPileList.sort(Collections.reverseOrder());
        dirtyPileList.sort(Collections.reverseOrder());

        // Stackify the sorted list
        Stack<Integer> cleanPileStack = new Stack<>(), dirtyPileStack = new Stack<>(), cleanPileStackTemp = new Stack<>(), dirtyPileStackTemp = new Stack<>();
        cleanPileStack.addAll(cleanPileList);
        cleanPileStackTemp.addAll(cleanPileList);
        dirtyPileStack.addAll(dirtyPileList);
        dirtyPileStackTemp.addAll(dirtyPileList);

        // Get maximum sock pair
        if(noOfWashes > 0) {
            // get exclusive clean and dirty combo
            int cleanCount = getMax(cleanPileStackTemp);
            int exclusiveMax = cleanCount + getMax(dirtyPileStackTemp, noOfWashes);

            // get clean and dirty intersect
            dirtyPileStackTemp.addAll(dirtyPileStack);
            int crossMax = getMaximumCleanAndDirtyPair(cleanPileStack, dirtyPileStack, noOfWashes);

            // get filtered clean and dirty intersect
            cleanPileStackTemp.sort(Collections.reverseOrder());
            int crossMaxCustom = getMaximumCleanAndDirtyPair(cleanPileStackTemp, dirtyPileStackTemp, noOfWashes) + cleanCount;

            // get the maximum combo
            max = Math.max(Math.max(exclusiveMax, crossMax), crossMaxCustom);
        } else {
            max = getMax(cleanPileStack);
        }

        return max;
    }

    /**
     * You can create various helper methods
     * */

    private int getMaximumCleanAndDirtyPair(Stack<Integer> cleanPile, Stack<Integer> dirtyPile, int noOfWashes) {
        int max = 0;
        Stack<Integer> cleanStack = new Stack<>();
        Stack<Integer> dirtyStack = new Stack<>();

        try {
            while(max < noOfWashes && (!cleanPile.isEmpty() || !dirtyPile.isEmpty())) {
                int cleanPeek = cleanPile.peek();
                int dirtyPeek = dirtyPile.peek();
                if(cleanPeek == dirtyPeek) {
                    cleanPile.pop();
                    dirtyPile.pop();
                    max++;
                } else if (cleanPeek < dirtyPeek) {
                    int cleanPop = cleanPile.pop();
                    cleanStack.push(cleanPop);
                } else {
                    int dirtyPop = dirtyPile.pop();
                    dirtyStack.push(dirtyPop);
                }
            }
        } catch (Exception e) {}

        // update the exclusive stack
        dirtyPile.addAll(dirtyStack);
        cleanPile.addAll(cleanStack);


        max = max < noOfWashes ? max + getMax(cleanPile) + getMax(dirtyPile, noOfWashes, max) : max + getMax(cleanPile);
        return max;
    }

    private void sanitize(int[] cleanPile, int[] dirtyPile, int noOfWashes) throws EmptyStackException, OutOfRangeException {
        if(cleanPile.length == 0 || dirtyPile.length == 0) {
            throw new EmptyStackException();
        }
        if(noOfWashes < 0 || noOfWashes > 50) {
            throw new OutOfRangeException("NoOfWashes");
        }
        if(cleanPile.length > 50 || dirtyPile.length > 50) {
            throw new OutOfRangeException("cleanPile or dirtyPile size");
        }

        if(Arrays.stream(cleanPile).anyMatch(item -> item < 1 || item > 50) || Arrays.stream(dirtyPile).anyMatch(item -> item < 1 || item > 50)) {
            throw new OutOfRangeException("cleanPile or dirtyPile elements");
        }
    }

    private int getMax(Stack<Integer> pile, int noOfWashes, int max) {
        int count = 0;

        while(!pile.isEmpty() && (noOfWashes - max) % 2 == 0 && max < noOfWashes) {
            int firstItem = pile.pop();
            int secondItem = pile.size() >= 1 ? pile.peek() : -1; // Using -1 to indicate end of stack
            if(firstItem == secondItem) {
                pile.pop();
                count++;
                max += 2;
            }
        }

        return count;
    }

    private int getMax(Stack<Integer> pile, int noOfWashes) {
        int max = 0;
        int count = noOfWashes / 2;

        while(!pile.isEmpty() && max < count) {
            int firstItem = pile.pop();
            int secondItem = pile.size() >= 1 ? pile.peek() : -1; // Using -1 to indicate end of stack
            if(firstItem == secondItem) {
                pile.pop();
                max++;
            }
        }
        return max;
    }

    private int getMax(Stack<Integer> pile) {
        int max = 0;

        Stack<Integer> tmp = new Stack<>();

        while(!pile.isEmpty()) {
            int firstItem = pile.pop();
            int secondItem = pile.size() >= 1 ? pile.peek() : -1; // Using -1 to indicate end of stack
            if(firstItem == secondItem) {
                pile.pop();
                max++;
            } else {
                tmp.push(firstItem);
            }
        }
        pile.addAll(tmp);
        return max;
    }

}
