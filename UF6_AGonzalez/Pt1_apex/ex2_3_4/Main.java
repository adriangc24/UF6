package ex2_3_4;

import com.db4o.*;
import com.db4o.query.Predicate;
import com.db4o.query.Query;

import java.util.*;

public class Main {
	
	static ObjectSet<Object>result;
	static ObjectSet<Object>result2;
	
	
	public static void main(String[] args) {
		
		ObjectContainer db = null;
		
		try {
		
		db=obrirBaseDades("apexBase");
		
		Jugador j1 = new Jugador("herawer",1,98,6788,5,4);
		Jugador j2 = new Jugador("toguer",2,54,566,1,1);
		Jugador j3 = new Jugador("daxtervr",3,45,44,0,0);
		Jugador j4 = new Jugador("rubearen",4,33,34,2,0);
		Jugador j5 = new Jugador("josu",5,22,456,1,0);
		Jugador j6 = new Jugador("jgomez",6,444,12000,5,3);

		Llegenda l1 = new Llegenda(1,"bangalore","healer",1);
		Llegenda l2 = new Llegenda(2,"bloodhound","defensive",2);
		Llegenda l3 = new Llegenda(3,"caustic","explorer",0);
		
		
		/*
		db.store(j1);
		db.store(j2);
		db.store(j3);
		db.store(j4);
		db.store(j5);
		db.store(j6);
		db.store(l1);
		db.store(l2);
		db.store(l3);
		*/
		
		
		
		result=db.queryByExample(Jugador.class);
		result2=db.queryByExample(Llegenda.class);
		
		System.out.println("Jugadors: ");
		mostrarResultat(result);
		
		System.out.println("Llegendes: ");
		mostrarResultat(result2);
		
		Jugador pro = new Jugador("herawer",0,0,0,0,0);

		//eliminarJugador(pro, db);
				
		mostrarKills(db);
		
		ordreAscendent(db);
		
		killsOrdreAsc(db);
		
		damageMenor(db);
		}
		finally {
			db.close();
		}
		
	}
	public static ObjectContainer obrirBaseDades(String nomBase) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
				nomBase);
		return db;
	}
	public static void mostrarResultat(List resultat) {
		for (Object o : resultat) {
			System.out.println(o.toString());
		}
	}
	public static void eliminarJugador(Jugador j,ObjectContainer db) {
		try {
			result=db.queryByExample(j);
			Jugador found=(Jugador) result.next();
			db.delete(found);
			System.out.println(found+" esborrat");
		}
		catch (Exception e) {
			System.out.println("No s'ha trobat el jugador");
		}
	}
	public static void mostrarKills(ObjectContainer db) {
		
		try {
			List<Jugador>resultat=db.query(new Predicate<Jugador>(){
				
				@Override
				public boolean match(Jugador Jugador) {
					return Jugador.getKills()>=10;
				}
				
			});
			System.out.println("-------------------------  Jugadors amb 10 kills o mes -------------------------");
			for (Object o:resultat) {
				System.out.println(o);
			}
		}
		catch(Exception e) {
			actualitzarResultats(db);
		}
	}
	public static void actualitzarResultats(ObjectContainer db) {
		
		List<Jugador>resultat2=db.query(new Predicate<Jugador>(){
			
			@Override
			public boolean match(Jugador Jugador) {
				return Jugador.getKills()<10;
			}
			
		});
		for (Jugador j:resultat2) {
			j.setKills(11);
		}
		
	}
	public static void ordreAscendent(ObjectContainer db) {
		Query query = db.query();
		query.constrain(Jugador.class);
		query.descend("timesTop3").orderAscending();
		ObjectSet<Jugador> resultat = query.execute();
		System.out.println("-------------------------  Jugadors amb mes vegades al top3 -------------------------");
		for (Jugador j:resultat) {
			System.out.println(j);
		}
		
		
	}
	public static void killsOrdreAsc(ObjectContainer db) {
		Query query = db.query();
		query.constrain(Jugador.class);
		query.descend("kills").orderAscending();
		ObjectSet<Jugador> resultat = query.execute();
		System.out.println("-------------------------  Jugadors amb mes de 10 kills ordre ascendent -------------------------");
		int aux=1;
		for (Jugador j:resultat) {
			if (j.getKills()>=10) {
			System.out.println(j);
			j.setKills(j.getKills()+aux);
			Jugador auxJugador = j;
			db.delete(j);
			db.store(auxJugador);
			aux++;
				}
			}
		System.out.println("-------------------------  Jugadors amb mes de 10 kills ordre ascendent (2) -------------------------");
		for (Jugador j:resultat) {
			if (j.getKills()>=10) {
			System.out.println(j);
				}
			}
	}
	public static void damageMenor(ObjectContainer db) {
		Query query = db.query();
		query.constrain(Jugador.class);
		query.descend("totalDamage");
		ObjectSet<Jugador>resultat = query.execute();
		System.out.println("-------------------------  Jugadors amb total damage menor a 10000 -------------------------");
		for (Jugador j : resultat) {
			if (j.getTotalDamage()<10000) {
				System.out.println(j);
			}
		}
	}
	

}
