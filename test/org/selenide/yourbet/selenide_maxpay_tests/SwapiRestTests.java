package org.selenide.yourbet.selenide_maxpay_tests;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;
import org.json.simple.JSONValue;
import org.junit.Assert;
import org.junit.Test;
import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.jayway.restassured.response.Response;

import org.selenide.yourbet.config_Properties_MaxPay.DataConfigMaxPay;


public class SwapiRestTests extends DataConfigMaxPay {


    @Test
    public void getRequestFindLukeSkywalkerData() {

        // выполняем запрос get для доступа ко всем параметрам ответа
        Response response = get(getTestProperty("url_root_people")+getTestProperty("people_id"));
        String responseBody = response.getBody().asString();

        // получаем параметры ответа
        System.out.println("Response Body is =  " + responseBody);

        // парсим джэйсон
        try {
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            org.json.simple.JSONObject result = (org.json.simple.JSONObject) parser.parse(responseBody);
            String searchPeopleByName = (String) result.get("name");
        // получаем name человека
            System.out.println("People with ID#1: " + searchPeopleByName);

        } catch (org.json.simple.parser.ParseException e) {
            System.out.println("Error: " + e);
        }



    }
}


