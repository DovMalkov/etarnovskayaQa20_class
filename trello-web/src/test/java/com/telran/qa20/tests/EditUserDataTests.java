package com.telran.qa20.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class EditUserDataTests extends  TestBase {


  @Test
  public void addAvatarTest() throws InterruptedException {
    app.getUser().clickOnAvatar();
    app.getUser().enterToProfile();
    app.getUser().changeAvatar();



  }
}
