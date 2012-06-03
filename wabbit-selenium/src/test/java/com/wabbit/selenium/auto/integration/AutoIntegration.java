package com.wabbit.selenium.auto.integration;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;
import com.wabbit.selenium.auto.bean.Auto;
import com.wabbit.selenium.auto.service.GoogleAutoPersister;
import com.wabbit.selenium.auto.util.TableParser;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * User: andrey.osipov
 */
public class AutoIntegration extends SeleneseTestCase {
    private static final Logger log = Logger.getLogger(AutoIntegration.class);

    private static final String WAIT_TIME_SHORT = "2000";
    private static final String WAIT_TIME_MEDIUM = "5000";
    private static final String WAIT_TIME_LONG = "10000";


    @Before
    public void setUp() throws Exception {
        selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://auto.ria.ua/");
        selenium.setSpeed("1000");
        selenium.start();
    }

    @Test
    public void testSearch() throws Exception {
        selenium.open("/search.html");
        selenium.waitForPageToLoad(WAIT_TIME_MEDIUM);
        selenium.click("MainAutoCategoryA");
        selenium.click("//a[@id='1InactiveAC']/i");
        selenium.select("search_date_from", "label=2006");
        selenium.select("search_date_to", "label=2010");

        selenium.select("custom", "value=1");
        selenium.select("saledParam", "value=2");
        selenium.select("damage", "value=1");
        selenium.select("under_credit", "value=2");

        selenium.click("search_with_photo");

        selenium.type("//input[@name='price_ot' and @value='' and @type='text']", "6000");
        selenium.type("//input[@name='price_do' and @value='' and @type='text']", "9000");

        // 8 - 3 hours, 9 - 6 hours, 2 - за день, 10 - за два дня
        selenium.select("top", "value=10");

        selenium.click("search_button");
        selenium.waitForPageToLoad(WAIT_TIME_MEDIUM);

        // setup output table view

        selenium.click("tabs4View");
        selenium.click("tableOptionsLink");
        //*1 - МАРКА/МОДЕЛЬ/Г.В
        //2 - город
        //*3 - ЦЕНА
        //4 - тип кузова
        //5 - пробег
        //6 - коробка передач
        //7 - объем двигателя
        //8 - цвет
        //9 - дата размещения
        //10 - телефон
        selenium.click("id_2");
        selenium.click("id_5");
        selenium.click("id_6");
        selenium.click("id_7");

        selenium.select("ipp", "value=30");
        selenium.waitForPageToLoad(WAIT_TIME_MEDIUM);

        //Parse results
        List<Auto> autoList = TableParser.parseAutosFromPage(selenium.getHtmlSource());
        for (Auto auto : autoList) {
            GoogleAutoPersister.persistAuto(auto);
            log.info(auto);
        }
        //TODO: 2. persist Autos to google docs
    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}
