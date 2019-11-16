package dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import daoInterface.IdaoUsuarioAdapter;
import exception.DaoException;
import model.Usuario;
import model.UsuarioTabAdapter;
import util.SqlUtil;

public class UsuarioAdapterDao extends Dao<UsuarioTabAdapter>implements IdaoUsuarioAdapter {



	public UsuarioAdapterDao() {
		super(UsuarioTabAdapter.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public UsuarioTabAdapter searchUser(String login, String senha) throws DaoException {
//		try {
//
//			TypedQuery<Usuario> query = entityManager.createQuery(SqlUtil.USUARIO_LOGIN + "", classe);
//			query.setParameter("login", login);
//			query.setParameter("senha", senha);
//
//			return query.getSingleResult();
//			
//		} catch (NoResultException n) {
//			n.printStackTrace();
//			throw new DaoException("Nenhum Usuário Encontrado");
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new DaoException("Erro ao Procurar " + classe.getSimpleName() + " - " + e.getMessage());
//		}
		return null;
	}
	


	}
