package com.helloworld;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StringBuilder sb = new StringBuilder();
	private String languageCode = "en";
	private String countryCode = "us";

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
		userText.addActionListener(new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				doSearch();
				
			}
			
		});
		controlPanel.add(userText);

		// Search button
		button = new JButton();
		controlPanel.add(button);
		button.setText("Tìm");
		// Search action
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				doSearch();
			}
		});

		// Language Selection
		controlPanel.add(renderLanguageComboBoxLayout());

		// Country Selection
		controlPanel.add(renderCountryComboBoxLayout());

		// Result text area
		textArea = new JTextArea(5, 10);
		textArea.setAutoscrolls(true);
		Font font = new Font("Times-Roman", Font.PLAIN, 16);
		textArea.setFont( font.deriveFont( 16.0f) );
		JScrollPane scrollPane = new JScrollPane(textArea);

		// Show UI
		setTitle("Keyword tool");
		add(controlPanel, BorderLayout.NORTH);
		add(renderFilterButton(), BorderLayout.SOUTH);
		add(scrollPane, BorderLayout.CENTER);
		setSize(windowDimension);
		setVisible(true);

	}

	private void showSearchDialog() {
		UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
		String inputValue = "";

		inputValue = JOptionPane.showInputDialog("Nhập từ khoá tìm kiếm", "");
		if (inputValue == null || inputValue.isEmpty() || inputValue.isBlank()) {
			return;
		}
		System.out.println("Filter: "+inputValue);
		if (inputValue != null) {
			System.out.println(inputValue);
			Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);

			textArea.getHighlighter().removeAllHighlights();

			int offset = textArea.getText().indexOf(inputValue);
			int length = inputValue.length();

			while (offset != -1) {
				try {
					textArea.getHighlighter().addHighlight(offset, offset + length, painter);
					offset = textArea.getText().indexOf(inputValue, offset + 1);
				} catch (BadLocationException exception) {
					System.out.println(exception);
				}
			}
		}

	}

	// Start search
	private void doSearch() {
		String userInput = userText.getText();
		if (userInput.isBlank() || userInput.isEmpty()) {
			return;
		}
		String[] keywords = userText.getText().split(",");
	
		System.out.print("Do search with languageCode = " + languageCode + " ; CountryCode = " + countryCode);
		sb = new StringBuilder();
		try {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						sb = new StringBuilder();
						
						for (String keywordInlist : keywords) {
							//Search for raw keyword
							String keywordFirstShot = keywordInlist.trim();
							String dataFirstShot = ConnectionUtils.getSugguestion(languageCode, countryCode, keywordFirstShot);
							List<String> resultsFirstShot = DataUtils.parseData(dataFirstShot);
							for (String result : resultsFirstShot) {
								sb.append(result + "\n");
							}
							textArea.setText(sb.toString());
							
							//Search for keyword + alphabet character
							for (String alphabet : DataUtils.getAlphabet(languageCode)) {
								String keyword = keywordInlist.trim() + " " + alphabet;
								String data = ConnectionUtils.getSugguestion(languageCode, countryCode, keyword);
								List<String> results = DataUtils.parseData(data);
								for (String result : results) {
									sb.append(result + "\n");
								}
								textArea.setText(sb.toString());
							}
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

	JButton renderFilterButton() {
		JButton button = new JButton("Lọc từ khoá");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// doSearch();
				showSearchDialog();
			}
		});
		return button;
	}

	// Language
	JPanel renderLanguageComboBoxLayout() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(new JLabel("Ngôn ngữ"));

		JComboBox cb = new JComboBox(DataUtils.languages);
		cb.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				String item = (String) e.getItem();

				languageCode = DataUtils.getLanguageCode(item);
				System.out.println("Selected " + item + " ; LanguageCode = " + languageCode);
			}

		});
		panel.add(cb);
		return panel;
	}

	// Country
	JPanel renderCountryComboBoxLayout() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(new JLabel("Quốc gia"));
		JComboBox cb = new JComboBox(DataUtils.locations);
		cb.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				String item = (String) e.getItem();

				countryCode = DataUtils.getLocationCode(item);
				System.out.println("Selected " + item + " ; LanguageCode = " + languageCode);
			}

		});
		panel.add(cb);
		return panel;
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.init();
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment ();
        Font [] fonts = ge.getAllFonts ();
        for (Font font : fonts) {
        	System.out.println(font.getFontName());
        }
		

	}

}
