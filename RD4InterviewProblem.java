package interview;

import java.util.*;
import java.util.stream.*;

public class RD4InterviewProblem
{
	
	public static boolean IS_LOGGING_ON = false;

	public static void main(String[] args)
	{
		// Execute custom tests
		runCustomTests();
		
		// Execute our tests when ready
		// runTests();
	}
	
	/*
	 * This is a method to make a "venn diagram" of arrays
	 * You will have 2 inputs, both being integer arrays, that represent 2 sides of a venn diagram
	 * The output is expected to be a list of integer arrays representing each part of the "venn diagram"
	 * For instance, the following input with result in the following output:
	 * getArraysVennDiagram([1, 2, 3], [2, 3, 4]) -> <[1], [2, 3], [4]>
	 */
	public static List<int[]> getArraysVennDiagram(int[] a, int[] b)
	{
		// TODO: Add logic here to compare arrays
		return List.of(arr(), arr(), arr());
	}
	
	// Custom tests that you can write to validate
	public static void runCustomTests()
	{
		// Example test of output from example above
		validateEquivalentLists(
				getArraysVennDiagram(arr(1, 2, 3), arr(2, 3, 4)), 
				List.of(arr(1), arr(2, 3), arr(4)));
	}
	
	// Predefined tests that we have written to validate
	public static void runTests()
	{
		validateEquivalentLists(
				getArraysVennDiagram(arr(1, 2, 3), arr(2, 3, 4)), 
				List.of(arr(1), arr(2, 3), arr(4)));
		validateEquivalentLists(
				getArraysVennDiagram(arr(1, 2), arr(3, 4)), 
				List.of(arr(1, 2), arr(), arr(3, 4)));
		validateEquivalentLists(
				getArraysVennDiagram(arr(1, 2, 3), arr(10, 10, 11, 12, 9)), 
				List.of(arr(1, 2, 3), arr(), arr(9, 10, 11, 12)));
		validateEquivalentLists(
				getArraysVennDiagram(arr(1, 2, 3), arr(4, 3, 9, 10)), 
				List.of(arr(1, 2), arr(3), arr(4, 9, 10)));
		validateEquivalentLists(
				getArraysVennDiagram(arr(), arr(4, 3, 10)), 
				List.of(arr(), arr(), arr(3, 4, 10)));
		validateEquivalentLists(
				getArraysVennDiagram(null, arr(4, 3, 10)), 
				List.of(arr(), arr(), arr(3, 4, 10)));
	}
	
	/*
	 * Helper methods to execute comparisons - don't worry about updating these!
	 */
	public static int[] arr(int... values)
	{
        return values;
    }

	public static void validateEquivalentLists(List<int[]> list1, List<int[]> list2) 
	{
		System.out.println("Executing test...");

		// Check if sizes match
		boolean areListsEquivalent = true;
        if (list1.size() != list2.size()) {
        	RD4Helpers.log("-> Your list is size: " + list1.size() + " and expected list is size: " + list2.size());
        	areListsEquivalent = false;
        }

        // Compare each array pair
        for (int i = 0; i < list1.size(); i++) {
            if (!Arrays.equals(list1.get(i), list2.get(i))) {
            	RD4Helpers.log(i == 0 ? "-> Comparison of left array failed!" : i == 1 ? "-> Comparison of middle array failed!" : "-> Comparison of right array failed!");
            	RD4Helpers.log("-> Your array: " + RD4Helpers.printArray(list1.get(i)));
            	RD4Helpers.log("-> Expected array: " + RD4Helpers.printArray(list2.get(i)));
            	areListsEquivalent = false;
            	break;
            }
        }
        
        System.out.println(areListsEquivalent ? "Executed test passed!\n" : "Executed test failed!\n");
    }

	// This is the code that RD4 has compiled. Do not open this until you have completed (if you are interested)
	public static List<int[]> getArraysVennDiagramMaster(int[] a, int[] b)
	{
		// Initialize hash sets
		Set<Integer> set1 = (a == null) ? new TreeSet<>() : IntStream.of(a).boxed().collect(Collectors.toCollection(TreeSet::new));
		Set<Integer> set2 = (b == null) ? new TreeSet<>() : IntStream.of(b).boxed().collect(Collectors.toCollection(TreeSet::new));
		Set<Integer> intersect = new TreeSet<>();

		// Iterate and create venn diagram
		Iterator<Integer> iterator = set1.iterator();
		while (iterator.hasNext())
		{
			Integer i = iterator.next();
			if (set2.contains(i))
			{
				iterator.remove();
				intersect.add(i);
				set2.remove(i);
			}
		}
		
		// Convert tree sets back into arrays and return
		List<int[]> vennDiagram = new ArrayList<>();
		vennDiagram.add(set1.stream().mapToInt(Integer::intValue).toArray());
		vennDiagram.add(intersect.stream().mapToInt(Integer::intValue).toArray());
		vennDiagram.add(set2.stream().mapToInt(Integer::intValue).toArray());

		return vennDiagram;
	}
}
