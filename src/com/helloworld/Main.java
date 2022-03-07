package com.helloworld;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StringBuilder sb = new StringBuilder();
	private String languageCode = "en";

	// UI
	JTextField userText;
	JButton button;
	JTextArea textArea;

	void init() {
		Dimension windowDimension = Toolkit.getDefaultToolkit().getScreenSize();

		// Search box
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		userText = new JTextField(50);
		controlPanel.add(userText);

		// Search button
		button = new JButton();
		controlPanel.add(button);
		button.setText("Search");
		// Search action
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				doSearch();
			}
		});

		// Country Selection
		JPanel radioPanel = new JPanel();
		JRadioButton radioBtnEng = new JRadioButton("English");
		radioBtnEng.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					languageCode = "en";
				}

			}

		});
		JRadioButton radioBtnIndia = new JRadioButton("India");
		radioBtnIndia.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					languageCode = "hi";
				}

			}

		});
		JRadioButton radioBtnSpanish = new JRadioButton("Spanish");
		radioBtnSpanish.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					languageCode = "es";
				}

			}

		});
		radioBtnEng.setBounds(50, 60, 170, 30);
		radioBtnIndia.setBounds(50, 100, 170, 30);
		radioBtnSpanish.setBounds(50, 140, 170, 30);
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioBtnEng);
		bg.add(radioBtnIndia);
		bg.add(radioBtnSpanish);
		radioPanel.add(radioBtnEng);
		radioPanel.add(radioBtnIndia);
		radioPanel.add(radioBtnSpanish);
		controlPanel.add(radioPanel);

		// Result text area
		textArea = new JTextArea(5, 10);
		textArea.setAutoscrolls(true);
		JScrollPane scrollPane = new JScrollPane(textArea);

		// Show UI
		setTitle("Keyword tool");
		add(controlPanel, BorderLayout.NORTH);
		add(new JLabel(), BorderLayout.SOUTH);
		add(scrollPane, BorderLayout.CENTER);
		setSize(windowDimension);
		setVisible(true);

	}

	// Start search
	private void doSearch() {
		sb = new StringBuilder();
		try {
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						sb = new StringBuilder();
						for (String alphabet : DataUtils.ALPHABET) {
							String keyword = userText.getText() + " " + alphabet;
							String data = ConnectionUtils.getSugguestion(languageCode, "", keyword);
							List<String> results = DataUtils.parseData(data);
							for (String result : results) {
								sb.append(result + "\n");
							}
							textArea.setText(sb.toString());
						}

//						
					} catch (Exception e) {

						e.printStackTrace();
					}

				}

			}).start();

		} catch (Exception e1) {

			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.init();
	}

}
