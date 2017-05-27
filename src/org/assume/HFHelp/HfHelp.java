package org.assume.HFHelp;

public class HfHelp {
	public static void main(String[] args) {
		HfHelp help = new HfHelp();
		int[] t = new int[10];
		t[0] = 1;
		t[1] = 2;
		t[3] = 3;
		t[7] = 1;
		System.out.println(t[9]);
		System.out.println(help.readData(t));
	}

	private int readData(int[] x) {
		int t = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] == -999) {
				return t;
			} else if (x[i] == 0) {
				continue;
			} else {
				t++;
			}
		}
		return t;
	}
}
