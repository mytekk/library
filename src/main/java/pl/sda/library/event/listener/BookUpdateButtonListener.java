package pl.sda.library.event.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;

import pl.sda.library.model.Book;
import pl.sda.library.table.model.CrudDataTableModel;

public class BookUpdateButtonListener implements ActionListener {

	private CrudDataTableModel model;

	private JTable table;

	private JTextField titleTextField;
	private JTextField authorFirstNameTextField;
	private JTextField authorLastNameTextField;
	private JTextField categoriesTextField;

	public BookUpdateButtonListener(CrudDataTableModel model, JTable table,
			JTextField titleTextField, JTextField authorFirstNameTextField,
			JTextField authorLastNameTextField, JTextField categoriesTextField) {
		super();
		this.model = model;
		this.table = table;
		this.titleTextField = titleTextField;
		this.authorFirstNameTextField = authorFirstNameTextField;
		this.authorLastNameTextField = authorLastNameTextField;
		this.categoriesTextField = categoriesTextField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.update(getBookToUpdate());
		titleTextField.setText("");
		authorFirstNameTextField.setText("");
		authorLastNameTextField.setText("");
		categoriesTextField.setText("");
	}

	private Book getBookToUpdate() {
		int id = (int) model.getValueAt(table.getSelectedRow(), 0);
		Book book = model.getById(id);
		book.setTitle(titleTextField.getText());
		book.setAuthorFirstName(authorFirstNameTextField.getText());
		book.setAuthorLastName(authorLastNameTextField.getText());
		book.setCategories(categoriesTextField.getText());
		return book;
	}

}
