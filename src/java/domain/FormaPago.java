package domain;

public class FormaPago {

	private int codigo_fp;
	private String nombre_fp;

	public FormaPago(int codigo_fp, String nombre_fp) {

		this.codigo_fp = codigo_fp;
		this.nombre_fp = nombre_fp;
	}

	public FormaPago(int codigo_fp) {
		this.codigo_fp = codigo_fp;
	}

	public FormaPago() {
	}

	public int getCodigo_fp() {
		return codigo_fp;
	}

	public void setCodigo_fp(int codigo_fp) {
		this.codigo_fp = codigo_fp;
	}

	public String getNombre_fp() {
		return nombre_fp;
	}

	public void setNombre_fp(String nombre_fp) {
		this.nombre_fp = nombre_fp;
	}
	
	

}
