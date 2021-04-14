package domain;

public class Familias {

	private int cod_fam;
	private String nom_fam;
	private String desc_fam;
	
	public Familias() {
	}
	
	public Familias(int cod_fam) {
		this.cod_fam = cod_fam;
	}

	public Familias(int cod_fam, String nom_fam, String desc_fam) {
		this.cod_fam = cod_fam;
		this.nom_fam = nom_fam;
		this.desc_fam = desc_fam;
	}

	public int getCod_fam() {
		return cod_fam;
	}

	public void setCod_fam(int cod_fam) {
		this.cod_fam = cod_fam;
	}

	public String getNom_fam() {
		return nom_fam;
	}

	public void setNom_fam(String nom_fam) {
		this.nom_fam = nom_fam;
	}

	public String getDesc_fam() {
		return desc_fam;
	}

	public void setDesc_fam(String desc_fam) {
		this.desc_fam = desc_fam;
	}
	
}
