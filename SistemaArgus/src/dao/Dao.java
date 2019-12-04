package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.hibernate.internal.ExceptionConverterImpl;

import com.itextpdf.text.ExceptionConverter;


import daoInterface.IDao;
import exception.DaoException;
import model.Aluno;
import model.Disciplina;
import model.Entidade;
import util.FactoryConnection;
import util.SqlUtil;

public class Dao<Tipo extends Entidade> implements IDao<Tipo> {

	protected static EntityManager entityManager = getEntityManager();
	protected Class<Tipo> classe;

	public static void closeConnection() {
		entityManager.flush();
		entityManager.close();
	}
	
	public static void resetConnection() {
		
		FactoryConnection.alterarPropriedades(true);
		entityManager.clear();
		entityManager.close();
		entityManager = FactoryConnection.getEntityManager();
		entityManager.clear();
		
	}
	
	public Dao(Class<Tipo> classe) {
		this.classe = classe;
	}
	
	protected static EntityManager getEntityManager() {
		if (entityManager == null) {
			FactoryConnection.alterarPropriedades(false);
			entityManager = FactoryConnection.getEntityManager();
			entityManager.clear();
		}

		return entityManager;
	}

	@Override
	public void create(Tipo entidade) throws DaoException {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entidade);
			entityManager.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new DaoException("Erro ao Salvar " + classe.getSimpleName() + " - " + e.getMessage());
		}

	}

	@Override
	public Tipo search(int id) throws DaoException {
		
		try {
			return entityManager.find(classe, id);
		} catch (NoResultException n) {
			n.printStackTrace();
			throw new DaoException("Nenhum " + classe.getSimpleName() + " Encontrado");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro Ao Procurar Por " + classe.getSimpleName());
		}
	}

	@Override
	public void remove(int id) throws DaoException {
		
		try {
			entityManager.getTransaction().begin();
			Tipo entidade = entityManager.find(classe, id);
			entityManager.remove(entidade);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new DaoException("Erro ao Remover " + classe.getSimpleName() + " - " + e.getMessage());
		}

	}

	@Override
	public void update(Tipo entidade) throws DaoException {
		
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entidade);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new DaoException("Erro ao Atualizar " + classe.getSimpleName() + " - " + e.getMessage());
		}

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Tipo> searchAll() throws DaoException {
		try {
			return entityManager.createQuery("FROM " + classe.getName()).getResultList();
		} catch (NoResultException n) {
			n.printStackTrace();
			throw new DaoException("Nenhum " + classe.getSimpleName() + " Encontrado");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao Procurar " + classe.getSimpleName() + " - " + e.getMessage());
		}
	}

	@Override
	public List<Tipo> searchAll(String search) throws DaoException {
		try {
			TypedQuery<Tipo> query = entityManager.createQuery(SqlUtil.buscaPorBusca(classe), classe);
			query.setParameter("trocar", "%" + search.toLowerCase() + "%");

			return query.getResultList();
		} catch (NoResultException n) {
			n.printStackTrace();
			throw new DaoException("Nenhum " + classe.getSimpleName() + " Encontrado");
		} 
//		catch (Exception e) {
//			e.printStackTrace();
//			throw new DaoException("Erro ao Procurar " + classe.getSimpleName() + " - " + e.getMessage());
//		}
	
	}
	
	
	

}
