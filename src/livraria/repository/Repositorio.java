package livraria.repository;

import livraria.model.Obra;

public interface Repositorio {
	
	//CRUD
	public void procurarPorCodigo(int codigo);
	public void listarTodas();
	public void registrar(Obra obra);
	public void atualizar(Obra obra);
	public void excluir(int codigo);

}
