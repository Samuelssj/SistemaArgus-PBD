package business;

import businessInterface.IbusinessAcompanhamento;
import dao.AcompanhamentoDao;
import daoInterface.IdaoAcompanhamento;
import model.Acompanhamento;

public class BusinessAcompanhamento extends Business<Acompanhamento> implements IbusinessAcompanhamento{

	private  IdaoAcompanhamento daoAcompanhamento;
	
	public BusinessAcompanhamento() {
		daoAcompanhamento = new AcompanhamentoDao();
		init(daoAcompanhamento);
		
	}
}
