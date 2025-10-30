/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.halloween.poo;

public class Fantasma extends MonstruoClasico {

    public Fantasma(String nombre) {
        super(nombre, "👻", "fantasma.png"); 
    }

    @Override
    public String ejecutarAccion(SerMagico objetivo) {
        if (objetivo instanceof Vampiro) {
            return "El " + this.emoji + " " + this.nombre + " **Atraviesa la pared** justo antes de que " + objetivo.getNombre() + " lo atrape. (Inmunidad)";
        } else {
            return "El " + this.emoji + " " + this.nombre + " se **Vuelve Intangible** y atraviesa a " + objetivo.getNombre() + ". (Movimiento Etéreo)";
        }
    }
}
