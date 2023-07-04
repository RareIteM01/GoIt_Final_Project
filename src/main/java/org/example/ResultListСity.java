package org.example;

import java.util.LinkedList;
import java.util.List;

import static org.maven.study.Main.isCity;
import static org.maven.study.Main.winner;

public class ResultListСity {
	private LinkedList<String> resultList = new LinkedList<>();

	public LinkedList<String> getResultList() {
		return resultList;
	}

	private void addToList(String city){
		resultList.add(city);
	}

	private boolean isExistInList(String city){
		return resultList.stream().anyMatch(i -> i.equalsIgnoreCase(city));

	}

	public boolean addCityToCompList(List<String> findCitiesInComputerList){

		for (String compCity : findCitiesInComputerList) {
			if (!resultList.contains(compCity)){
				addToList(compCity);
				System.out.println(compCity);
				return true;
			}
		}
		return false;
	}

	private boolean isFirstLetterCorrect(String city, String lastCity){
		return city.toLowerCase().charAt(0)==lastCity.toLowerCase().charAt(lastCity.length()-1);
	}


	//Тут потрібно також добавити перевірку на то, чи це є реально місто
	public String addToResultCity(String city){
		if (isExistInList(city)) {
			return "City already exist";
		}
		else if (city.equalsIgnoreCase("здаюсь")) {
			winner="Computer win!";
			return winner;
		}
		else if(getResultList().size()>1&&!isFirstLetterCorrect(city,getResultList().getLast())){
			return "Incorrect city";

		} else if (!isCity) {
			return "It's not a city"; //перевірка на то, чи це дійсно є місто, буде брати з джейсону і порівнюватись з вмістом.
		} else {
			addToList(city);
			return city;
		}
	}
}
