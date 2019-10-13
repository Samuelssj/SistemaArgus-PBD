package fachada;

import java.util.List;

import exception.BusinessException;
import model.Pessoa;


public interface IFachada {


//  SuperUsuario	businessSuperUsuario = new BusinessSuperUsuario();
public void createOrUpdatePessoa(Pessoa entidade) throws BusinessException;
  public Pessoa searchSuperUsuario(int id) throws BusinessException;
  public void removeSuperUsuario(int id) throws BusinessException;
  public List<Pessoa> searchAllSuperUsuario() throws BusinessException;    
  public List<Pessoa> searchAllSuperUsuario(String search) throws BusinessException;

  //Usuario
  public Pessoa searchUser(String login, String senha) throws BusinessException;
  
}
