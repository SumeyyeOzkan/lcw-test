package com.lcwaikikitest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void run(){
        //Siteye giriş yapılır ve kontrol edillir
        WebElement loginEmail=this.webDriver.findElement(By.id("LoginEmail"));
        WebElement loginPassword=this.webDriver.findElement(By.id("Password"));
        WebElement loginButton=this.webDriver.findElement(By.id("loginLink"));
        loginEmail.sendKeys("mailadresi@mailadresi.com");
        loginPassword.sendKeys("şifrenizi giriniz");
        loginButton.click();
        if (webDriver.getCurrentUrl().contains("https://www.lcwaikiki.com/tr-TR/TR")) {
            System.out.println("lcwaikiki sayfasina giris yapildi");
            System.out.println("-----------------------------");
        } else {
            throw new WebDriverException("lcwaikiki sayfasi acilamadi");
        }
    }
    public boolean checkLogin(){
        WebElement control = webDriver.findElement(By.className("header-icon-label"));
        return control.getAttribute("innerText").equals("Hesabım");
    }
}
