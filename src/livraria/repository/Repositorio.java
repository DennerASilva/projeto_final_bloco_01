package livraria.repository;

import livraria.model.Obra;

public interface Repositorio {
	
	//CRUD
	public void procurarPorCodigo(int numero);
	public void listarTodas();
	public void cadastrar(Obra conta);
	public void atualizar(Obra conta);
	public void deletar(int numero);

}
