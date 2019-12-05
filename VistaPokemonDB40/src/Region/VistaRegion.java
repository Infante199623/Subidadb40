/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Region;


import EquipoPokemon.EquipoPokemon;
import java.util.ArrayList;



//setBackground(Color.GREEN)poner botones de colores...s
/**
 *
 * @author Infante96
 */
public class VistaRegion {
    
    protected  ArrayList<EquipoPokemon> arrayEquipos;

    public VistaRegion(){
    
        arrayEquipos = new ArrayList();
    }       

    public ArrayList<EquipoPokemon> getArrayEquipos() {
        return arrayEquipos;
    }

    public void setArrayEquipos(ArrayList<EquipoPokemon> arrayEquipos) {
        this.arrayEquipos = arrayEquipos;
    }
    
}
