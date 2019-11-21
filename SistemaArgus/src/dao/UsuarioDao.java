package dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import daoInterface.IdaoUsuario;
import exception.DaoException;
import model.Usuario;
import util.SqlUtil;

public class UsuarioDao extends Dao<Usuario> implements IdaoUsuario {

	
	public UsuarioDao() {
		// TODO Auto-generated constructor stub
		super(Usuario.class);
	}
	
	
	@Override
	public Usuario searchUser(String login, String senha) throws DaoException {
		try {

			TypedQuery<Usuario> query = entityManager.createQuery(SqlUtil.USUARIO_LOGIN + "", classe);
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





