package com.academy.techcenture.end2end;

import com.academy.techcenture.base.BaseTest;
import com.academy.techcenture.pages.LoginPage;
import com.academy.techcenture.pages.ViewAllOrdersPage;
import com.academy.techcenture.pages.ViewAllProductsPage;
import org.testng.annotations.Test;

import static com.academy.techcenture.constants.Constants.*;

public class WebOrderAllProductsListTest  extends BaseTest {

    @Test
    public void checkTableOfAllProductHeader(){
        LoginPage loginPage = new LoginPage(driver);
        ViewAllProductsPage viewAllProductsPage = new ViewAllProductsPage(driver);
        loginPage.login(USERNAME, PASSWORD);
        viewAllProductsPage.goToViewAllProductsLink();

        viewAllProductsPage.validateAllProductsPriceAndNameAndDiscount();


    }
}
