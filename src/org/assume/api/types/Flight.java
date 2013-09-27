package org.assume.api.types;

import java.io.Serializable;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.assume.api.flightchecking.GUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Flight implements Serializable
{

	private static final long serialVersionUID = 1494552303306952227L;
	private String firstName;
	private String lastName;
	private String confirmationNumber;
	private Date date;

	public Flight(String firstName, String lastName, String confirmationNumber,
			Date date)
	{
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setConfirmationNumber(confirmationNumber);
		this.setDate(date);
		GUI.flights.add(this);
	}

	public void schedule()
	{
		schedule(this);
	}

	private void schedule(final Flight f)
	{
		new Timer().schedule(new TimerTask()
		{
			@Override
			public void run()
			{
				f.checkIn();
			}
		}, this.getDate());
	}

	public void checkIn()
	{
		WebDriver driver = new HtmlUnitDriver();
		driver.get("http://www.southwest.com/flight/retrieveCheckinDoc.html");

		WebElement firstName = driver.findElement(By.name("firstName"));
		WebElement lastName = driver.findElement(By.name("lastName"));
		WebElement confirmationNumber = driver.findElement(By
				.name("confirmationNumber"));

		confirmationNumber.sendKeys(this.getConfirmationNumber());
		firstName.sendKeys(this.getFirstName());
		lastName.sendKeys(this.getLastName());
		lastName.submit();
		System.out.println("checked in" + this.getConfirmationNumber());
		GUI.flights.remove(this);
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getConfirmationNumber()
	{
		return confirmationNumber;
	}

	public void setConfirmationNumber(String confirmationNumber)
	{
		this.confirmationNumber = confirmationNumber;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

}
