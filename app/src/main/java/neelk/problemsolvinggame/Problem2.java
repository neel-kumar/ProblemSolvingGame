package neelk.problemsolvinggame;

import java.util.Random;

public class Problem2 {
    private final int MAX;
    long right;
    long left;
    int notShow;

    Problem2(int MAX) {
        right = 0;
        left = 0;
        this.MAX = MAX;
    }

    public void create() {
        while (left <= right) {
            Random r = new Random();
            right = r.nextInt(MAX);
            left = r.nextInt(MAX);
            notShow = r.nextInt(3);
        }
    }

    public String getString(final long value) {
        String valueString;

        if (value == -1) {
            // User has not provided any value yet
            valueString = "?";
        } else {
            valueString = Long.toString(value);
        }

        long result = left - right;
        String output = "";

        if (notShow == 0) {
            output = valueString + " - " + right + " = " + result;
        } else if (notShow == 1) {
            output = "" + left + " - " + valueString + " = " + result;
        } else {
            output = "" + left + " - " + right + " = " + valueString;
        }

        return output;
    }
    public boolean checkSolution(long solution) {
        if(notShow == 0){
            return solution == left;
        } else if(notShow ==1){
            return solution == right;
        } else{
            return solution == left - right;
        }
    }

}
