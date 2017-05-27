package org.assume.StackOverflow;

import java.io.File;

public class Progress implements Runnable {
	private File file;
	private long totalSize;
	private int currentProgress;

	public Progress(String filePath, long totalSize) {
		this(new File(filePath), totalSize);
	}

	public Progress(File file, long totalSize) {
		this.file = file;
		this.totalSize = totalSize;
	}

	public int getProgress() {
		return currentProgress;
	}

	@Override
	public void run() {
		while (file.length() < (totalSize - 100)) {
			currentProgress = (int) (file.length() / totalSize);
		}
	}
}
