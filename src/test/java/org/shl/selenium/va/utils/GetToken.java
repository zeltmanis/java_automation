package org.shl.selenium.va.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//Function to get user access token to use it in ResetExercise

public class GetToken {

    public static String getAccessToken() throws IOException {
        String data = "{ \"AuthParameters\" : { \"USERNAME\" : \"admin\", \"PASSWORD\" : \"Ps@33wrd18\" }, \"AuthFlow\" : \"USER_PASSWORD_AUTH\", \"ClientId\" : \"atn70ucomv3mmsvqva3rmihg5\" }";

        URL url = new URL("https://cognito-idp.eu-central-1.amazonaws.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        // con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("X-Amz-Target", "AWSCognitoIdentityProviderService.InitiateAuth");
        con.setRequestProperty("Content-Type", "application/x-amz-json-1.1");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        try (OutputStream os = con.getOutputStream()) {
            byte[] input = data.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response);

            JSONParser parser = new JSONParser();
            Map<String, Object> json = (Map<String, Object>) parser.parse(response.toString());
            Map<String, Object> authenticationResult = (Map<String, Object>) json.get("AuthenticationResult");
            String accessToken = (String) authenticationResult.get("AccessToken");
            System.out.println(accessToken);

            return accessToken;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}