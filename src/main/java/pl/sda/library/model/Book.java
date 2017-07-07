package pl.sda.library.model;

public class Book {

	private Integer id;

	private String title;

	private String authorFirstName;

	private String authorLastName;

	private String categories;

	public Book() {
	}

	public Book(Integer id, String title, String authorFirstName,
			String authorLastName, String categories) {
		this.id = id;
		this.title = title;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.categories = categories;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

}
