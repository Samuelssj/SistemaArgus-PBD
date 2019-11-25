package business;

import java.util.List;

import javax.xml.bind.ValidationException;


import businessInterface.Ibusiness;
import daoInterface.IDao;
import exception.BusinessException;
import exception.DaoException;
import exception.ValidacaoException;
import model.Entidade;
import util.Criptografia;

public class Business<Tipo extends Entidade> implements Ibusiness<Tipo> {

	protected IDao<Tipo> dao;

	@Override
	public void init(IDao<Tipo> dao) {
		this.dao = dao;
		
	}

	@Override
	public void createOrUpdate(Tipo entidade) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			validation(entidade);
			if(entidade.getId() == null)
				dao.create(entidade);
			else
				dao.update(entidade);
		} catch (DaoException | ValidacaoException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
		
	}

	@Override
	public Tipo search(int id) throws BusinessException {
		try {
			return dao.search(id);
		} catch (DaoException e) {
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void remove(int id) throws BusinessException {
		try {
			dao.remove(id);
		} catch (DaoException e) {
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Tipo> searchAll() throws BusinessException {
		try {
			return dao.searchAll();
		} catch (DaoException e) {
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Tipo> searchAll(String search) throws BusinessException {
		try {
			return dao.searchAll(search);
		} catch (DaoException e) {
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void validation(Tipo entidade) throws ValidacaoException {
		// TODO Auto-generated method stub
	
		
//		if (entidade.getId().length() < 6 || entidade.getSenha().length() > 11)
//			throw new ValidationException("A SENHA TEM QUE TER NO MINIMO 6 E NO MAXIMO 11 CARACTERES");
//		else if (!Criptografia.isCriptografado(entidade.getSenha()))
//			entidade.setSenha(Criptografia.criptografar(entidade.getSenha().getBytes()));
//		
	}

	
	

}
