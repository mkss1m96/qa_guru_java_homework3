package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import pages.TextBoxPage;

import static testdata.TestData.*;

public class TestBox extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();
    RegistrationFormPage regBoxPage = new RegistrationFormPage();

    @Test
    void successfulFileFormTestReg() {
        regBoxPage.openPage();
        regBoxPage.fixBan();
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
                submitForm().
                checkField(full_name).
                checkField(email).
                checkField(sex).
                checkField(number).
                checkField(full_date).
                checkField(subjects).
                checkField(hobbies).
                checkField(address).
                checkField("bigl.png").
                checkField(state_city);
    }

    @Test
    void successfulFileFormTestBox() {
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
