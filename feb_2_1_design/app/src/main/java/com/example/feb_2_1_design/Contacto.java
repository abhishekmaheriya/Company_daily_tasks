package com.example.feb_2_1_design;

public class Contacto {
    private String numero, correo, direccion;
    private int img1, img2, img3;

    public Contacto(String numero, int img_11, int img_22, int img_33) {
        this.numero = numero;
        this.correo = correo;
        this.direccion = direccion;
        this.img1 = img_11;
        this.img2 = img_22;
        this.img3 = img_33;
    }


    public String getNumero() {
        return numero;
    }


    public int getImg1() {
        return img1;
    }

    public int getImg2() {
        return img2;
    }
    public int getImg3() {
        return img3;
    }

}
