package businessInterface;

import exception.BusinessException;

import model.UsuarioTabAdapter;

public interface IbusinessUsuarioAdapter extends Ibusiness<UsuarioTabAdapter> {

	public UsuarioTabAdapter searchUserTabAdapter(String login, String senha) throws BusinessException;
}
