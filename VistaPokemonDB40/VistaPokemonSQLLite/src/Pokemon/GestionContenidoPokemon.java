/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pokemon;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Infante96
 */
public class GestionContenidoPokemon extends  DefaultHandler {	 
            
            Pokemon e;
            String fichero = "";
            private ArrayList<Pokemon> arrayPokemon = new ArrayList();

        public void setArrayPokemon(ArrayList<Pokemon> arrayPokemon) {
            this.arrayPokemon = arrayPokemon;
        }
            
            
    public GestionContenidoPokemon() {
	        super();
	    }	    
	    public void startDocument() {
	       // System.out.println("Comienzo del Documento XML");
               
	    }	    
	    public void endDocument() {
	       // System.out.println("Final del Documento XML");
	   
            }	 
	    public void startElement(String uri, String nombre,String nombreC, Attributes atts) {
	      //  System.out.printf("\t Principio Elemento: %s %n",nombre);
                fichero = nombre;     
                if(fichero.equals("pokemon")){
                    e = new Pokemon();
                
                }

	    } 	
	    public void endElement(String uri, String nombre,String nombreC) {
	       // System.out.printf("\tFin Elemento: %s %n", nombre);
                 fichero = nombre;
                
                if(fichero.equals("pokemon")){
                      arrayPokemon.add(e);
                }
	    }	
	    public void characters(char[] ch, int inicio, int longitud) throws SAXException {
		   String car = new String(ch, inicio, longitud);
               //quitar saltos de línea	
		   car = car.replaceAll("[\t\n]","");	   
		   //System.out.printf ("\t Caracteres: %s %n", car);
                   
                    if(fichero.equals("nombre")){
                       e.setNombre(String.valueOf(car));
                   } 
                    if(fichero.equals("ataque")){
                       e.setAtaque(String.valueOf(car));
                   }
                    if(fichero.equals("tipo")){
                       e.setTipo(String.valueOf(car));
                   }
                    if(fichero.equals("hurt")){
                       e.setHurt(Integer.parseInt(car));
                   }
                    if(fichero.equals("peso")){
                         e.setPeso(Double.parseDouble(car));
                    }
                    if(fichero.equals("nombreEntrenador")){
                         e.setEntrenador(car);
                    }
	    }	
            
}