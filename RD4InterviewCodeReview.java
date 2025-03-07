package interview;

import java.util.*;

public class RD4InterviewCodeReview 
{

    public static void main(String[] args)
    {
    	RD4Helpers.log("Starting the execution of random number methods...");
    	
        // Create a collection of random numbers and display the results
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 20; i++)
        {
            nums.add(new Random().nextInt(100));
        }

        System.out.println("Random numbers: ");
        for (Integer n : nums) {
            System.out.println(n);
        }

        // Get the sum of all numbers in the list
        int sum = 0;
        for (Integer n : nums)
        {
            sum += n;
        }

        System.out.println("The sum of the numbers is: " + sum);

        // Find the largest number
        int largest = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            if (nums.get(i) > largest) {
                largest = nums.get(i);
            }
        }

        System.out.println("The largest number is: " + largest);

        // Sort the numbers in descending order
        ArrayList<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            sortedList.add(nums.get(i));
        }

        Collections.sort(sortedList, Collections.reverseOrder());

        System.out.println("Sorted list in descending order: ");
        for (Integer n : sortedList) 
        {
            System.out.println(n);
        }

        // Check for duplicates
        ArrayList<Integer> duplicates = new ArrayList<>(nums);
        for (int i = 0; i < duplicates.size(); i++)
        {
            for (int j = i + 1; j < duplicates.size(); j++)
            {
                if (duplicates.get(i).equals(duplicates.get(j)))
                {
                	duplicates.remove(j);
                	System.out.println("Found duplicate! Value is " + duplicates.get(i));
                    j--; // Decrement j to stay at the same index after removal
                }
            }
        }
	}
  
	// This is the code that RD4 has compiled. Do not open this until you have completed (if you are interested)
    public static void consolidatedVersion()
    {
        // Create a collection of random numbers and display the results
    	NavigableSet<Integer> randomNumbers = new TreeSet<>(Comparator.reverseOrder());
        int sum = 0;
        for (int i = 0; i < 20; i++) {
            int randomNumber = new Random().nextInt(100);
            sum += randomNumber;
            if (randomNumbers.contains(randomNumber))
            {
            	RD4Helpers.log("Found duplicate! Value is " + randomNumber);
            }
            randomNumbers.add(randomNumber);
        }
        RD4Helpers.log("The sum of the numbers is: " + sum);
        RD4Helpers.log("The largest number is: " + randomNumbers.first());
        RD4Helpers.log("Random numbers in descending order: " + randomNumbers.toString());
    }
}
