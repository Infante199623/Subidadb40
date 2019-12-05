/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pokemon;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
/**
 *
 * @author pedro
 */
public class VistaPokemon implements java.io.Serializable{
    

    public  ArrayList<Pokemon> arrayPokemon;

    public VistaPokemon(){
    
        arrayPokemon = new ArrayList();
        
    }       
    void deletePokemon(VistaPokemon p,String pokemon){
       
        for(int i =0; i < p.arrayPokemon.size();i++) { 
        
            if(pokemon.equals( this.arrayPokemon.get(i).getNombre())){
                 p.arrayPokemon.remove(p.arrayPokemon.get(i));
                // pokemon.Escribirfichero(p.arrayPokemon); 
            }
        }
    
    }
    void addPokemon(VistaPokemon p,Pokemon pokemon){
 
        p.arrayPokemon.add(pokemon);
      //  PokemonControler.Escribirfichero(p.arrayPokemon);    
        
    }
    
    DefaultListModel<String> MostrarPokemonRegistrados(ArrayList<Pokemon> p) {
       DefaultListModel <String> v = new DefaultListModel();
       
        for(int i = 0;i < p.size();i++){
            
            String cadena_amigo = arrayPokemon.get(i).getNombre();
            v.addElement(arrayPokemon.get(i).getNombre());
        
        }
        
        return v;
    }

    void PredefinidosSistemaPokemon(VistaPokemon p) {
       
        Pokemon.pokemonPredefinidos(p);
    }

    public boolean comprobarPokemon(String text) {
        
        boolean existe = false;
        
        for(int i =0; i < this.arrayPokemon.size();i++) { 
        
            if(text.equals( this.arrayPokemon.get(i).getNombre())){
                existe = true;
            }
        }
        
       return existe; 
    }
    Pokemon PokemonSeleccionado(String nombrePokemon) {
        
        
        Pokemon seleccionado = null;
        
        for(int i =0; i < this.arrayPokemon.size();i++) { 
        
            if(nombrePokemon.equals( this.arrayPokemon.get(i).getNombre())){
                seleccionado = this.arrayPokemon.get(i);
            }
        }
        
       return seleccionado; 
    }
    public int PokemonBusquedaPosicion(String nombrePokemon) {
       
        int posicion = -1;
        
        for(int i =0; i < this.arrayPokemon.size();i++) { 
        
            if(nombrePokemon.equals( this.arrayPokemon.get(i).getNombre())){
                posicion = i;
            }
        }
        
       return posicion; 
    }
}