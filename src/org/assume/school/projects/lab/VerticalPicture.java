package org.assume.school.projects.lab;

import java.util.List;

public class VerticalPicture {

	private List<String> words;

	public VerticalPicture(List<String> words) {
		this.words = words;
	}

	public String[] getWords()
	{
		return words.toArray(new String[words.size()]);
	}
	
	public int getLongestWordLength() {

		int max = 0;
		for (String w : words) {
			if (w.length() > max)
				max = w.length();
		}
		return max;
	}

}
