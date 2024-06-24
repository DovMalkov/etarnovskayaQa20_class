package com.tran.ssuper.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ApplicationManager {
  SessionHelper session;
  AppiumDriver driver;

  public void init() throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "qa20_class");
    capabilities.setCapability("platformVersion", "8.0");
    capabilities.setCapability("automationName", "Appium");
    capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
    capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");
    capabilities.setCapability("app", "C:/Users/Elena/Documents/GitHub/etarnovskayaQa20_class/supers-android/src/test/resources/v.0.0.2.apk");

 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


    session = new SessionHelper(driver);
//    String deviceTime = driver.getDeviceTime();
//    System.out.println(deviceTime);
    System.out.println(driver.getDeviceTime());
   // driver.launchApp();
//    List<LogEntry> logcat = driver.manage().logs().get("logcat").getAll();
//    System.out.println(logcat);

    //   session.login("elena.telran@yahoo.com", "12345.com");

  }

//  public void stop() {
//    driver.quit();
//  }

  public void pause(int millis) throws InterruptedException {
    Thread.sleep(millis);
  }


  public void click(By locator) {
    driver.findElement(locator).click();
  }






  public SessionHelper getSession() {
    return session;
  }




}

