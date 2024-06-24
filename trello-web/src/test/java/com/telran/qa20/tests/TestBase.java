package com.telran.qa20.tests;

import com.telran.qa20.manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
   static  ApplicationManager app =
           new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  Logger logger =
          LoggerFactory.getLogger(TestBase.class);

  @BeforeSuite
  public void setUp() throws InterruptedException {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {

    app.stop();
  }

  @BeforeMethod
  public void startLogger(Method m){
    logger.info("Start test  " + m.getName());
  }

  @AfterMethod(alwaysRun = true)
  public void stopLogger(Method m){
    logger.info("Stop test  " + m.getName());
  }



}
