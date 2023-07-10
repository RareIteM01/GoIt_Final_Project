package interfaceUI;


import basiclogic.ComputerCity;
import basiclogic.ResultListCity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuWindow extends JFrame {
	private JTextField cityTextField;
	private JLabel computerResponseResultList;
	private JButton makeMoveButton;
	private ComputerCity computerCity;
	private ResultListCity resultList;



	public MenuWindow() {

		setTitle("Гра у міста");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		computerCity = new ComputerCity();
		resultList = new ResultListCity();

		cityTextField = new JTextField();
		computerResponseResultList = new JLabel();

		makeMoveButton = new JButton("Зробити хід");

		makeMoveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				makeMove();
			}
		});

		setLayout(new BorderLayout());
		add(cityTextField, BorderLayout.NORTH);
		add(computerResponseResultList, BorderLayout.CENTER);
		add(makeMoveButton, BorderLayout.SOUTH);
	}



	private void makeMove() {
		StringBuilder stringBuilder = new StringBuilder();
		String city = cityTextField.getText();

		String result = resultList.addToResultCity(city);
		if (result.equals("Місто повинно починатись на літеру, яка є останньою в останньому слові списку") || result.equals("Місто вже є у списку, спробуйте інше") || result.equals("Введіть існуючу назву міста")) {
			JOptionPane.showMessageDialog(this, result, "Помилка", JOptionPane.ERROR_MESSAGE);
		} else if (result.equals("Computer wins!")) {
			showGameResult("Комп'ютер переміг!");
		} else {
			resultList.addToResultListByHuman(city);
			List<String> findCitiesInComputerList = computerCity.getCity(city);
			String resultComputerCityFound = resultList.addCityToCompList(findCitiesInComputerList);
			if (resultComputerCityFound.equals("citynotfound")) {
				showGameResult("Ви перемогли!");

			} else {
				for (int i = 0; i < resultList.getResultList().size(); i++) {
					stringBuilder.append(resultList.getResultList().get(i)).append(", ");
				}
				computerResponseResultList.setText(stringBuilder.toString());
			}
		}
		cityTextField.setText("");
	}


	private void showGameResult(String message) {
		JOptionPane.showMessageDialog(this, message + "\nРахунок: " + ResultListCity.humanScore + "-" + ResultListCity.computerScore, "Результат", JOptionPane.INFORMATION_MESSAGE);
		dispose();
	}
}
