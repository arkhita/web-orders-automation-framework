package com.academy.techcenture.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class OrderPage  extends BasePage{

    public OrderPage(WebDriver driver){
        super(driver);

    }

    @FindBy(tagName =  "h1")
    protected WebElement pageMainHeader;

    @FindBy(xpath = "//div[@class ='login_info'] ")
    protected WebElement welcomeUser;

    @FindBy(id ="ctl00_logout")
    protected WebElement logoutBtn;

    @FindBy(xpath = "//a[text() ='View all orders']")
    protected WebElement viewAllOrdersLink;

    @FindBy(xpath = "//a[text() ='View all products']")
    protected WebElement viewAllProductsLink;

    @FindBy(xpath = "//a[text() ='Order']")
    protected WebElement orderLink;

    @FindBy(tagName = "h2")
    protected WebElement orderPageHeader;


    //======  Product Information
    @FindBy(xpath = "//h3[contains(text(), 'Product Information')]")
    protected WebElement productInfoLabel;
    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    protected WebElement productMenu;
    @FindBy(id ="ctl00_MainContent_fmwOrder_txtQuantity")
    protected WebElement quantityInput;
    @FindBy(id ="ctl00_MainContent_fmwOrder_txtUnitPrice")
    protected WebElement pricePerUniteInput;
    @FindBy(id ="ctl00_MainContent_fmwOrder_txtDiscount")
    protected WebElement discountInput;
    @FindBy(id ="ctl00_MainContent_fmwOrder_txtTotal")
    protected WebElement totalInput;
    @FindBy(xpath="//input[@value ='Calculate']")
    protected WebElement calculateBtn;

    //=======Address Information
    @FindBy(xpath = "//h3[contains(text(), 'Address Info')]")
    protected WebElement addressInfoLabel;
    @FindBy(id ="ctl00_MainContent_fmwOrder_txtName")
    protected WebElement customerNameInput;
    @FindBy(id ="ctl00_MainContent_fmwOrder_TextBox2")
    protected WebElement streetInput;
    @FindBy(id ="ctl00_MainContent_fmwOrder_TextBox3")
    protected WebElement cityInput;
    @FindBy(id ="ctl00_MainContent_fmwOrder_TextBox4")
    protected WebElement stateInput;
    @FindBy(id ="ctl00_MainContent_fmwOrder_TextBox5")
    protected WebElement zipCodeInput;

    //==== Payment Information
    @FindBy(xpath = "//h3[contains(text(), 'Payment Information')]")
    protected WebElement paymentInfoLabel;
    @FindBy(id ="ctl00_MainContent_fmwOrder_cardList_0")
    protected WebElement visaCardBox;
    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
    protected WebElement masterCardBox;
    @FindBy(id ="ctl00_MainContent_fmwOrder_cardList_2")
    protected  WebElement americanExpressBox;
    @FindBy(id ="ctl00_MainContent_fmwOrder_TextBox6")
    protected WebElement cardNumberInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    protected WebElement expDateInput;
    @FindBy(linkText = "Process")
    protected WebElement processBtn;
    @FindBy(xpath = "//input[@value ='Reset']")
    protected WebElement resetBtn;

    public void fillOutProductInfo(String product, int quantity) throws InterruptedException {
        Select select = new Select(productMenu);
        select.selectByValue(product);

        quantityInput.clear();
        Thread.sleep(300);
        quantityInput.sendKeys(quantity +"");
        Assert.assertTrue(calculateBtn.isEnabled(), "Calculate button is not enabled");
        calculateBtn.click();

        WebElement pricePerUnit = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice"));
        String pricePerUnitStr = pricePerUnit.getAttribute("value"); //getting the text from the input box
        double pricePerUnitDbl = Double.parseDouble(pricePerUnitStr);

        WebElement discount = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount"));
        String discountStr = discount.getAttribute("value");
        double discountDbl = Double.parseDouble(discountStr);

        double expectedTotal = (quantity * pricePerUnitDbl) -  ((quantity  * pricePerUnitDbl) * discountDbl/100);

        WebElement total = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal"));
        String totalTxt = total.getAttribute("value");
        double actualTotalDbl = Double.parseDouble(totalTxt);

        Assert.assertEquals(expectedTotal,actualTotalDbl);
    }



    public  void fillOutAddressInfo(String customerName, String street, String city, String state, String zipCode){
        customerNameInput.sendKeys(customerName);
        streetInput.sendKeys(street);
        cityInput.sendKeys(city);
        stateInput.sendKeys(state);
        zipCodeInput.sendKeys(zipCode);
    }

    public void fillOutPaymentInfo(String cardName, String cardNumber, String expDate){
        if(cardName.toLowerCase().contains(("visa"))){
            visaCardBox.click();
        }else if (cardName.toLowerCase().contains("mastercard")){
            masterCardBox.click();
        }else if (cardName.toLowerCase().contains("american express")){
        americanExpressBox.click();
        }else {
            System.out.println("Invalid card");;}

        cardNumberInput.sendKeys(cardNumber);
        expDateInput.sendKeys(expDate);

        }

        public void clickOnProcess(){
        Assert.assertTrue(processBtn.isEnabled(), "Process button is not enabled");
        processBtn.click();
        }

        public void verifyOrderSuccess(){
            WebElement orderSuccess = driver.findElement(By.tagName("strong"));
            String orderSuccessMessage = orderSuccess.getText().trim();
            Assert.assertTrue(orderSuccessMessage.contains("New order has been successfully added"), "Order success message is not displayed as expected");
        }

        public void resetOrder(){
        Assert.assertTrue(resetBtn.isEnabled());
        resetBtn.click();
        }
}

