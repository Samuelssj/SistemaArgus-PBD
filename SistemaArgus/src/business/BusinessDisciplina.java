package business;

import businessInterface.IbusinessDisciplina;
import dao.DisciplinaDao;
import daoInterface.IdaoDisciplina;
import model.Disciplina;

public class BusinessDisciplina extends Business<Disciplina> implements IbusinessDisciplina {

	private IdaoDisciplina daodisciplina;
	
	public BusinessDisciplina() {
		daodisciplina = new DisciplinaDao();
		init(daodisciplina);
		
	}
}
