package dao;

import daoInterface.IdaoParcela;
import model.Parcela;

public class ParcelaDao extends Dao<Parcela> implements IdaoParcela{
	
	public ParcelaDao() {
	super(Parcela.class);
		// TODO Auto-generated constructor stub
	}

}
