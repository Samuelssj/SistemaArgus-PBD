package exception;

public class DaoException extends Exception {

	public DaoException(String mensagem) {
		super(mensagem.toUpperCase());
	}
}
