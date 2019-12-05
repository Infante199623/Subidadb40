/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EquipoPokemon;


import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Infante96
 */
public class GestionContenidoEquipo extends  DefaultHandler {	 
            
            EquipoPokemon e;
            String fichero = "";
            private ArrayList<EquipoPokemon> arrayEquipo = new ArrayList();

        public void setArrayEntrenador(ArrayList<EquipoPokemon> arrayEquipo) {
            this.arrayEquipo = arrayEquipo;
        }
            
            
    public GestionContenidoEquipo() {
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
                if(fichero.equals("equipoPokemon")){
                    e = new EquipoPokemon();
                
                }

	    } 	
	    public void endElement(String uri, String nombre,String nombreC) {
	       // System.out.printf("\tFin Elemento: %s %n", nombre);
                 fichero = nombre;
                
                if(fichero.equals("equipoPokemon")){
                      arrayEquipo.add(e);
                }
	    }	
	    public void characters(char[] ch, int inicio, int longitud) throws SAXException {
		   String car = new String(ch, inicio, longitud);
               //quitar saltos de línea	
		   car = car.replaceAll("[\t\n]","");	   
		   //System.out.printf ("\t Caracteres: %s %n", car);
                   
                    if(fichero.equals("nombre")){
                       e.setNombre_Equipo(String.valueOf(car));
                   } 
                    if(fichero.equals("region")){
                       e.setRegion(String.valueOf(car));
                   }
                    if(fichero.equals("colorEquipo")){
                       e.setColor_Equipo(String.valueOf(car));
                   }
                    if(fichero.equals("miembroEquipo")){
                       e.setMiembrosEquipo(Integer.parseInt(car));
                   }
                    if(fichero.equals("fechaCreacion")){
                         e.setFechaCreacion(String.valueOf(car));
                    }
                    if(fichero.equals("region")){
                         e.setRegion(String.valueOf(car));
                    }
	    }	
            
}