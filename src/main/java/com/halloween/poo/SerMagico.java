/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.halloween.poo;


public abstract class SerMagico {
    protected String nombre;
    protected String emoji;
    protected String rutaImagen; 


    public SerMagico(String nombre, String emoji, String rutaImagen) { 
        this.nombre = nombre;
        this.emoji = emoji;
        this.rutaImagen = rutaImagen;
    }


    public String presentarse() {
        return this.emoji + " " + this.nombre + " se presenta: ¡Feliz Halloween!";
    }


    public abstract String ejecutarAccion(SerMagico objetivo);
    
    public String getNombre() {
        return nombre;
    }

    public String getEmoji() {
        return emoji;
    }
    
    public String getRutaImagen() {
        return rutaImagen;
    }
}