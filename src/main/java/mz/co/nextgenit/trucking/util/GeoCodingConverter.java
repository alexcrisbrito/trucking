package mz.co.nextgenit.trucking.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GeoCodingConverter {

    public static String getAddress(double lat, double lng) throws Exception {
        String url = "https://nominatim.openstreetmap.org/reverse?lat=" + lat + "&lon=" + lng + "&format=json";

        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestProperty("User-Agent", "Trucking");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) response.append(line);
        reader.close();

        // parse with Jackson or any JSON lib
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.toString());
        return root.get("display_name").asText();
    }


}
