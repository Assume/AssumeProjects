package org.assume.school.projects.lab;

public class Frame extends FNode
{

    public static void main(String[] args)
    {
	long st = System.currentTimeMillis();
	String[] words =
	{ "Spring", "In the", "Big old summer" };
	String[] words2 =
	{ "Summer in the", "long old spring", "is summery and summer",
		"and has leaves that", "are red" };
	PNode p1 = StrPic.INSTANCE(words);
	p1 = Frame.INSTANCE(p1);
	p1 = VCat.INSTANCE(p1, StrPic.INSTANCE(words2));
	p1 = HCat.INSTANCE(
		Frame.INSTANCE(p1),
		HCat.INSTANCE(
			Frame.INSTANCE(p1),
			VCat.INSTANCE(Frame.INSTANCE(p1),
				Frame.INSTANCE(StrPic.INSTANCE(words2)))));
	p1 = Frame.INSTANCE(Frame.INSTANCE(HScrollBar.INSTANCE(VScrollBar
		.INSTANCE(Frame.INSTANCE(VCat.INSTANCE(
			Frame.INSTANCE(HCat.INSTANCE(p1, p1)),
			StrPic.INSTANCE(words2)))))));
	System.out.println(p1);
	System.out.println("Runtime: " + (System.currentTimeMillis() - st)
		+ " milliseconds");
    }

    private String framed;

    private int height;
    private int width;

    public static Frame INSTANCE(PNode p1)
    {
	return new Frame(p1);
    }

    private Frame(PNode p1)
    {
	super(p1);
	framed = frame();
	super.setWords(framed.split("\n"));
    }

    @Override
    public int getWidth()
    {
	return this.width;
    }

    @Override
    public int getHeight()
    {
	return this.height;
    }

    private StringBuilder topBar(int wOrig)
    {
	StringBuilder b = new StringBuilder();
	for (int i = 0; i < wOrig + 2; i++)
	{
	    b.append(i == 0 | i == wOrig + 1 ? "+" : "-");
	}
	b.append("\n");
	return b;
    }

    private StringBuilder content(String[] words, StringBuilder b)
    {
	for (String i : words)
	{
	    b.append("|" + i);
	    for (int j = 0; j < super.getP1().getWidth() - i.length(); j++)
	    {
		b.append(" ");
	    }
	    b.append("|");
	    b.append("\n");
	}
	return b;
    }

    private StringBuilder bottomBar(int wOrig, StringBuilder b)
    {
	for (int i = 0; i < wOrig + 2; i++)
	{
	    b.append(i == 0 | i == wOrig + 1 ? "+" : "-");
	}
	b.append("\n");
	return b;
    }

    private String frame()
    {
	String s = super.getP1().getString();
	int wOrig = super.getP1().getWidth();
	this.width = wOrig + 2;
	this.height = super.getP1().getHeight() + 2;
	String[] words = s.split("\n");
	StringBuilder b = bottomBar(wOrig, (content(words, topBar(wOrig))));
	return b.toString();
    }

    @Override
    public String getString()
    {
	return this.framed;
    }

    @Override
    public String toString()
    {
	return this.framed;
    }

}
