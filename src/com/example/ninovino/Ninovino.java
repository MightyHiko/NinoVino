package com.example.ninovino;


import java.util.ArrayList;









import metier.Vin;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import base_donnees.Appelation;
import base_donnees.AppelationsBDD;
import base_donnees.Bdd;
import base_donnees.Millesime;
import base_donnees.MillesimesBDD;
import base_donnees.Region;
import base_donnees.RegionsBDD;
import base_donnees.TypesBDD;
import base_donnees.Type;

public class Ninovino extends Activity implements OnClickListener{

	Button consult=null;
	public RegionsBDD regionBdd;
	public AppelationsBDD appelationBdd=new AppelationsBDD(this);
	public MillesimesBDD millesimeBdd;
	public TypesBDD typeBdd=new TypesBDD(this);
	public SQLiteOpenHelper helper;
	public Bdd base;
	
	// D�clarations des constantes pour les diff�rentes tables de la base
	
	private static final String TABLE_REGION = "region";
	private static final String COL_REG_ID = "id_reg";
	private static final String COL_REG_NOM = "nom";
	private static final String TABLE_MILL = "millesime";
	private static final String COL_MILL_ID = "id_mill";
	private static final String COL_MILL_ANNEE = "annee";	
	private static final String TABLE_APP = "appelation";
	private static final String COL_APP_ID = "id_app";
	private static final String COL_APP_NOM = "nom";
	private static final String TABLE_TYPE = "type";
	private static final String COL_TYPE_ID = "id_type";
	private static final String COL_TYPE_NOM = "nom";	
	private static final String TABLE_VIN = "vin";
	private static final String COL_VIN_ID = "id_vin";
	private static final String COL_VIN_PROD = "producteur";
	private static final String COL_VIN_QUANTI = "quantite";	
	
	
	// Insertion des donn�es dans les tables 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ninovino);
 		Bdd base = new Bdd(this);
 		
 		// insertion dans la table "REGION"
		// SOURCE : http://avis-vin.lefigaro.fr/connaitre-deguster/tout-savoir-sur-le-vin/guide-des-regions-et-des-appellations
 		base.insertion_region("Alsace");
		base.insertion_region("Champagne");	
		base.insertion_region("Bourgogne");
		base.insertion_region("Vall�e de la Loire");
		base.insertion_region("Jura");
		base.insertion_region("Beaujolais");
		base.insertion_region("Vall�e du Rhone");
		base.insertion_region("Savoie et Bugey");
		base.insertion_region("Provence");
		base.insertion_region("Languedoc");
		base.insertion_region("Roussillon");
		base.insertion_region("Sud-Ouest");
		base.insertion_region("Bordeaux");
		base.insertion_region("Poitou-Charente");
 		
 		
		// insertion dans la table "MILLESIME"
 		
 		base.insertion_Mill("1980");
		base.insertion_Mill("1981");
		base.insertion_Mill("1982");
		base.insertion_Mill("1983");
		base.insertion_Mill("1984");
		base.insertion_Mill("1985");
		base.insertion_Mill("1986");
		base.insertion_Mill("1987");
		base.insertion_Mill("1988");
		base.insertion_Mill("1989");
		base.insertion_Mill("1990");
		base.insertion_Mill("1991");
		base.insertion_Mill("1992");
		base.insertion_Mill("1993");
		base.insertion_Mill("1994");
		base.insertion_Mill("1995");
		base.insertion_Mill("1996");
		base.insertion_Mill("1997");
		base.insertion_Mill("1998");
		base.insertion_Mill("1999");
		base.insertion_Mill("2000");
		base.insertion_Mill("2001");
		base.insertion_Mill("2002");
		base.insertion_Mill("2003");
		base.insertion_Mill("2004");
		base.insertion_Mill("2005");
		base.insertion_Mill("2006");
		base.insertion_Mill("2007");
		base.insertion_Mill("2008");
		base.insertion_Mill("2009");
		base.insertion_Mill("2010");
		base.insertion_Mill("2011");
		base.insertion_Mill("2012");
		base.insertion_Mill("2013");
		base.insertion_Mill("2014");
		base.insertion_Mill("2015");
		base.insertion_Mill("2016");
		base.insertion_Mill("2017");
		base.insertion_Mill("2018");
		base.insertion_Mill("2019");
		
		
		// insertion dans la table "APPELATION"
		
