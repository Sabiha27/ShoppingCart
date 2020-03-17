package com.test;

import java.io.IOException;

import org.testng.annotations.Test;


import com.Util.Utility;
import com.pages.LoginPage;
import com.Base.TestBase;

public class LoginTest extends TestBase {

	public LoginPage loginpage;
	public Utility ut;
	public static String sheetName= "Sheet1";
	public static String fileName=System.getProperty("user.dir")+"/src/main/java/login.xlsx";

	@Test(priority = 1)
	public void checkErrorMessageForEmail() throws IOException {
		loginpage = new LoginPage(driver, childTest);
		ut = new Utility();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actErrorMessage1 = loginpage.emailerrorMsg.getText();
		System.out.println("actErrorMessage1" + actErrorMessage1);
		Utility.info(childTest, "actual error message");
		String expMessage1 = "Please enter email as kiran@gmail.com";
		Utility.info(childTest, "expected error message");
		if (actErrorMessage1.equals(expMessage1)) {
			Utility.pass(childTest, "Actual error & Expected error are equals");
			ut.assertEqual(expMessage1, actErrorMessage1, false,childTest);
		} else {
			Utility.fail(childTest, "Actual error & Expected error are not equals");
			ut.assertEqual(expMessage1, actErrorMessage1, true,childTest);

		}


	}

	@Test(priority = 2)
	public void checkErrorMessageForPassword() throws IOException {
		loginpage = new LoginPage(driver, childTest);
		ut = new Utility();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actErrorMessage2 = loginpage.pswderrorMsg.getText();
		System.out.println("actErrorMessage1" + actErrorMessage2);
		ut.info(childTest, "actual error message");
		String expMessage2 = "Please enters password 123456";
		ut.info(childTest, "expected error message");

		if (actErrorMessage2.equals(expMessage2)) {
			ut.pass(childTest, "Actual error & Expected error are equals");
			ut.assertEqual(expMessage2, actErrorMessage2, false,childTest);
		} else {
			ut.fail(childTest, "Actual error & Expected error are not equals");
			ut.assertEqual(expMessage2, actErrorMessage2, true,childTest);

		}

		ut.assertAll();

	}

}
