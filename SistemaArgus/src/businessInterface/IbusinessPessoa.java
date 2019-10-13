package businessInterface;

import exception.BusinessException;
import model.Pessoa;

public interface IbusinessPessoa extends Ibusiness<Pessoa> {
	

	public Pessoa searchUser(String login, String senha) throws BusinessException;
	

}
