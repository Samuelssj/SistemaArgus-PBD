package dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.annotations.common.util.impl.Log;

import EntidadeEnum.HistoricoTipo;
import daoInterface.IDaoUtil;
import exception.DaoException;
import model.Aluno;
import model.Disciplina;
import model.Entidade;
import util.SqlUtil;


public class DaoUtil implements IDaoUtil{

	
	private EntityManager entityManager;

	public DaoUtil() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		return Dao.getEntityManager();
	}

	public Long searchCont(Class<? extends Entidade> classe) throws DaoException {
		try {
			Query query = entityManager.createQuery("Select count(1) From " + classe.getName() + " a", Long.class);

			return (Long) query.getSingleResult();

		} catch (NoResultException n) {
			n.printStackTrace();
			throw new DaoException("Nenhum " + classe.getSimpleName() + " Encontrado");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao Procurar " + classe.getSimpleName() + " - " + e.getMessage());
		}
	}

	@Override
	public List<Log> searchLog(LocalDate date, HistoricoTipo tipoHistorico) throws DaoException {
		try {
			TypedQuery<Log> query = entityManager.createQuery(SqlUtil.LOG + "", Log.class);
			query.setParameter("data", date);
			query.setParameter("alteracao", "%"+tipoHistorico.getValor()+"%");

			return query.getResultList();

		} catch (NoResultException n) {
			n.printStackTrace();
			throw new DaoException("Nenhum Histórico Encontrado");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao Procurar Histórico" + e.getMessage());
		}
	}

	@Override
	public Long searchContSelect(Class<? extends Entidade> classe, String sql) throws DaoException {
		try {
			Query query = entityManager.createQuery("select count(1) from "+classe.getName()+" a where "+sql, Long.class);

			return (Long) query.getSingleResult();

		} catch (NoResultException n) {
			n.printStackTrace();
			throw new DaoException("Nenhum Registro Encontrado");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao Procurar Quantidade de "+classe.getSimpleName() + e.getMessage());
		}

	}
	
	   public static List<Aluno> listarEmpsMuitoAtrasados(){
			
			EntityManager em = Dao.getEntityManager();
			em.getTransaction().begin();
			String consulta = "select * from listar_Alunos";
			Query query = em.createNativeQuery(consulta, Disciplina.class);
			@SuppressWarnings("unchecked")
			List<Aluno> Alunos = (List<Aluno>) query.getResultList();
			em.getTransaction().commit();
			em.close();			
			return Alunos;	
			
		}
	
	
	
}
