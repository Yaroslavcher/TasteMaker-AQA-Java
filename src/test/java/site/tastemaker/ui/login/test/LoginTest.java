package site.tastemaker.ui.login.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.*;
import io.qameta.allure.selenide.AllureSelenide;
import site.tastemaker.ui.login.data.DataHelper;
import site.tastemaker.ui.login.page.LoginPage;
import site.tastemaker.ui.login.page.MainPage;
import site.tastemaker.ui.login.page.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class LoginTest {
    MainPage mainPage;
    DataHelper.AuthInfo authInfo;
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
    @BeforeEach
    void setUp() {
        mainPage = open("http://localhost:80", MainPage.class);
    }


    @Test
    @DisplayName("TM-1 - Happy registration of new user with valid login and password")
    void shouldLogin() {
        var authInfo = DataHelper.getAuthInfo();
        var loginPage = mainPage.goToLoginPage();
        var registrationPage = loginPage.goToRegistrationPage();
        registrationPage.validLogin(authInfo);
    }
}
