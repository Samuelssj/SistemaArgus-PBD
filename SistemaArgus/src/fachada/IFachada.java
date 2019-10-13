package fachada;

import java.util.List;

import exception.BusinessException;
import model.Pessoa;


public interface IFachada {


////  SuperUsuario	businessSuperUsuario = new BusinessSuperUsuario();
//	public void createOrUpdateSuperUsuario(SuperUsuario entidade) throws BusinessException;
//  public SuperUsuario searchSuperUsuario(int id) throws BusinessException;
//  public void removeSuperUsuario(int id) throws BusinessException;
//  public List<SuperUsuario> searchAllSuperUsuario() throws BusinessException;    
//  public List<SuperUsuario> searchAllSuperUsuario(String search) throws BusinessException;

  //Usuario
  public Pessoa searchUser(String login, String senha) throws BusinessException;
  
}
