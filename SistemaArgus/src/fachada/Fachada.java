package fachada;

import business.BusinessPessoa;
import businessInterface.IbusinessPessoa;
import exception.BusinessException;
import model.Pessoa;

public class Fachada implements IFachada{
	
	private IbusinessPessoa businessPessoa;
	
	
	private static Fachada instance;
	
	
	

	public Fachada() {
		businessPessoa = new BusinessPessoa();
	}

	public static Fachada getInstance() {
		if (instance == null)
			instance = new Fachada();
		return instance;
	}



//	@Override
//	public void createOrUpdateSuperUsuario(Pessoa entidade) throws BusinessException {
//		businessSuperUsuario.createOrUpdate(entidade);
//	}
	@Override
	public Pessoa searchUser(String login, String senha) throws BusinessException {
		
		return businessPessoa.searchUser(login, senha);
	}

}
