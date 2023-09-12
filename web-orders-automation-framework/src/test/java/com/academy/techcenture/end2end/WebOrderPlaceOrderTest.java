package com.academy.techcenture.end2end;

import com.academy.techcenture.base.BaseTest;
import org.testng.annotations.Test;
import com.academy.techcenture.pages.LoginPage;
import com.academy.techcenture.pages.OrderPage;
import com.academy.techcenture.pages.ViewAllOrdersPage;

import static com.academy.techcenture.constants.Constants.*;

/**
 * This is a test class for placing order on 'web order website'
 */
public class WebOrderPlaceOrderTest extends BaseTest {
@Test
public void placeWebOrderTest() throws InterruptedException {

    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(USERNAME, PASSWORD);
    ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage(driver);
    Thread.sleep(500);
    viewAllOrdersPage.goToOrderLink();
    OrderPage orderPage = new OrderPage(driver);
    orderPage.goToOrderLink();

    orderPage.fillOutProductInfo(FAMILY_ALBUM_PRODUCT, QUANTITY);

    orderPage.fillOutAddressInfo(CUSTOMER_NAME, STREET, CITY, STATE, ZIPCODE);

    orderPage.fillOutPaymentInfo(MASTER_CARD, CARD_NUMBER, EXPIRATION_DATE);
    orderPage.clickOnProcess();

    orderPage.goToViewAllOrdersLink();
    viewAllOrdersPage.verifyOrderInAllOrders(CUSTOMER_NAME, FAMILY_ALBUM_PRODUCT, QUANTITY);

    viewAllOrdersPage.logout();

}


}
