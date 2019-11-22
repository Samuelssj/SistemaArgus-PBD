package business;

import businessInterface.IbusinessNota;
import dao.NotaDao;
import daoInterface.IdaoNota;
import model.Nota;

public class BusinessNota extends Business<Nota> implements IbusinessNota {

	private IdaoNota daonota;
	
	public BusinessNota() {
	
		daonota = new NotaDao();
		init(daonota);
	}
	
}
