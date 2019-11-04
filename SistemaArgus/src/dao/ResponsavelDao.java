package dao;

import daoInterface.IdaoResponsavel;
import model.Responsavel;

public class ResponsavelDao extends Dao<Responsavel> implements IdaoResponsavel {

	public ResponsavelDao() {
		super(Responsavel.class);
	}

}
