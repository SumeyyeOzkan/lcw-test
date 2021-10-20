package com.lcwaikikitest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void run(){
        //arama çubuğuna pantolon yazılır ve aratılır
        WebElement search=this.webDriver.findElement(By.id("search"));
        search.sendKeys("pantolon");
        search.sendKeys(Keys.ENTER);

        //sayfanın sonuna scroll edilir
        WebElement scroll=this.webDriver.findElement(By.cssSelector("body"));
        scroll.sendKeys(Keys.CONTROL,Keys.END);

        //daha fazla gör butonuna tıklanır
        WebElement seemore=this.webDriver.findElement(By.className("lazy-load-text"));
        seemore.click();

        //Rastgele bir ürün seçilir
        List<WebElement> products = this.webDriver.findElements(By.className("product-item-wrapper"));
        Random rnd=new Random();
        int index= rnd.nextInt(products.size());
        WebElement productRandom = products.get(index);
        WebElement productA = productRandom.findElement(By.className("a_model_item"));
        productA.click();
    }
}
