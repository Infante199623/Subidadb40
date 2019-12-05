
package JFrame;

import Region.Region;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.util.ArrayList;

/**
 *
 * @author Infante96
 */
public class db4o {
    
   public static void insertarRegion(Region r){
    
        ObjectContainer db = com.db4o.Db4o.openFile("Pokemon1.db");
        db.store(r);
        db.close();
         
    }
    public static void leerRegiones(ArrayList<Region> re)  {
        
        ObjectContainer db = com.db4o.Db4o.openFile("Pokemon1.db");
        Query q = db.query();
        q.constrain(Region.class);
        ObjectSet result = q.execute();
        while(result.hasNext()){
            
            Region r = new Region();
            r = (Region) result.next();
            re.add(r);
        }
        
        db.close();
        
    }
    public static void deleteRegion(Region r) {
            
       ObjectContainer db = com.db4o.Db4o.openFile("Pokemon1.db");    
       Query q = db.query();
       q.constrain(Region.class);
       q.descend("id_Region").constrain(new Integer(r.getId_Region())).equal();
       ObjectSet result = q.execute();
       Region b = (Region) result.next();
       db.delete(b);
       db.close();
       
    }
}
    