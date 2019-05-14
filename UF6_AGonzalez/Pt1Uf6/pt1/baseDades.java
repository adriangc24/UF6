package pt1;

import java.util.*;

import com.db4o.*;

public class baseDades {
	
	static ObjectSet<Object>result2;
	
	public static ObjectContainer obrirBaseDades(String nomBase) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
				nomBase);
		return db;
	}
	public static void tancarBaseDades(ObjectContainer db) {
		db.close();
	}
	public static void mostrarPerNom (ObjectContainer db,String nom) {
			
			Pilot pp = new Pilot(nom);
			result2=db.queryByExample(pp);
		if(result2.size()==0){
			System.out.println("No es troba el pilot");
		}
		else {
			System.out.println(result2);

		}
		
	}
	public static void llistarPilots(Pilot buscat,ObjectContainer db) {
		result2=db.queryByExample(buscat);
		System.out.println("Nom: "+buscat.getName());
		System.out.println("Punts: "+buscat.getPoints());
	}
	public static void canviarNom(String nombreA,String nombreB,ObjectContainer db) {
		Pilot pp = new Pilot(nombreA);
		result2=db.queryByExample(pp);
		Pilot found = (Pilot)result2.next();
		db.delete(pp);
		found.setName(nombreB);
		db.store(found);
		
	}
	public static void llistarResultat(List resultat) {
		System.out.println("Hi ha "+resultat.size()+" registres totals:");
		for (Object o : resultat) {
			System.out.println(o.toString());
		}
	}
	public static void canviarPunts(Pilot p,int punts,ObjectContainer db) {
		result2 = db.queryByExample(p);
		Pilot found = (Pilot)result2.next();
		db.delete(p);
		found.setPoints(punts);
		db.store(found);
		}
	public static void borrarPilot(Pilot p,ObjectContainer db) {
		try{
			result2=db.queryByExample(p);
			Pilot found=(Pilot)result2.next();
			db.delete(found);
			System.out.println(found+" Eliminado");
		}
		catch(Exception e){
			System.out.println("El piloto "+p.getName()+" no pudo ser eliminado");
		}
		
		
	}
	
	
}
