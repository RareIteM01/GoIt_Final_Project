package city;

import java.util.ArrayList;

public class CityList {
	private String name;
	private ArrayList<City> cities;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<City> getCities() {
		return cities;
	}

	public void setCities(ArrayList<City> cities) {
		this.cities = cities;
	}

	public CityList(String name, ArrayList<City> cities) {
		this.name = name;
		this.cities = cities;
	}


	@Override
	public String toString() {
		return "CityList{" +
				"name='" + name + '\'' +
				", cities=" + cities +
				'}';
	}
}
