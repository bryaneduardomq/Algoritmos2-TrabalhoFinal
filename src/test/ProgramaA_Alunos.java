package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import datastructures.ListaEncadeada;
import model.Aluno;

public class ProgramaA_Alunos {

	public static void main(String[] args) {
		BufferedReader reader = null;
		String linha = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("data/alunos.csv")));

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado" + e);
			System.exit(0);
		}
		//ListaEncadeada<Aluno> lista = ListaEncadeada.loadFromFile(new OrdenaPorEmail());

		/*
		 * Iterador<Aluno> iterador = lista.iterador(); while
		 * (iterador.hasNext()) {
		 * System.out.println(iterador.next().getEmail());
		 */
	}
}

// }