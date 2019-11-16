package business;

import businessInterface.IbusinessUsuarioAdapter;
import dao.UsuarioAdapterDao;
import daoInterface.IdaoUsuarioAdapter;
import exception.BusinessException;
import model.UsuarioTabAdapter;

public class BusinessUsuarioAdapter  extends Business<UsuarioTabAdapter> implements IbusinessUsuarioAdapter{

	
	private IdaoUsuarioAdapter daoUsuarioAdapter;
	
	
	public BusinessUsuarioAdapter() {
		daoUsuarioAdapter = new UsuarioAdapterDao();
		
	//	init(daoUsuarioAdapter);
		
		
		
	}

	@Override
	public UsuarioTabAdapter searchUserTabAdapter(String login, String senha) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
}


