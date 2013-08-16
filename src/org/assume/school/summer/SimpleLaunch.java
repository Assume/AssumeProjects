package org.assume.school.summer;


public class SimpleLaunch {
	public static void main(String[] args) {

		HelloSimple helloNoMsg = new HelloSimple();	
		helloNoMsg.go();														

		HelloSimple hello = new HelloSimple("Hello, world!");	
		hello.go();																						 

		HelloMultiline helloMLNoMsg = new HelloMultiline();		
		helloMLNoMsg.go();															

		HelloMultiline helloML = new HelloMultiline("multiline Hello, world, how are you?");
		helloML.go();

		Hello  helloFor = new HelloSimple(String.format("Did you know: %d + %d = %d?", 22, 33, 22 + 33));
		helloFor.go();

		Hello  helloFor2 = new HelloSimple(String.format("And that: %d%% of %.2f = %.4f?", 15, 12.23, 0.15*12.23));
		helloFor2.go();

		String  quote = "it seemed unfair that anyone should possess (apparently) perpetual youth as well as (reputedly) inexhaustible wealth";
		HelloSimple  helloUnsorted = new HelloSimple(quote);
		helloUnsorted.go();
		HelloSorted  helloSorted  = new HelloSorted(quote);
		helloSorted.go();

		HelloSorted helloSortedRev = new HelloSorted(quote, true);
		helloSortedRev.go();

		HelloSorted  hsr = new HelloSorted(true);
		hsr.go();
	}
}