/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.halloween.poo;

public class Driade extends MonstruoMagico {

    public Driade(String nombre) {
        super(nombre, "🌳", "driade.png");
    }

    @Override
    public String ejecutarAccion(SerMagico objetivo) {
        if (objetivo instanceof HombreLobo) {
            return "La " + this.emoji + " " + this.nombre + " invoca **Raíces Enredadoras** para inmovilizar al " + objetivo.getNombre() + ". (Control Natural)";
        } else {
            return "La " + this.emoji + " " + this.nombre + " genera una **Niebla Protectora** para ocultarse. (Defensa Mágica)";
        }
    }
}
