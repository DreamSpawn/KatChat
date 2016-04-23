package client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChatUI {
	boolean isUserNameOK = false;

	public ChatUI(){
		System.out.println("ChatUI");
		final JFrame frame = new JFrame("KatChat");
		final JPanel panelMain = new JPanel();
		final JPanel panelTop = new JPanel();
		final JPanel panelCN = new JPanel();
		final JPanel panelButtom = new JPanel();
		final JTextField textToSend = new JTextField();
		final JTextField textUserName = new JTextField();
		final JTextField textPswd = new JTextField();
		final JLabel labelUser = new JLabel("Brugernavn: ");
		final JLabel labelName = new JLabel("");
		final JLabel labelPswd = new JLabel("Kodeord: ");
		final JButton buttonSend = new JButton("Send");
		final JButton buttonLogin = new JButton("Login");
		final JList ls = new JList();

		panelMain.setLayout(new BorderLayout(5, 5));
		panelTop.setLayout(new GridLayout(1, 5));
		panelCN.setLayout(new BorderLayout(5, 5));
		panelButtom.setLayout(new BorderLayout(5, 5));

		panelTop.add(labelUser);
		panelTop.add(textUserName);
		panelTop.add(labelPswd);
		panelTop.add(textPswd);
		panelTop.add(buttonLogin);

		panelCN.add(new JScrollPane(), BorderLayout.CENTER);
		panelCN.add(ls, BorderLayout.EAST);
		ls.setVisible(false);

		panelButtom.add(textToSend, BorderLayout.CENTER);
		panelButtom.add(buttonSend, BorderLayout.EAST);
		textToSend.setVisible(false);
		buttonSend.setVisible(false);

		panelMain.add(panelTop, BorderLayout.NORTH);
		panelMain.add(panelCN, BorderLayout.CENTER);
		panelMain.add(panelButtom, BorderLayout.SOUTH);
		panelMain.setBorder(new EmptyBorder(10, 10, 10, 10));

		//Ska sende et request til java-serveren, om brugeren existere
		buttonLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(textUserName.getText().isEmpty()){
					JOptionPane.showMessageDialog(frame,
							"Indtast venligst Brugernavn!",
							"Inane warning",
							JOptionPane.WARNING_MESSAGE);
				}
				if(textUserName.getText().isEmpty() == false) isUserNameOK = true; 
				if(isUserNameOK){
					labelName.setText(textUserName.getText());
					panelTop.remove(textUserName);
					panelTop.remove(textPswd);
					panelTop.remove(labelPswd);
					panelTop.remove(buttonLogin);
					panelTop.add(labelName);
					ls.setVisible(true);
					textToSend.setVisible(true);
					buttonSend.setVisible(true);
				}

			} });
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		} });
		textToSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		} });


		frame.setContentPane(panelMain);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
}
