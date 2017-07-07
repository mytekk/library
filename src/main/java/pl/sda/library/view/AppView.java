package pl.sda.library.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import pl.sda.library.event.listener.BookCreateButtonListener;
import pl.sda.library.event.listener.BookDeleteButtonListener;
import pl.sda.library.event.listener.BookSearchButtonListener;
import pl.sda.library.event.listener.BookSelectButtonListener;
import pl.sda.library.event.listener.BookUpdateButtonListener;
import pl.sda.library.table.model.CrudDataTableModel;
import pl.sda.library.table.model.MemoryDataTableModel;

public class AppView {

	public AppView() {

		JTable table = new JTable(); //obiekt, ktory umie wyswietlac dane z bazy danych
		CrudDataTableModel model = getDataTableModel();
		table.setModel(model);

		JTextField searchTextField = new JTextField();
		JButton bookSearchButton = new JButton("Szukaj");
		BookSearchButtonListener bookSearchButtonListener = new BookSearchButtonListener(
				model, searchTextField);
		bookSearchButton.addActionListener(bookSearchButtonListener);

		JLabel titleLabel = new JLabel("Tytuł");
		JLabel authorFirstNameLabel = new JLabel("Imię autora");
		JLabel authorLastNameLabel = new JLabel("Nazwisko autora");
		JLabel categoriesLabel = new JLabel("Kategorie");
		JTextField titleTextField = new JTextField();
		JTextField authorFirstNameTextField = new JTextField();
		JTextField authorLastNameTextField = new JTextField();
		JTextField categoriesTextField = new JTextField();
		JButton bookCreateButton = new JButton("Dodaj");
		BookCreateButtonListener bookCreateButtonListener = new BookCreateButtonListener(
				model, titleTextField, authorFirstNameTextField, authorLastNameTextField, categoriesTextField);
		bookCreateButton.addActionListener(bookCreateButtonListener);
		JButton bookUpdateButton = new JButton("Zmień");
		BookUpdateButtonListener bookUpdateButtonListener = new BookUpdateButtonListener(
				model, table, titleTextField, authorFirstNameTextField, authorLastNameTextField, categoriesTextField);
		bookUpdateButton.addActionListener(bookUpdateButtonListener);
		JButton bookDeleteButton = new JButton("Usuń");
		BookDeleteButtonListener bookDeleteButtonListener = new BookDeleteButtonListener(model, table);
		bookDeleteButton.addActionListener(bookDeleteButtonListener);

		table.getSelectionModel().addListSelectionListener(new BookSelectButtonListener(
				model, table, titleTextField, authorFirstNameTextField,
				authorLastNameTextField, categoriesTextField));

		JPanel bookPanel = new JPanel();
		bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS));
		bookPanel.add(titleLabel);
		bookPanel.add(titleTextField);
		bookPanel.add(authorFirstNameLabel);
		bookPanel.add(authorFirstNameTextField);
		bookPanel.add(authorLastNameLabel);
		bookPanel.add(authorLastNameTextField);
		bookPanel.add(categoriesLabel);
		bookPanel.add(categoriesTextField);
		bookPanel.add(bookCreateButton);
		bookPanel.add(bookUpdateButton);
		bookPanel.add(bookDeleteButton);
		bookPanel.add(searchTextField);
		bookPanel.add(bookSearchButton);

		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setPreferredSize(new Dimension(700, 182));
		tableScrollPane.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Lista książek",
				TitledBorder.CENTER, TitledBorder.TOP));

		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				bookPanel, tableScrollPane);
		splitPane.setEnabled(false);

		JFrame frame = new JFrame("Biblioteka");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(splitPane);
		frame.pack(); //porzadkowanie komponentow przez Swinga
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	protected CrudDataTableModel getDataTableModel() {
		return new MemoryDataTableModel();
	}

}
