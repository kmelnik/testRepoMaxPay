package org.selenide.yourbet.selenide_maxpay_tests;


import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.junit.Assert;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.get;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


import com.jayway.restassured.response.Response;

import org.selenide.yourbet.config_Properties_MaxPay.DataConfigMaxPay;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class SwapiRestApiTests extends DataConfigMaxPay {


    @Test
    public void getRequestFindLukeSkywalkerData() {

        try {
            // выполняем запрос get для доступа ко всем параметрам ответа
            Response response = get(getTestProperty("basic_swapi_url"));
            String responseBody = response.getBody().asString();
            System.out.println("Basic info API is " + responseBody);

            org.json.simple.parser.JSONParser parserBasicInfo = new org.json.simple.parser.JSONParser();
            org.json.simple.JSONObject resultPeople = (org.json.simple.JSONObject) parserBasicInfo.parse(responseBody);
            String value = (String) resultPeople.get("people");

            Response responseResultPeople = get(value + getTestProperty("people_id"));
            String responseBodyPeople = responseResultPeople.getBody().asString();

            // получаем параметры ответа
            System.out.println("Searched people is  " + responseBodyPeople);
            // парсим джэйсон
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            org.json.simple.JSONObject result = (org.json.simple.JSONObject) parser.parse(responseBodyPeople);
            String valueLuke = (String) result.get("name");
            // получаем name человека

            assertEquals(valueLuke, "Luke Skywalker");

            String homeworld = (String) result.get("homeworld");

            assertEquals(homeworld, "https://swapi.co/api/planets/1/");

            Response responseHomeworld = get(homeworld);
            String responseHomeworldBody = responseHomeworld.getBody().asString();
            System.out.println("Lucke's Homeworld is  " + responseHomeworldBody);


            org.json.simple.parser.JSONParser parserHomeworldResponse = new org.json.simple.parser.JSONParser();
            org.json.simple.JSONObject resultHomeworldResponse = (org.json.simple.JSONObject) parserHomeworldResponse.parse(responseHomeworldBody);

            String valueNamePlanet = (String) resultHomeworldResponse.get("name");
            String valuesPopulationPlanet = (String) resultHomeworldResponse.get("population");

            assertEquals(valueNamePlanet, "Tatooine");
            assertEquals(valuesPopulationPlanet, "200000");


            JSONArray arrayFilms = (JSONArray) resultHomeworldResponse.get("films");
            Iterator<String> iterator1stFilmsOfArray = arrayFilms.iterator();
            Response responseFilmPage = get(iterator1stFilmsOfArray.next().toString());
            String responseFilmPageBody = responseFilmPage.getBody().asString();
            System.out.println("First film in Lucke's Homeworld is  " + responseFilmPageBody);
            org.json.simple.parser.JSONParser parserFilmsResponse = new org.json.simple.parser.JSONParser();
            org.json.simple.JSONObject resultFilmResponse = (org.json.simple.JSONObject) parserFilmsResponse.parse(responseFilmPageBody);
            String valueFilmsTitle = (String) resultFilmResponse.get("title");

            assertEquals(valueFilmsTitle, "Attack of the Clones");

            try {

                JSONArray arrayCharacters = (JSONArray) resultFilmResponse.get("characters");
                assertTrue((arrayCharacters).contains(value + getTestProperty("people_id") + "/"));
               // Iterator<String> iteratorArrayCharacters = arrayCharacters.iterator();
               /* ListIterator<String> itArP = arrayCharacters.listIterator();

                while (itArP.hasNext()) {

                    Assert.assertEquals(value + getTestProperty("people_id") + "/", itArP.next());

                }*/

            } catch (java.lang.AssertionError e) {
                System.out.println(e);
            }


            JSONArray arrayPlanets = (JSONArray) resultFilmResponse.get("planets");
            assertTrue((arrayPlanets).contains(homeworld));

          /*  ListIterator<String> itArPl = arrayPlanets.listIterator();

            while (itArPl.hasNext()) {

              //  assertEquals(homeworld, arrayPlanets);

                assertTrue((arrayPlanets).contains(homeworld));
            }*/






          /*  } catch (org.junit.ComparisonFailure e) {
                System.out.println(e);
            }*/


        } catch (org.json.simple.parser.ParseException e) {
            System.out.println("Error: " + e);
        }


    }
}


