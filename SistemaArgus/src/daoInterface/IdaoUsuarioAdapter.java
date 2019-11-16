package daoInterface;

import exception.DaoException;
import model.UsuarioTabAdapter;

public interface IdaoUsuarioAdapter {

	public UsuarioTabAdapter	 searchUser(String login, String senha) throws DaoException;

}
