package com.ejemplo.testbatch.modelo;

public class PersonaBatch {
	private int id;
	private String nombre;
	private String apepat;
	private String tel;
	
	//CONSTRUCTORES	
	public PersonaBatch() {
		super();
	}

	public PersonaBatch(int id) {
		super();
		this.id = id;
	}

	public PersonaBatch(int id, String nombre, String apepat, String tel) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apepat = apepat;
		this.tel = tel;
	}
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApepat() {
		return apepat;
	}

	public void setApepat(String apepat) {
		this.apepat = apepat;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
