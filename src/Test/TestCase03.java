package Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.Browsers;
import utils.Util;
/*“Verify that you cannot add more product in cart than the product available in store"    
Test Steps:
1. Goto http://live.demoguru99.com/
2. Click on ‘MOBILE’ menu
3. Click on add to cart for Sony Xperia mobile
4. Change 'QTY' value to 1000 and click update button
5. Verify the error message
6. Click on empty cart link in footer of list of all mobile
7. Verify cart is empty
*/
public class TestCase03 extends Browsers{
	@BeforeTest
	public void browserOpen(){Browsers.setUp();}

	@AfterTest
	//public void tearDown() throws Exception { driver.quit();}

	@Test
	public void day01() throws InterruptedException{
		driver.findElement(By.xpath(Util.mobileLinkPath)).click() ;
		List<WebElement> addToCartButtons = getDriver().findElements(By.xpath(Util.addToCartButtonPath));
		addToCartButtons.get(Util.SonyXperiaAddToCartButtonIndex).click();
		driver.findElement(By.xpath(Util.QuantityButtonPath)).clear();
		driver.findElement(By.xpath(Util.QuantityButtonPath)).sendKeys(Util.Quantity);
		driver.findElement(By.xpath(Util.QuantityUpdateButtonPath)).click();
		String ActualErrorMessage = driver.findElement(By.xpath(Util.ErrorMessagePath)).getText();
		assertEquals(ActualErrorMessage.replaceAll(" ", ""),Util.ExpectedErrorMessage.replaceAll(" ", ""));
		driver.findElement(By.xpath(Util.EmptyCartLinkPath)).click();
		assertEquals(driver.findElement(By.xpath(Util.HeaderMiniCartPath)).getText(),"");
	
		}
}
