package daoInterface;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.common.util.impl.Log;

import EntidadeEnum.HistoricoTipo;
import exception.DaoException;
import model.Entidade;


public interface IDaoUtil {

public Long searchCont(Class<? extends Entidade> classe) throws DaoException;
	
	public Long searchContSelect(Class<? extends Entidade> classe, String sql) throws DaoException;
	
	public List<Log> searchLog(LocalDate date, HistoricoTipo tipoHistorico) throws DaoException;
}
