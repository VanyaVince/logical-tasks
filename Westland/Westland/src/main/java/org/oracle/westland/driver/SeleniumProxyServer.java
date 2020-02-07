package org.oracle.westland.driver;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;

import java.util.Base64;

class SeleniumProxyServer {

    private BrowserMobProxy browserMobProxy = null;

    SeleniumProxyServer() {
        this.browserMobProxy = new BrowserMobProxyServer();
    }

    Proxy SetAuthorizationHeader(String credentials) {
        browserMobProxy.start();
        String encodedCredential = "Basic " + (Base64.getEncoder().encodeToString(credentials.getBytes()));
        browserMobProxy.addHeader("Authorization", encodedCredential);
        return ClientUtil.createSeleniumProxy(browserMobProxy);
    }
}
