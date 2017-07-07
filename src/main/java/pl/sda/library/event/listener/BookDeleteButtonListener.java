package pl.sda.library.event.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import pl.sda.library.model.Book;
import pl.sda.library.table.model.CrudDataTableModel;

public class BookDeleteButtonListener implements ActionListener {

	private CrudDataTableModel model;

	private JTable table;

	public BookDeleteButtonListener(CrudDataTableModel model, JTable table) {
		super();
		this.model = model;
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int id = (int) model.getValueAt(table.getSelectedRow(), 0);
		Book book = model.getById(id);
		model.delete(book);
	}

}
