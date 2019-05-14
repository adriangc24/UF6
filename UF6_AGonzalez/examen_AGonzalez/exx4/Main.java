package exx4;

import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

import ex3.Viking;

public class Main {
	static ObjectSet<Object> result;	public static void main(String[] args) {
		ObjectContainer db = null;
		try {
			db = obrirBaseDades("discos");
			
			Disc d1 = new Disc("my head is broken","rock",8,25,9,"Metal Head");
			Disc d2 = new Disc("i cant feel my soul","rock",5,30,10,"Yung Beef");
			Disc d3 = new Disc("boys dont cry","rock",12,22,13,"rels b");
			Disc d4 = new Disc("i love my mum","hip hop",2,10,6,"2pac");
			Disc d5 = new Disc("crossing down the street","hip hop",5,10,7,"ice cube");
			Disc d6 = new Disc("whigga trying to love","jazz",4,66,8,"paco de lucia");
			Disc d7 = new Disc("caro","pop",1,44,2,"bad bunny");
			Disc d8 = new Disc("wanna die","rock",5,25,3,"lil peep");
			
			Disc proto;
			
			//a
			
			/*
			db.store(d1);
			db.store(d2);
			db.store(d3);
			db.store(d4);
			db.store(d5);
			db.store(d6);
			db.store(d7);
			db.store(d8);
			*/
			
			System.out.println("--------------------- b");
			proto = new Disc(null,"rock",0,0,0,null);
			result = db.queryByExample(proto);
			System.out.println("Discos de rock: ");
			mostrarResultat(result);
			
			System.out.println("--------------------- c");
			eliminarDisc(db);
			proto = new Disc(null,null,0,0,0,null);
			result = db.queryByExample(proto);
			mostrarResultat(result);
			
		
		}
		finally {
			db.close();
		}
	}
	public static ObjectContainer obrirBaseDades(String nomBase) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), nomBase);
		return db;
	}
	public static void mostrarResultat(List resultat) {
		for (Object o : resultat) {
			System.out.println(o.toString());
		}
	}
	public static void eliminarDisc(ObjectContainer db) {
		try {
			List<Disc>resultat=db.query(new Predicate<Disc>(){
				
				
				public boolean match(Disc Disc) {
					return Disc.getStock()==10;
				}
				
			});
			for (Disc d:resultat) {
				db.delete(d);
			}
		}
		catch (Exception e) {
			System.out.println("No s'ha trobat el disc");
		}
	}

}
