package com.tran.ssuper.manager;

import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  SessionHelper session;
AppiumDriver  wd;
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

  public void init() throws InterruptedException, MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "qa20_class");
    capabilities.setCapability("platformVersion", "8.0");
    capabilities.setCapability("automationName", "Appium");
    capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
    capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");
    capabilities.setCapability("app", "C:/Users/Elena/Documents/GitHub/etarnovskayaQa20_class/supers-android/src/test/resources/v.0.0.2.apk");

wd = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


    session = new SessionHelper(wd);
    String deviceTime = wd.getDeviceTime();
    System.out.println(deviceTime);
    wd.launchApp();
    List<LogEntry> logcat = wd.manage().logs().get("logcat").getAll();
    System.out.println(logcat);

    //   session.login("elena.telran@yahoo.com", "12345.com");

  }

//  public void stop() {
//    wd.quit();
//  }

  public void pause(int millis) throws InterruptedException {
    Thread.sleep(millis);
  }


  public void click(By locator) {
    wd.findElement(locator).click();
  }






  public SessionHelper getSession() {
    return session;
  }




}

