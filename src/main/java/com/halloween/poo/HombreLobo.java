/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.halloween.poo;

public class HombreLobo extends MonstruoClasico {

    public HombreLobo(String nombre) {
        super(nombre, "🐺", "hombrelobo.png"); 
    }

    @Override
    public String ejecutarAccion(SerMagico objetivo) {
        if (objetivo instanceof Fantasma) {
            return "El " + this.emoji + " " + this.nombre + " **Aúlla** tan fuerte que asusta a " + objetivo.getNombre() + ". (Ruido Físico)";
        } else {
            return "El " + this.emoji + " " + this.nombre + " **Corre** a toda velocidad para alcanzar a " + objetivo.getNombre() + ". (Asalto Rápido)";
        }
    }
}
