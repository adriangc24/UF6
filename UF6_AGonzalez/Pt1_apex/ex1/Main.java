package ex1;

import java.awt.List;

import com.db4o.Db4o;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) {
		ObjectContainer db = null;
		
		try {
		
		db=obrirBaseDades("miBase");
		
		ObjectSet<Object>result;
		
		Perro p1 = new Perro("toby","pastor aleman",6.8,4,"barcelona");
		Perro p2 = new Perro("nano","caniche",4.5,5,"madrid");
		Perro p3 = new Perro("kira","perro de aguas",8.9,7,"londres");
		
		Perro pro = new Perro("nano",null,0,0,null);
		
		/*db.store(p1);
		db.store(p2);
		db.store(p3);*/
		
		/*result = db.queryByExample(pro);
		Perro found=(Perro) result.next();
		db.delete(found);*/
		
		result = db.queryByExample(Perro.class);
		
		llistarTots(result);
		
		
		
		}
		finally {
			db.close();
		}
	}
	public static ObjectContainer obrirBaseDades (String nomBase) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),nomBase);
		return db;
	}
	public static void llistarTots(ObjectSet result) {
		for(Object o : result ) {
			System.out.println(o.toString());
		}
	}
	
}
