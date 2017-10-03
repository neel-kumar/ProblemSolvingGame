package neelk.problemsolvinggame;

import java.util.Random;

public class Problem {
    private final int MAX;
    long right;
    long left;
    int notShow;

    Problem(int MAX) {
        right = 0;
        left = 0;
        this.MAX = MAX;
    }

    public void create() {
        Random r = new Random();
        right = r.nextInt(MAX);
        left = r.nextInt(MAX);
        notShow = r.nextInt(3);
    }

    public String getString(final long value) {
        String valueString;

        if (value == -1) {
            // User has not provided any value yet
            valueString = "?";
        } else {
            valueString = Long.toString(value);
        }

        long sum = left + right;
        String output = "";

        if (notShow == 0) {
            output = valueString + " + " + right + " = " + sum;
        } else if (notShow == 1) {
            output = "" + left + " + " + valueString + " = " + sum;
        } else {
            output = "" + left + " + " + right + " = " + valueString;
        }

        return output;
    }
    public boolean checkSolution(long solution) {
        if(notShow == 0){
            return solution == left;
        } else if(notShow ==1){
            return solution == right;
        } else{
            return solution == right + left;
        }
    }

}
