package business;

import javax.xml.bind.ValidationException;
import businessInterface.IbusinessPessoa;
import dao.Dao;
import dao.PessoaDao;
import daoInterface.IdaoPessoa;
import exception.BusinessException;
import model.Pessoa;


public class BusinessPessoa extends Business<Pessoa> implements IbusinessPessoa{

	private IdaoPessoa daopessoa;
	
	public BusinessPessoa() {
		// TODO Auto-generated constructor stub
		daopessoa = new PessoaDao();
		init(daopessoa);
		
	}
	
	@Override
	public void validation(Pessoa entidade) throws ValidationException {

//		if (entidade.getSenha().length() < 6 || entidade.getSenha().length() > 11)
//			throw new ValidationException("A SENHA TEM QUE TER NO MINIMO 6 E NO MAXIMO 11 CARACTERES");
//		else if (!CriptografiaUtil.isCriptografado(entidade.getSenha()))
//			entidade.setSenha(CriptografiaUtil.criptografar(entidade.getSenha().getBytes()));
//
//		if (entidade instanceof SuperUsuario) {
//			SuperUsuario superUsuario = (SuperUsuario) entidade;
//
//			if (superUsuario.getSenha_padrao().length() < 6 || superUsuario.getSenha_padrao().length() > 11)
//				throw new ValidationException("A SENHA PADRÃO TEM QUE TER NO MINIMO 6 E NO MAXIMO 11 CARACTERES");
//			else if (!CriptografiaUtil.isCriptografado(superUsuario.getSenha_padrao()))
//				superUsuario.setSenha_padrao(CriptografiaUtil.criptografar(superUsuario.getSenha_padrao().getBytes()));
//		}
	}

	
	
	
	
	
	@Override
	public Pessoa searchUser(String login, String senha) throws BusinessException {
//		try {
//
//			senha = CriptografiaUtil.criptografar(senha.getBytes());
//			Usuario usuario = daoUsuario.searchUser(login, senha);
//
//			return usuario;
//
//		} catch (DaoException e) {
//			throw new BusinessException(e.getMessage());
//		}
		return null;
	}

}
