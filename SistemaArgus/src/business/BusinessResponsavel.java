package business;

import businessInterface.IbusinessResponsavel;
import dao.ResponsavelDao;
import daoInterface.IdaoResponsavel;
import model.Responsavel;

public class BusinessResponsavel extends Business<Responsavel> implements IbusinessResponsavel {
	
	private IdaoResponsavel daoResponsavel;
	
	
public BusinessResponsavel() {

	daoResponsavel = new ResponsavelDao();
	init(daoResponsavel);
}
}
