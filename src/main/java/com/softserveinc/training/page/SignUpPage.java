package com.softserveinc.training.page;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignUpPage {
    private String user = "";

    @FindBy(how = How.NAME, using = "title")
    private SelenideElement userName;

    @FindBy(how = How.NAME, using = "login")
    private SelenideElement login;

    @FindBy(how = How.NAME, using = "password")
    private SelenideElement password;

    @FindBy(how = How.CSS, using = ".btn-link-sign > .btn-link-i")
    private SelenideElement signUp;

    public SignUpPage setUserName(String userName) {
        this.userName.setValue(userName);
        user = userName;
        return this;
    }

    public SignUpPage setLogin(String login) {
        this.login.setValue(login);
        return this;
    }

    public SignUpPage setPassword(String password) {
        this.password.setValue(password);
        return this;
    }

    public MainPage clickSignUp() {
        signUp.click();
        $(By.linkText(user)).shouldBe(visible);
        return page(MainPage.class);
    }

}
