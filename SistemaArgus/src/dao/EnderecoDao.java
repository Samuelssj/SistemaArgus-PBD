package dao;

import daoInterface.IdaoEndereco;
import model.Endereco;

public class EnderecoDao extends Dao<Endereco> implements IdaoEndereco {

	public EnderecoDao() {
		super(Endereco.class);
	}
}
