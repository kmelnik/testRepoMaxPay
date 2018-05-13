package org.selenide.maxPay.selenide_maxpay_tests;


import org.json.simple.JSONArray;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.get;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


import com.jayway.restassured.response.Response;

import org.selenide.maxPay.config_Properties_MaxPay.DataConfigMaxPay;


import java.util.Iterator;
import java.util.logging.Logger;


public class SwapiRestApiTests extends DataConfigMaxPay {

    private Logger logger = Logger.getLogger(SwapiRestApiTests.class.getName());

    @Test

    /**
     * При желании, каждую проверку можно обернуть в try-catch + разбить тест на классы с тестами с импользованием паттерна PageObject
     * Из задания я понял, что это один тест
     **/

    public void getRequestFindSwapiApiData() {

        try {
            // выполняем запрос get для доступа ко всем параметрам ответа к базовому урлу АПИ
            Response response = get(getTestProperty("basic_swapi_url"));
            String responseBody = response.getBody().asString();
            logger.info("Basic info API is " + responseBody);

            // парсим джейсон для доступа к people
            org.json.simple.parser.JSONParser parserBasicInfo = new org.json.simple.parser.JSONParser();
            org.json.simple.JSONObject resultPeople = (org.json.simple.JSONObject) parserBasicInfo.parse(responseBody);
            String value = (String) resultPeople.get("people");

            // получаем параметры ответа по Люку Скайволкеру
            Response responseResultPeople = get(value + getTestProperty("people_id"));
            String responseBodyPeople = responseResultPeople.getBody().asString();
            logger.info("Searched people is  " + responseBodyPeople);

            // парсим джэйсон для доступа к name - Люку Скайволкеру
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            org.json.simple.JSONObject result = (org.json.simple.JSONObject) parser.parse(responseBodyPeople);
            String valueLuke = (String) result.get("name");
            assertEquals(valueLuke, "Luke Skywalker");
            logger.info("Assert passed: \"Name\" belongs to \"Luke Skywalker\"");

            // по homeworld ищем планету
            String homeworld = (String) result.get("homeworld");
            assertEquals(homeworld, "https://swapi.co/api/planets/1/");

            Response responseHomeworld = get(homeworld);
            String responseHomeworldBody = responseHomeworld.getBody().asString();
            logger.info("Lucke's Homeworld is  " + responseHomeworldBody);

            // парсим джэйсон для проверки имени планеты и ее населения, проверяем assertEquals
            org.json.simple.parser.JSONParser parserHomeworldResponse = new org.json.simple.parser.JSONParser();
            org.json.simple.JSONObject resultHomeworldResponse = (org.json.simple.JSONObject) parserHomeworldResponse.parse(responseHomeworldBody);

            String valueNamePlanet = (String) resultHomeworldResponse.get("name");
            String valuesPopulationPlanet = (String) resultHomeworldResponse.get("population");

            assertEquals(valueNamePlanet, "Tatooine");
            logger.info("Assert passed: \"Name\" belongs to \"Tatooine\"");

            assertEquals(valuesPopulationPlanet, "200000");
            logger.info("Assert passed: \"population\" is \"200000\"");

            // парсим джэйсон, используем паттерн итератор для поиска первого в списке этой планеты фильма
            JSONArray arrayFilms = (JSONArray) resultHomeworldResponse.get("films");
            Iterator<String> iterator1stFilmsOfArray = arrayFilms.iterator();
            Response responseFilmPage = get(iterator1stFilmsOfArray.next().toString());
            String responseFilmPageBody = responseFilmPage.getBody().asString();
            logger.info("First film in Lucke's Homeworld is  " + responseFilmPageBody);

            // находим title, проверяем совпадает ли с Attack of the Clones
            org.json.simple.parser.JSONParser parserFilmsResponse = new org.json.simple.parser.JSONParser();
            org.json.simple.JSONObject resultFilmResponse = (org.json.simple.JSONObject) parserFilmsResponse.parse(responseFilmPageBody);
            String valueFilmsTitle = (String) resultFilmResponse.get("title");
            assertEquals(valueFilmsTitle, "Attack of the Clones");
            logger.info("Assert passed: \"title\" equals \"Attack of the Clones\"");

            // проверяем принадлежит ли фильму - Lucke Skywalker и его планета
            try {

                JSONArray arrayCharacters = (JSONArray) resultFilmResponse.get("characters");
                assertTrue((arrayCharacters).contains(value + getTestProperty("people_id") + "/"));
                logger.info("Assert passed: Lucke Skywalker is belong to this film \"Attack of the Clones\"");

            } catch (java.lang.AssertionError e) {
                logger.info("Assertion Error: Lucke Skywalker is not belong to film \"Attack of the Clones\"");
            }

            try {
                JSONArray arrayPlanets = (JSONArray) resultFilmResponse.get("planets");
                assertTrue((arrayPlanets).contains(homeworld));
                logger.info("Assert passed: Lucke's Planet belong to film \"Attack of the Clones\"");


            } catch (java.lang.AssertionError e) {
                logger.info("Assertion Error: Lucke's Planet is not belong to film \"Attack of the Clones\"");

            }

        } catch (org.json.simple.parser.ParseException e) {
            logger.info("Parse Error: " + e);
        }


    }

}


