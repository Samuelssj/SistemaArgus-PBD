package dao;

import java.util.List;

import daoInterface.IDao;
import exception.DaoException;
import model.Entidade;

public class Dao <Tipo extends Entidade> implements IDao<Tipo >{

	@Override
	public void create(Tipo entidade) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tipo search(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(int id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Tipo entidade) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tipo> searchAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tipo> searchAll(String search) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
