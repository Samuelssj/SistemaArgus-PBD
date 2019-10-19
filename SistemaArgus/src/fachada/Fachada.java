package fachada;

import java.util.List;

import business.BusinessEndereco;
import business.BusinessUsuario;
import businessInterface.IbusinessEndereco;
import businessInterface.IbusinessUsuario;
import exception.BusinessException;
import model.Endereco;
import model.Usuario;

public class Fachada implements IFachada {

	private IbusinessUsuario businessUsuario;
	private IbusinessEndereco businessEndereco;

	private static Fachada instance;

	public Fachada() {
		businessUsuario = new BusinessUsuario();
		businessEndereco = new BusinessEndereco();
	}

	public static Fachada getInstance() {
		if (instance == null)
			instance = new Fachada();
		return instance;
	}

	@Override
	public void createOrUpdatePessoa(Usuario entidade) throws BusinessException {
		businessUsuario.createOrUpdate(entidade);
	}

	@Override
	public Usuario searchUser(String login, String senha) throws BusinessException {

		return businessUsuario.searchUser(login, senha);
	}

	@Override
	public Usuario searchSuperUsuario(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessUsuario.search(id);
	}

	@Override
	public void removeSuperUsuario(int id) throws BusinessException {
		// TODO Auto-generated method stub
		businessUsuario.remove(id);

	}

	@Override
	public List<Usuario> searchAllSuperUsuario() throws BusinessException {
		// TODO Auto-generated method stub
		return businessUsuario.searchAll();
	}

	@Override
	public List<Usuario> searchAllSuperUsuario(String search) throws BusinessException {
		// TODO Auto-generated method stub
		return businessUsuario.searchAll(search);
	}

	
	//ENDERECO
	
	@Override
	public void createOrUpdateEndereco(Endereco entidade) throws BusinessException {
		businessEndereco.createOrUpdate(entidade);

	}

	@Override
	public Endereco searchEndereco(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessEndereco.search(id);
	}

	@Override
	public void removeEndereco(int id) throws BusinessException {
		businessEndereco.remove(id);

	}

	@Override
	public List<Endereco> searchAllEndereco() throws BusinessException {
		// TODO Auto-generated method stub
		return businessEndereco.searchAll();
	}

	@Override
	public List<Endereco> searchAllEndereco(String search) throws BusinessException {
		// TODO Auto-generated method stub
		return businessEndereco.searchAll(search);
	}

}
