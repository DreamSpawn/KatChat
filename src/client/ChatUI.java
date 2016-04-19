package client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChatUI {

	public ChatUI(){
		System.out.println("ChatUI");
		JFrame frame = new JFrame("Group chat");
		JPanel panelMain = new JPanel();
		JPanel panelTop = new JPanel();
		JPanel panelCN = new JPanel();
		JPanel panelButtom = new JPanel();
		JTextField textToSend = new JTextField();
		JLabel labelName = new JLabel("KITTY");
		JButton buttonSend = new JButton("Send");
		JList ls = new JList();
		
		panelMain.setLayout(new BorderLayout(5, 5));
		panelTop.setLayout(new GridLayout(1, 5));
		panelCN.setLayout(new BorderLayout(5, 5));
		panelButtom.setLayout(new BorderLayout(5, 5));
		
		panelTop.add(new JLabel("Bruger: "));
		panelTop.add(labelName);
		
		panelCN.add(new JScrollPane(), BorderLayout.CENTER);
		panelCN.add(ls, BorderLayout.EAST);
		
		panelButtom.add(textToSend, BorderLayout.CENTER);
		panelButtom.add(buttonSend, BorderLayout.EAST);
		
		panelMain.add(panelTop, BorderLayout.NORTH);
		panelMain.add(panelCN, BorderLayout.CENTER);
		panelMain.add(panelButtom, BorderLayout.SOUTH);
		panelMain.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		} });
		textToSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		} });
		
		
		frame.setContentPane(panelMain);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
