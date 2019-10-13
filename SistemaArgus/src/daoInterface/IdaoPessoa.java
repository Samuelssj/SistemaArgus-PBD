package daoInterface;

import exception.DaoException;
import model.Pessoa;

public interface IdaoPessoa extends IDao<Pessoa>{
	

	public Pessoa searchUser(String login, String senha) throws DaoException;

}
