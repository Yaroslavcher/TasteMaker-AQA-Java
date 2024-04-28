package site.tastemaker.ui.login.page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class MainPage {
    private SelenideElement loginButton = $("[href*='/login']");

    public MainPage() {
        loginButton.shouldBe(Condition.visible);
    }

    public LoginPage goToLoginPage() {
        loginButton.click();
        return page(LoginPage.class);
    }
}

