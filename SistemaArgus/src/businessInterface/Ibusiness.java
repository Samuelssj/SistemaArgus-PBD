package businessInterface;

import java.util.List;

import javax.xml.bind.ValidationException;

import daoInterface.IDao;
import exception.BusinessException;
import exception.ValidacaoException;
import model.Entidade;

public interface Ibusiness <Tipo extends Entidade>{

	
	
	public void init(IDao<Tipo> dao);
	
	public void createOrUpdate(Tipo entidade) throws BusinessException;
	  
    public Tipo search(int id) throws BusinessException;

    public void remove(int id) throws BusinessException;

    public List<Tipo> searchAll() throws BusinessException;
    
    public List<Tipo> searchAll(String search) throws BusinessException;

	public void validation(Tipo entidade) throws ValidacaoException;
}
