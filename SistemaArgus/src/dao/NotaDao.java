package dao;

import daoInterface.IdaoNota;
import model.Nota;

public class NotaDao extends Dao<Nota> implements IdaoNota {

	
	public NotaDao() {
	super(Nota.class);
		// TODO Auto-generated constructor stub
	}
}
