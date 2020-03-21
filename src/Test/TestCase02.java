package Test;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.Browsers;
import utils.Util;
/*“Verify that cost of product in list page and details page are equal”.     
Test Steps:
1. Goto http://live.demoguru99.com/
2. Click on ‘MOBILE’ menu
3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
4. Click on Sony-Xperia mobile
5. Read the Sony-Xperia mobile from detail page. Product value in list and details page should be equal ($100).*/

public class TestCase02 extends Browsers{
	@BeforeTest
	public void browserOpen(){Browsers.setUp();}

	@AfterTest
	public void tearDown() throws Exception { driver.quit();}

	@Test
	public void day01(){
		driver.findElement(By.xpath(Util.mobileLinkPath)).click() ;
		String SonyXperiaPriceOnListPage = driver.findElement(By.xpath(Util.SonyXperiaPricePath)).getText();
		driver.findElement(By.xpath(Util.SonyXperiaNamePath)).click();
		assertTrue(driver.getTitle().contains(Util.SonyXperiaDeatilPageTitle));
		String SonyXperiaPriceOnSetailPage = driver.findElement(By.xpath(Util.SonyXperiaPricePath)).getText();
		Assert.assertEquals(SonyXperiaPriceOnListPage, SonyXperiaPriceOnSetailPage);
		}
}
