package livraria.controller;

import java.util.ArrayList;

import livraria.model.*;
import livraria.repository.Repositorio;

public class Controller implements Repositorio {

	public static ArrayList<Obra> acervo = new ArrayList<Obra>();	
	int codigo = 8;
	
	
	@Override
	public void procurarPorCodigo(int codigo) {
		var obra = buscarNaCollection(codigo);
		if (obra == null) {
			System.out.println("A Obra de código "+ codigo +" não foi encontrada!");
		} else {
			obra.visualizar();
		}
	}

	@Override
	public void listarTodas() {
		for (var obra: acervo) {
			obra.visualizar();
		}
	}

	@Override
	public void registrar(Obra obra) {
		acervo.add(obra);
		System.out.println("A Obra '" + obra.getTitulo() + "' foi registrada e atribuída ao código " + obra.getCodigo() + "!");
		
	}

	@Override
	public void atualizar(Obra obra) {
		var buscaObra = buscarNaCollection(obra.getCodigo());

		if (buscaObra == null) {
			System.out.println("A Obra de código "+ obra.getCodigo() +" não foi encontrada!");
		} else  {
			acervo.set(acervo.indexOf(buscaObra),obra);
			System.out.println("Os dados da Obra de código "+ obra.getCodigo() +" foi atualizada!");
		}
	}

	@Override
	public void excluir(int codigo) {
		var obra = buscarNaCollection(codigo);
		
		if (obra != null) {
			if (acervo.remove(obra) == true) 
				System.out.println("\nA Obra de código " + codigo + " foi deletada com sucesso!");
		} else 
			System.out.println("\nA Obra código "+ codigo + " não foi encontrada!");
	}

	public int gerarCod() {		
		return ++ codigo;
	}
	
	public Obra buscarNaCollection(int codigo) {
		for (var obra: acervo) {
			if (obra.getCodigo() == codigo) {
				return obra;
			}
		}
		return null;
	}
	
}
