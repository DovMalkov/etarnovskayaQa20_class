package com.telran.qa20.tests;

import org.testng.annotations.Test;

public class TrelloLoginTest  extends  TestBase{

  @Test(enabled = false)
  public void loginTest() throws InterruptedException {
    app.getSession().clickLoginButton();
    app.getSession().fillLoginForm("elena.telran@yahoo.com", "12345.com");
    app.getSession().pause(3000);
    app.getSession().confirmLogin();
    app.getSession().pause(10000);


  }

}
