package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import pages.MainPage;

public class MainMenuTests extends BaseTest{
    private static MainPage mainPage;

    @BeforeAll
    public static void init(){
        mainPage = new MainPage();
    }

    @Description("open menu")
    @Test
    public void openMenu(){
        mainPage.clickMenu();
        System.out.println("info: complete");
    }
}
