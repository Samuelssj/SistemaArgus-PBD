package dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import daoInterface.IdaoPessoa;
import exception.DaoException;
import model.Pessoa;
import util.SqlUtil;

public class PessoaDao extends Dao<Pessoa> implements IdaoPessoa {

	
	public PessoaDao() {
		// TODO Auto-generated constructor stub
		super(Pessoa.class);
	}
	
	
	@Override
	public Pessoa searchUser(String login, String senha) throws DaoException {
		try {

			TypedQuery<Pessoa> query = entityManager.createQuery(SqlUtil.USUARIO_LOGIN + "", classe);
			query.setParameter("login", login);
			query.setParameter("senha", senha);

			return query.getSingleResult();

		} catch (NoResultException n) {
			n.printStackTrace();
			throw new DaoException("Nenhum Usuário Encontrado");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao Procurar " + classe.getSimpleName() + " - " + e.getMessage());
		}
	}
	}


//	EntityManagerFactory emf;
//	EntityManager em;
//
//	public PessoaDao() {
//		emf = Persistence.createEntityManagerFactory("BANCO");
//		em = emf.createEntityManager();
//	}
//
//	public void salvar(Pessoa pessoa) {
//		em.getTransaction().begin();
////		em.persist(pessoa); modo de salvar apagando e criando novamente
//		em.merge(pessoa);// se o objeto ja existir ele tenta atualizar
//
//		em.getTransaction().commit();
//		emf.close();
//
//	}
//
//	public void remover(Pessoa pessoa) {
//		em.getTransaction().begin();
//		em.remove(pessoa);
//		em.getTransaction().commit();
//		em.close();
//
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<Pessoa> listarTodos() {
//		em.getTransaction().begin();
//		Query consulta = em.createQuery("select pessoa from Pessoa pessoa");
//		List<Pessoa> pessoas = consulta.getResultList();
//		em.getTransaction().commit();
//		em.close();
//		return pessoas;
//
//	}



