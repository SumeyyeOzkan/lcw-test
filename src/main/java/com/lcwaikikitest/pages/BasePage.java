package com.lcwaikikitest.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriver webDriver;
    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public void run(){
        this.webDriver.get("https://www.lcwaikiki.com/tr-TR/TR");
        System.out.println("Site Açıldı");
    }
    public boolean checkUrl(String url ){
        String URL = webDriver.getCurrentUrl();
        return url.equals(URL);
    }

}
