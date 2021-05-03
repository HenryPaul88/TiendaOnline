package domain;

import java.io.InputStream;
import java.sql.Date;

public class Producto {

    private int cod_pro;
    private String nom_pro;
    private double precio;
    private Familias cod_fam;
    private Descuento cod_des;
    private InputStream img;
    private Date fecha_pro;
    private String desc_pro;

    public Producto(int cod_pro, String nom_pro ,double precio, Familias cod_fam,Descuento cod_des, InputStream img,
            Date fecha_pro, String desc_pro) {
        this.cod_pro = cod_pro;
        this.nom_pro = nom_pro;
        this.cod_fam = cod_fam;
        this.precio = precio;
        this.desc_pro = desc_pro;
        this.img = img;
        this.fecha_pro = fecha_pro;
        this.cod_des = cod_des;
    }

    public Date getFecha_pro() {
        return fecha_pro;
    }

    public void setFecha_pro(Date fecha_pro) {
        this.fecha_pro = fecha_pro;
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

    public InputStream getImg() {
        return img;
    }

    public void setImg(InputStream img) {
        this.img = img;
    }

    public Descuento getCod_des() {
        return cod_des;
    }

    public void setCod_des(Descuento cod_des) {
        this.cod_des = cod_des;
    }

}
