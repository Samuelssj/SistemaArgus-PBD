package business;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.common.util.impl.Log;

import EntidadeEnum.HistoricoTipo;
import businessInterface.IbusinessUtil;
import dao.DaoUtil;
import daoInterface.IDaoUtil;
import exception.BusinessException;
import exception.DaoException;
import model.Entidade;

public class BusinessUtil implements IbusinessUtil{


	private IDaoUtil daoUtil;
	
	public BusinessUtil() {
		daoUtil = new DaoUtil();
	}
	
	@Override
	public Long searchCont(Class<? extends Entidade> classe) throws BusinessException {
		try {
			return daoUtil.searchCont(classe);
		} catch (DaoException e) {
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Log> searchLog(LocalDate date, HistoricoTipo tipoHistorico) throws BusinessException {		
		try {
			return daoUtil.searchLog(date, tipoHistorico);
		} catch (DaoException e) {
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public Long searchContSelect(Class<? extends Entidade> classe, String sql) throws BusinessException {
		try {
			return daoUtil.searchContSelect(classe, sql);
		} catch (DaoException e) {
			throw new BusinessException(e.getMessage());
		}	}
}
