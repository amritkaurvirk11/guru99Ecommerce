package Test;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.Browsers;
import utils.Util;
//go to baseUrl
//verify the title of the page
//click on mobile menu
//verify the title of the page
//click sort by drop-down and click names
//verify the products are sorted with names
public class TestCase01 extends Browsers{
	@BeforeTest
	public void browserOpen(){Browsers.setUp();}

	@AfterTest
	public void tearDown() throws Exception { driver.quit();}

	@Test
	public void day01(){
		assertTrue(driver.getTitle().toLowerCase().contains(Util.ExpecedHomePageTitle.toLowerCase()));
		driver.findElement(By.xpath(Util.mobileLinkPath)).click() ;
		assertTrue(driver.getTitle().toLowerCase().contains(Util.ExpecedMobilePageTitle.toLowerCase()));
		Select SortBy = new Select(driver.findElement(By.xpath(Util.SortByDropDownPath)));
		SortBy.selectByVisibleText(Util.SortByVisibleText);
		assertTrue(Util.verifySortByName());
		}
}
