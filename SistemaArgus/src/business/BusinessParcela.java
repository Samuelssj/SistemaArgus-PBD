package business;

import businessInterface.IbusinessParcela;
import dao.ParcelaDao;
import daoInterface.IdaoParcela;
import model.Parcela;

public class BusinessParcela extends Business<Parcela> implements IbusinessParcela {

	private IdaoParcela daoParcela;
	
	public BusinessParcela() {
	
		daoParcela = new ParcelaDao();
		init(daoParcela);
	}
	
	
}
