package livraria.model;

public class Revista extends Obra{

	private int mes, ano, volume;
	
	public Revista(int tipo, String titulo, String editora, int mes, int ano, int volume, int codigo) {
		super(tipo, titulo, editora,codigo);
		
		this.mes = mes;
		this.ano = ano;
		this.volume = volume;
	}


	public void visualizar() {
		
		String mes = ""; 
		
		switch (this.mes) {
		case 1 -> mes = "Jan";
		case 2 -> mes = "Fev";
		case 3 -> mes = "Mar";
		case 4 -> mes = "Abr";
		case 5 -> mes = "Mai";
		case 6 -> mes = "Jun";
		case 7 -> mes = "Jul";
		case 8 -> mes = "Ago";
		case 9 -> mes = "Set";
		case 10 -> mes = "Out";
		case 11 -> mes = "Nov";
		case 12 -> mes = "Dez";
		
		}
		
		super.visualizar();
		System.out.println("Vol.: " + this.volume + ". Data: "+ mes + "/" + this.ano);
		System.out.println("Código Interno: " + this.codigo);
	}
}
