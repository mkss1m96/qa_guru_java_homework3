package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import pages.TextBoxPage;

import static io.qameta.allure.Allure.step;
import static testdata.TestData.*;

public class TestBox extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();
    RegistrationFormPage regBoxPage = new RegistrationFormPage();

    @Test
    void successfulFileFormRegTest() {
        step("Открытие формы регистрации и удаление баннеров", () -> {
            regBoxPage.openPage();
            regBoxPage.fixBan();
        });
        step("Заполнение формы регистрации", () -> {
            regBoxPage.
                    typeFirstName(firstName).
                    typeLastName(lastName).
                    typeUserEmail(email).
                    setGender(sex).
                    typeUserNumber(number).
                    setDateOfBirth(day, month, year).
                    setSubjects(subjects).
                    setHobbies(hobbies).
                    setPicture("bigl.png").
                    typeCurrentAddress(address).
                    setState(state).
                    setCity(city).
                    submitForm();
        });
        step("Проверка заполненных полей", () -> {
            regBoxPage.checkField(full_name).
                    checkField(email).
                    checkField(sex).
                    checkField(number).
                    checkField(full_date).
                    checkField(subjects).
                    checkField(hobbies).
                    checkField(address).
                    checkField("bigl.png").
                    checkField(state_city);
        });
    }

    @Test
    void successfulFileFormBoxTest() {
        textBoxPage.openPage();
        textBoxPage.fixBan();

        textBoxPage.
                typeUserName(full_name).
                typeUserEmail(email).
                typeUserCurrentAddress(address).
                userPermanentAddress(address).
                submitForm().
                checkField("name", full_name).
                checkField("email", email).
                checkField("currentAddress", address).
                checkField("permanentAddress", address);
    }
}