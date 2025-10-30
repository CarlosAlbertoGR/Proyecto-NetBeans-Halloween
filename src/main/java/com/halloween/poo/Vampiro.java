/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.halloween.poo;

public class Vampiro extends MonstruoClasico {

    public Vampiro(String nombre) {

        super(nombre, "🧛", "vampiro.png");
    }

    @Override
    public String ejecutarAccion(SerMagico objetivo) {
        if (objetivo instanceof HombreLobo) {
            return "El " + this.emoji + " " + this.nombre + " intenta morder al Hombre Lobo, ¡pero es demasiado peludo! 🐺";
        } else {
            return "El " + this.emoji + " " + this.nombre + " **Drena Energía** de " + objetivo.getNombre() + ". (Ataque Vampírico)";
        }
    }
}
