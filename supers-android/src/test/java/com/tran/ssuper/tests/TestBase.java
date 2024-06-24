package com.tran.ssuper.tests;

import com.tran.ssuper.manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class TestBase {
   static  ApplicationManager app =
           new ApplicationManager();

  Logger logger =
          LoggerFactory.getLogger(TestBase.class);

  @BeforeSuite
  public void setUp() throws InterruptedException, MalformedURLException {
    app.init();
    app.pause(7000);
  }

  @AfterSuite(enabled = false)
  public void tearDown() {

    //app.stop();
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
