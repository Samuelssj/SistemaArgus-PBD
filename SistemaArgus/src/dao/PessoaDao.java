package dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Pessoa;

public class PessoaDao {

	EntityManagerFactory emf;
	EntityManager em;

	public PessoaDao() {
		emf = Persistence.createEntityManagerFactory("BANCO");
		em = emf.createEntityManager();
	}

	public void salvar(Pessoa pessoa) {
		em.getTransaction().begin();
//		em.persist(pessoa); modo de salvar apagando e criando novamente
		em.merge(pessoa);// se o objeto ja existir ele tenta atualizar

		em.getTransaction().commit();
		emf.close();

	}

	public void remover(Pessoa pessoa) {
		em.getTransaction().begin();
		em.remove(pessoa);
		em.getTransaction().commit();
		em.close();

	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> listarTodos() {
		em.getTransaction().begin();
		Query consulta = em.createQuery("select pessoa from Pessoa pessoa");
		List<Pessoa> pessoas = consulta.getResultList();
		em.getTransaction().commit();
		em.close();
		return pessoas;

	}

}
