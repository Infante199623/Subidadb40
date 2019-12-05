/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Region;

import java.util.ArrayList;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author pedro
 */
public class Region extends DefaultHandler{
    
    protected int id_Region;
    protected String Piedras_Region;
    protected String nombre;
    protected int pokemon_Registrados_Total;
    protected String gimnasio_Liga;
 //   protected ArrayList<EquipoPokemon> arrayEquipo;
   
    public Region(int id_Region, String id_Pokemon, String nombre, int pokemon_Registrados_Total, String gimnasio_Liga) {
        
        this.id_Region = id_Region;
        this.Piedras_Region = id_Pokemon;
        this.nombre = nombre;
        this.pokemon_Registrados_Total = pokemon_Registrados_Total;
        this.gimnasio_Liga = gimnasio_Liga;
    //    arrayEquipo = new ArrayList();

    }
    public Region(){
    
        this.id_Region = 0;
        this.Piedras_Region = "";
        this.nombre = "";
        this.pokemon_Registrados_Total = 0;
        this.gimnasio_Liga = "";
 
    }
    
    public int getId_Region() {
        return id_Region;
    }

    public void setId_Region(int id_Region) {
        this.id_Region = id_Region;
    }
    public void setPiedras_Region(String piedras) {
        this.Piedras_Region = piedras;
    }
    public String getPiedras_Region() {
        return Piedras_Region;
    }

    public void setId_Pokemon(String id_Pokemon) {
        this.Piedras_Region = id_Pokemon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPokemon_Registrados_Total() {
        return pokemon_Registrados_Total;
    }

    public void setPokemon_Registrados_Total(int pokemon_Registrados_Total) {
        this.pokemon_Registrados_Total = pokemon_Registrados_Total;
    }

    public String getGimnasio_Liga() {
        return gimnasio_Liga;
    }

    public void setGimnasio_Liga(String gimnasio_Liga) {
        this.gimnasio_Liga = gimnasio_Liga;
    }
    
    @Override
    public String toString() {
        return "Region{" + ", Piedras_Region=" + Piedras_Region + ", nombre=" + nombre + ", pokemon_Registrados_Total=" + pokemon_Registrados_Total + ", gimnasio_Liga=" + gimnasio_Liga + '}';
    }
    
    public static void printRegion(ArrayList<Region> region){
        
        for (Region r: region){
            System.out.println("----");
            System.out.println(r);
            
        }
    }
    
    
}
