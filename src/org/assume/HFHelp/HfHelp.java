package org.assume.HFHelp;
import java.util.Scanner;

public class HfHelp
{
	public static void main(String[] args)
	{
		String[] blah = {"Question one here", "Question two here", "Question 3 here", "Etc etc ectc"};
		String[] answerOne = {"Answer one for question 1 here", "Answer one for question two here", "etc etc etc"};
		String[] answerTwo = {"Answer two for question 1 here", "Answer two for question two here", "etc etc etc"};
		String[] answerThree = {"Answer three for question 1 here", "Answer three for question two here", "etc etc etc"};
		String[] answerFour = {"Answer four for question 1 here", "Answer four for question two here", "etc etc etc"};

		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int i  = 0;
		for(String t : blah)
		{
			System.out.println(t);
			System.out.format("A. "+answerOne[i]+"%nB. "+answerTwo[i] +"%nC. "+answerThree[i]+"%nD. "+answerFour[i]+"%n");
			switch(new Scanner(System.in).nextLine().toUpperCase())
			{
			case "A":
				a++;
				break;
			case "B":
				b++;
				break;
			case "C":
				c++;
				break;
			case "D":
				d++;
				break;
			}
			if(i < blah.length)
				i++;
		}
		System.out.format("You chose manipulative: "+a+" times" +
				"%nYou chose nonmanipulative: "+b+" times" +
				"%nYou chose neutral: "+c+" times" +
				"%nYou chose random: "+d+" times");
	}
}
