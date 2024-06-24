package com.tran.ssuper.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
  AppiumDriver driver;


  public HelperBase(AppiumDriver driver) {
    this.driver = driver;
  }

  public void click(By locator) {
    driver.findElement(locator).click();

  }

  public  void closeKeyBoard(){
    driver.hideKeyboard();
  }

  public void waitForElementAndClick(Long timeout, By locator) {

    new WebDriverWait(driver, timeout)
            .until(ExpectedConditions.presenceOfElementLocated(locator));

    driver.findElement(locator).click();

  }

  public void type(By locator, String text) {
    if(text != null) {
      click(locator);
      driver.findElement(locator).clear();
      driver.findElement(locator).sendKeys(text);
    }
  }

  public void pause(int millis) throws InterruptedException {
    Thread.sleep(millis);
  }


  public boolean isElementPresent(By locator){
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isElementPresent2(By locator){
    return  driver.findElements(locator).size()>0;
  }
}
