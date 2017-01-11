package com.qait.quia2.keywords;

import org.openqa.selenium.WebDriver;
import com.qait.quia2.automation.getpageobjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Archit
 */
public class AB_Canvas_Page extends GetPage {

    public String placeholder;

    public AB_Canvas_Page(WebDriver driver) {
        super(driver, "QUIA2/ABCanvasPage");
    }

    public void clicking_platform(String value) {
        wait.waitForElementToDisappear(element("load_spinner"));
        removing_alert();
        element("platform", value).click();
    }

    public void clicking_artifact(String value) {
        element("show_environment", value).click();
        wait.waitForElementToDisappear(element("load_spinner"));
        removing_alert();
    }

    public void clicking_Edit_Platform() {
        element("action_button").click();
        wait.waitForElementToBeVisible(element("edit_Platform"));
        element("edit_Platform").click();
        wait.waitForElementToDisappear(element("load_spinner"));
        removing_alert();
    }

    public void clicking_Foundation_Setting() {
        wait.waitForElementToBeVisible(element("foundation_settings"));
        element("foundation_settings").click();
    }

    public void clicking_Artifact(String value) {
        element("artifact_button").click();
        element("select_artifact", value).click();
        logMessage("Artifact: " + value);
    }

    public void fetching_current_build() {
        wait.waitForElementToBeVisible(element("current_build"));
        String build = element("current_build").getText();
        logMessage("Current build is : " + build);
    }

    public void removing_alert() {
        if (isElementDisplayed("alert")) {
            element("end_tour").click();
        }
    }

    public void selecting_Label(String value) {
        scroll_Up();
        element("label", value).click();
    }

    public void scroll_Up() {
        WebElement element = driver.findElement(By.xpath("//h3[@class='closed']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
