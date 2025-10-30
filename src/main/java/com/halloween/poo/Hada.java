/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.halloween.poo;


public class Hada extends MonstruoMagico {

    public Hada(String nombre) {
        super(nombre, "🧚", "hada.png");
    }

    @Override
    public String ejecutarAccion(SerMagico objetivo) {
        if (objetivo instanceof MonstruoClasico) {
            return "El " + this.emoji + " " + this.nombre + " lanza **Polvo de Hadas** sobre " + objetivo.getNombre() + ", distrayéndolo. (Hechizo)";
        } else {
            return "El " + this.emoji + " " + this.nombre + " realiza una **Danza Curativa** para sus aliados. (Soporte Mágico)";
        }
    }
}
