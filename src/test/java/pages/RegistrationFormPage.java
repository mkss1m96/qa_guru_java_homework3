package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.*;

public class RegistrationFormPage {

    CalendarComponent calendar = new CalendarComponent();
    TableResultComponent result = new TableResultComponent();

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderContainer = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesContainer = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement userCurrentAddress = $("#currentAddress");
    private final SelenideElement stateSelect = $("#state");
    private final SelenideElement citySelect = $("#city");
    private final SelenideElement stateSelectContainer = $("#react-select-3-input");
    private final SelenideElement citySelectContainer = $("#react-select-4-input");

    private final SelenideElement submitButton = $("#submit");

    public void openPage() {
        open("/automation-practice-form");
    }

    public void fixBan() {
        executeJavaScript("document.getElementById('fixedban')?.remove();document.querySelector('footer')?.remove();");
    }

    public RegistrationFormPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage typeUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderContainer.$(byText(sex)).click();
        return this;
    }

    public RegistrationFormPage typeUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        hobbiesContainer.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationFormPage setPicture(String value) {
        uploadPicture.uploadFromClasspath("bigl.png");
        return this;
    }

    public RegistrationFormPage typeCurrentAddress(String value) {
        userCurrentAddress.setValue(value);
        return this;
    }

    public RegistrationFormPage setState(String value) {
        stateSelect.click();
        stateSelectContainer.setValue(state).pressEnter();
        return this;
    }

    public RegistrationFormPage setCity(String value) {
        citySelect.click();
        citySelectContainer.setValue(city).pressEnter();
        return this;
    }

    public RegistrationFormPage submitForm() {
        submitButton.click();
        return this;
    }

    public RegistrationFormPage checkField(String value) {
        result.checkResult(value);
        return this;
    }
}