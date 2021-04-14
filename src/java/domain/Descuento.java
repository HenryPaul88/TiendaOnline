package domain;

public class Descuento {

	private int cod_des;
	private int descuento;

	public Descuento(int cod_des, int descuento) {
		this.cod_des = cod_des;
		this.descuento = descuento;
	}

	public Descuento() {
	}

	public Descuento(int cod_des) {
		this.cod_des = cod_des;
	}

	public int getCod_des() {
		return cod_des;
	}

	public void setCod_des(int cod_des) {
		this.cod_des = cod_des;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	
}
