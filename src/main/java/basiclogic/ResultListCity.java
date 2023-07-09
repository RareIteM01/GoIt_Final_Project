package basiclogic;

import java.util.LinkedList;
import java.util.List;


public class ResultListCity {
    public static int humanScore = 0;
    public static int computerScore = 0;
    public LinkedList<String> resultList = new LinkedList<>();


    private boolean isExistInList(String city) {
        if(resultList.size()!=0) return resultList.stream().anyMatch(i -> i.equalsIgnoreCase(city));
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
            return "Not a real city";
        } else {

            return city;
        }
    }

    public void addToResultListByHuman(String city){
        humanScore++;
        resultList.addLast(city);
    }

    private boolean isRealCity(String city) {
        return resultList.contains(city);
    }

    public LinkedList<String> getResultList() {
        return resultList;
    }


}