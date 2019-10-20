package business;

import javax.xml.bind.ValidationException;

import businessInterface.IbusinessEndereco;
import dao.EnderecoDao;
import daoInterface.IdaoEndereco;
import exception.ValidacaoException;
import model.Endereco;

public class BusinessEndereco extends Business<Endereco> implements IbusinessEndereco {

	private IdaoEndereco daoEndereco;

	public BusinessEndereco() {
		daoEndereco = new EnderecoDao();
		init(daoEndereco);

	}
	
	@Override
	public void validation(Endereco entidade) throws ValidacaoException {
		
		if(entidade.getBairro().trim().isEmpty())
			throw new ValidacaoException("INFORME O BAIRRO");
		if(entidade.getCep().trim().isEmpty())
			throw new ValidacaoException("INFORME O CEP");
		if(entidade.getCidade().trim().isEmpty())
			throw new ValidacaoException("INFORME A CIDADE");
		if(entidade.getEstado() == null)
			throw new ValidacaoException("INFORME O ESTADO");
		if(entidade.getNumero().trim().isEmpty())
			throw new ValidacaoException("INFORME O NUMERO");
		if(entidade.getRua().trim().isEmpty())
			throw new ValidacaoException("INFORME  A RUA");
	}
	}
	
	
	



