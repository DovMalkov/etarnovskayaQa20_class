package com.telran.qa20.manager;

import com.google.common.io.Files;
import com.telran.qa20.tests.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  Board board;
  SessionHelper session;
  UserHelper user;
  EventFiringWebDriver wd;
  Teams teams;
   String browser;



   public static class MyListener extends AbstractWebDriverEventListener{
     @Override
     public void afterFindBy(By by, WebElement element, WebDriver driver) {
       System.out.println(by + " found");
     }

     @Override
     public void onException(Throwable throwable, WebDriver driver) {
       System.out.println(throwable);
       File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       File screenshot = new File("src/test/screenshots/screenshot-" + System.currentTimeMillis()+".png");
       try {
         Files.copy(tmp, screenshot);
       } catch (IOException e) {
         e.printStackTrace();
       }
       System.out.println("!!!! Created Screenshot "+ screenshot);

     }

     @Override
     public void beforeFindBy(By by, WebElement element, WebDriver driver) {
       System.out.println("start search " + by);

     }
   }


  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() throws InterruptedException {

    if(browser.equals(BrowserType.CHROME)){
      wd = new EventFiringWebDriver(new ChromeDriver());
    } else if(browser.equals(BrowserType.FIREFOX)){
      wd = new EventFiringWebDriver(new FirefoxDriver());
    }else if(browser.equals(BrowserType.IE)){
      wd = new EventFiringWebDriver(new InternetExplorerDriver());
    }

    wd.register(new MyListener());

    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wd.get("https://trello.com");
    session = new SessionHelper(wd);

    session.login("elena.telran@yahoo.com", "12345.com");
    user = new UserHelper(wd);
    board = new Board(wd);
    teams = new Teams(wd);
  }

  public void stop() {
    wd.quit();
  }

  public void pause(int millis) throws InterruptedException {
    Thread.sleep(millis);
  }


  public void click(By locator) {
    wd.findElement(locator).click();
  }


  public void clickOnPlusButtonOnHeader() {
    click(By.cssSelector("[name=add]"));
  }

  public void returnToHomePage() throws InterruptedException {
    click(By.cssSelector("a [name=house]"));
    pause(5000);
    click(By.cssSelector("a [name=house]"));
  }

  public Board getBoard() {
    return board;
  }

  public SessionHelper getSession() {
    return session;
  }

  public Teams getTeams() {
    return teams;
  }

  public UserHelper getUser() {
    return user;
  }


}

