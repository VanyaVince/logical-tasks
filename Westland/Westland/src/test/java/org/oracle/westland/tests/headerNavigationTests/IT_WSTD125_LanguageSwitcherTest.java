package org.oracle.westland.tests.headerNavigationTests;

import org.junit.Test;
import org.oracle.westland.PrimaryTemplate;
import org.oracle.westland.utils.AccountCredentials;

public class IT_WSTD125_LanguageSwitcherTest extends PrimaryTemplate {

    @Test
    public void showLanguageDropdownList() {
        homePage.openUrl();
        logInPage.logInAs(AccountCredentials.LOGIN, AccountCredentials.PASSWORD);
        homePage.shouldSeeLanguagePanel();
    }
}
