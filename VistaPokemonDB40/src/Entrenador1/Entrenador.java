/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entrenador1;

/**
 *
 * @author pedro
 */
public class Entrenador{
    
    protected int id_Entrandor;
    protected String nombre;
    protected int edad;
    protected int pokemon_Capturados;
    protected String equipo;
    protected String ciudad;

    public Entrenador(int id_Entrandor, String nombre, int edad, int pokemon_Capturados, String equipo,String ciudad) {
        this.id_Entrandor = id_Entrandor;
        this.nombre = nombre;
        this.edad = edad;
        this.pokemon_Capturados = pokemon_Capturados;
        this.ciudad = equipo;
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    public Entrenador(){
    
        this.id_Entrandor = 0;
        this.nombre = null;
        this.edad = 0;
        this.pokemon_Capturados = 0;
        this.ciudad = "";
    
    }

    public int getId_Entrenador() {
        return id_Entrandor;
    }

    public void setId_Entrandor(int id_Entrandor) {
        this.id_Entrandor = id_Entrandor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPokemon_Capturados() {
        return pokemon_Capturados;
    }

    public void setPokemon_Capturados(int pokemon_Capturados) {
        this.pokemon_Capturados = pokemon_Capturados;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    
    
}
