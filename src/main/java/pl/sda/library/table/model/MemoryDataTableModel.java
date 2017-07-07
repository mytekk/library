package pl.sda.library.table.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import pl.sda.library.model.Book;

public class MemoryDataTableModel extends CrudDataTableModel {

	private static final long serialVersionUID = 1L;

	private Map<Integer, Book> allBooks = new HashMap<>();
	private int currentId = 0;

	public MemoryDataTableModel() {
		Book bookDWPN = new Book(null, "Droga wiodła przez Narvik", "Ksawery",
				"Pruszyński", "Historyczna, Młodzieżowa");
		Book bookCIFC = new Book(null, "Charlie i fabryka czekolady", "Roald",
				"Dahl", "Młodzieżowa");
		Book bookCIWSW = new Book(null, "Charlie i Wielka Szklana Winda", "Roald",
				"Dahl", "Młodzieżowa");
		create(bookDWPN);
		create(bookCIFC);
		create(bookCIWSW);
		filterByName("");
	}

	@Override
	public int getRowCount() {
		return getByName(filter).size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Book book = getByName(filter).get(rowIndex);
		switch (columnIndex) {
			case 0:
				return book.getId();
			case 1:
				return book.getTitle();
			case 2:
				return book.getAuthorFirstName();
			case 3:
				return book.getAuthorLastName();
			case 4:
				return book.getCategories();
			default:
				return null;
		}
	}

	@Override
	public Book getById(int id) {
		return allBooks.get(id);
	}

	@Override
	public List<Book> getByName(String name) {
		return allBooks.values().stream()
				.filter(book -> book.getTitle().contains(name))
				.collect(Collectors.toList());
	}

	@Override
	public void create(Book book) {
		book.setId(++currentId);
		allBooks.put(book.getId(), book);
		refresh();
	}

	@Override
	public void update(Book book) {
		allBooks.put(book.getId(), book);
		refresh();
	}

	@Override
	public void delete(Book book) {
		allBooks.remove(book.getId());
		refresh();
	}

}
