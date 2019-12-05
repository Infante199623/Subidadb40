
package Pokemon;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.util.ArrayList;

/**
 *
 * @author Infante96
 */
public class bdPokemon {

   public static void insertarPokemon(Pokemon r){
    
        ObjectContainer db = com.db4o.Db4o.openFile("Pokemon1.db");
        db.store(r);
        db.close();
         
    }
    public static void leerPokemon(ArrayList<Pokemon> re)  {
        
        ObjectContainer db = com.db4o.Db4o.openFile("Pokemon1.db");
        Query q = db.query();
        q.constrain(Pokemon.class);
        ObjectSet result = q.execute();
        while(result.hasNext()){
            
            Pokemon r = new Pokemon();
            r = (Pokemon) result.next();
            re.add(r);
        }
        
        db.close();
        
    }
    public static void deletePokemon(Pokemon r) {
            
       ObjectContainer db = com.db4o.Db4o.openFile("Pokemon1.db");    
       Query q = db.query();
       q.constrain(Pokemon.class);
       q.descend("id_Pokemon").constrain(new Integer(r.getId_registro())).equal();
       ObjectSet result = q.execute();
       Pokemon b = (Pokemon) result.next();
       db.delete(b);
      
       db.close();
       
    }
}
    