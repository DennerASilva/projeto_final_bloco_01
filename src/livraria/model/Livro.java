package livraria.model;

public class Livro extends Obra{

	private int genero;
	private String autor;

	public Livro(int tipo, String titulo, String editora, int genero, String autor, int codigo) {
		super(tipo, titulo, editora,codigo);
		this.genero = genero;
		this.autor = autor;
	}

	public int getGenero() {
		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void visualizar() {
		String genero = "";
		switch (this.genero) {
		case 1: {
			genero = "Romance";
			break;
		}
		case 2: {
			genero = "Fantasia";
			break;
		}
		case 3: {
			genero = "Drama";
			break;
		}
		case 4: {
			genero = "Ação e Aventura";
			break;
		}
		case 5: {
			genero = "Suspense";
			break;
		}
		case 6: {
			genero = "Outros";
			break;
		}
			
		}
		super.visualizar();
		System.out.println("Autor: " + this.autor);
		System.out.println("Gênero do Livro: " + genero);
		System.out.println("Código Interno: " + this.codigo+"\n");
	}

}
