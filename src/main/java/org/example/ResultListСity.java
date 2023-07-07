package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;



class ResultListCity {
    private LinkedList<String> resultList = new LinkedList<>();

    public LinkedList<String> getResultList() {
        return resultList;
    }

    private void addToList(String city) {
        resultList.add(city);
    }

    private boolean isExistInList(String city) {
        return resultList.stream().anyMatch(i -> i.equalsIgnoreCase(city));
    }

    public boolean addCityToCompList(List<String> findCitiesInComputerList) {
        for (String compCity : findCitiesInComputerList) {
            if (!resultList.contains(compCity)) {
                addToList(compCity);
                System.out.println(compCity);
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
        }  else if (!isRealCity(city)) {
            return "Not a real city";
        } else {
            addToList(city);
            return city;
        }
    }

    private boolean isRealCity(String city) {
        try {

            String jsonUrl = "https://raw.githubusercontent.com/RareIteM01/GoIt_Final_Project/main/ua-cities%20in%20ukrainian.json";
            InputStream inputStream = new URL(jsonUrl).openStream();
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
}