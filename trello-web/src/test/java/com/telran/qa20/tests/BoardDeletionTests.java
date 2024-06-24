package com.telran.qa20.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends  TestBase{
  @BeforeMethod
  public void  preconditions() throws InterruptedException {
    if(!app.getSession().isUserLoggedIn()){
      app.getSession().login("elena.telran@yahoo.com", "12345.com");
    };
  }

  @Test
  public void testPrivateBoardDeletion() throws InterruptedException {
    int before = app.getBoard().getPrivateBoardsCount();
    while (before > 4) {
      app.getBoard().openFirstPrivateBoard();

//    if (app.getBoard().isElementPresent(By.cssSelector("div.big-message.quiet"))) {
//        app.returnToHomePage();
//        app.getBoard().pause(10000);
//      } else {
     //   String boardname = app.getBoard().getBoardName();
     //   app.getBoard().openFirstPrivateBoard();
      if(!app.getBoard().isBoardMenuOpened()){
        app.getBoard().openMenu();
      }
        app.getBoard().initBoardDeletion();


        app.getBoard().confirmBoardDeletion();//.js-delete
        app.getBoard().confirmFinishBoardDeletion();//.js-confirm.full
        app.returnToHomePage();//[href='/']

        int after = app.getBoard().getPrivateBoardsCount();
        logger.info("left " + after + "groups");
before = app.getBoard().getPrivateBoardsCount();
    //    logger.info("GOOD JOB! Board " + boardname + " deleted ");
      // Assert.assertEquals(after, before - 1);
      }
    }
 // }

}
