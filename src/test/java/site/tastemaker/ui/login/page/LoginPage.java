package site.tastemaker.ui.login.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    @FindBy(css = "[type=email] input")
    private SelenideElement loginField;
    @FindBy(css = "[href*='/registration']")
    private SelenideElement registerButton;

    public void verifyLoginFieldVisibility() {
        loginField.shouldBe(Condition.visible);
    }
    public RegistrationPage goToRegistrationPage() {
        registerButton.click();
        return page(RegistrationPage.class);
    }
}
