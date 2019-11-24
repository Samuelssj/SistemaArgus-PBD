package fachada;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.common.util.impl.Log;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import EntidadeEnum.HistoricoTipo;
import business.BusinessAcompanhamento;
import business.BusinessCurriculo;
import business.BusinessDisciplina;
import business.BusinessEndereco;
import business.BusinessNota;
import business.BusinessParcela;
import business.BusinessPedagogo;
import business.BusinessProfessor;
import business.BusinessResponsavel;
import business.BusinessTurma;
import business.BusinessUsuario;
import business.BusinessUtil;
import business.BussinessAluno;
import businessInterface.IbusinessAcompanhamento;
import businessInterface.IbusinessAluno;
import businessInterface.IbusinessCurriculo;
import businessInterface.IbusinessDisciplina;
import businessInterface.IbusinessEndereco;
import businessInterface.IbusinessNota;
import businessInterface.IbusinessParcela;
import businessInterface.IbusinessPedagogo;
import businessInterface.IbusinessResponsavel;
import businessInterface.IbusinessTurma;
import businessInterface.IbusinessUsuario;
import businessInterface.IbusinessUtil;
import businessInterface.IbusunessProfessor;
import exception.BusinessException;
import model.Acompanhamento;
import model.Aluno;
import model.Curriculo;
import model.Disciplina;
import model.Endereco;
import model.Entidade;
import model.Nota;
import model.Parcela;
import model.Pedagogo;
import model.Professor;
import model.Responsavel;
import model.Turma;
import model.Usuario;
import model.UsuarioTabAdapter;

public class Fachada implements IFachada {

	private IbusinessUsuario businessUsuario;
	private IbusinessAluno businessAluno;
	private IbusinessEndereco businessEndereco;
	private IbusinessResponsavel businessResponsavel;
	private IbusunessProfessor businessProfessor;
	private IbusinessPedagogo businessPedagogo;
	private IbusinessAcompanhamento businessAcompanhamento;
	private IbusinessCurriculo businessCuriculo;
	private IbusinessDisciplina businessDisciplina;
	private IbusinessNota businessNota;
	private IbusinessParcela businessParcela;
	private IbusinessTurma businessTurma;
	
	private IbusinessUtil businessUtil;
	private static Fachada instance;

