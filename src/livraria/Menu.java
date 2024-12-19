package livraria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println("\n|===============================================|");
			System.out.println("|						|");
			System.out.println("|		LIVRARIA DOS ANJOS		|");
			System.out.println("|						|");
			System.out.println("|===============================================|");
			System.out.println("|						|");
			System.out.println("|	1 - Registrar Obra			|");
			System.out.println("|	2 - Listar Obras no Acervo		|");
			System.out.println("|	3 - Buscar Obra por código		|");
			System.out.println("|	4 - Atualizar dados da Obra		|");
			System.out.println("|	5 - Excluir Obra do acervo		|");
			System.out.println("|	6 - Sair				|");
			System.out.println("|						|");
			System.out.println("|===============================================|");
			System.out.print("Entre com a opção desejada: ");

			try {
				opcao = ler.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros.");
				ler.nextLine();
				opcao = 0;
			}

			switch (opcao) {

			case 1 -> {
				System.out.println("\nRegistrar Obra\n");
				apertarContinuar();
			}
			case 2 -> {
				System.out.println("\nListar todas as Obras do Acervo\n");
				apertarContinuar();
			}
			case 3 -> {
				System.out.println("\nBuscar por Código\n");
				apertarContinuar();
			}
			case 4 -> {
				System.out.println("\nAtualizar Dados\n");
				apertarContinuar();
			}
			case 5 -> {
				System.out.println("\nExcluir Obra\n");
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
