package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initlization();
		testUtil=new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("name"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLinks();
		
	}
	
	@Test(priority=1)
	public void verifyContactLabelTest()
	{
		Assert.assertTrue(contactsPage.verifyContactLabel(),"contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectsSingleContactsByNameTest()
	{
		contactsPage.selectsContactsByName("Natwar Lal");
	}
	
	@Test(priority=3)
	public void selectsDoubleContactsByNameTest()
	{
		contactsPage.selectsContactsByName("Bahu Bali");
		contactsPage.selectsContactsByName("Natwar Lal");
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
