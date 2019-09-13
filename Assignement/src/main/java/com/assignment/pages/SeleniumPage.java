package com.assignment.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.basetest.TestBase;

public class SeleniumPage extends TestBase{
	
	
	
	
	@FindBy(id="External_links")
	WebElement external_links;
	
	@FindBy(xpath="//td[@title='O, Oxygen']//span[contains(text(),'O')]")
	WebElement click_oxygen_link;
	
	@FindBy(tagName="a")
	List <WebElement> link_count;
	
	@FindBy(id="searchInput")
	WebElement search_data;
	
	@FindBy(xpath="//div[@class='suggestions-result']")
	List <WebElement> suggestions_value;
	
	public SeleniumPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String Selenium_Page_Title_Feature()
	{
		return driver.getTitle();
	}
	
	public void External_Link_Feature()
	{
		if(external_links.isDisplayed())
		{
			System.out.println("External_Link is Displayed in the WebPage");
		}
		else
		{
			System.out.println("External_Link is Not - Displayed in the WebPage");
		}
	}
	
	public void Oxygen_Click_Feature()
	{
		click_oxygen_link.click();
		
	}
	
	public String Oxgen_Page_Title_Feature()
	{
		return driver.getTitle();
	}
	
	public void Links_In_Page_Feature()
	{
		int count=0; 
	
		for(WebElement links : link_count)
		{
			String url=links.getAttribute("href");
			if(url!=null && url.contains(".pdf"))
			{
				count++;
			}		
		}
		System.out.println("No of Links with PDF Extention is --->"+count);
	}
	
	public void Search_Data_Feature(String search)
	{
		search_data.sendKeys(search);
	}
	
	public void Suggestion_Value_Feature()
	{
		int count = suggestions_value.size();
		System.out.println(count);
		
		for(WebElement element : suggestions_value)
		{
			String values = element.getText();
			System.out.println(values);
		}

	}
}
