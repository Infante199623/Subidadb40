/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EquipoPokemon;

import java.io.Serializable;

/**
 *
 * @author Infante96
 */
public class EquipoPokemon implements Serializable{
    
    protected int id_Equipo;
    protected String region ;
    protected String nombre_Equipo;
    protected String color_Equipo;
    protected int miembrosEquipo;
    protected String fechaCreacion;
     
    public EquipoPokemon(int id_Pokemon, String nombre_Equipo, String color_Equipo, int miembrosEquipo, String fechaCreacion) {
        this.id_Equipo = id_Pokemon;
        this.nombre_Equipo = nombre_Equipo;
        this.color_Equipo = color_Equipo;
        this.miembrosEquipo = miembrosEquipo;
        this.fechaCreacion = fechaCreacion;
    }
    
    public EquipoPokemon() {
        this.id_Equipo =0;
        this.nombre_Equipo = "";
        this.color_Equipo ="";
        this.miembrosEquipo = 0;
        this.fechaCreacion = "";
    }

    public int getId_Equipo() {
        return id_Equipo;
    }

    public void setId_Equipo(int id_Equipo) {
        this.id_Equipo = id_Equipo;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    public int getId_Pokemon() {
        return id_Equipo;
    }

    public void setId_Pokemon(int id_Pokemon) {
        this.id_Equipo = id_Pokemon;
    }

    public String getNombre_Equipo() {
        return nombre_Equipo;
    }

    public void setNombre_Equipo(String nombre_Equipo) {
        this.nombre_Equipo = nombre_Equipo;
    }

    public String getColor_Equipo() {
        return color_Equipo;
    }

    public void setColor_Equipo(String color_Equipo) {
        this.color_Equipo = color_Equipo;
    }

    public int getMiembrosEquipo() {
        return miembrosEquipo;
    }

    public void setMiembrosEquipo(int miembrosEquipo) {
        this.miembrosEquipo = miembrosEquipo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
}
