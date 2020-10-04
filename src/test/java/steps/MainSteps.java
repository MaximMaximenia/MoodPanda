package steps;

import io.qameta.allure.Step;
import models.LoginModal;
import other.Account;
import pages.FeedPage;
import pages.MainPage;

public class MainSteps {
    MainPage mainPage = new MainPage();
    LoginModal loginModal = new LoginModal();
    @Step("Create account")
    public void createAccount(Account account) {
        mainPage.openPage()
                .pressStart()
                .pressCreateNewAccount()
                .createAccount(account);
    }
    @Step("Create Account and check that error message appeared ")
    public void createAccountAndCheckThatErrorMessageAppeared(Account account) {

        mainPage.openPage()
                .pressStart()
                .pressCreateNewAccount()
                .createAccount(account)
                .checkThatErrorMessageAppeared();
    }
    @Step("Failed login for get error message")
    public MainSteps failedLogin(String email, String password) {

        mainPage.openPage()
                .pressStart()
                .failedLogin(email, password);
        return this;
    }
    @Step("Login")
    public void login(String email, String password) {

        mainPage.openPage()
                .pressStart()
                .login(email, password)
                .validateLogin();

    }

    @Step("Check error message")
    public void errorMessageShouldBe(String errorMessage) {
        loginModal.errorMessageShouldBe(errorMessage);


    }
}
