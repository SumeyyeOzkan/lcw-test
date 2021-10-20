package com.lcwaikikitest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductPage extends BasePage{
    public float price = 0;
    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void run(){
        Random rnd=new Random();

        //Beden seçilir. (BEDEN SEÇİLMEDEN SEPETE EKLEME YAPILMAMAKTADIR)
        //Bazı ürünler birden fazla renk olabildiği için, önce renk, sonra beden seçimi yapılır
        WebElement optionSize =this.webDriver.findElement(By.id("option-size"));
        List<WebElement> otherColors = this.webDriver.findElements(By.className("dv-look-list"));

        if(otherColors.size()>0) {
            int index3=rnd.nextInt(otherColors.size());
            //Renk seçimi yapılmıştır
            WebElement color= otherColors.get(index3);
            //ürün fiyatı alınmıştır
            WebElement priceElement=color.findElement(By.className("option-single-cash"));
            String str = priceElement.getAttribute("innerText");
            String strArray[] = str.trim().split("\\s+");
            price = Float.parseFloat(strArray[0].replace(",","."));
            //Beden listesi açılmıştır
            WebElement dropDownOpener = color.findElement(By.className("sizeHeight"));
            dropDownOpener.click();
            WebElement optionSize2=color.findElement(By.id("option-size"));
            List<WebElement> sizes =  optionSize2.findElements(By.tagName("a"));

            int index2=rnd.nextInt(sizes.size());
            //Beden seçimi yapılmıştır
            WebElement selectSize = sizes.get(index2);
            selectSize.click();
            WebElement sizeAndCart=color.findElement(By.className("sizeAndCart"));
            List<WebElement> sizeAndCartA = sizeAndCart.findElements(By.tagName("a"));
            //ürün sepete eklenir
            sizeAndCartA.get(sizeAndCartA.size() - 1).click();

        }
        else if (optionSize!=null){
            WebElement priceElement=this.webDriver.findElement(By.className("price"));
            String str = priceElement.getAttribute("innerText");
            String strArray[] = str.trim().split("\\s+");
            price = Float.parseFloat(strArray[0].replace(",","."));
            //tek renk varsa sadece beden seçimi yapılır
            List<WebElement> sizes =  optionSize.findElements(By.tagName("a"));
            int index2=rnd.nextInt(sizes.size());
            sizes.get(index2).click();
            //ürün sepete eklenir
            WebElement productbutton=this.webDriver.findElement(By.id("pd_add_to_cart"));
            productbutton.click();
        }
        System.out.println(price == 0 ? "nbull":price);


    }
}
