package interview;

public class RD4Helpers 
{
	public static boolean IS_LOGGING_ON = true;
	
	public static void log(String log)
	{
		if (IS_LOGGING_ON) System.out.println(log);
	}
	
	public static String printArray(int[] a)
	{
		String array = "";
		for (int i : a)
		{
			array += i + ", ";
		}
		if (a.length > 0) array = array.substring(0, array.length() - 2);
		return "[" + array + "]";
	}
}
