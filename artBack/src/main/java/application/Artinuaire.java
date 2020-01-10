package application;

import java.util.LinkedList;

import model.Compte;


public class Artinuaire {

	private LinkedList<Compte> file = new LinkedList();
	static private Artinuaire _instance = null;

	
	private Artinuaire() {
	
	}

	public static Artinuaire getInstance() {
		
		if(_instance==null) 
		{
			_instance=new Artinuaire();
		}
		return _instance;
	}

	public LinkedList<Compte> getFile() {
		return file;
	}
	
	public void addCompte(Compte p) 
	{
		file.add(p);
	}

	public void setFile(LinkedList<Compte> file) {
		this.file = file;
	}

}
