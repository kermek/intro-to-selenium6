package com.softserveinc.training.page;

import static com.codeborne.selenide.Selenide.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignInPage {

    @FindBy(how = How.LINK_TEXT, using = "Зарегистрироваться")
    private SelenideElement signUp;

    public SignUpPage signUp() {
        signUp.click();
        return page(SignUpPage.class);
    }

    public MainPage signUp(String userName, String login, String password) {
        signUp();
        page(SignUpPage.class).setUserName(userName)
                .setLogin(login)
                .setPassword(password)
                .clickSignUp();
        return page(MainPage.class);
    }
}
