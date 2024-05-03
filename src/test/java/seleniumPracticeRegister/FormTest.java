package seleniumPracticeRegister;

import org.junit.jupiter.api.Test;

public class FormTest extends TestBase{

    @Test
    void registerTest() {
        formPage.openPageRegistration()
                .setFirstName()
                .setLastName()
                .setUserName()
                .setPasswordForRegistration()
                .clickRegisterButton()
                .checkEmptyField();

    }


    @Test
    void authorizationTest() {
        formPage.openAuthorizationPage()
                .setEmail()
                .setPasswordForAuthorization()
                .clickLoginButton()
                .checkEmptyFields();

    }

    @Test
    void StudentRegistrationForm() {
        formPage.openFormPage()
                .setName()
                .setEmail()
                .choiceGender()
                .setMobilePhone()
                .setBirthday()
                .setSubject()
                .choiceHobbies()
                .downloadImg()
                .setCurrentAddress();

    }

}
