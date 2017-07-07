package pl.sda.library.event.listener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pl.sda.library.model.Book;
import pl.sda.library.table.model.CrudDataTableModel;

public class BookSelectButtonListener implements ListSelectionListener {

	private CrudDataTableModel model;

	private JTable table;

	private JTextField titleTextField;
	private JTextField authorFirstNameTextField;
	private JTextField authorLastNameTextField;
	private JTextField categoriesTextField;

	public BookSelectButtonListener(CrudDataTableModel model, JTable table,
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
	public void valueChanged(ListSelectionEvent e) {
		Book book = getBook();
		if (book != null) {
			titleTextField.setText(book.getTitle());
			authorFirstNameTextField.setText(book.getAuthorFirstName());
			authorLastNameTextField.setText(book.getAuthorLastName());
			categoriesTextField.setText(book.getCategories());
		}
	}

	private Book getBook() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow >= 0) {
			int id = (int) model.getValueAt(selectedRow, 0);
			Book book = model.getById(id);
			return book;
		} else {
			return null;
		}
	}

}
