package com.academy.techcenture.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ViewAllProductsPage extends BasePage {
    public ViewAllProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h2")
    protected WebElement viewAllProductsPageHeader;

//    @FindBy(xpath= "//table[@class ='ProductsTable']")
//    protected WebElement tableOfProducts;

    public void verifyUserIsOnViewAllProductsPage(){
        Assert.assertTrue(viewAllProductsPageHeader.isDisplayed());
    }

    public void validateViewAllProductsPageHeader(){
        Assert.assertEquals(viewAllProductsPageHeader.getText(),"List of Products");
    }

    public void validateAllProductsPriceAndNameAndDiscount(){
        WebElement tableOfProduct = driver.findElement(By.xpath("//table[@class ='ProductsTable']"));

        List<WebElement> tableHeader = tableOfProduct.findElements(By.tagName("th"));
        WebElement firstElementTableHeader = tableHeader.get(0);
        Assert.assertEquals(firstElementTableHeader.getText(),"Product name");

        WebElement secondElementTableHeader = tableHeader.get(1);
        Assert.assertEquals(secondElementTableHeader.getText(),"Price");
        WebElement thirdElementTableHeader = tableHeader.get(2);
        Assert.assertEquals(thirdElementTableHeader.getText(),"Discount");


        List<WebElement> rows = tableOfProduct.findElements(By.tagName("tr"));
        //cells  of row1
        List<WebElement> cells1 = rows.get(1).findElements(By.tagName("td"));
        // cell1
        String myMoneyProduct = cells1.get(0).getText();
        Assert.assertEquals( myMoneyProduct,"MyMoney");
        String myMoneyPrice = cells1.get(1).getText();
        Assert.assertEquals( myMoneyPrice,"$100");
        String myMoneyDiscount = cells1.get(2).getText();
        Assert.assertEquals( myMoneyDiscount, "8%");

        //cells  of row2
        List<WebElement> cells2 = rows.get(2).findElements(By.tagName("td"));
        // cell2
        String familyAlbumProduct = cells2.get(0).getText();
        Assert.assertEquals( familyAlbumProduct,"FamilyAlbum");
        String familyAlbumPrice = cells2.get(1).getText();
        Assert.assertEquals( familyAlbumPrice,"$80");
        String familyAlbumDiscount = cells2.get(2).getText();
        Assert.assertEquals(familyAlbumDiscount, "15%");

        //cells  of row3
        List<WebElement> cells3 = rows.get(3).findElements(By.tagName("td"));
        // cell3
        String screenSaverProduct = cells3.get(0).getText();
        Assert.assertEquals( screenSaverProduct,"ScreenSaver");
        String screenSaverPrice = cells3.get(1).getText();
        Assert.assertEquals( screenSaverPrice,"$20");
        String screenSaverDiscount = cells3.get(2).getText();
        Assert.assertEquals(screenSaverDiscount, "10%");

    }


}
