package com.telran.qa20.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
  WebDriver wd;


  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  public void click(By locator) {
    wd.findElement(locator).click();

  }

  public void waitForElementAndClick(Long timeout, By locator) {

    new WebDriverWait(wd, timeout)
            .until(ExpectedConditions.presenceOfElementLocated(locator));

    wd.findElement(locator).click();

  }

  public void type(By locator, String text) {
    if(text != null) {
      click(locator);
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(text);
    }
  }

  public void pause(int millis) throws InterruptedException {
    Thread.sleep(millis);
  }


  public boolean isElementPresent(By locator){
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isElementPresent2(By locator){
    return  wd.findElements(locator).size()>0;
  }
}
