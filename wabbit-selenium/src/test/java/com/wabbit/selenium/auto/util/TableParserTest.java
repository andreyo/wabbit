package com.wabbit.selenium.auto.util;

import com.wabbit.selenium.auto.bean.Auto;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * TableParser Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>02/05/2011</pre>
 */
public class TableParserTest {
    public static final String htmlFileName = "html/autoria.htm";
    private static String htmlSource;
    public static final Logger log = Logger.getLogger(TableParserTest.class);

    @BeforeClass
    public static void init() throws Exception {
        htmlSource = IOUtils.toString(
                TableParserTest.class.getClassLoader().getResourceAsStream(htmlFileName),
                "cp1251");
    }


    @Test
    public void testParseAutosFromPage() throws Exception {
        List<Auto> autoList = TableParser.parseAutosFromPage(htmlSource);
        assertEquals(30, autoList.size());
        //TODO: 3. Add more verification
    }
}
