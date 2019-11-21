package util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Entidade;
import model.Usuario;


public enum SqlUtil {

	USUARIO_LOGIN("select a from Usuario a where a.login = :login and a.senha = :senha"),
	USUARIO_ADAPTER("select a from Usuario a where a.login = :login and a.senha = :senha"),
	LOG("Select a From Log a WHERE a.data = :data AND a.alteracao LIKE :alteracao");
	
	
	private String sql;

	private SqlUtil(String sql) {
		this.sql = sql;
	}

	@Override
	public String toString() {
		
		return sql;
	}

	public static String buscaPorBusca(Class<? extends Entidade> classe) {
		String sql = "SELECT a FROM " + classe.getName() + " a WHERE ";

		List<Field> fields = new ArrayList<>();
		if (classe.getSuperclass() != Entidade.class)
		{
			for(Field t : classe.getSuperclass().getDeclaredFields())
			{
				if(!t.getName().equalsIgnoreCase("serialVersionUID") && !t.getName().equalsIgnoreCase("sequence"))
					fields.add(t);
			}
		}
		for(Field t : classe.getDeclaredFields())
			if(!t.getName().equalsIgnoreCase("serialVersionUID") && !t.getName().equalsIgnoreCase("sequence"))
				fields.add(t);

		for (int i = 0; i < fields.size(); i++) {
			Field f = fields.get(i);

			if (i == fields.size() - 1)
				sql += "LOWER(str(a." + f.getName() + ")) LIKE :trocar ";
			else
				sql += "LOWER(str(a." + f.getName() + ")) LIKE :trocar OR ";
		}

		System.out.println(sql);
		return sql;
	}

	public static void main(String[] args) {
		
		buscaPorBusca(Aluno.class);
		
	}

	
	
}
