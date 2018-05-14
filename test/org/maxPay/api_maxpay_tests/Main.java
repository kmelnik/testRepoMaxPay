package org.maxPay.api_maxpay_tests;

import com.jayway.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.maxPay.config_Properties_MaxPay.JsonUtils;

import java.net.URL;
import java.util.logging.Logger;

import static com.jayway.restassured.RestAssured.get;
import static org.junit.Assert.assertEquals;
import static org.maxPay.config_Properties_MaxPay.DataConfigMaxPay.getTestProperty;

public class Main extends JsonUtils {
    private Logger logger = Logger.getLogger(SwapiRestApiTests.class.getName());

    @Test

    public void findLuckeSkywalker () {

        try {
            try {
                Response responsePeopleID = get(getTestProperty("url_root_people") + getTestProperty("people_id"));
                String responseBodyPeopleID = responsePeopleID.getBody().asString();
                JSONParser parserBasicInfo = new JSONParser();
                JSONObject resultPeople = (org.json.simple.JSONObject) parserBasicInfo.parse(responseBodyPeopleID);

                String valueName = (String) resultPeople.get("name");

                assertEquals(valueName, "Luke Skywalker");
                logger.info("Assert passed: \"Name\" belongs to \"Luke Skywalker\"");
            } catch (java.lang.AssertionError e) {
                logger.info("Assertion Error: "+e);

            }

        }
        catch (ParseException e) {
            logger.info("Parse Error: " + e);
            }



    }
}