package ex3;

import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import com.db4o.query.Query;

import ex2_3_4.Jugador;

public class Main {
	static ObjectSet<Object> result;

	public static void main(String[] args) {
		ObjectContainer db = null;

		try {
			db = obrirBaseDades("vikings");

			Viking v1 = new Viking("adri", 45, true, 2, true);
			Viking v2 = new Viking("jony", 32, false, 5, false);
			Viking v3 = new Viking("ruben", 25, true, 1, true);
			Viking v4 = new Viking("joan", 12, true, 0, false);
			Viking v5 = new Viking("toguer", 50, false, 3, true);

			/*
			 * db.store(v1); db.store(v2); db.store(v3); db.store(v4); db.store(v5);
			 */
			Viking proto;
			// mostrar tots
			result = db.queryByExample(Viking.class);
			System.out.println("Vikings: ");
			mostrarResultat(result);

			// a
			System.out.println("------------------------- a");
			proto = new Viking(null, 0, true, 0, false);
			result = db.queryByExample(proto);
			mostrarResultat(result);

			// b
			System.out.println("------------------------- b");
			mostrarEdat(db);
			
			// c
			System.out.println("------------------------- c");
			actualitzarResultats(db);
			result=db.queryByExample(Viking.class);
			mostrarResultat(result);
			
			//d
			System.out.println("------------------------- d");
			eliminarViking(db);
			
			
			
			proto = new Viking(null, 0, true&&false, 0, true&&false);
			result=db.queryByExample(proto);
			mostrarResultat(result);
		} finally {
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

	public static void mostrarEdat(ObjectContainer db) {

		Query query = db.query();
		query.constrain(Viking.class);
		query.descend("edat").orderAscending();
		ObjectSet<Viking> resultat = query.execute();
		for (Viking v : resultat) {
			System.out.println(v);
		}

	}
public static void actualitzarResultats(ObjectContainer db) {
		
		List<Viking>resultat2=db.query(new Predicate<Viking>(){
			
			@Override
			public boolean match(Viking Viking) {
				
				return Viking.isValhalla()==true&&Viking.getFils()<2;
			}
			
		});
		for (Viking v:resultat2) {
			v.setValhalla(false);;
		}
		
	}
public static void eliminarViking(ObjectContainer db) {
	try {
		List<Viking>resultat=db.query(new Predicate<Viking>(){
			
			@Override
			public boolean match(Viking Viking) {
				return Viking.isValhalla()==false||Viking.isLider()==false;
			}
			
		});
		for (Viking v:resultat) {
			db.delete(v);
		}
	}
	catch (Exception e) {
		System.out.println("No s'ha trobat el viking");
	}
}
}
