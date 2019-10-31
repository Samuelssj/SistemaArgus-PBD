package dao;

import daoInterface.IdaoAluno;
import model.Aluno;

public class AlunoDao extends Dao<Aluno> implements IdaoAluno{

	public AlunoDao() {
		
		super(Aluno.class);
	
	}

}
