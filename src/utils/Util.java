package utils;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Util extends Browsers{
	public static final String driverType ="chrome";
	public static final String FirefoxDriveLocation= System.getProperty("user.dir")+"\\driver\\geckodriver.exe";
	public static final String ChromeDriveLocation= System.getProperty("user.dir")+"\\driver\\chromedriver.exe";
	public static final int driverWaitTime = 20;	
	public static final String baseUrl= "http://live.demoguru99.com/index.php/";
	
	public static final	String mobileLinkPath = "//*[contains(text(),'Mobile')]";
	public static final String ExpecedHomePageTitle = "Home page";
	public static final String ExpecedMobilePageTitle="Mobile";
	public static final String SortByDropDownPath = "//select[@title='Sort By']";
	public static final String SortByVisibleText ="Name";
	
//	public static final String passwordPath = "//input[@name = 'password']";
//	public static final String loginButtonPath = "//input[@name='btnLogin']";
//	public static final String usernameInput ="mngr247775";
//	public static final String passwordInput = "pYhYjYg";
//	public static final String expectedError = "User or Password is not valid";
//	public static final String ExcelLocation = System.getProperty("user.dir")+"\\excels\\TestData.xlsx";
//	public static final String SheetName = "Login";
//	public static final String pageTextTagName = "tbody";
//	public static final String pattern = ":";
//	public static final String firstPattern = "mngr";
//	public static final String secondPattern= "[0-9]+";
	
	public static boolean verifySortByName(){
		//create an LinkedList instead of array-list because it preserves insertion order
		List<WebElement> products_Webelement = new LinkedList<WebElement>();
		//store the products (web elements) into the linked-list
		products_Webelement = driver.findElements(By.xpath("//img[contains(@id, 'product-collection-image')]"));
		//create another linked list of type string to store image title
		LinkedList<String> product_names =  new LinkedList<String>();
		//loop through all the elements of the product_webelement list get it title and store it into the product_names list
		for(int i=0;i<products_Webelement.size();i++){
			String s = products_Webelement.get(i).getAttribute("alt");
			product_names.add(s);}
		//send the list to check if the elements in the list are in alphabetical order and print the result
		String previous = ""; // empty string
		for (final String current: product_names) {
			if (current.compareTo(previous) < 0)
				return false;
			previous = current;}
		return true;
	}
}
