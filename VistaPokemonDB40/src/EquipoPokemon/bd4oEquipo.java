/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EquipoPokemon;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.util.ArrayList;

/**
 *
 * @author Infante96
 */
public class bd4oEquipo {

   public static void insertarEquipo(EquipoPokemon r){
    
        ObjectContainer db = com.db4o.Db4o.openFile("Pokemon1.db");
        db.store(r);
        db.close();
         
    }
    public static void leerEquipoPokemon(ArrayList<EquipoPokemon> re)  {
        
        ObjectContainer db = com.db4o.Db4o.openFile("Pokemon1.db");
        Query q = db.query();
        q.constrain(EquipoPokemon.class);
        ObjectSet result = q.execute();
        while(result.hasNext()){
            
            EquipoPokemon r = new EquipoPokemon();
            r = (EquipoPokemon) result.next();
            re.add(r);
        }
        
        db.close();
        
    }
    public static void deleteEquipoPokemon(EquipoPokemon r) {
            
       ObjectContainer db = com.db4o.Db4o.openFile("Pokemon1.db");    
       Query q = db.query();
       q.constrain(EquipoPokemon.class);
       q.descend("id_Equipo").constrain(new Integer(r.getId_Equipo())).equal();
       ObjectSet result = q.execute();
       EquipoPokemon b = (EquipoPokemon) result.next();
       db.delete(b);
       db.close(); 
    }
}
