package base_donnees;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MillesimesBDD {

	private static final int VERSION_BDD = 3;
	private static final String NOM_BDD = "cave.db";
 
	private static final String TABLE_MILLESIMES = "table_mill";
	private static final String COL_ID = "ID";
	private static final int NUM_COL_ID = 0;
	private static final String COL_ANNEE = "annee";
	private static final int NUM_COL_ANNEE = 1;
 
	private SQLiteDatabase bdd;
 
	private MaCaveSQLite maCaveSQLite;
 
	public MillesimesBDD(Context context){
		//On cr�er la BDD et sa table
		maCaveSQLite = new MaCaveSQLite(context, NOM_BDD, null, VERSION_BDD);
	}
 
	public void open(){
		//on ouvre la BDD en �criture
		bdd = maCaveSQLite.getWritableDatabase();
	}
 
	public void close(){
		//on ferme l'acc�s � la BDD
		bdd.close();
	}
 
	public SQLiteDatabase getBDD(){
		return bdd;
	}
 
	public long insertLMillesime(Millesime millesime){
		//Cr�ation d'un ContentValues (fonctionne comme une HashMap)
		ContentValues values = new ContentValues();
		//on lui ajoute une valeur associ� � une cl� (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
		values.put(COL_ANNEE, millesime.getAnnee());
		//on ins�re l'objet dans la BDD via le ContentValues
		return bdd.insert(TABLE_MILLESIMES, null, values);
	}
 
	public int updateMillesime(int id, Millesime millesime){
		//La mise � jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
		//il faut simple pr�ciser quelle livre on doit mettre � jour gr�ce � l'ID
		ContentValues values = new ContentValues();
		values.put(COL_ANNEE, millesime.getAnnee());
		return bdd.update(TABLE_MILLESIMES, values, COL_ID + " = " +id, null);
	}
 
	public int removeMillesimeWithID(int id){
		//Suppression d'un livre de la BDD gr�ce � l'ID
		return bdd.delete(TABLE_MILLESIMES, COL_ID + " = " +id, null);
	}
 
	public Millesime getMillesimeWithAnnee(String annee){
		//R�cup�re dans un Cursor les valeur correspondant � un region contenu dans la BDD (ici on s�lectionne le livre gr�ce � son titre)
		Cursor c = bdd.query(TABLE_MILLESIMES, new String[] {COL_ID, COL_ANNEE}, COL_ANNEE + " LIKE \"" + annee +"\"", null, null, null, null);
		return cursorToMillesime(c);
	}
 
	//Cette m�thode permet de convertir un cursor en un livre
	private Millesime cursorToMillesime(Cursor c){
		//si aucun �l�ment n'a �t� retourn� dans la requ�te, on renvoie null
		if (c.getCount() == 0)
			return null;
 
		//Sinon on se place sur le premier �l�ment
		c.moveToFirst();
		//On cr�� un livre
		Millesime millesime = new Millesime();
		//on lui affecte toutes les infos gr�ce aux infos contenues dans le Cursor
		millesime.setId(c.getInt(NUM_COL_ID));
		millesime.setAnnee(c.getString(NUM_COL_ANNEE));
		//On ferme le cursor
		c.close();
 
		//On retourne le livre
		return millesime;
	}
}
