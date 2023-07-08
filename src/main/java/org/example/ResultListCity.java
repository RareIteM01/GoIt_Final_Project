package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;


public class ResultListCity {
    public static final String JSON_URL = "https://raw.githubusercontent.com/RareIteM01/GoIt_Final_Project/main/ukrainian_cities.json";
    public static int humanScore = 0;
    public static int computerScore = 0;
    private LinkedList<String> resultList = new LinkedList<>();


    private void addToList(String city) {
        resultList.add(city);
    }

    private boolean isExistInList(String city) {
        return resultList.stream().anyMatch(i -> i.equalsIgnoreCase(city));
    }

    public boolean addCityToCompList(List<String> findCitiesInComputerList) {
        for (String compCity : findCitiesInComputerList) {
            if (!resultList.contains(compCity)) {
                computerScore++;
                addToList(compCity);
                return true;
            }
        }
        return false;
    }

    private boolean isFirstLetterCorrect(String city, String lastCity) {
        return city.toLowerCase().charAt(0) == lastCity.toLowerCase().charAt(lastCity.length() - 1);
    }

    public String addToResultCity(String city) {
        if (isExistInList(city)) {
            return "City already exists";
        } else if (city.equalsIgnoreCase("здаюсь")) {
            return "Computer wins!";
        } else if (getResultList().size() > 1 && !isFirstLetterCorrect(city, getResultList().getLast())) {
            return "Incorrect city";
        } else if (!isRealCity(city)) {
            return "Not a real city";
        } else {
            addToList(city);
            humanScore++;
            return city;
        }
    }

    private boolean isRealCity(String city) {
        try {

            InputStream inputStream = new URL(JSON_URL).openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("\"name\":\"" + city + "\"")) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public LinkedList<String> getResultList() {
        return resultList;
    }
}