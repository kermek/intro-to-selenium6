package com.softserveinc.training.page;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import sun.applet.Main;

public class MainPage {

    @FindBy(how = How.LINK_TEXT, using = "войдите в личный кабинет")
    private SelenideElement signIn;

    @FindBy(how = How.NAME, using = "text")
    private SelenideElement search;

    @FindBy(how = How.CSS, using = ".g-i-tile:nth-child(2) .g-i-tile-i-title")
    private SelenideElement product;

    @FindBy(how = How.CSS, using = "#goods_price_block_45433456 .g-price-old-uah span")
    private SelenideElement price;

    @FindBy(how = How.LINK_TEXT, using = "Выход")
    private SelenideElement logOut;

    public SignInPage signIn() {
        signIn.click();
        return page(SignInPage.class);
    }

    public MainPage search(String text) {
        search.setValue(text)
                .sendKeys(Keys.ENTER);
        return this;
    }

    public String getProductName() {
        return product.shouldBe(visible).getText();
    }

    public String getProductPrice() {
        return price.getText();
    }

    public MainPage openMenu(String userName) {
        $(By.linkText(userName)).click();
        $(By.linkText(userName)).hover();
        return this;
    }

    public MainPage logOut() {
        logOut.shouldBe(visible).click();
        return this;
    }
}

