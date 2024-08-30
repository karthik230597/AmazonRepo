package com.amazonproject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Ipl2024_project {
	
	
	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "/Users/karthikgunasekaran/eclipse-workspace1/Amazon_Project/driver/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement googleSearchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		googleSearchBox.click();
		googleSearchBox.sendKeys("iplt20");
		googleSearchBox.submit();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		WebElement iplT20 = driver.findElement(By.xpath("//div[@class='BYM4Nd']/descendant::div[@class='yuRUbf']/descendant::h3"));
		System.out.println(iplT20.getText()+'\n');
		iplT20.click();
		WebElement fullPointTable= driver.findElement(By.xpath("//div[@class='pt-more-btn']/descendant::a"));
		Actions action = new Actions(driver);
		action.moveToElement(fullPointTable).build().perform();
		fullPointTable.click();
		Thread.sleep(4000);
		WebElement pointTableHeading = driver.findElement(By.xpath("//tr[@class='ih-pt-tbl']"));
		String tableHeading = pointTableHeading.getText();
		System.out.println(tableHeading+'\n');
		
		List<WebElement> pointTableStatus = driver.findElements(By.xpath("//tbody[@id=\"pointsdata\"]/child::tr"));
		for (WebElement tableStatus : pointTableStatus) {
			String pointTable = tableStatus.getText();
			System.out.println(pointTable);
			
		}
	
		
	}

}
