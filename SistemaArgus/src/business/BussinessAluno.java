package business;

import javax.xml.bind.ValidationException;

import businessInterface.IbusinessAluno;
import dao.AlunoDao;
import dao.Dao;
import daoInterface.IdaoAluno;
import model.Aluno;

public class BussinessAluno extends Business<Aluno> implements IbusinessAluno{
	
	private IdaoAluno daoAluno;
	
	public BussinessAluno() {
		daoAluno= new AlunoDao();
		init(daoAluno);
	}
	
	@Override
	public void validation(Aluno entidade) {
	}

}
