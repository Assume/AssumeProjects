package org.assume.ZybezPriceGrabber;

import java.io.IOException;

import org.assume.ZybezPriceGrabber.PriceItem;
public class Handler implements Runnable
{

	public int price;
	public String name;
	private int id;
	public Handler(String name)
	{
		this.name = name;
	}

	@Override
	public void run() 
	{
		if(this.name != null)
		{
			this.price = PriceItem.getPrice(name);
			try {
				ZybezPriceGrabber.me.addItem(this.name, this.price);
				System.out.println(this.name + " : "+ this.price);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
