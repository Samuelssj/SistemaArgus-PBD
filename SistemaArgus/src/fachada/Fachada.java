package fachada;

import java.util.List;

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
	public void createOrUpdatePessoa(Pessoa entidade) throws BusinessException {
		businessPessoa.createOrUpdate(entidade);
	}
	
	@Override
	public Pessoa searchUser(String login, String senha) throws BusinessException {
		
		return businessPessoa.searchUser(login, senha);
	}

	@Override
	public Pessoa searchSuperUsuario(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeSuperUsuario(int id) throws BusinessException {
		// TODO Auto-generated method stub
			businessPessoa.remove(id);
		
		
	}

	@Override
	public List<Pessoa> searchAllSuperUsuario() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> searchAllSuperUsuario(String search) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
