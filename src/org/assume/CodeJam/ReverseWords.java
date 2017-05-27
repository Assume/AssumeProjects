package org.assume.CodeJam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReverseWords {

	public static void main(String[] args) throws IOException {
		new ReverseWords(new File("C:\\Users\\Adam\\Google Drive\\InputFiles\\B-large-practice.in"))
				.printLinesReversed();
	}

	private File file;
	private String[] lines;

	public ReverseWords(String filePath) throws IOException {
		this(new File(filePath));
	}

	public ReverseWords(File file) throws IOException {
		this.setFile(file);
		this.lines = readLines();
	}

	public String[] readLines() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(file));
		List<String> list = new ArrayList<String>();
		String line;
		while ((line = in.readLine()) != null) {
			list.add(line);
		}
		in.close();
		return list.toArray(new String[list.size()]);
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	private String reverse(String s) {

		StringBuilder b = new StringBuilder();
		String[] words = s.split(" ");
		for (int i = words.length - 1; i > -1; i--) {
			b.append(words[i] + " ");
		}
		return b.toString().trim();

	}

	public void printLinesReversed() {
		if (lines.length == 0) {
			return;
		}
		int cases = Integer.parseInt(lines[0]);
		for (int i = 1; i <= cases; i++) {
			System.out.println("Case #" + i + ": " + reverse(lines[i]));
		}
	}

}
