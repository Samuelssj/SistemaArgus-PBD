package fachada;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.common.util.impl.Log;

import EntidadeEnum.HistoricoTipo;
import business.BusinessEndereco;
import business.BusinessUsuario;
import business.BusinessUtil;
import business.BussinessAluno;
import businessInterface.IbusinessAluno;
import businessInterface.IbusinessEndereco;
import businessInterface.IbusinessUsuario;
import businessInterface.IbusinessUtil;
import exception.BusinessException;
import model.Aluno;
import model.Endereco;
import model.Entidade;
import model.Usuario;

public class Fachada implements IFachada {

	private IbusinessUsuario businessUsuario;
	private IbusinessAluno businessAluno;
	private IbusinessEndereco businessEndereco;
	private IbusinessUtil businessUtil;
	private static Fachada instance;

	public Fachada() {
		businessUsuario = new BusinessUsuario();
		businessEndereco = new BusinessEndereco();
		businessUtil = new BusinessUtil();
		businessAluno = new BussinessAluno();
	}

	public static Fachada getInstance() {
		if (instance == null)
			instance = new Fachada();
		return instance;
	}

	@Override
	public void createOrUpdatePessoa(Usuario entidade) throws BusinessException {
		businessUsuario.createOrUpdate(entidade);
	}

	@Override
	public Usuario searchUser(String login, String senha) throws BusinessException {

		return businessUsuario.searchUser(login, senha);
	}

	@Override
	public Usuario searchUsuario(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessUsuario.search(id);
	}

	@Override
	public void removeSuperUsuario(int id) throws BusinessException {
		// TODO Auto-generated method stub
		businessUsuario.remove(id);

	}

	@Override
	public List<Usuario> searchAllSuperUsuario() throws BusinessException {
		// TODO Auto-generated method stub
		return businessUsuario.searchAll();
	}

	@Override
	public List<Usuario> searchAllSuperUsuario(String search) throws BusinessException {
		// TODO Auto-generated method stub
		return businessUsuario.searchAll(search);
	}

	
	//ENDERECO
	
	@Override
	public void createOrUpdateEndereco(Endereco entidade) throws BusinessException {
		businessEndereco.createOrUpdate(entidade);

	}

	@Override
	public Endereco searchEndereco(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessEndereco.search(id);
	}

	@Override
	public void removeEndereco(int id) throws BusinessException {
		businessEndereco.remove(id);

	}

	@Override
	public List<Endereco> searchAllEndereco() throws BusinessException {
		// TODO Auto-generated method stub
		return businessEndereco.searchAll();
	}

	@Override
	public List<Endereco> searchAllEndereco(String search) throws BusinessException {
		// TODO Auto-generated method stub
		return businessEndereco.searchAll(search);
	}

	@Override
	public Long searchCont(Class<? extends Entidade> classe) throws BusinessException {
		// TODO Auto-generated method stub
		return businessUtil.searchCont(classe);
	}

	@Override
	public List<Log> searchLog(LocalDate date, HistoricoTipo tipoHistorico) throws BusinessException {
		// TODO Auto-generated method stub
		return businessUtil.searchLog(date, tipoHistorico);
	}

	@Override
	public Long searchContSelect(Class<? extends Entidade> classe, String sql) throws BusinessException {
		// TODO Auto-generated method stub
		return businessUtil.searchContSelect(classe, sql);
	}

	
	//ALUNO
	
	
	@Override
	public void createOrUpdateAluno(Usuario entidade) throws BusinessException {
		businessUsuario.createOrUpdate(entidade);
		
	}

	@Override
	public Usuario searchAluno(int id) throws BusinessException {
	
		return businessUsuario.search(id);
	}

	@Override
	public void removeAluno(int id) throws BusinessException {
		businessEndereco.remove(id);
		
	}

	@Override
	public List<Aluno> searchAllAluno() throws BusinessException {
		// TODO Auto-generated method stub
		return businessAluno.searchAll();
	}

	@Override
	public List<Aluno> searchAllAluno(String search) throws BusinessException {
		// TODO Auto-generated method stub
		return businessAluno.searchAll(search);
	}

}
