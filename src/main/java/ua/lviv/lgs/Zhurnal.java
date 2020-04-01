package ua.lviv.lgs;

public class Zhurnal {
	
	private int id;
	private String nameZhurnal;
	private double priseZhurnal;
	
	public Zhurnal(String nameZhurnal, double priseZhurnal) {
		super();
		this.nameZhurnal = nameZhurnal;
		this.priseZhurnal = priseZhurnal;
	}
	
	public Zhurnal(int id, String nameZhurnal, double priseZhurnal) {
		super();
		this.id = id;
		this.nameZhurnal = nameZhurnal;
		this.priseZhurnal = priseZhurnal;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameZhurnal() {
		return nameZhurnal;
	}

	public void setNameZhurnal(String nameZhurnal) {
		this.nameZhurnal = nameZhurnal;
	}

	public double getPriseZhurnal() {
		return priseZhurnal;
	}

	public void setPriseZhurnal(double priseZhurnal) {
		this.priseZhurnal = priseZhurnal;
	}
	
	@Override
	public String toString() {
		return "Журнал [id=" + id + ", Назва журналу=" + nameZhurnal + ", ціна=" + priseZhurnal + "]";
	}
}
