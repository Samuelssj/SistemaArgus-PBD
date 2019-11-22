package business;

import businessInterface.IbusinessCurriculo;
import businessInterface.IbusinessParcela;
import dao.CurriculoDao;
import daoInterface.IdaoCurriculo;
import model.Curriculo;

public class BusinessCurriculo extends Business<Curriculo> implements IbusinessCurriculo {

	private IdaoCurriculo daocurriculo;
	
	public BusinessCurriculo() {
	
		daocurriculo = new CurriculoDao();
		init(daocurriculo);
	}
	
	
	
}
