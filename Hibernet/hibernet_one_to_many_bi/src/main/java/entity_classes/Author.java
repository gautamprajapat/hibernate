package entity_classes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {
	@Id
	private int id;
	private String name;
	@OneToMany
	private List<Book>books;
	public Author() {
		
	}
	public Author(int id, String name) {
		
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	

}
