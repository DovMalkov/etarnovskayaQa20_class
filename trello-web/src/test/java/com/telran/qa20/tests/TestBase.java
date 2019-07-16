package com.telran.qa20.tests;

import com.telran.qa20.manager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

   ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws InterruptedException {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }


}
