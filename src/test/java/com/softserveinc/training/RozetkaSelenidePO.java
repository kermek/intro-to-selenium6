package com.softserveinc.training;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.softserveinc.training.page.MainPage;
import org.junit.Test;

public class RozetkaSelenidePO {
    @Test
    public void robotxiaomi() {
        String userName = "user" + System.currentTimeMillis();
        
        MainPage mainPage = open("https://rozetka.com.ua/", MainPage.class);
        mainPage.signIn()
                .signUp(userName, userName + "@gmail.com", "P@ssw0rd")
                .search("робот пылесос xiaomi");

        assertThat(mainPage.getProductName(),
                is("Робот-пылесос Xiaomi RoboRock Sweep One Vacuum Cleaner s50 White "
                        + "(S502-00) (Международная версия)"));

        assertThat(mainPage.getProductPrice(), is("13 799"));

        mainPage.openMenu(userName)
                .logOut();
    }
}

