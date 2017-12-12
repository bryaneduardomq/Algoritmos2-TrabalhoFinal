package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import comparators.SearchByAgeAndCity;
import comparators.SearchByEmail;
import comparators.SearchByName;
import datastructures.ListaEncadeada;
import model.Aluno;
import predicates.NamePredicate;

public class ProgramaB_Alunos {

	private static final String nome = "";
	private static final String email = "";
	private static final int idade = 0;
	private static final String cidade = "";

	public static void main(String[] args) throws IOException {
		BufferedReader reader = null;
		String linha = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("data/alunos.csv")));

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado" + e);
			System.exit(1);
		}

		ListaEncadeada<Aluno> lista = ListaEncadeada.loadFromFile();

		Aluno busca = new Aluno(nome, email, idade, cidade);

		System.out.println(lista.search(busca, new SearchByName()));
		// lista.removeIf(new NamePredicate(name));
		if (lista.search(busca, new SearchByName()) != null)
			System.out.println(nome + " nao deveria estar na lista.");

		System.out.println(lista.search(busca, new SearchByEmail()));
		System.out.println(lista.search(busca, new SearchByAgeAndCity()));
	}

}