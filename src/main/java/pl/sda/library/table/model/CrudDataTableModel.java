package pl.sda.library.table.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import pl.sda.library.model.Book;

public abstract class CrudDataTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	protected String filter;

	public abstract Book getById(int id);

	public abstract List<Book> getByName(String name);

	public abstract void create(Book book);

	public abstract void update(Book book);

	public abstract void delete(Book book);

	public void refresh() {
		fireTableDataChanged();
	}

	public void filterByName(String name) {
		filter = name;
		refresh();
	}

}
