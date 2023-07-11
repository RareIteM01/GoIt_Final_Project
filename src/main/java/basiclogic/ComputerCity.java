package basiclogic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerCity {
	private final List<String> computerCity = new LinkedList<>(
			Arrays.asList("Львів", "Київ", "Одеса", "Харків", "Вінниця", "Олешки", "Вроцлав", "Подільск", "Ямпіл")
	);


	public List<String> getCity(String city) {

		char lastChar = city.toLowerCase().charAt(city.length() - 1);
		return computerCity.stream().filter(i -> i.toLowerCase().charAt(0) == lastChar).collect(Collectors.toList());

	}
}
