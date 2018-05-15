package org.maxPay.api_maxpay_tests;

import com.jayway.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.maxPay.config_Properties_MaxPay.JsonUtils;

import java.net.URL;
import java.util.Iterator;
import java.util.logging.Logger;

import static com.jayway.restassured.RestAssured.get;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.maxPay.config_Properties_MaxPay.DataConfigMaxPay.getTestProperty;

public class Main extends JsonUtils {
    private Logger logger = Logger.getLogger(SwapiRestApiTests.class.getName());

    @Test

    public void assertNameAndLuckeSkywalker() {

        try {
            try {
                Response responsePeopleID = get(getTestProperty("url_root_people") + getTestProperty("people_id"));
                String responseBodyPeopleID = responsePeopleID.getBody().asString();
                JSONParser parserPeopleID = new JSONParser();
                JSONObject resultPeople = (JSONObject) parserPeopleID.parse(responseBodyPeopleID);

                String valueName = (String) resultPeople.get("name");

                assertEquals(valueName, "Luke Skywalker");
                logger.info("Assert passed: \"Name\" belongs to \"Luke Skywalker\"");
            } catch (java.lang.AssertionError e) {
                logger.info("Assertion Error: " + e);

            }


        } catch (ParseException e) {
            logger.info("Parse Error: " + e);
        }


    }

    @Test
    public void assertNameAndPopulationPlanet() {
        try {
            try {
                Response responsePeopleID = get(getTestProperty("url_root_people") + getTestProperty("people_id"));
                String responseBodyPeopleID = responsePeopleID.getBody().asString();
                JSONParser parserPeopleID = new JSONParser();
                JSONObject resultPeople = (JSONObject) parserPeopleID.parse(responseBodyPeopleID);
                String homeworld = (String) resultPeople.get("homeworld");
                assertEquals(homeworld, "https://swapi.co/api/planets/1/");

                Response responseHomeworld = get(homeworld);
                String responseHomeworldBody = responseHomeworld.getBody().asString();
                JSONObject resultHomeworld = (JSONObject) parserPeopleID.parse(responseHomeworldBody);

                String valueNamePlanet = (String) resultHomeworld.get("name");
                assertEquals(valueNamePlanet, "Tatooine");
                logger.info("Assert passed: \"Name\" belongs to \"Tatooine\"");

                String valuesPopulationPlanet = (String) resultHomeworld.get("population");
                assertEquals(valuesPopulationPlanet, "200000");
                logger.info("Assert passed: \"population\" is \"200000\"");

                JSONArray arrayFilms = (JSONArray) resultHomeworld.get("films");
                Iterator<String> iterator1stFilmsOfArray = arrayFilms.iterator();
                Response responseFilmPage = get(iterator1stFilmsOfArray.next().toString());
                String responseFilmPageBody = responseFilmPage.getBody().asString();
                logger.info("First film in Lucke's Homeworld is  " + responseFilmPageBody);

                JSONParser parserFilmsResponse = new JSONParser();
                JSONObject resultFilmResponse = (JSONObject) parserFilmsResponse.parse(responseFilmPageBody);
                String valueFilmsTitle = (String) resultFilmResponse.get("title");
                assertEquals(valueFilmsTitle, "Attack of the Clones");
                logger.info("Assert passed: \"title\" equals \"Attack of the Clones\"");


                JSONArray arrayPlanets = (JSONArray) resultFilmResponse.get("planets");
                assertTrue((arrayPlanets).contains(homeworld));
                logger.info("Assert passed: Lucke's Planet belong to film \"Attack of the Clones\"");


            } catch (java.lang.AssertionError e) {
                logger.info("Assertion Error: " + e);

            }
        } catch (ParseException e) {
            logger.info("Parse Error: " + e);
        }

    }

}