package org.selenide.yourbet.selenide_maxpay_tests;


import org.json.simple.JSONArray;
import org.junit.Assert;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.get;


import com.jayway.restassured.response.Response;

import org.selenide.yourbet.config_Properties_MaxPay.DataConfigMaxPay;

import java.util.Iterator;

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

            Assert.assertEquals(valueLuke, "Luke Skywalker");

            String homeworld = (String) result.get("homeworld");

            Assert.assertEquals(homeworld, "https://swapi.co/api/planets/1/");

            Response responseHomeworld = get(homeworld);
            String responseHomeworldBody = responseHomeworld.getBody().asString();
            System.out.println("Lucke's Homeworld is  " + responseHomeworldBody);


            org.json.simple.parser.JSONParser parserHomeworldResponse = new org.json.simple.parser.JSONParser();
            org.json.simple.JSONObject resultHomeworldResponse = (org.json.simple.JSONObject) parserHomeworldResponse.parse(responseHomeworldBody);

            String valueNamePlanet = (String) resultHomeworldResponse.get("name");
            String valuesPopulationPlanet = (String) resultHomeworldResponse.get("population");

            Assert.assertEquals(valueNamePlanet, "Tatooine");
            Assert.assertEquals(valuesPopulationPlanet, "200000");


            JSONArray arrayFilms = (JSONArray) resultHomeworldResponse.get("films");
            Iterator<String> iterator1stFilmsOfArray = arrayFilms.iterator();
           // System.out.println("The first film in Luke's planet is "+iterator1stFilmsOfArray.next().toString());
          /*  while (iterator.hasNext())
            {
                System.out.println(iterator.next());
            }*/
            Response responseFilmPage = get(iterator1stFilmsOfArray.next().toString());
            String responseFilmPageBody = responseFilmPage.getBody().asString();
            System.out.println("First film in Lucke's Homeworld is  " + responseFilmPageBody);
            org.json.simple.parser.JSONParser parserFilmsResponse = new org.json.simple.parser.JSONParser();
            org.json.simple.JSONObject resultFilmResponse = (org.json.simple.JSONObject) parserFilmsResponse.parse(responseFilmPageBody);
            String valueFilmsTitle = (String) resultFilmResponse.get("title");

            Assert.assertEquals(valueFilmsTitle, "Attack of the Clones");

        } catch (org.json.simple.parser.ParseException e) {
            System.out.println("Error: " + e);
        }


    }
}


