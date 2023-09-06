package tests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import io.qameta.allure.Description;
import pages.MainPage;

public class MainMenuTests extends BaseTest{
    private static MainPage mainPage;

    @BeforeClass
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
