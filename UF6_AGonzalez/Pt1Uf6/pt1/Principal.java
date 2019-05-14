package pt1;


import com.db4o.*;
import com.db4o.query.Predicate;

import java.util.*;

public class Principal extends baseDades{

	public static void main(String[] args) {
		
		ObjectContainer db = null;
		
		try{
			
			db=obrirBaseDades("Pilots");
			
			/*Pilot p = new Pilot("fernando alonso",50);
			db.store(p);
			p = new Pilot("luis hamilton",80);
			db.store(p);
			*/
			
			Pilot pc = new Pilot(null,0);
			
			Pilot pc2 = new Pilot("fernando alonso",50);

			ObjectSet<Object> result2; 
			
			result2 = db.queryByExample(Pilot.class);
			//llistarResultat(result2);
			
			//mostrarPerNom(db, "fernando alonso");
			
			//llistarPilots(pc2, db);
			
			//canviarNom("fernando alonso", "luis hamilton", db);
			
			//llistarResultat(result2);
			
			//canviarPunts(pc2, 5, db);
			
			//llistarResultat(result2);

			//borrarPilot(pc2, db);
			
			//llistarResultat(result2);
			
			//llistarPilots(pc2, db);
			
			//db.store(pc2);
			
			llistarResultat(result2);
			
			
			//Predicate<Pilot>ggg=new Predicate<Pilot>();
			//db.delete(result2.next());
			
		}
		finally {
			db.close();
		}
		
		
		
	}

}
