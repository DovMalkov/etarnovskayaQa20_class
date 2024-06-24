package com.telran.qa20.tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardModificationTests extends  TestBase {
  @Test
  public void changeBoardNameTest() throws InterruptedException {

   String nameOnHomePage = app.getBoard().getFirstPrivateBoardName();
    logger.info("Opened board with name: "+ nameOnHomePage);
    app.getBoard().openFirstPrivateBoard();
    String boardName = app.getBoard().getBoardName();
    Assert.assertEquals(boardName, nameOnHomePage);

    app.getBoard().changeBoardName("changes" + System.currentTimeMillis()+ Keys.ENTER);

    //Assert.assertTrue();








  }
}
