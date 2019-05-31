package applications;

import java.util.ArrayList;

public class GlobalHelpers {

	public static final String LINE_SEPARATOR = System.getProperty("line.separator");

	private GlobalHelpers()
		{
		}

	public static void printStringArray(String[] strArr)
		{
		for (int i = 0; i < strArr.length; i++)
			{
			System.out.println(strArr[i]);
			}
		}

	public static void printStringArrayList(ArrayList<String> stringList)
		{
		for (String str : stringList)
			{
			System.out.println(str);
			}
		}

	public static String stringArrayListToString(ArrayList<String> stringList)
		{
		StringBuilder sb = new StringBuilder();
		for (String str : stringList)
			{
			sb.append(LINE_SEPARATOR + str);
			}
		return sb.toString();
		}
}
