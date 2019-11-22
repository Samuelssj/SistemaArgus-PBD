package dao;

import daoInterface.IdaoTurma;
import model.Turma;

public class TurmaDao extends Dao<Turma> implements IdaoTurma{
	
	
	public TurmaDao() {
		
		super(Turma.class);
	}

}
