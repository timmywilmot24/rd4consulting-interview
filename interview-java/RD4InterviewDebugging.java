package interview;

import java.util.Arrays;

public class RD4InterviewDebugging 
{

	/*
	 * This method is designed to compute the product of all integers for each index except its own.
	 * Currently, this isn't functioning properly, and your task is to debug and find the issues.
	 * You are free to tweak any and all code within productExceptSelf(int[] numbers) to get the correct answer.
	 */
    public static int[] productExceptSelf(int[] numbers)
    {
        int[] leftProducts = new int[numbers.length];
        int[] rightProducts = new int[numbers.length];
        int[] result = new int[numbers.length];

        // Recursively compute "left product" for each index (starting at the left-hand side)
        leftProducts[0] = 1;
        for (int i = 1; i < numbers.length; i++) {
            leftProducts[i] = leftProducts[i - 1] * numbers[i];
        }

        // Recursively compute "right product" for each index (starting at the right-hand side)
        rightProducts[numbers.length - 1] = 1;
        for (int i = numbers.length - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * numbers[i];
        }

        // Compute result by multiplying these together
        for (int i = 0; i < numbers.length; i++) {
            result[i] = leftProducts[i] * rightProducts[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4};
        RD4Helpers.log(Arrays.toString(productExceptSelf(input1))); 
        // Expected: [24, 12, 8, 6]
    }

}
