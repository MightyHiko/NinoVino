package base_donnees;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
 
public class RegionsBDD {
 
	private static final int VERSION_BDD = 3;
	private static final String NOM_BDD = "cave.db";
 
	private static final String TABLE_REGIONS = "table_regions";
	private static final String COL_ID = "ID";
	private static final int NUM_COL_ID = 0;
	private static final String COL_NOM = "nom";
	private static final int NUM_COL_nom = 1;
 
	private SQLiteDatabase bdd;
 
	private MaCaveSQLite maCaveSQLite;
 
	public RegionsBDD(Context context){
		//On cr�e la BDD et sa table
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
 
	public long insertRegion(Region region){
		//Cr�ation d'un ContentValues (fonctionne comme une HashMap)
		ContentValues values = new ContentValues();
		//on lui ajoute une valeur associ� � une cl� (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
		values.put(COL_NOM, region.getNom());
		//on ins�re l'objet dans la BDD via le ContentValues
		return bdd.insert(TABLE_REGIONS, null, values);
	}
 
	public int updateRegion(int id, Region region){
		//La mise � jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
		//il faut simple pr�ciser quelle livre on doit mettre � jour gr�ce � l'ID
		ContentValues values = new ContentValues();
		values.put(COL_NOM, region.getNom());
		return bdd.update(TABLE_REGIONS, values, COL_ID + " = " +id, null);
	}
 
	public int removeRegionWithID(int id){
		//Suppression d'un livre de la BDD gr�ce � l'ID
		return bdd.delete(TABLE_REGIONS, COL_ID + " = " +id, null);
	}
 
	public Region getRegionWithNom(String nom){
		//R�cup�re dans un Cursor les valeur correspondant � un region contenu dans la BDD (ici on s�lectionne le livre gr�ce � son titre)
		Cursor c = bdd.query(TABLE_REGIONS, new String[] {COL_ID, COL_NOM}, COL_NOM + " LIKE \"" + nom +"\"", null, null, null, null);
		return cursorToRegion(c);
	}
 
	//Cette m�thode permet de convertir un cursor en un livre
	private Region cursorToRegion(Cursor c){
		//si aucun �l�ment n'a �t� retourn� dans la requ�te, on renvoie null
		if (c.getCount() == 0)
			return null;
 
		//Sinon on se place sur le premier �l�ment
		c.moveToFirst();
		//On cr�� un livre
		Region region = new Region();
		//on lui affecte toutes les infos gr�ce aux infos contenues dans le Cursor
		region.setId(c.getInt(NUM_COL_ID));
		region.setNom(c.getString(NUM_COL_nom));
		//On ferme le cursor
		c.close();
 
		//On retourne le livre
		return region;
	}
}