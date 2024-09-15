package Pickaboo;



import java.util.List;

//import java.awt.Dimension;
//import java.awt.Toolkit;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Google {
	Playwright playwright;
	BrowserType browserType;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	
	@BeforeSuite
	public void start() {
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		int width = (int)screenSize.getWidth();
//		int height = (int)screenSize.getHeight();
//		System.out.println(width +":"+height);
		
		
		playwright = Playwright.create();
		browserType = playwright.chromium();
		browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized")));
		browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		page = browserContext.newPage();
	}
	@Test(priority = 0)
	public void openUrl() throws InterruptedException {
		page.navigate("https://www.google.com");
		Thread.sleep(2000);
	}
	@Test(priority = 1)
	public void pressEnter() throws InterruptedException {
		ElementHandle tex = page.querySelector("//textarea[@id='APjFqb']");
		tex.fill("Selenium");
		tex.press("Enter");
		Thread.sleep(5000);
		
		ElementHandle selenium = page.querySelector("//a[@href='https://www.selenium.dev/']//h3[@class='LC20lb MBeuO DKV0Md'][normalize-space()='Selenium']");
		selenium.click();
		Thread.sleep(5000);
		
		ElementHandle navbarDropdown = page.querySelector("//a[@id='navbarDropdown']");
		navbarDropdown.click();
		Thread.sleep(5000);
		
		ElementHandle History = page.querySelector("//a[normalize-space()='History']");
		History.click();
		Thread.sleep(5000);
		
		String scriptButtom= "window.scrollTo(0,document.body.scrollHeight)";
		page.evaluate(scriptButtom);
		Thread.sleep(5000);
		
		String scriptTop= "window.scrollTo(0,0)";
		page.evaluate(scriptTop);
		Thread.sleep(5000);
		
		page.reload();
		Thread.sleep(5000);
	}

}
