package fachada;

import java.util.List;

import business.BusinessUsuario;
import businessInterface.IbusinessUsuario;
import exception.BusinessException;
import model.Usuario;

public class Fachada implements IFachada{
	
	private IbusinessUsuario businessPessoa;
	
	
	private static Fachada instance;
	
	
	

	public Fachada() {
		businessPessoa = new BusinessUsuario();
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
	public void createOrUpdatePessoa(Usuario entidade) throws BusinessException {
		businessPessoa.createOrUpdate(entidade);
	}
	
	@Override
	public Usuario searchUser(String login, String senha) throws BusinessException {
		
		return businessPessoa.searchUser(login, senha);
	}

	@Override
	public Usuario searchSuperUsuario(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeSuperUsuario(int id) throws BusinessException {
		// TODO Auto-generated method stub
			businessPessoa.remove(id);
		
		
	}

	@Override
	public List<Usuario> searchAllSuperUsuario() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> searchAllSuperUsuario(String search) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
