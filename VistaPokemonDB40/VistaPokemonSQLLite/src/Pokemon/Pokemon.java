/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pokemon;

import java.io.Serializable;

/**
 *
 * @author pedro
 */
public class Pokemon implements Serializable{
    
        protected int id_Pokemon;
        protected String entrenador;
        protected String nombre;
        protected String tipo;
        protected int  hurt;
        protected String ataque;
        protected double peso;

    public Pokemon(){
        
        this.id_Pokemon = 0;
        this.nombre = null;
        this.tipo = null;
        this.hurt = 0;
        this.ataque = null;
        this.peso = 0.0;
    
    }

    public Pokemon(int id_registro, String nombre, String tipo, int hurt,String ataque,double peso) {
        this.id_Pokemon = id_registro;
        this.nombre = nombre;
        this.tipo = tipo;
        this.hurt = hurt;
        this.ataque = ataque;
        this.peso = peso ;
        
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getId_registro() {
        return id_Pokemon;
    }

    public void setId_registro(int id_registro) {
        this.id_Pokemon = id_registro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getHurt() {
        return hurt;
    }

    public void setHurt(int hurt) {
        this.hurt = hurt;
    }

    public String getAtaque() {
        return ataque;
    }

    public void setAtaque(String ataque) {
        this.ataque = ataque;
    }

    public void printPokemon(){
    
        System.out.println("El nombre del pokemon : " + this.nombre);
        System.out.println("Tipo de pokemon : " + this.tipo);
        System.out.println("Daño : " + this.hurt);
        System.out.println("Ataque : " + this.ataque);
        System.out.println("Peso : " + this.peso);
        
    }

    public static void pokemonPredefinidos(VistaPokemon p){
        
        Pokemon p1 = new Pokemon(25,"Pikachu","Electrico",90,"Voltio Cruel",3.35);
        Pokemon p2 = new Pokemon(9,"Blastoise","Agua",130,"Hidrobomba",43.2);
        Pokemon p3 = new Pokemon(447,"Riolu","Lucha",50,"Tajo Cruzado",11.26);

        p.arrayPokemon.add(p1);
        p.arrayPokemon.add(p2);
        p.arrayPokemon.add(p3);
    
    }
}
