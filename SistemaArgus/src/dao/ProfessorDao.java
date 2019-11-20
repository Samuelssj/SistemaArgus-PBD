package dao;

import daoInterface.IdaoProfessor;
import model.Professor;

public class ProfessorDao extends Dao<Professor> implements IdaoProfessor{

	
	 public ProfessorDao() {
		
		 super(Professor.class);
	}
}
