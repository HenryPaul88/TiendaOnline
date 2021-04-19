package domain;

public class Imagen {
	
	private int cod_img;
	private String ruta;
	private String ruta_abs;
	
	
	public Imagen(int cod_img, String ruta, String ruta_abs) {
		this.cod_img = cod_img;
		this.ruta = ruta;
		this.ruta_abs = ruta_abs;
	}


	public Imagen() {
	}
	
	public Imagen(int cod_img) {
		this.cod_img = cod_img;
	}
	
	public int getCod_img() {
		return cod_img;
	}


	public void setCod_img(int cod_img) {
		this.cod_img = cod_img;
	}


	public String getRuta() {
		return ruta;
	}


	public void setRuta(String ruta) {
		this.ruta = ruta;
	}


	public String getRuta_abs() {
		return ruta_abs;
	}


	public void setRuta_abs(String ruta_abs) {
		this.ruta_abs = ruta_abs;
	}
	
	
	

}