		base.insertion_Appel("Gewurztraminer", 1);
		base.insertion_Appel("Pinot Gris", 1);
		base.insertion_Appel("Pinot Noir", 1);
		base.insertion_Appel("Riesling", 1);
		base.insertion_Appel("Sylvaner", 1);
		base.insertion_Appel("Muscat", 1);
		base.insertion_Appel("Champagne", 2);
		base.insertion_Appel("Chablis", 3);
		base.insertion_Appel("C�te Chalonnaise", 3);
		base.insertion_Appel("C�te de Beaune", 3);
		base.insertion_Appel("C�te de Nuits", 3);
		base.insertion_Appel("Coteaux-du-Layon", 3);
		base.insertion_Appel("Cl�ry", 4);
		base.insertion_Appel("Saumur", 4);
		base.insertion_Appel("Bourgueil", 4);
		base.insertion_Appel("Cheverny", 4);
		base.insertion_Appel("Chinon", 4);
		base.insertion_Appel("Saint-Nicolas-de-Bourgueil", 4);
		base.insertion_Appel("Vouvray", 4);
		base.insertion_Appel("Arbois", 5);
		base.insertion_Appel("C�tes-du-Jura", 5);
		base.insertion_Appel("Vin jaune", 5);
		base.insertion_Appel("Vin de paille", 5);
		base.insertion_Appel("Beaujolais-villages", 6);
		base.insertion_Appel("Brouilly", 6);
		base.insertion_Appel("Ch�nas", 6);
		base.insertion_Appel("Chiroubles", 6);
		base.insertion_Appel("C�te-de-brouilly", 6);
		base.insertion_Appel("Fleurie", 6);
		base.insertion_Appel("Juli�nas", 6);
		base.insertion_Appel("Morgon", 6);
		base.insertion_Appel("Moulin-�-vent", 6);
		base.insertion_Appel("Beaumes-de-venise", 7);
		base.insertion_Appel("Ch�teauneuf-du-pape", 7);
		base.insertion_Appel("C�te-r�tie", 7);
		base.insertion_Appel("Crozes-hermitage", 7);
		base.insertion_Appel("C�tes-du-rh�ne", 7);
		base.insertion_Appel("Clairette-de-die", 7);
		base.insertion_Appel("Bugey", 8);
		base.insertion_Appel("Cr�py", 8);
		base.insertion_Appel("Savoie", 8);
		base.insertion_Appel("Seyssel", 8);
		base.insertion_Appel("Roussette-de-savoie", 8);
		base.insertion_Appel("Bandol", 9);
		base.insertion_Appel("Baux-de-provence", 9);
		base.insertion_Appel("Bellet", 9);
		base.insertion_Appel("C�tes-de-provence", 9);
		base.insertion_Appel("Cassis", 9);
		base.insertion_Appel("Corbi�res", 10);
		base.insertion_Appel("Fitou", 10);
		base.insertion_Appel("Faug�res", 10);
		base.insertion_Appel("Minervois", 10);
		base.insertion_Appel("Saint-chinian", 10);
		base.insertion_Appel("Banyuls", 11);
		base.insertion_Appel("Collioure", 11);
		base.insertion_Appel("C�tes-du-roussillon", 11);
		base.insertion_Appel("Rivesaltes", 11);
		base.insertion_Appel("Maury", 11);
		base.insertion_Appel("Buzet", 12);
		base.insertion_Appel("Cahors", 12);
		base.insertion_Appel("C�tes-du-marmandais", 12);
		base.insertion_Appel("Fronton", 12);
		base.insertion_Appel("P�charmant", 12);
		base.insertion_Appel("Cadillac", 13);
		base.insertion_Appel("Fronsac", 13);
		base.insertion_Appel("Graves", 13);
		base.insertion_Appel("Margaux", 13);
		base.insertion_Appel("M�doc", 13);
		base.insertion_Appel("Pomerol", 13);
		base.insertion_Appel("Saint-est�phe", 14);
		base.insertion_Appel("Saint-julien", 14);
		base.insertion_Appel("Sauternes", 14);
		base.insertion_Appel("Pineau-des-charentes", 14);
		base.insertion_Appel("Haut-poitou", 14);
		
		
		// Insertion des r�gions dans la table R�gions de la Base de donn�es macave
		base.insertionType("Blanc");
		base.insertionType("Rouge");
		base.insertionType("Ros�");
		base.insertionType("P�tillant");
		
		// insertion dans la table "VIN"
		
		base.insertionVin(1, 1, 1, "Arno", 1, 10);

		helper=base;
		
		
		
