package com.wabbit.selenium.auto.util;

import com.wabbit.selenium.auto.bean.Auto;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.Source;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Elena
 * Date: 05.02.2011
 * Time: 11:03:21
 * To change this template use File | Settings | File Templates.
 */
public final class TableParser {

    private static final Logger log = Logger.getLogger(TableParser.class);

    private TableParser() {
    }

    public static List<Auto> parseAutosFromPage(String htmlSource) throws Exception {
        List<Auto> autoList = new ArrayList<Auto>();
        Source source = new Source(htmlSource);
        source.getEncoding();
        List<Element> rows = getRows(source);
        for (Element row : rows) {
            Auto auto = parseAutoFromRow(row);
            autoList.add(auto);
        }
        return autoList;
    }

    private static List<Element> getRows(Source source) throws Exception {
        Element tableDiv = source.getElementById("commonForeachDiv");
        Element tbody = null;
        List<Element> rows = null;
        try {
            tbody = tableDiv.getAllElements(HTMLElementName.TBODY).get(0);
            rows = tbody.getAllElements(HTMLElementName.TR);
        } catch (NullPointerException e) {
            throw new Exception("Problem parsing BODY", e);
        }
        return rows;
    }

    private static Auto parseAutoFromRow(Element row) throws Exception {
        Auto auto = null;
        if (row != null) {
            auto = new Auto();
            try {
                //MakeModel
                Element columnMakeModel = row.getAllElements(HTMLElementName.TD).get(0);
                addMakeModelParameters(auto, columnMakeModel);
                //Description
                Element columnDescription = row.getAllElements(HTMLElementName.TD).get(1);
                addDescriptionParameters(auto, columnDescription);
                //Price
                Element columnPrice = row.getAllElements(HTMLElementName.TD).get(2);
                addPriceParameters(auto, columnPrice);
            } catch (NullPointerException e) {
                throw new Exception("Problem parsing ROW", e);
            }
        }
        log.debug(auto);
        return auto;
    }

    /**
     * Get id, link, make_model, year
     *
     * @param auto
     * @param element
     */
    private static void addMakeModelParameters(Auto auto, Element element) {
        //Get id
        Element htmlLink = element.getAllElements(HTMLElementName.A).get(1);
        String id = htmlLink.getAttributeValue("id").split("_")[0];
        auto.setId(id);
        //Get link
        String link = htmlLink.getAttributeValue("href");
        auto.setLink(link);
        //Get make_model
        String make_model = htmlLink.getRenderer().toString();
        auto.setMake_model(make_model);
        //Get year
        Element span = element.getAllElements(HTMLElementName.SPAN).get(0);
        String year = span.getRenderer().toString().split(" ")[0];
        auto.setYear(year);
        log.trace(auto);
    }

    /**
     * Get description = km, transmission, volume
     *
     * @param auto
     * @param element
     */
    private static void addDescriptionParameters(Auto auto, Element element) {
        String description = element.getRenderer().toString();
        auto.setDescription(description);
        log.trace(auto);
    }

    /**
     * Get price
     *
     * @param auto
     * @param element
     */
    private static void addPriceParameters(Auto auto, Element element) {
        String price = element.getFirstElement(HTMLElementName.P).getRenderer().toString();
        auto.setPrice(price);
        log.trace(auto);
    }
}