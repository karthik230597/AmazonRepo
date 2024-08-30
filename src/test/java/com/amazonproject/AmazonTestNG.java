package com.amazonproject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTestNG {

	static WebDriver driver = null;
	static String expected = "Furniture";

	@BeforeSuite
	private void browser_Launch() {

		List<String> m = new ArrayList<String>();
		m.add("start-maximized");
		m.add("incognito");
		ChromeOptions option = new ChromeOptions();
		option.addArguments(m);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);

	}

	@BeforeTest
	private void url_Launch() throws InterruptedException {
		driver.get("https://www.amazon.in/");
	}

	@BeforeClass
	private void elementWait() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	private void searchDropdown() {

		WebElement searchDropdown = driver.findElement(By.id("searchDropdownBox"));
		Select s = new Select(searchDropdown);
		List<WebElement> options = s.getOptions();
		for (WebElement dropdownOptions : options) {
			String selectedOption = dropdownOptions.getText();
			if (selectedOption.equals(expected)) {
				s.selectByVisibleText(expected);
				break;
			} 
		}
		

	}

}
