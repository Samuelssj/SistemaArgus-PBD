package business;

import javax.xml.bind.ValidationException;
import businessInterface.IbusinessUsuario;
import dao.Dao;
import dao.UsuarioDao;
import daoInterface.IdaoUsuario;
import exception.BusinessException;
import exception.DaoException;
import exception.ValidacaoException;
import model.Usuario;
import util.Criptografia;


public class BusinessUsuario extends Business<Usuario> implements IbusinessUsuario{

	private IdaoUsuario daousuario;
	
	public BusinessUsuario() {
		// TODO Auto-generated constructor stub
		daousuario = new UsuarioDao();
		init(daousuario);
		
	}
	
	@Override
	public void validation(Usuario entidade) throws ValidacaoException {
			//completar

	}

	
	
	@Override
	public Usuario searchUser(String login, String senha) throws BusinessException {
		try {

			//senha = Criptografia.criptografar(senha.getBytes());
			Usuario usuario = daousuario.searchUser(login, senha);

			return usuario;

		} catch (DaoException e) {
			throw new BusinessException(e.getMessage());
		}
		
	}

}
