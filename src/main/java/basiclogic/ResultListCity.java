package basiclogic;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class ResultListCity {
	public static int humanScore = 0;
	public static int computerScore = 0;
	public LinkedList<String> resultList = new LinkedList<>();

	private HashMap<String,String> cityRegionMap = new HashMap<>();

	private boolean isExistInList(String city) {
		if (resultList.size() != 0) return resultList.stream().anyMatch(i -> i.equalsIgnoreCase(city));
		return false;
	}

	public String addCityToCompList(List<String> findCitiesInComputerList) {
		for (String compCity : findCitiesInComputerList) {
			if (!resultList.contains(compCity)) {
				computerScore++;
				resultList.addLast(compCity);
				return compCity;
			}
		}
		return "citynotfound";
	}

	private boolean isFirstLetterCorrect(String city, String lastCity) {
		return city.toLowerCase().charAt(0) == lastCity.toLowerCase().charAt(lastCity.length() - 1);
	}

	public String addToResultCity(String city) {
		if (isExistInList(city)) {
			return "Місто вже є у списку, спробуйте інше";
		} else if (city.equalsIgnoreCase("здаюсь")) {
			return "Computer wins!";
		} else if (getResultList().size() > 1 && !isFirstLetterCorrect(city, getResultList().getLast())) {
			return "Місто повинно починатись на літеру, яка є останньою в останньому слові списку";
		} else if (!isRealCity(city)) {
			return "Введіть існуючу назву міста";
		} else {

			return city;
		}
	}

	public void addToResultListByHuman(String city) {
		humanScore++;
		resultList.addLast(city);
	}

		private void parseCityData()  {
		try {

			String filePath = "file:///" + System.getProperty("user.dir") + "/src/main/resources/ukrainian_cities.json";
			URL url = new URL(filePath);

			InputStream inputStream = url.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
			Gson gson = new Gson();
			JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);

				for (JsonElement regionElement : jsonArray) {
					JsonObject regionObject = regionElement.getAsJsonObject();
					JsonArray citiesArray = regionObject.getAsJsonArray("cities");
					for (JsonElement cityElement : citiesArray) {
						JsonObject cityObject = cityElement.getAsJsonObject();
						String cityName = cityObject.getAsJsonPrimitive("name").getAsString();
						String regionName = regionObject.getAsJsonPrimitive("name").getAsString();
						cityRegionMap.put(cityName, regionName);
					}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private boolean isRealCity(String city) {
		if (cityRegionMap.isEmpty()) {
			parseCityData();
		}
		return cityRegionMap.containsKey(city.toLowerCase());
	}


	public LinkedList<String> getResultList() {
		return resultList;
	}

}
