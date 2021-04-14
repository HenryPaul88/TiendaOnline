package domain;

public class Producto {
	
	private int cod_pro;
	private String nom_pro;
	private Familias cod_fam;
	private double precio;
	private String desc_pro;
	private Imagen cod_img;
	private Descuento cod_des;
	
	public Producto(int cod_pro,String nom_pro, Familias cod_fam, double precio, String desc_pro, Imagen cod_img,
			Descuento cod_des) {
		this.cod_pro = cod_pro;
		this.nom_pro = nom_pro;
		this.cod_fam = cod_fam;
		this.precio = precio;
		this.desc_pro = desc_pro;
		this.cod_img = cod_img;
		this.cod_des = cod_des;
	}
	public Producto() {
	}
	
	public Producto(int cod_pro) {
		this.cod_pro = cod_pro;
	}
	
	public int getCod_pro() {
		return cod_pro;
	}
	public void setCod_pro(int cod_pro) {
		this.cod_pro = cod_pro;
	}
	public Familias getCod_fam() {
		return cod_fam;
	}
	public void setCod_fam(Familias cod_fam) {
		this.cod_fam = cod_fam;
	}
	public String getNom_pro() {
		return nom_pro;
	}
	public void setNom_pro(String nom_pro) {
		this.nom_pro = nom_pro;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getDesc_pro() {
		return desc_pro;
	}
	public void setDesc_pro(String desc_pro) {
		this.desc_pro = desc_pro;
	}
	public Imagen getCod_img() {
		return cod_img;
	}
	public void setCod_img(Imagen cod_img) {
		this.cod_img = cod_img;
	}
	public Descuento getCod_des() {
		return cod_des;
	}
	public void setCod_des(Descuento cod_des) {
		this.cod_des = cod_des;
	}
	

	
}
