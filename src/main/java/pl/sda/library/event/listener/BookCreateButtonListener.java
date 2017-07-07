package pl.sda.library.event.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import pl.sda.library.model.Book;
import pl.sda.library.table.model.CrudDataTableModel;

public class BookCreateButtonListener implements ActionListener {

	private CrudDataTableModel model;

	private JTextField titleTextField;
	private JTextField authorFirstNameTextField;
	private JTextField authorLastNameTextField;
	private JTextField categoriesTextField;

	public BookCreateButtonListener(CrudDataTableModel model,
			JTextField titleTextField, JTextField authorFirstNameTextField,
			JTextField authorLastNameTextField, JTextField categoriesTextField) {
		super();
		this.model = model;
		this.titleTextField = titleTextField;
		this.authorFirstNameTextField = authorFirstNameTextField;
		this.authorLastNameTextField = authorLastNameTextField;
		this.categoriesTextField = categoriesTextField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.create(getBookToCreate());
		titleTextField.setText("");
		authorFirstNameTextField.setText("");
		authorLastNameTextField.setText("");
		categoriesTextField.setText("");
	}

	private Book getBookToCreate() {
		return new Book(null, titleTextField.getText(),
				authorFirstNameTextField.getText(),
				authorLastNameTextField.getText(),
				categoriesTextField.getText());
	}

}