		/* CREATION DES BASES DE DONNEES */
//		regionBdd=new RegionsBDD(this);
//		millesimeBdd=new MillesimesBDD(this);
		
		
		
		// Insertion des r�gions dans la table R�gions de la Base de donn�es macave
		// SOURCE : http://avis-vin.lefigaro.fr/connaitre-deguster/tout-savoir-sur-le-vin/guide-des-regions-et-des-appellations
//		insertionRegion("Alsace");
//		insertionRegion("Champagne",regionBdd);	
//		insertionRegion("Bourgogne",regionBdd);
//		insertionRegion("Vall�e de la Loire",regionBdd);
//		insertionRegion("Jura",regionBdd);
//		insertionRegion("Beaujolais",regionBdd);
//		insertionRegion("Vall�e du Rhone",regionBdd);
//		insertionRegion("Savoie et Bugey",regionBdd);
//		insertionRegion("Provence",regionBdd);
//		insertionRegion("Languedoc",regionBdd);
//		insertionRegion("Roussillon",regionBdd);
//		insertionRegion("Sud-Ouest",regionBdd);
//		insertionRegion("Bordeaux",regionBdd);
//		insertionRegion("Poitou-Charente",regionBdd);
		
		
		// Insertion des appelations dans la table Appelations de la Base de donn�es macave
//		insertionAppelation("Gewurztraminer", 1); //v�rifier avec nico que 1 idreg de l'Alsace ????
//		insertionAppelation("Pinot Gris", 1);
//		insertionAppelation("Pinot Noir", 1);
//		insertionAppelation("Riesling", 1);
//		insertionAppelation("Sylvaner", 1);
//		insertionAppelation("Muscat", 1);
//		insertionAppelation("Champagne", 2);
//		insertionAppelation("Chablis", 3);
//		insertionAppelation("C�te Chalonnaise", 3);
//		insertionAppelation("C�te de Beaune", 3);
//		insertionAppelation("C�te de Nuits", 3);
//		insertionAppelation("Coteaux-du-Layon", 3);
//		insertionAppelation("Cl�ry", 4);
//		insertionAppelation("Saumur", 4);
//		insertionAppelation("Bourgueil", 4);
//		insertionAppelation("Cheverny", 4);
//		insertionAppelation("Chinon", 4);
//		insertionAppelation("Saint-Nicolas-de-Bourgueil", 4);
//		insertionAppelation("Vouvray", 4);
//		insertionAppelation("Arbois", 5);
//		insertionAppelation("C�tes-du-Jura", 5);
//		insertionAppelation("Vin jaune", 5);
//		insertionAppelation("Vin de paille", 5);
//		insertionAppelation("Beaujolais-villages", 6);
//		insertionAppelation("Brouilly", 6);
//		insertionAppelation("Ch�nas", 6);
//		insertionAppelation("Chiroubles", 6);
//		insertionAppelation("C�te-de-brouilly", 6);
//		insertionAppelation("Fleurie", 6);
//		insertionAppelation("Juli�nas", 6);
//		insertionAppelation("Morgon", 6);
//		insertionAppelation("Moulin-�-vent", 6);
//		insertionAppelation("Beaumes-de-venise", 7);
//		insertionAppelation("Ch�teauneuf-du-pape", 7);
//		insertionAppelation("C�te-r�tie", 7);
//		insertionAppelation("Crozes-hermitage", 7);
//		insertionAppelation("C�tes-du-rh�ne", 7);
//		insertionAppelation("Clairette-de-die", 7);
//		insertionAppelation("Bugey", 8);
//		insertionAppelation("Cr�py", 8);
//		insertionAppelation("Savoie", 8);
//		insertionAppelation("Seyssel", 8);
//		insertionAppelation("Roussette-de-savoie", 8);
//		insertionAppelation("Bandol", 9);
//		insertionAppelation("Baux-de-provence", 9);
//		insertionAppelation("Bellet", 9);
//		insertionAppelation("C�tes-de-provence", 9);
//		insertionAppelation("Cassis", 9);
//		insertionAppelation("Corbi�res", 10);
//		insertionAppelation("Fitou", 10);
//		insertionAppelation("Faug�res", 10);
//		insertionAppelation("Minervois", 10);
//		insertionAppelation("Saint-chinian", 10);
//		insertionAppelation("Banyuls", 11);
//		insertionAppelation("Collioure", 11);
//		insertionAppelation("C�tes-du-roussillon", 11);
//		insertionAppelation("Rivesaltes", 11);
//		insertionAppelation("Maury", 11);
//		insertionAppelation("Buzet", 12);
//		insertionAppelation("Cahors", 12);
//		insertionAppelation("C�tes-du-marmandais", 12);
//		insertionAppelation("Fronton", 12);
//		insertionAppelation("P�charmant", 12);
//		insertionAppelation("Cadillac", 13);
//		insertionAppelation("Fronsac", 13);
//		insertionAppelation("Graves", 13);
//		insertionAppelation("Margaux", 13);
//		insertionAppelation("M�doc", 13);
//		insertionAppelation("Pomerol", 13);
//		insertionAppelation("Saint-est�phe", 14);
//		insertionAppelation("Saint-julien", 14);
//		insertionAppelation("Sauternes", 14);
//		insertionAppelation("Pineau-des-charentes", 14);
//		insertionAppelation("Haut-poitou", 14);
//		
//		
		// Insertion des ann�es dans la table Millesime de la Base de donn�es macave
//		insertionMillesime("1980");
//		insertionMillesime(1981);
//		insertionMillesime(1982);
//		insertionMillesime(1983);
//		insertionMillesime(1984);
//		insertionMillesime(1985);
//		insertionMillesime(1986);
//		insertionMillesime(1987);
//		insertionMillesime(1988);
//		insertionMillesime(1989);
//		insertionMillesime(1990);
//		insertionMillesime(1991);
//		insertionMillesime(1992);
//		insertionMillesime(1993);
//		insertionMillesime(1994);
//		insertionMillesime(1995);
//		insertionMillesime(1996);
//		insertionMillesime(1997);
//		insertionMillesime(1998);
//		insertionMillesime(1999);
//		insertionMillesime(2000);
//		insertionMillesime(2001);
//		insertionMillesime(2002);
//		insertionMillesime(2003);
//		insertionMillesime(2004);
//		insertionMillesime(2005);
//		insertionMillesime(2006);
//		insertionMillesime(2007);
//		insertionMillesime(2008);
//		insertionMillesime(2009);
//		insertionMillesime(2010);
//		insertionMillesime(2011);
//		insertionMillesime(2012);
//		insertionMillesime(2013);
//		insertionMillesime(2014);
//		insertionMillesime(2015);
//		insertionMillesime(2016);
//		insertionMillesime(2017);
//		insertionMillesime(2018);
//		insertionMillesime(2019);
//		
//		// Insertion des r�gions dans la table R�gions de la Base de donn�es macave
//		insertionType("Blanc");
//		insertionType("Rouge");
//		insertionType("Ros�");
//		insertionType("P�tillant");
//		
		
		
//			Region region = new Region();
//        //Pour v�rifier que l'on a bien cr�� notre r�gion dans la BDD
//       //on extrait la r�gion de la BDD gr�ce � son nom que l'on a cr�� pr�c�demment
//        Region regionFromBdd = regionBdd.getRegionWithNom(region.getNom());
//       //Si une r�gion est retourn�e (donc si la r�gion � bien �t� ajout� � la BDD)
//        if(regionFromBdd != null){
//        	//On affiche les infos de la r�gion dans un Toast
//       	Toast.makeText(this, regionFromBdd.toString(), Toast.LENGTH_LONG).show();
//       	//On modifie le nom de la r�gion
//       	regionFromBdd.setNom("J'ai modifi� le nom de la r�gion");
//       	//Puis on met � jour la BDD
//            regionBdd.updateRegion(regionFromBdd.getId(), regionFromBdd);
//        }
// 
//        //On extrait la region de la BDD gr�ce au nouveau nom
//        regionFromBdd = regionBdd.getRegionWithNom("J'ai modifi� le nom de la r�gion");
//        //S'il existe une region poss�dant ce nom dans la BDD
//        if(regionFromBdd != null){
//	        //On affiche les nouvelles info de la region pour v�rifier que le nom de la region a bien �t� mis � jour
//	        Toast.makeText(this, regionFromBdd.toString(), Toast.LENGTH_LONG).show();
//	        //on supprime la region de la BDD gr�ce � son ID
//	    	regionBdd.removeRegionWithID(regionFromBdd.getId());
//        }
// 
//        //On essait d'extraire de nouveau la region de la BDD toujours gr�ce � son nouveau titre
//        regionFromBdd = regionBdd.getRegionWithNom("J'ai modifi� le nom de la r�gion");
//        //Si aucune region n'est retourn�
//        if(regionFromBdd == null){
//        	//On affiche un message indiquant que la region n'existe pas dans la BDD
//        	Toast.makeText(this, "Cette region n'existe pas dans la BDD", Toast.LENGTH_LONG).show();
//        }
//        //Si la region existe (mais normalement il ne devrait pas)
//        else{
//        	//on affiche un message indiquant que la region existe dans la BDD
//        	Toast.makeText(this, "Cette region existe dans la BDD", Toast.LENGTH_LONG).show();
//        }
// 
      
                     
        consult = (Button) findViewById(R.id.b_consultation_cave);
    	consult.setOnClickListener(this);
        
}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
//			millesimeBdd.open();
//			regionBdd.open();
//		
//        	Toast.makeText(this, "TEST = " + millesimeBdd.getMillesimeWithAnnee("1980") + 
//        			" REGION = " + regionBdd.getRegionWithNom("Alsace") , Toast.LENGTH_LONG).show();
//        	regionBdd.close();
//        	millesimeBdd.close();
        //Si la region existe (mais normalement il ne devrait pas)
		
