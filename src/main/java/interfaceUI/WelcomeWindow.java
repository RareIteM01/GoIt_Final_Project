package interfaceUI;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeWindow extends JFrame {
	private JLabel messageLabel;
	private JButton startButton;

	public WelcomeWindow() {
		setTitle("Вітаємо!");
		setSize(400, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		messageLabel = new JLabel("Натисніть кнопку, щоб розпочати гру");
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		startButton = new JButton("Продовжити");

		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openMenuWindow();
			}
		});

		setLayout(new BorderLayout());
		add(messageLabel, BorderLayout.CENTER);
		add(startButton, BorderLayout.SOUTH);
	}

	private void openMenuWindow() {
		MenuWindow menuWindow = new MenuWindow();
		menuWindow.setVisible(true);
		dispose();
	}

	public static void main(String[] args) {
		WelcomeWindow welcomeWindow = new WelcomeWindow();
		welcomeWindow.setVisible(true);
	}
}
