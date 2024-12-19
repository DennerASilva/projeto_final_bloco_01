package livraria.model;

public abstract class Obra {
	private String titulo, editora;
	int tipo,codigo;

	public Obra( int tipo, String titulo, String editora, int codigo) {
		this.tipo = tipo;
		this.titulo = titulo;
		this.editora = editora;
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}
		
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void visualizar() {
		String tipo = "";
		
		switch (this.tipo) {
		case 1 -> tipo = "Livro";
		case 2 -> tipo = "Revista";			
		}
		
		System.out.println("\n\nInformações da Obra '" + this.titulo +"'\n");
		System.out.println("Tipo: " + tipo);
		System.out.println("Editora: " + this.editora);	
	}

}

