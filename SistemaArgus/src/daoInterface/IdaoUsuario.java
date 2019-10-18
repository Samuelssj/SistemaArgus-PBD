package daoInterface;

import exception.DaoException;
import model.Usuario;

public interface IdaoUsuario extends IDao<Usuario>{
	

	public Usuario searchUser(String login, String senha) throws DaoException;

}
