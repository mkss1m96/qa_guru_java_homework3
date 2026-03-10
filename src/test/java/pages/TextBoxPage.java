package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    //Elements
    private SelenideElement userNameInput = $("#userName");
    private SelenideElement userEmailInput = $("#userEmail");

    //Actions
    public void openPage(){
        open("/text-box");
    }
    public void typeUserName(String value) {
        userNameInput.setValue(value);
    }
    public void typeUserEmail(String value) {
        userEmailInput.setValue(value);
    }
}
