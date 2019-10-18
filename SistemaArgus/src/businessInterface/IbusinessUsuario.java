package businessInterface;

import exception.BusinessException;
import model.Usuario;

public interface IbusinessUsuario extends Ibusiness<Usuario> {
	

	public Usuario searchUser(String login, String senha) throws BusinessException;
	

}
