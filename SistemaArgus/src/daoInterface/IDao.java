package daoInterface;

import java.util.List;

import exception.DaoException;
import model.Entidade;

public interface IDao<Tipo extends Entidade> {

	public void create(Tipo entidade) throws DaoException;
	  
    public Tipo search(int id) throws DaoException;

    public void remove(int id) throws DaoException;

    public void update(Tipo entidade) throws DaoException;

    public List<Tipo> searchAll() throws DaoException;
    
    public List<Tipo> searchAll(String search) throws DaoException;
	
	
}
