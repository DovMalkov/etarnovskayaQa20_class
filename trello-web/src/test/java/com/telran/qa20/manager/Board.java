package com.telran.qa20.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Board extends HelperBase {

  public Board(WebDriver wd) {
    super(wd);
  }

  public  void confirmBoardCreation(){
    click(By.cssSelector("[data-test-id=header-create-board-submit-button]"));
  }

  public void typeBoardName(String boardName) {
    type(By.cssSelector("[data-test-id=header-create-board-title-input]"), boardName);

  }

  public void selectCreateBoardFromDropDown() {
    click(By.cssSelector("[data-test-id=header-create-board-button]"));
  }

  public int getPersonalBoardsCount() {
    return  wd.findElements(By.xpath("//span[@class='icon-lg icon-member']/../../..//li")).size()-1;
  }

}
