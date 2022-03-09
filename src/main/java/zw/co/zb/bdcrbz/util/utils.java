package zw.co.zb.bdcrbz.util;/*
 * This program was developed by Douglas Gweera (douglasgweera@gmail.com ) on Copyright (c) 2021.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


@Service
public class utils {

    private static final Logger log = LoggerFactory.getLogger(utils.class);

    public static void viewBatch(String parameter) throws IOException {

        // set the request method and properties.
        String request = "https://api.bdctrs.jugaad.co.zw/api/v1/inbound/read/" + parameter.trim();
        URL url = new URL(request);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("X-api-key", "$apr1$0xpiuy83$80wyJVeTrN/UhcZuPA7pX.");

        int responseCode = conn.getResponseCode();
        log.info("\nSending 'GET' request to URL : " + url);
        log.info("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine); //

        }
        log.info("Received data is : " + response);
        in.close();

    }

    public static void main(String[] Args) {

    }


    public static String doPost(String urlParameters) throws Exception {

        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

        int postDataLength = 0;

        // set the request method and properties.
       // String request = "https://api.bdctrs.jugaad.co.zw/api/v1/inbound/add";

        String request = "http://api.bdctrs.rbz.co.zw";

        URL url = new URL(request);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Content-Length", String.valueOf(postData.length));
       // conn.setRequestProperty("X-api-key", "$apr1$0xpiuy83$80wyJVeTrN/UhcZuPA7pX."); TEST
        conn.setRequestProperty("X-api-key", "JujflZLuVCQ32nAEJnkP8VMJ/sN4wwiqKDN4YBdU");

        try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
            wr.write(postData);


            int responseCode = conn.getResponseCode();

            log.info("\nSending 'POST' request to URL : " + url);
            log.info("Post parameters : " + urlParameters);
            log.info("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine); //
                System.out.println("Got the following response:::::" + response);
            }
            in.close();

            log.info("RESPONSE IYI: {}", response);
            return response.toString();

        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }

    }

    public static String getPurpose(String data) {
        String[] res = data.split("-");
        return res[0];
    }

    public static String formatDate(String data) {
        String[] res = data.split(" ");
        return (res[0] + "T" + res[1]);
    }
}
