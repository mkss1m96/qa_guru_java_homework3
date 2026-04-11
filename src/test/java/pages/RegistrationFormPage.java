package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.TableResultComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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

    @Step("Открытие формы")
    public void openPage() {
        open("/automation-practice-form");
    }
    @Step("Удаление рекламных баннеров")
    public void fixBan() {
        executeJavaScript("document.getElementById('fixedban')?.remove();document.querySelector('footer')?.remove();");
    }
    @Step("Заполнение имени")
    public RegistrationFormPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    @Step("Заполнение фамилии")
    public RegistrationFormPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    @Step("Заполнение Email")
    public RegistrationFormPage typeUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    @Step("Заполнение пола")
    public RegistrationFormPage setGender(String value) {
        genderContainer.$(byText(value)).click();
        return this;
    }
    @Step("Заполнение номера телефона")
    public RegistrationFormPage typeUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    @Step("Заполнение даты рождения")
    public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }
    @Step("Заполнение направления")
    public RegistrationFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    @Step("Заполнение хобби")
    public RegistrationFormPage setHobbies(String value) {
        hobbiesContainer.$(byText(value)).click();
        return this;
    }
    @Step("Загрузка картинки")
    public RegistrationFormPage setPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }
    @Step("Заполнение адреса")
    public RegistrationFormPage typeCurrentAddress(String value) {
        userCurrentAddress.setValue(value);
        return this;
    }
    @Step("Заполнение штата")
    public RegistrationFormPage setState(String value) {
        stateSelect.click();
        stateSelectContainer.setValue(value).pressEnter();
        return this;
    }
    @Step("Заполнение города")
    public RegistrationFormPage setCity(String value) {
        citySelect.click();
        citySelectContainer.setValue(value).pressEnter();
        return this;
    }
    @Step("Отправка данных")
    public RegistrationFormPage submitForm() {
        submitButton.click();
        return this;
    }
    @Step("Проверки параметров {value}")
    public RegistrationFormPage checkField(String value) {
        result.checkResult(value);
        return this;
    }
}