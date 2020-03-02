package org.shl.selenium.va.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApiExercise {

    // Function to reset exercise
    // Use below code to run manually exercise reset

    public void removeExercise(long exercise_id) {

        try {

            URL url = new URL("https://vivid-vadevqa.eu.shl.zone/graphql");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", GetToken.getAccessToken());

            // Change "exercise_id number" to the exercise you want to reset
            System.out.println(exercise_id);

            String input = String.format("{ \"operationName\":\"Reset\", \"variables\":{ \"exercise_id\": \"%s\", \"hard\": false}, \"query\":\"mutation Reset($exercise_id: Int!){reset(exercise_id: $exercise_id)}\" }", exercise_id);
            System.out.println(input);
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public void resetExercise(long exercise_id) {

        try {

            URL url = new URL("https://vivid-vadevqa.eu.shl.zone/graphql");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", GetToken.getAccessToken());

            // Change "exercise_id number" to the exercise you want to reset
            String input = String.format("{ \"operationName\":\"Reset\", \"variables\":{ \"exercise_id\": %s, \"hard\": false}, \"query\":\"mutation Reset($exercise_id: Int!, $hard: Boolean){reset(exercise_id: $exercise_id, hard: $hard)}\" }", exercise_id);

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long assignExercise(String exercise_tag) {

        try {

            URL url = new URL("https://vivid-vadevqa.eu.shl.zone/graphql");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", GetToken.getAccessToken());

            // Change "exercise_id number" to the exercise you want to reset
            String input = String.format("{ \"operationName\":\"Assign\", \"variables\":{ \"exercise_tag\": \"%s\", \"test_ref_id\": \"test_ref_id\", \"company_id\": 1, \"candidate_user_id\": \"candidate1\", \"failure_url\": \"https://www.google2.com\", \"success_url\": \"https://www.shl2.com\" }, \"query\":\"mutation Assign($exercise_tag: String!, $test_ref_id: String! $company_id: Int!, $candidate_user_id: String!, $success_url: String!, $failure_url: String!){ assign(exercise_tag: $exercise_tag, test_ref_id: $test_ref_id, company_id: $company_id, candidate_user_id: $candidate_user_id, success_url: $success_url, failure_url: $failure_url){ success errors{ name message } exercise_id } }\" }", exercise_tag);
            System.out.println(input);

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
//            System.out.println(response);
            conn.disconnect();

            JSONParser parser = new JSONParser();
            Map<String, Object> json = (Map<String, Object>) parser.parse(response.toString());
//            System.out.println(json);
            Map<String, Object> dataResult = (Map<String, Object>) json.get("data");
//            System.out.println(dataResult);
            Map<String, Object> assignResult = (Map<String, Object>) dataResult.get("assign");
            System.out.println(assignResult);
            long exercise_id = (long) assignResult.get("exercise_id");

            return exercise_id;

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return 0;

    }

}