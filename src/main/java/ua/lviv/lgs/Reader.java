package ua.lviv.lgs;

public class Reader {

	private int id;
	private String nameReader;
	private int agReader;
	private String email;

	public Reader(String nameReader, int agReader, String email) {
		super();
		this.nameReader = nameReader;
		this.agReader = agReader;
		this.email = email;
	}

	public Reader(int id, String nameReader, int agReader, String email) {
		super();
		this.id = id;
		this.nameReader = nameReader;
		this.agReader = agReader;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameReader() {
		return nameReader;
	}

	public void setNameReader(String nameReader) {
		this.nameReader = nameReader;
	}

	public int getAgReader() {
		return agReader;
	}

	public void setAgReader(int agReader) {
		this.agReader = agReader;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Читач [id=" + id + ", Імя=" + nameReader + ", Вік=" + agReader + ", email=" + email + "]";
	}

}