	public Fachada() {
		businessUsuario = new BusinessUsuario();
		businessEndereco = new BusinessEndereco();
		businessUtil = new BusinessUtil();
		businessAluno = new BussinessAluno();
		businessResponsavel = new BusinessResponsavel();
		businessProfessor = new BusinessProfessor();
		businessPedagogo = new BusinessPedagogo();
		businessAcompanhamento = new BusinessAcompanhamento();
		businessCuriculo = new BusinessCurriculo();
		businessDisciplina = new BusinessDisciplina();
		businessNota = new BusinessNota();
		businessParcela = new BusinessParcela();
		businessTurma = new BusinessTurma();
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

	@Override
	public List<UsuarioTabAdapter> searchAllUsuarioAdapter() throws BusinessException {
		// TODO Auto-generated method stub
		// return businessUsuario.searchAll();
		return null;
	}

	@Override
	public List<UsuarioTabAdapter> searchAllUsuarioAdapter(String search) throws BusinessException {
		// TODO Auto-generated method stub
		// return businessUsuario.searchAll(search);
		return null;
	}

												// ENDERECO

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

												// UTILL

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

												// ALUNO

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

											// RESPONSAVEL

	@Override
	public void createOrUpdateResponsavel(Responsavel entidade) throws BusinessException {

		businessResponsavel.createOrUpdate(entidade);

	}

	@Override
	public Responsavel searchResponsavel(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessResponsavel.search(id);
	}

	@Override
	public void removeResponsavel(int id) throws BusinessException {
		// TODO Auto-generated method stub
		businessResponsavel.remove(id);

	}

	@Override
	public List<Responsavel> searchAllResponsavel() throws BusinessException {
		// TODO Auto-generated method stub
		return businessResponsavel.searchAll();
	}

	@Override
	public List<Responsavel> searchAllResponsavel(String search) throws BusinessException {
		// TODO Auto-generated method stub
		return businessResponsavel.searchAll(search);
	}

	@Override
	public List<UsuarioTabAdapter> searchAllResponsavelAdapter(String search) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioTabAdapter> searchAllResponsavelAdapter() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

									//PROFESSOR
										
	
	@Override
	public void createOrUpdateProfessor(Professor entidade) throws BusinessException {
			
		businessProfessor.createOrUpdate(entidade);
		
	}

	@Override
	public Professor searchProfessor(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessProfessor.search(id);
	}

	@Override
	public void removeProfessor(int id) throws BusinessException {
		// TODO Auto-generated method stub
		businessProfessor.remove(id);
		
	}

	@Override
	public List<Professor> searchAllProfessor() throws BusinessException {
		// TODO Auto-generated method stub
		return  businessProfessor.searchAll();
	}

	@Override
	public List<Professor> searchAllProfessor(String search) throws BusinessException {
		// TODO Auto-generated method stub
		return businessProfessor.searchAll(search); 
		
	}

						//PEDAGOGO
	
	@Override
	public void createOrUpdatePedagogo(Pedagogo entidade) throws BusinessException {
		// TODO Auto-generated method stub
		businessPedagogo.createOrUpdate(entidade);

	}

	@Override
	public Usuario searchPedagogo(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessPedagogo.search(id);
	}

	@Override
	public void removePedagogo(int id) throws BusinessException {
		// TODO Auto-generated method stub
		businessPedagogo.remove(id);
		
	}

	@Override
	public List<Pedagogo> searchAllPedagogo() throws BusinessException {
		// TODO Auto-generated method stub
		return businessPedagogo.searchAll();
	}

	@Override
	public List<Pedagogo> searchAllPedagogo(String search) throws BusinessException {
		// TODO Auto-generated method stub
		return businessPedagogo.searchAll(search);
	}

		//ACOMPANHAMENTO
	
	@Override
	public void createOrUpdateAcompanhamento(Acompanhamento entidade) throws BusinessException {
		// TODO Auto-generated method stub
		businessAcompanhamento.createOrUpdate(entidade);
	}

	@Override
	public Acompanhamento searchAcompanhamento(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessAcompanhamento.search(id);
	}

	@Override
	public void removeAcompanhamento(int id) throws BusinessException {
		// TODO Auto-generated method stub
		businessAcompanhamento.remove(id);
	}

	@Override
	public List<Acompanhamento> searchAllAcompanhamento() throws BusinessException {
		// TODO Auto-generated method stub
		return businessAcompanhamento.searchAll();
	}

	@Override
	public List<Acompanhamento> searchAllAcompanhamento(String search) throws BusinessException {
		// TODO Auto-generated method stub
		return businessAcompanhamento.searchAll(search);
	}

	
	
	//DISCIPLINA
	
	@Override
	public void createOrUpdateDisciplina(Disciplina entidade) throws BusinessException {
		// TODO Auto-generated method stub
		businessDisciplina.createOrUpdate(entidade);
		
	}

	@Override
	public Disciplina searchDisciplina(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessDisciplina.search(id);
	}

	@Override
	public void removeDisciplina(int id) throws BusinessException {
		// TODO Auto-generated method stub
		businessDisciplina.remove(id);
	}

	@Override
	public List<Disciplina> searchAllDisciplina() throws BusinessException {
		// TODO Auto-generated method stub
		return businessDisciplina.searchAll();
	}

	@Override
	public List<Disciplina> searchAllDisciplina(String search) throws BusinessException {
		// TODO Auto-generated method stub
		return businessDisciplina.searchAll(search);
	}

			//NOTA
	
	@Override
	public void createOrUpdateNota(Nota entidade) throws BusinessException {
		// TODO Auto-generated method stub
		businessNota.createOrUpdate(entidade);
	}

	@Override
	public Nota searchNota(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessNota.search(id);
	}

	@Override
	public void removeNota(int id) throws BusinessException {
		// TODO Auto-generated method stub
		businessNota.remove(id);
	}

	@Override
	public List<Nota> searchAllNota() throws BusinessException {
		// TODO Auto-generated method stub
		return businessNota.searchAll();
	}

	@Override
	public List<Nota> searchAllNota(String search) throws BusinessException {
		// TODO Auto-generated method stub
		return businessNota.searchAll(search);
	}

	//CURRICULO
	
	@Override
	public void createOrUpdateCurriculo(Curriculo entidade) throws BusinessException {
		// TODO Auto-generated method stub
		
		businessCuriculo.createOrUpdate(entidade);
	}

	@Override
	public Curriculo searchCurriculo(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessCuriculo.search(id);
	}

	@Override
	public void removeCurriculo(int id) throws BusinessException {
		// TODO Auto-generated method stub
		businessCuriculo.remove(id);
	}

	@Override
	public List<Curriculo> searchAllCurriculo() throws BusinessException {
		// TODO Auto-generated method stub
		return businessCuriculo.searchAll();
	}

	@Override
	public List<Curriculo> searchAllCurriculo(String search) throws BusinessException {
		// TODO Auto-generated method stub
		return businessCuriculo.searchAll(search);
	}

	
		//PARCELA
	
	@Override
	public void createOrUpdateParcela(Parcela entidade) throws BusinessException {
		// TODO Auto-generated method stub
		businessParcela.createOrUpdate(entidade);
	}

	@Override
	public Parcela searchParcela(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessParcela.search(id);
	}

	@Override
	public void removeParcela(int id) throws BusinessException {
		// TODO Auto-generated method stub
		businessParcela.remove(id);
		
	}

	@Override
	public List<Parcela> searchAllParcela() throws BusinessException {
		// TODO Auto-generated method stub
		return businessParcela.searchAll();
	}

	@Override
	public List<Parcela> searchAllParcela(String search) throws BusinessException {
		// TODO Auto-generated method stub
		return businessParcela.searchAll(search);
	}

	//TURMA
	
	@Override
	public void createOrUpdateTurma(Turma entidade) throws BusinessException {
		// TODO Auto-generated method stub
		businessTurma.createOrUpdate(entidade);
	}

	@Override
	public Turma searchTurma(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessTurma.search(id);
	}

	@Override
	public void removeTurma(int id) throws BusinessException {
		// TODO Auto-generated method stub
		businessTurma.remove(id);
	}

	@Override
	public List<Turma> searchAllTurma() throws BusinessException {
		// TODO Auto-generated method stub
		return businessTurma.searchAll();
	}

	@Override
	public List<Turma> searchAllTurma(String search) throws BusinessException {
		// TODO Auto-generated method stub
		return businessTurma.searchAll(search);
	}



	
}
