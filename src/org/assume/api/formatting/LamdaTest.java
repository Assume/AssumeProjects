package org.assume.api.formatting;

public interface LamdaTest {
	double test(int a, int b);

	static final LamdaTest ADD = (a , b) -> a + b;
	
}
