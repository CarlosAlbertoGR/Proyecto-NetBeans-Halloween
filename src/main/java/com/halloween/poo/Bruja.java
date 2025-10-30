/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.halloween.poo;


public class Bruja extends MonstruoMagico {

    public Bruja(String nombre) {
        super(nombre, "🧙", "bruja.png");
    }

    @Override
    public String ejecutarAccion(SerMagico objetivo) {
        if (objetivo instanceof MonstruoClasico) {
            return "La " + this.emoji + " " + this.nombre + " lanza una **Maldición de la Rana** a " + objetivo.getNombre() + ". (Ataque Mágico)";
        } else {
            return "La " + this.emoji + " " + this.nombre + " prepara una **Poción Revitalizante** en su caldero. (Crafteo)";
        }
    }
}
