package com.wabbit.selenium;

import com.thoughtworks.selenium.SeleneseTestCase;

/**
 * User: andrey.osipov
 */
public class SimpleTest extends SeleneseTestCase {

    public void setUp() throws Exception {
        setUp("http://google.com.ua/", "*firefox /usr/local/firefox/firefox");
        //setUp("http://google.com.ua/", "*firefox");
        selenium.setSpeed("3000");
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testWikipediaTechnology() throws Exception {
        selenium.open("");
        selenium.type("q", "auto");
        selenium.click("btnG");
        //selenium.waitForPageToLoad("3000");
        verifyTrue(selenium.isTextPresent("auto.ria.ua"));
    }
}