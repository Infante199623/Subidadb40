
package Entrenador1;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.util.ArrayList;

/**
 *
 * @author Infante96
 */
public class bdEntrenador {

 
   public static void insertarEntrenador(Entrenador r){
    
        ObjectContainer db = com.db4o.Db4o.openFile("Pokemon1.db");
        db.store(r);
        db.close();
         
    }
    public static void leerEntrenador(ArrayList<Entrenador> re)  {
        
        ObjectContainer db = com.db4o.Db4o.openFile("Pokemon1.db");
        Query q = db.query();
        q.constrain(Entrenador.class);
        ObjectSet result = q.execute();
        while(result.hasNext()){
            
            Entrenador r = new Entrenador();
            r = (Entrenador) result.next();
            re.add(r);
        }
        
        db.close();
        
    }
    public static void deleteEntrenador(Entrenador r) {
            
       ObjectContainer db = com.db4o.Db4o.openFile("Pokemon1.db");    
       Query q = db.query();
       q.constrain(Entrenador.class);
       q.descend("id_Entrandor").constrain(new Integer(r.getId_Entrenador())).equal();
       ObjectSet result = q.execute();
       Entrenador b = (Entrenador) result.next();
       
       db.delete(b);
       db.close();
       
    }
}
    