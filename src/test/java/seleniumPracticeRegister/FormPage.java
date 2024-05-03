package seleniumPracticeRegister;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;

import java.io.File;
import java.text.Normalizer;
import java.text.SimpleDateFormat;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.RandomUtils.getRandomString;

public class FormPage {
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userName = faker.name().username();
    String passwordRegistration = getRandomString(10);
    String email = faker.internet().emailAddress();
    String passwordAuthorization = getRandomString(10);
    String Name = faker.name().name();
    String Email = faker.internet().emailAddress();
    String mobileNumber = faker.phoneNumber().phoneNumber();
    String dob = sdf.format(faker.date().birthday()) ;
    String subject = faker.animal().name();
    String currentAddress = faker.address().fullAddress();

    public FormPage openPageRegistration() {
        open("/selenium/practice/register.php");
        $("#signupForm").shouldHave(text("Welcome,Register"));
        return this;
    }

    public FormPage setFirstName() {
        $("#firstname").setValue(firstName);
        return this;
    }

    public FormPage setLastName() {
        $("#lastname").setValue(lastName);
        return this;
    }

    public FormPage setUserName() {
        $("#username").setValue(userName);
        return this;
    }

    public FormPage setPasswordForRegistration() {
        $("#password").setValue(passwordRegistration);
        return this;
    }

    public FormPage clickRegisterButton() {
        $(".btn-primary").click();
        return this;
    }

    public FormPage checkEmptyField() {
        $("#firstname").shouldHave(Condition.empty);
        return this;
    }

    public FormPage openAuthorizationPage() {
        open("/selenium/practice/login.php");
        $("#signInForm").shouldHave(text("Welcome, Login In"));
        return this;
    }

    public FormPage setEmail() {
        $("#email").setValue(email);
        return this;
    }

    public FormPage setPasswordForAuthorization() {
        $("#password").setValue(passwordAuthorization);
        return this;
    }

    public FormPage clickLoginButton() {
        $(".btn-primary").click();
        return this;
    }

    public FormPage checkEmptyFields() {
        $("#email").shouldHave(Condition.empty);
        return this;
    }

    public FormPage openFormPage(){
        open("/selenium/practice/selenium_automation_practice.php");
        $("#practiceForm").shouldHave(text("Student Registration Form"));
        return this;
    }

    public FormPage setName(){
        $("#name").setValue(Name);
        return this;
    }

    public FormPage setFormEmail() {
        $("#email").setValue(Email);
        return this;
    }

    public FormPage choiceGender(){
        $("#gender").click();
        return this;
    }

    public FormPage setMobilePhone(){
        $("#mobile").setValue(mobileNumber);
        return this;
    }

    public FormPage setBirthday(){
        $("#dob").click();
        $("#dob").setValue(dob);
        return this;
    }

    public FormPage setSubject(){
        $("#subjects").setValue(subject);
        return this;
    }

    public FormPage choiceHobbies(){
        $("#hobbies").click();
        return this;
    }
   public FormPage downloadImg() {
    $(".input-group").$("#picture").uploadFromClasspath("img/galaktika_svechenie_spiral_142698_3840x2160.jpg");
    return this;
   }

    public FormPage setCurrentAddress() {
        $("textarea#picture").click();
        $("textarea#picture").setValue(currentAddress);
        return this;
    }

    public FormPage choiceState() {
        $(".d-flex").$(byText("Uttar Pradesh")).click();
        return this;
    }

    public FormPage choiceCity() {
        $(".d-flex").$(byText("Lucknow")).click();
        return this;
    }

    public FormPage clickLogin() {
        $(".btn-primary").click();
        return this;
    }

    public FormPage checkEmptyForm() {
        $("#name").shouldHave(Condition.empty);
        return this;
    }

}
