package client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

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

import server.IKatServer;

public class ChatUI {

	private boolean isUserNameOK = false;
	private int sessionID;
	private IKatServer srv;

	public void doConnect() {
		System.out.println("client.ChatUI.doConnect()");
		try {
			srv = (IKatServer) Naming.lookup(IKatServer.FULL_ADDRESS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("connected to server at" + IKatServer.FULL_ADDRESS);
	}

	public int doLogin(String userName, String pswd) {
		System.out.println("client.ChatUI.doLogin()");
		if (srv == null) {
			doConnect();
		}

		int sID = 0;
		try {
			sID = srv.login(userName, pswd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Logged in with ID =" + sID);
		return sID;
	}

	public void doSendMsg(String msg) {
		System.out.println("Sending message:" + msg);
		try {
			srv.sentMessage(msg, sessionID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ChatUI() {
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

		buttonLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (textUserName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame,
							"Indtast venligst Brugernavn!",
							"Inane warning",
							JOptionPane.WARNING_MESSAGE);
				} else {
					sessionID = doLogin(textUserName.getText(), textPswd.getText());
					if (sessionID == -1) {
						JOptionPane.showMessageDialog(frame,
								"Det indtastede brugernavn og kode er ikke korrekt",
								"Inane warning",
								JOptionPane.WARNING_MESSAGE);
					} else {
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
				}
			}

		});

		textToSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doSendMsg(textToSend.getText());
			}
		});
		
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doSendMsg(textToSend.getText());
			}
		});


		frame.setContentPane(panelMain);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}

}
