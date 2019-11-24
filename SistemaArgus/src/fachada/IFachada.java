package fachada;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.common.util.impl.Log;

import EntidadeEnum.HistoricoTipo;
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


public interface IFachada {


//  Usuario	
  public void createOrUpdatePessoa(Usuario entidade) throws BusinessException;
  public Usuario searchUsuario(int id) throws BusinessException;
  public void removeSuperUsuario(int id) throws BusinessException;
  public List<Usuario> searchAllSuperUsuario() throws BusinessException;    
  public List<Usuario> searchAllSuperUsuario(String search) throws BusinessException;
  public Usuario searchUser(String login, String senha) throws BusinessException;
  public List<UsuarioTabAdapter> searchAllUsuarioAdapter() throws BusinessException;    
  public List<UsuarioTabAdapter> searchAllUsuarioAdapter(String search) throws BusinessException;
  
//PROFESSOR
public void createOrUpdateProfessor(Professor entidade) throws BusinessException;
public Professor searchProfessor(int id) throws BusinessException;
public void removeProfessor(int id) throws BusinessException;
public List<Professor> searchAllProfessor() throws BusinessException;    
public List<Professor> searchAllProfessor(String search) throws BusinessException;
  
//Endereco
public void createOrUpdateEndereco(Endereco entidade) throws BusinessException;
public Endereco searchEndereco(int id) throws BusinessException;
public void removeEndereco(int id) throws BusinessException;
public List<Endereco> searchAllEndereco() throws BusinessException;
public List<Endereco> searchAllEndereco(String search) throws BusinessException;

  
//Aluno
public void createOrUpdateAluno(Usuario entidade) throws BusinessException;
public Usuario searchAluno(int id) throws BusinessException;
public void removeAluno(int id) throws BusinessException;
public List<Aluno> searchAllAluno() throws BusinessException;    
public List<Aluno> searchAllAluno(String search) throws BusinessException;

// RESPONSAVEL

public void createOrUpdateResponsavel(Responsavel entidade) throws BusinessException;
public Responsavel searchResponsavel(int id) throws BusinessException;
public void removeResponsavel(int id) throws BusinessException;
public List<Responsavel> searchAllResponsavel() throws BusinessException;    
public List<Responsavel> searchAllResponsavel(String search) throws BusinessException;
public List<UsuarioTabAdapter> searchAllResponsavelAdapter() throws BusinessException;    
public List<UsuarioTabAdapter> searchAllResponsavelAdapter(String search) throws BusinessException;

//PEDAGOGO

public void createOrUpdatePedagogo(Pedagogo entidade) throws BusinessException;
public Usuario searchPedagogo(int id) throws BusinessException;
public void removePedagogo(int id) throws BusinessException;
public List<Pedagogo> searchAllPedagogo() throws BusinessException;    
public List<Pedagogo> searchAllPedagogo(String search) throws BusinessException;

//ACOMPANHAMENTO

public void createOrUpdateAcompanhamento(Acompanhamento entidade) throws BusinessException;
public Acompanhamento searchAcompanhamento(int id) throws BusinessException;
public void removeAcompanhamento(int id) throws BusinessException;
public List<Acompanhamento> searchAllAcompanhamento() throws BusinessException;    
public List<Acompanhamento> searchAllAcompanhamento(String search) throws BusinessException;

//DISCIPLINA 

public void createOrUpdateDisciplina(Disciplina entidade) throws BusinessException;
public Disciplina searchDisciplina(int id) throws BusinessException;
public void removeDisciplina(int id) throws BusinessException;
public List<Disciplina> searchAllDisciplina() throws BusinessException;    
public List<Disciplina> searchAllDisciplina(String search) throws BusinessException;

//NOTA
public void createOrUpdateNota(Nota entidade) throws BusinessException;
public Nota searchNota(int id) throws BusinessException;
public void removeNota(int id) throws BusinessException;
public List<Nota> searchAllNota() throws BusinessException;    
public List<Nota> searchAllNota(String search) throws BusinessException;

// CURRICULO
public void createOrUpdateCurriculo(Curriculo entidade) throws BusinessException;
public Curriculo searchCurriculo(int id) throws BusinessException;
public void removeCurriculo(int id) throws BusinessException;
public List<Curriculo> searchAllCurriculo() throws BusinessException;    
public List<Curriculo> searchAllCurriculo(String search) throws BusinessException;

//PARCELA
public void createOrUpdateParcela(Parcela entidade) throws BusinessException;
public Parcela searchParcela(int id) throws BusinessException;
public void removeParcela(int id) throws BusinessException;
public List<Parcela> searchAllParcela() throws BusinessException;    
public List<Parcela> searchAllParcela(String search) throws BusinessException;

//TURMA

public void createOrUpdateTurma(Turma entidade) throws BusinessException;
public Turma searchTurma(int id) throws BusinessException;
public void removeTurma(int id) throws BusinessException;
public List<Turma> searchAllTurma() throws BusinessException;    
public List<Turma> searchAllTurma(String search) throws BusinessException;




//Util
public Long searchCont(Class<? extends Entidade> classe) throws BusinessException;
public List<Log> searchLog(LocalDate date, HistoricoTipo tipoHistorico) throws BusinessException;
public Long searchContSelect(Class<? extends Entidade> classe, String sql) throws BusinessException;

}
