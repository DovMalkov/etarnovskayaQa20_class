package com.telran.qa20.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class UserHelper extends  HelperBase {
  public UserHelper(WebDriver wd) {
    super(wd);
  }
  public void clickOnAvatar() {
    click(By.cssSelector("[data-test-id='header-member-menu-button']"));
  }

  public void enterToProfile() {
    click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
  }

  public void changeAvatar() throws InterruptedException {
    WebElement avatar = wd.findElement(By.cssSelector("div.rsiNque2CCqtPE"));
    new Actions(wd).moveToElement(avatar).pause(3)
            .click(wd.findElement(By.cssSelector("button._2e97X7K2YRLv4Q"))).perform();

   attach(By.name("file"), new File("src/test/resources/cat_small1.png"));
    pause(10000);

  }

  private void attach(By locator, File file) {
    wd.findElement(locator).sendKeys(file.getAbsolutePath());
  }

  public void saveChanges() {
  }
}
