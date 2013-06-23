package org.assume.api.math.Algebra;

import java.util.HashMap;

public class Algebra {
	public static double getAverage(double[] doubleArray)
	{

		double total = 0;
		for(int i = 0; i< doubleArray.length; i++)
		{
			total = total+ doubleArray[i];
		}
		return total / doubleArray.length;

	}

	public static double getLargest(double[] doubleArray)
	{
		double largest = Double.MIN_VALUE;
		for(int i=0; i<doubleArray.length; i++)
		{
			if(doubleArray[i] > largest)
			{
				largest = doubleArray[i];
			}
		}
		return largest;
	}
	
	public static double getSmallest(double[] doubleArray)
	{
		double smallest = Double.MAX_VALUE;
		for(int i = 0; i<doubleArray.length;i++)
		{
			if(doubleArray[i] < smallest)
			{
				smallest = doubleArray[i];
			}
		}
		return smallest;
	}

	public static double[] smallestToLargest(double[] doubleArray)
	{
		double toreplace;
		for (int i = 0; i < doubleArray.length-1; i++)
		{
			if(doubleArray[i] > doubleArray[i+1])
			{
				toreplace = doubleArray[i];
				doubleArray[i] = doubleArray[i+1];
				doubleArray[i+1] = toreplace;
				i=-1;
			}
		}
		return doubleArray;
	}

	public static double[] largestToSmallest(double[] doubleArray)
	{
		double toreplace;
		for (int i = 0; i < doubleArray.length-1; i++) 
		{
			if(doubleArray[i] < doubleArray[i+1])
			{
				toreplace = doubleArray[i];
				doubleArray[i] = doubleArray[i+1];
				doubleArray[i+1] = toreplace;
				i=-1;
			}
		}
		return doubleArray;
	}

	public static double getMedian(double[] doubleArray)
	{
		int middle = doubleArray.length/2;
		if (doubleArray.length%2 == 1) 
		{
			return doubleArray[middle];
		}
		else 
		{
			return (doubleArray[middle-1] + doubleArray[middle]) / 2.0;
		}
	}

	public static double getMode(double[] doubleArray)
	{
		double maxValue = 0, maxCount = 0;

		for (int i = 0; i < doubleArray.length; i++) 
		{
			int count = 0;
			for (int j = 0; j < doubleArray.length; j++)
			{
				if (doubleArray[j] == doubleArray[i]) count++;
			}
			if (count > maxCount)
			{
				maxCount = count;
				maxValue = doubleArray[i];
			}
		}

		return maxValue;
	}

	public static double getAverageRange(double[] doubleArray, int start, int finish)
	{
		double average = 0;
		if(finish > doubleArray.length)
		{
			finish = doubleArray.length;
		}
		if(start < 0)
		{
			start = 0;
		}
		double total = 0;
		for(int i = start; i< finish; i++)
		{
			total = total+ doubleArray[i];
		}
		return average = total / (finish - start);
	}




	public static double doQuadraticFormula(double a, double b, double c)
	{
		return ((-b) + (Math.sqrt(Math.pow(b, 2) - (4)*a*c))) / (2*(a));
	}
	
	public static double doGeometricSequence(double a1, double r, double n)
	{
		return a1 * (Math.pow(r, n-1)); 
	}
	
	public static double doGeometricSeries(double a1, double r, double n)
	{
		return a1*(1-Math.pow(r, n)) / (1-r);
	}
	
	public static double doArithmeticSequence(double a1, double n, double d)
	{
		return a1 + (n-1)*d;
	}
	
	public static double doArithmeticSeries(double a1, double an, double n)
	{
		return (n*(a1 + an)) / (2);
	}
	
	public static double doGeometricInfinite(double r, double n)
	{
		return (1- Math.pow(r, n)) / (1 - r);
	}
}