//		"Le millesime est " + getMill("1980")
		Toast.makeText(this, "La region est " + getNomRegion("Alsace") + 
				" Le millesime est " + getMill("1980") + " L'appelation est " 
				+ getAppelation("Gewurztraminer") +
				" Producteur " + getVin("Arno"), Toast.LENGTH_LONG).show();
		
		
	}

	// cette proc�dure permet de remplir La table r�gion
//	public void insertionRegion(String nom){
//        //Cr�ation d'une instance de RegionsBDD
////      RegionsBDD regionBdd = new RegionsBDD(this);
//      //Cr�ation d'une r�gion
//      Region region = new Region(nom);
//      //On ouvre la base de donn�es pour �crire dedans
//      
//  
//      regionBdd.open();
//      //On ins�re la r�gion que l'on vient de cr�er
//      regionBdd.insertRegion(region);
//      regionBdd.close();
//		}
	
	// cette proc�dure permet de remplir La table Appelation
//	public void insertionAppelation(String nom, int idreg){
//        //Cr�ation d'une instance de RegionsBDD
////      RegionsBDD regionBdd = new RegionsBDD(this);
//      //Cr�ation d'une r�gion
//      Appelation appelation = new Appelation(nom,idreg);
//      //On ouvre la base de donn�es pour �crire dedans
//      appelationBdd.open();
//      //On ins�re la r�gion que l'on vient de cr�er
//      appelationBdd.insertAppelation(appelation);
//      appelationBdd.close();
//		}
//	
//	// cette proc�dure permet de remplir La table Millesime
//	public void insertionMillesime(String annee){
//      //Cr�ation d'une r�gion
//      Millesime millesime = new Millesime(annee);
//      //On ouvre la base de donn�es pour �crire dedans
//      millesimeBdd.open();
//      //On ins�re la r�gion que l'on vient de cr�er
//      millesimeBdd.insertLMillesime(millesime);
//      millesimeBdd.close();
//		}
//	
//	// cette proc�dure permet de remplir La table type
//	public void insertionType(String nom){
//      //Cr�ation d'une r�gion
//      Type type = new Type(nom);
//      //On ouvre la base de donn�es pour �crire dedans
//      typeBdd.open();
//      //On ins�re la r�gion que l'on vient de cr�er
//      typeBdd.insertType(type);
//      typeBdd.close();
//		}
	
	
	public String getNomRegion(String nom){
		//R�cup�re dans un Cursor les valeur correspondant � un region contenu dans la BDD (ici on s�lectionne le livre gr�ce � son titre)
//		Cursor c = bdd.query("region", new String[] {"id", "nom"}, "nom" + " LIKE \"" + nom +"\"", null, null, null, null);	
		SQLiteOpenHelper helper = new Bdd(this);
		SQLiteDatabase writableDB = helper.getWritableDatabase();
		
		Cursor cursor = writableDB.query(TABLE_REGION, new String[] {COL_REG_ID, COL_REG_NOM}, null, null, null, null, null);
		
		ArrayList<Region> liste = new ArrayList<Region>();
		
		while (cursor.moveToNext()) {

    	liste.add(new Region(cursor.getInt(0), cursor.getString(1)));
		}
		cursor.close();
		
		
		
		String test="Nardine";
		
		for (int i = 0; i < liste.size(); i++) {
			
			if (liste.get(i).getNom().equals(nom)) {
				test = nom;
			}
			
		}
		return test;
	}
	
	
	public String getMill(String annee){
		//R�cup�re dans un Cursor les valeur correspondant � un region contenu dans la BDD (ici on s�lectionne le livre gr�ce � son titre)
//		Cursor c = bdd.query("region", new String[] {"id", "nom"}, "nom" + " LIKE \"" + nom +"\"", null, null, null, null);	
		SQLiteOpenHelper helper = new Bdd(this);
		SQLiteDatabase writableDB = helper.getWritableDatabase();
		
		Cursor cursor = writableDB.query(TABLE_MILL, new String[] {COL_MILL_ID, COL_MILL_ANNEE}, null, null, null, null, null);
		
		ArrayList<Millesime> liste = new ArrayList<Millesime>();
		
		while (cursor.moveToNext()) {

    	liste.add(new Millesime(cursor.getInt(0), cursor.getString(1)));
		}
		cursor.close();
		
		String test="Nardine";
		
		for (int i = 0; i < liste.size(); i++) {
			
			if (liste.get(i).getAnnee().equals(annee)) {
				test = annee;
			}
			
		}
		return test;
	}
	
	public String getAppelation(String nom){
		//R�cup�re dans un Cursor les valeur correspondant � un region contenu dans la BDD (ici on s�lectionne le livre gr�ce � son titre)
//		Cursor c = bdd.query("region", new String[] {"id", "nom"}, "nom" + " LIKE \"" + nom +"\"", null, null, null, null);	
		SQLiteOpenHelper helper = new Bdd(this);
		SQLiteDatabase writableDB = helper.getWritableDatabase();
		
		Cursor cursor = writableDB.query(TABLE_APP, new String[] {COL_APP_ID, COL_APP_NOM,COL_REG_ID}, null, null, null, null, null);
		
		ArrayList<Appelation> liste = new ArrayList<Appelation>();
		
		while (cursor.moveToNext()) {

    	liste.add(new Appelation(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
		}
		cursor.close();
		
		String test="Nardine";
		
		for (int i = 0; i < liste.size(); i++) {
			
			if (liste.get(i).getNom().equals(nom)) {
				test = nom;
			}
			
		}
		return test;
	}
	
	
	public String getType(String nom){
		//R�cup�re dans un Cursor les valeur correspondant � un region contenu dans la BDD (ici on s�lectionne le livre gr�ce � son titre)
//		Cursor c = bdd.query("region", new String[] {"id", "nom"}, "nom" + " LIKE \"" + nom +"\"", null, null, null, null);	
		SQLiteOpenHelper helper = new Bdd(this);
		SQLiteDatabase writableDB = helper.getWritableDatabase();
		
		Cursor cursor = writableDB.query(TABLE_TYPE, new String[] {COL_TYPE_ID, COL_TYPE_NOM}, null, null, null, null, null);
		
		ArrayList<Type> liste = new ArrayList<Type>();
		
		while (cursor.moveToNext()) {

    	liste.add(new Type(cursor.getInt(0), cursor.getString(1)));
		}
		cursor.close();
		
		String test="Nardine";
		
		for (int i = 0; i < liste.size(); i++) {
			
			if (liste.get(i).getType().equals(nom)) {
				test = nom;
			}	
		}
		return test;
	}
	
	
	public String getVin(String producteur){
		//R�cup�re dans un Cursor les valeur correspondant � un region contenu dans la BDD (ici on s�lectionne le livre gr�ce � son titre)
//		Cursor c = bdd.query("region", new String[] {"id", "nom"}, "nom" + " LIKE \"" + nom +"\"", null, null, null, null);	
		SQLiteOpenHelper helper = new Bdd(this);
		SQLiteDatabase writableDB = helper.getWritableDatabase();
		
		Cursor cursor = writableDB.query(TABLE_VIN, new String[] {COL_VIN_ID,COL_TYPE_ID, COL_REG_ID, 
				COL_APP_ID,COL_VIN_PROD, COL_MILL_ID,COL_VIN_QUANTI}, null, null, null, null, null);
		
		ArrayList<Vin> liste = new ArrayList<Vin>();
		
		while (cursor.moveToNext()) {

    	liste.add(new Vin(cursor.getInt(0), cursor.getInt(1),cursor.getInt(2),cursor.getInt(3),
    			cursor.getString(4),cursor.getInt(5),cursor.getInt(6)));
		}
		cursor.close();
		
		String test="Nardine";
		
		for (int i = 0; i < liste.size(); i++) {
			
			if (liste.get(i).getProducteur().equals(producteur)) {
				test = producteur;
			}	
		}
		return test;
	}
	
	
	
	
	
}

	

