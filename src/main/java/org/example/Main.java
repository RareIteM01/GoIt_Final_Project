package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static boolean theEnd = false;
    public static boolean isCity = true;
    public static String winner = "You win";

    public static void main(String[] args) {

        ComputerCity computerCity = new ComputerCity();

        ResultListCity resultList = new ResultListCity();

        while (!theEnd) {
            Scanner scanner = new Scanner(System.in);
            String city = scanner.nextLine();

            //додавання юзером. Якщо юзер вводить слово, яке не починається на букву, яка є в кінці останнього слова, то цикл пропускає код.
            if (resultList.addToResultCity(city).equals("Incorrect city")) {
                continue;
            }

            resultList.addToResultCity(city);
            //пошук в компютері усіх міст, які підходять на кінцеву букву введеного міста
            List<String> findCitiesInComputerList = computerCity.getCity(city);

            //результат пошуку
            boolean isFind = resultList.addCityToCompList(findCitiesInComputerList);
            if (!isFind) {
                theEnd = true;
                scanner.close();
            }
            System.out.println(winner);
            System.out.println("resultList = " + resultList.getResultList());
        }
    }
}