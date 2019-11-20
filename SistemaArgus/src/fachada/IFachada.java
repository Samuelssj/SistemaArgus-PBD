package fachada;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.common.util.impl.Log;

import EntidadeEnum.HistoricoTipo;
import exception.BusinessException;
import model.Aluno;
import model.Endereco;
import model.Entidade;
import model.Professor;
import model.Responsavel;
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
public Usuario searchProfessor(int id) throws BusinessException;
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

//Util
public Long searchCont(Class<? extends Entidade> classe) throws BusinessException;
public List<Log> searchLog(LocalDate date, HistoricoTipo tipoHistorico) throws BusinessException;
public Long searchContSelect(Class<? extends Entidade> classe, String sql) throws BusinessException;

}
