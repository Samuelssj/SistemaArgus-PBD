package business;

import businessInterface.IbusinessTurma;
import dao.TurmaDao;
import daoInterface.IdaoTurma;
import model.Turma;

public class BusinessTurma extends Business<Turma> implements IbusinessTurma{

	private IdaoTurma daoTurma;
	
	
	public BusinessTurma() {
		// TODO Auto-generated constructor stub
		daoTurma = new TurmaDao();
		init(daoTurma);
	}
	
}
