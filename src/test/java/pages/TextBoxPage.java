package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private SelenideElement userNameInput = $("#userName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement userCurrentAddress = $("#currentAddress");
    private SelenideElement userPermanentAddress = $("#permanentAddress");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement outputResults = $("#output");

    public void openPage() {
        open("/text-box");
    }
    public void fixBan() {
        executeJavaScript("document.getElementById('fixedban')?.remove();document.querySelector('footer')?.remove();");
    }

    public TextBoxPage typeUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage typeUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage typeUserCurrentAddress(String value) {
        userCurrentAddress.setValue(value);
        return this;
    }

    public TextBoxPage userPermanentAddress(String value) {
        userPermanentAddress.setValue(value);
        return this;
    }

    public TextBoxPage submitForm() {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkField(String key, String value) {
        outputResults.$(byId(key)).shouldHave(text(value));
        return this;
    }
}
