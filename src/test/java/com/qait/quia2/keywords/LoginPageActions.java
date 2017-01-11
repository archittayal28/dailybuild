package com.qait.quia2.keywords;

import static com.qait.quia2.automation.utils.YamlReader.getData;
import static com.qait.quia2.automation.utils.YamlReader.getYamlValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qait.quia2.automation.getpageobjects.*;

/**
 *
 * @author
 */
public class LoginPageActions extends GetPage {

	public LoginPageActions(WebDriver driver) {
		super(driver, "QUIA2/LoginPage");
	}

	public void login_to_the_application_as(String username, String password) {
		element("username").clear();
		element("username").sendKeys(username);
		element("password").clear();
		element("password").sendKeys(password);
		element("btn_signin").click();
		//logMessage("[INFO]: log into the application using credentials '" + username + " / " + password + "'");
	}

}
