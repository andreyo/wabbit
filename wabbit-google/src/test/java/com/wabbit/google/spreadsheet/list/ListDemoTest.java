package com.wabbit.google.spreadsheet.list;

import com.google.gdata.client.spreadsheet.SpreadsheetService;
import org.junit.Test;

/**
 * User: andrey.osipov
 */
public class ListDemoTest {

    @Test
    public void testLoadSheetByName() throws Exception {
        ListDemo demo = new ListDemo(new SpreadsheetService("List Demo"), System.out);
        demo.login("kievdn", "bokajuniors");
        demo.loadSheetByKeyAndWorksheetTitle("to9QemTUVKeL9hQZcz28ojQ", "2009");        
        for (int i = 0; i < 10; i++) {
            demo.addNewEntry("Col1=a,Col2=b,Col3=c");
        }
    }
}
