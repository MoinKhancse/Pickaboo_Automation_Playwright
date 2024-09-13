package Pickaboo;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MouseHover {
	Playwright playwright;
	BrowserType browserType;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	
	@BeforeSuite
	public void start() {
		playwright = Playwright.create();
		browserType = playwright.chromium();
		browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
		browserContext = browser.newContext(new Browser.NewContextOptions());
		page = browser.newPage();	
	}
	
	@Test(priority = 0)
	public void openUrl() throws InterruptedException {
		page.navigate("https://www.pickaboo.com");
		Thread.sleep(5000);
	}
	@Test(priority = 2)
	public void mouseHover() throws InterruptedException {
//		ElementHandle close = page.querySelector("//div[@class='close-btn']//img");
//		close.click();
//		Thread.sleep(2000);
		
		ElementHandle element = page.querySelector("//div[@class='home-banner__menu']//a[@class='a-tag'][normalize-space()='Smartphones']");
		element.hover();
		Thread.sleep(2000);
		
		ElementHandle realme = page.querySelector("//li[1]//ul[1]//li[2]//a[1]");
		realme.click();
		Thread.sleep(2000);
		
		ElementHandle phone = page.querySelector("//img[@alt='realme C61 6GB/128GB']");
		phone.click();
		Thread.sleep(5000);
		
		ElementHandle color = page.querySelector("//div[@class='views']//div[1]//center[1]//img[1]");
		color.click();
		Thread.sleep(2000);
		
//		ElementHandle scroll = page.querySelector("//div[@class='TitleBig__StyledTitleBig-sc-j7ml3i-0 btWVZf big-title']");
//		scroll.scrollIntoViewIfNeeded();
//		Thread.sleep(2000);
		
		ElementHandle buy_now = page.querySelector("//span[normalize-space()='ADD TO CART']");
		buy_now.click();
		Thread.sleep(10000);
		
	
	}
	@Test(priority = 1)
	public void login() throws InterruptedException {
		ElementHandle close = page.querySelector("//div[@class='close-btn']//img");
		close.click();
		Thread.sleep(2000);
		ElementHandle Login = page.querySelector("//span[normalize-space()='Login']");
		Login.click();
		Thread.sleep(2000);
		ElementHandle Number = page.querySelector("//input[@placeholder='Mobile Number/Email']");
		Number.fill("01920436373");
		Thread.sleep(2000);
		ElementHandle pass = page.querySelector("//input[@placeholder='Password']");
		pass.fill("01717511288mk");
		Thread.sleep(2000);
		
		ElementHandle button = page.querySelector("//span[@class='MuiButton-label']");
		button.click();
		Thread.sleep(5000);	
			
	}
	@Test(priority = 3)
	public void chackOut() throws InterruptedException {
		ElementHandle cart = page.querySelector("//img[@alt='cart']");
		cart.click();
		Thread.sleep(5000);	
		
		ElementHandle checkout = page.querySelector("//span[normalize-space()='Proceed to checkout']");
		checkout.click();
		Thread.sleep(5000);
		
		ElementHandle first_name = page.querySelector("//input[@placeholder='Enter your first name']");
		first_name.fill("Moin");
		Thread.sleep(5000);
		
		ElementHandle last_name = page.querySelector("//input[@placeholder='Enter your last name']");
		last_name.fill("Khan");
		Thread.sleep(5000);
		
		ElementHandle number = page.querySelector("//input[@placeholder='Enter your number']");
		number.fill("0177511288");
		Thread.sleep(5000);
		
		ElementHandle address = page.querySelector("//input[@id='outlined-multiline-static']");
		address.fill("Gulshan:01, Dhaka-1212");
		Thread.sleep(5000);
		
		ElementHandle Division = page.querySelector("//em[normalize-space()='Select Division']");
		Division.click();
		Thread.sleep(5000);
		
		ElementHandle Barisal = page.querySelector("//li[normalize-space()='Barisal']");
		Barisal.click();
		Thread.sleep(5000);
		
		ElementHandle City = page.querySelector("//em[normalize-space()='Select City']");
		City.click();
		Thread.sleep(5000);
		
		ElementHandle Bhola = page.querySelector("//li[normalize-space()='Bhola']");
		Bhola.click();
		Thread.sleep(5000);
		
		ElementHandle Area = page.querySelector("//em[normalize-space()='Select Area']");
		Area.click();
		Thread.sleep(5000);
		
		ElementHandle Fasson = page.querySelector("//li[normalize-space()='Daulat Khan']");
		Fasson.click();
		Thread.sleep(5000);
		
		ElementHandle btn = page.querySelector("//div[@class='Button__StyledBtn-sc-55nib8-0 kjtuoW dc-btn']//a");
		btn.scrollIntoViewIfNeeded();
		Thread.sleep(5000);
		
		ElementHandle Continue = page.querySelector("//span[normalize-space()='Continue']");
		Continue.click();
		Thread.sleep(5000);
	}
	@Test(priority = 4)
	public void removeCart() throws InterruptedException {
		ElementHandle cart = page.querySelector("//img[@alt='cart']");
		cart.click();
		Thread.sleep(5000);
		
		ElementHandle Remove = page.querySelector("//div[normalize-space()='Remove']");
		Remove.click();
		Thread.sleep(5000);
		
	}
	
	@AfterSuite
	public void close() {
		page.close();
		browser.close();
		playwright.close();
	}

}
