package livraria;

import java.io.IOException;
import java.util.InputMismatchException;

import java.util.Scanner;
import livraria.model.*;
import livraria.controller.*;

public class Menu {

	public static Scanner ler = new Scanner(System.in);
	public static String titulo, editora, autor, genero = "", mes = "";
	public static int tipo, codigo, generoInt, mesInt, volume, ano;

	public static void main(String[] args) {

		Controller comando = new Controller();

		int opcao;
		
		Controller.acervo.add(new Livro(1, "A Máquina de Xadrez", "Record", 1, "Robert Lohr", 1));
		Controller.acervo.add(new Revista(2, "Monstros e Perigos", "Dragão Brasil", 12, 2022, 189, 2));
		Controller.acervo.add(new Livro(1, "O Chamado De Cthulhu", "Principis", 5, "H.P. Lovecraft", 3));
		Controller.acervo.add(new Livro(1, "O Manipulador", "Rocco", 5, "John Grisham", 4));
		Controller.acervo.add(new Livro(1, "Canção dos Ossos", "Galera", 2, "Giu Domingues", 5));
		Controller.acervo.add(new Revista(2, "O Fator Saúde", "Veja", 12, 2024, 2923, 6));
		Controller.acervo.add(new Revista(2, "E Agora?", "Veja", 11, 2024, 2918, 7));
		Controller.acervo.add(new Revista(2, "Amor Brasileiro", "Forbes LifeFashion", 10, 2024, 7, 8));
		
		while (true) {

			System.out.println("\n|===============================================|");
			System.out.println("|						|");
			System.out.println("|		LIVRARIA DOS ANJOS		|");
			System.out.println("|						|");
			System.out.println("|===============================================|");
			System.out.println("|						|");
			System.out.println("|	1 - Registrar Obra			|");
			System.out.println("|	2 - Listar Todas as Obras no Acervo	|");
			System.out.println("|	3 - Buscar Obra por código		|");
			System.out.println("|	4 - Atualizar dados da Obra		|");
			System.out.println("|	5 - Excluir Obra do acervo		|");
			System.out.println("|	6 - Sair				|");
			System.out.println("|						|");
			System.out.println("|===============================================|");
			System.out.print("	Entre com a opção desejada: ");

			try {
				opcao = ler.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros.");
				ler.nextLine();
				opcao = 0;
			}
			System.out.println("=================================================");
			switch (opcao) {

			case 1 -> {
				System.out.println("\nRegistrar Obra\n");

				do {
					System.out.print("Digite o tipo da obra a ser registrada (1- Livro ou 2- Revista): ");
					tipo = ler.nextInt();
				} while (tipo < 1 && tipo > 2);
				System.out.print("Digite o título desta obra: ");
				ler.skip("\\R?");
				titulo = ler.nextLine();
				System.out.print("Digite a editora desta obra: ");
				ler.skip("\\R?");
				editora = ler.nextLine();
				switch (tipo) {
				case 1 -> {
					System.out.print("Digite o autor do livro: ");
					ler.skip("\\R?");
					autor = ler.nextLine();
					System.out.println("Digite o código do gênero do livro: ");
					System.out.println(
							"(1- Romance, 2 - Fantasia, 3- Drama, 4- Ação e Aventura, 5- Autoajuda e Motivacional, 6- Outros)");
					ler.skip("\\R?");
					generoInt = ler.nextInt();

					comando.registrar(new Livro(tipo, titulo, editora, generoInt, autor, comando.gerarCod()));

				}

				case 2 -> {
					System.out.print("Digite o número de Volume da revista: ");
					volume = ler.nextInt();
					System.out.print("Digite o mês de publicação da revista em números (Jan =1, Fev = 2, etc.) : ");
					mesInt = ler.nextInt();
					System.out.print("Digite o ano de publicação da revista: ");
					ano = ler.nextInt();

					comando.registrar(new Revista(tipo, titulo, editora, mesInt, ano, volume, comando.gerarCod()));

				}

				}
				apertarContinuar();
			}
			case 2 -> {
				System.out.println("\nListar todas as Obras do Acervo\n");
				comando.listarTodas();
				apertarContinuar();
			}
			case 3 -> {
				System.out.println("\nBuscar por Código\n");

				System.out.print("Digite o código da Obra a ser encontrada: ");
				codigo = ler.nextInt();

				comando.procurarPorCodigo(codigo);

				apertarContinuar();
			}
			case 4 -> {
				System.out.println("\nAtualizar Dados\n");
				System.out.print("Digite o código da Obra a ser atualizada: ");
				codigo = ler.nextInt();
				var buscaObra = comando.buscarNaCollection(codigo);

				if (buscaObra == null) {
					System.out.println("A Obra de código " + codigo + " não foi encontrada!");
				} else {
					do {
						System.out.print("Digite o tipo da obra(1- Livro ou 2- Revista): ");
						tipo = ler.nextInt();
					} while (tipo < 1 && tipo > 2);
					System.out.print("Digite o título desta obra: ");
					ler.skip("\\R?");
					titulo = ler.nextLine();
					System.out.print("Digite a editora desta obra: ");
					ler.skip("\\R?");
					editora = ler.nextLine();
					switch (tipo) {
					case 1 -> {
						System.out.print("Digite o autor do livro: ");
						ler.skip("\\R?");
						autor = ler.nextLine();
						System.out.println("Digite o código do gênero do livro: ");
						System.out.println(
								"(1- Romance, 2 - Fantasia, 3- Drama, 4- Ação e Aventura, 5- Autoajuda e Motivacional, 6- Outros)");
						ler.skip("\\R?");
						generoInt = ler.nextInt();

						comando.atualizar(new Livro(tipo, titulo, editora, generoInt, autor, codigo));

					}

					case 2 -> {
						System.out.print("Digite o número de Volume da revista: ");
						volume = ler.nextInt();
						System.out.print("Digite o mês de publicação da revista em números (Jan =1, Fev = 2, etc.) : ");
						mesInt = ler.nextInt();
						System.out.print("Digite o ano de publicação da revista: ");
						ano = ler.nextInt();

						comando.atualizar(new Revista(tipo, titulo, editora, mesInt, ano, volume, codigo));
					}
					}
				}
				apertarContinuar();
			}
			case 5 -> {
				System.out.println("\nExcluir Obra\n");
				
				System.out.println("Digite o código da Obra a ser excluída: ");
				codigo = ler.nextInt();
				
				var buscaObra = comando.buscarNaCollection(codigo);

				if (buscaObra == null) {
					System.out.println("A Obra de código " + codigo + " não foi encontrada!");
				} else {comando.excluir(codigo);}
				
				apertarContinuar();
			}
			case 6 -> {
				System.out.println("\nObrigado por vir!\n");
				System.out.println("|===============================================|");
				System.out.println("|  LIVRARIA DOS ANJOS: Onde ler é o Paraíso	|");
				sobre();
				ler.close();
				System.exit(0);
			}
			default -> System.out.println("\nOpção inválida. Tente novamente.");
			}
		}
	}

	public static void sobre() {

		System.out.println("|===============================================|");
		System.out.println("|Projeto Desenvolvido por:			|");
		System.out.println("|Denner A M Silva - denner.a.moura.s@gmail.com	|");
		System.out.println("|github.com/DennerASilva			|");
		System.out.println("|===============================================|");
	}

	public static void apertarContinuar() {
		try {
			System.out.println("\nPressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferentes de Enter!");
		}
	}
}
