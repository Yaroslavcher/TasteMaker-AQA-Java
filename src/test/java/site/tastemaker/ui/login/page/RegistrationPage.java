package site.tastemaker.ui.login.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import site.tastemaker.ui.login.data.DataHelper;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {
    @FindBy(css = "[type=email] input")
    private SelenideElement loginField;
    @FindBy(css = "[type=password] input")
    private SelenideElement passwordField;

    @FindBy(css = "[type=submit] button")
    private SelenideElement submitButton;

    public void verifySubmitButtonVisibility() {
        submitButton.shouldBe(Condition.visible);
    }
    public MainPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        submitButton.click();
        return page(MainPage.class);
    }
}
