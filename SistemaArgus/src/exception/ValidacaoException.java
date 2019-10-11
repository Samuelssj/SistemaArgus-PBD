package exception;


@SuppressWarnings("serial")
public class ValidacaoException extends Exception {

	public ValidacaoException(String mensagem) {
		 super(mensagem.toUpperCase());
	}
	
	
}
