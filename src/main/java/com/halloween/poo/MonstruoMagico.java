/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.halloween.poo;


public abstract class MonstruoMagico extends SerMagico {

    protected String fraseComun = "¡Por la Luna y el Sol! (Mágico)";

    public MonstruoMagico(String nombre, String emoji, String rutaImagen) {
        super(nombre, emoji, rutaImagen);
    }
    
    public String getFraseComun() {
        return fraseComun;
    }
}
