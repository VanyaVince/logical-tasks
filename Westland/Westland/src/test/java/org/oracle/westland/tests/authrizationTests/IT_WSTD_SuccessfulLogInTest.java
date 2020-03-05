package org.oracle.westland.tests.authrizationTests;

import org.junit.Test;
import org.oracle.westland.PrimaryTemplate;
import org.oracle.westland.utils.AccountCredentials;

public class IT_WSTD_SuccessfulLogInTest extends PrimaryTemplate {

    @Test
    public void LogInCheck() {
        homePage.openUrl();
        logInPage.logInAs(AccountCredentials.LOGIN, AccountCredentials.PASSWORD);
        homePage.verifyHomePageAppearance();
    }
}
