package com.lcwaikikitest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage extends BasePage{
    public BasketPage(WebDriver webDriver) {
        super(webDriver);
    }
    float price;
    float basketPrice;
    public void run(float price){
        //Ürün sayfasındaki fiyat ile sepette yer alan fiyat karşılaştırılır
        WebElement goToBasket=this.webDriver.findElement(By.className("header-cart"));
        goToBasket.click();
        WebElement priceElement2=this.webDriver.findElement(By.className("rd-cart-item-price"));
        String str = priceElement2.getAttribute("innerText");
        String strArray[] = str.trim().split("\\s+");
        float basketPrice = Float.parseFloat(strArray[0].replace(",","."));
        if (price==basketPrice){
            System.out.println("ürün tutarı ile sepet tutarı aynıdır");
        }
        else {
            System.out.println("Ürün tutarı ile sepet tutarı aynı değildir");
        }





    }
    public boolean priceControl(){
        return price == basketPrice;
    }
    public void incrementCount(){
        //Adet arttırılarak ürünün 2 adet olduğu doğrulanır
        WebElement productCountUp=this.webDriver.findElement(By.className("oq-up"));
        productCountUp.click();

    }
    public boolean incrementEquals2(){
        WebElement productCount=this.webDriver.findElement(By.className("item-quantity-input"));

        if (productCount.getAttribute("value").contains("2")) {
            System.out.println("Sepetteki urun adedi 2'dir.");
            System.out.println("-----------------------------");
            return true;

        } else {
            System.out.println("Sepetteki urun adedi 2 degildir.");
            return false;
        }
    }
    public void clearBasket(){
        //Ürün sepetten silinerek boş olduğu kontrol edilir
        WebElement clearbasket = this.webDriver.findElement(By.className("cart-square-link"));
        clearbasket.click();
        WebElement clearbasket2 = this.webDriver.findElement(By.className("sc-delete"));
        clearbasket2.click();


    }
    public boolean basketIsEmpty(){
        WebElement cardEmptyTitle = this.webDriver.findElement(By.className("cart-empty-title"));
        if (cardEmptyTitle != null) {
            System.out.println("Sepetteniz boştur");
            System.out.println("-----------------------------");
            return true;

        } else {
            System.out.println("Sepet doludur");
            return false;
        }
    }
}
