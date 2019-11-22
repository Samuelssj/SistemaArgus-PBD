package dao;

import daoInterface.IdaoCurriculo;
import model.Curriculo;

public class CurriculoDao extends Dao<Curriculo> implements IdaoCurriculo {
	
	public CurriculoDao() {
		super(Curriculo.class);
		// TODO Auto-generated constructor stub
	}

}
