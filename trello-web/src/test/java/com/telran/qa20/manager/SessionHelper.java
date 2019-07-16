package com.telran.qa20.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class SessionHelper  extends HelperBase{

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void confirmLogin() {
    click(By.id("login"));
  }

  public void fillLoginForm(String email, String password) {
    type(By.id("user"), email);
    type(By.name("password"), password);
  }

  public void login(String email, String pwd) throws InterruptedException {
    clickLoginButton();
    fillLoginForm(email, pwd); //"elena.telran@yahoo.com", "12345.com"
    pause(3000);
    confirmLogin();
    pause(10000);
  }

  public boolean isUserLoggedIn() {
    return isElementPresent2(By.cssSelector("[href='/']"));
  }

  public void clickLoginButton() {
    click(By.cssSelector("[href='/login']"));
  }
}
