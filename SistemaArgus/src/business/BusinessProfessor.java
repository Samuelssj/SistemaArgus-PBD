package business;

import businessInterface.IbusunessProfessor;
import dao.ProfessorDao;
import daoInterface.IdaoProfessor;
import model.Professor;

public class BusinessProfessor extends Business<Professor> implements IbusunessProfessor {

	
	private IdaoProfessor daoProfessor;
	
	public BusinessProfessor() {
		
		daoProfessor = new ProfessorDao();
		init(daoProfessor);
		
	}
	
	
}
