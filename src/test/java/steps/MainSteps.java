package steps;

import models.LoginModal;
import other.Account;
import pages.FeedPage;
import pages.MainPage;

public class MainSteps {
    MainPage mainPage = new MainPage();
    LoginModal loginModal = new LoginModal();

    public void createAccount(Account account) {
        mainPage.openPage()
                .pressStart()
                .pressCreateNewAccount()
                .createAccount(account);
    }

    public void createAccountAndCheckThatErrorMessageAppeared(Account account) {

        mainPage.openPage()
                .pressStart()
                .pressCreateNewAccount()
                .createAccount(account)
                .checkThatErrorMessageAppeared();
    }

    public MainSteps failedLogin(String email, String password) {

        mainPage.openPage()
                .pressStart()
                .failedLogin(email, password);
        return this;
    }

    public void login(String email, String password) {

        mainPage.openPage()
                .pressStart()
                .login(email, password)
                .feedPageIsOpen();

    }

    public void errorMessageShouldBe(String errorMessage) {
        loginModal.errorMessageShouldBe(errorMessage);


    }
}
