package business;

import businessInterface.IbusinessPedagogo;
import dao.PedagogoDao;
import daoInterface.IdaoPedagogo;
import model.Pedagogo;

public class BusinessPedagogo extends Business<Pedagogo> implements IbusinessPedagogo{

	private IdaoPedagogo daoPedagogo;
	
	public BusinessPedagogo() {
		
		daoPedagogo = new PedagogoDao();
		init(daoPedagogo);
		
	}
}
