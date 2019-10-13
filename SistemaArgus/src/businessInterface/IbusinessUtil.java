package businessInterface;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.common.util.impl.Log;

import EntidadeEnum.HistoricoTipo;
import exception.BusinessException;
import model.Entidade;


public interface IbusinessUtil {

	
public Long searchCont(Class<? extends Entidade> classe) throws BusinessException;
	
	public List<Log> searchLog(LocalDate date, HistoricoTipo tipoHistorico) throws BusinessException;
	
	public Long searchContSelect(Class<? extends Entidade> classe, String sql) throws BusinessException;
	
}
