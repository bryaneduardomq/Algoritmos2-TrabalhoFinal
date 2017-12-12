package test;

import java.io.*;
import comparators.SearchByAgeAndCity;
import comparators.SearchByCompanyAndEmail;
import comparators.SearchByEmail;
import comparators.SearchByName;
import datastructures.ListaEncadeada;
import model.Aluno;

public class ProgramaC_Alunos {

	private static final String nome = "Parks Gilliam";
	private static final String email = "parksgilliam@fishland.com";
	private static final int idade = 34;
	private static final String cidade = "Mooresburg";
	private static final String empresa = "FISHLAND";

	public static void main(String[] args) throws Exception {

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("data/alunos.csv")));

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado" + e);
			System.exit(1);
		}

		ListaEncadeada<Aluno> lista = ListaEncadeada.loadFromFile();
		
		Aluno busca = new Aluno(nome, email, idade, cidade);
		System.out.println(lista.search(busca, new SearchByName()));
		System.out.println(lista.search(busca, new SearchByEmail()));
		System.out.println(lista.search(busca, new SearchByAgeAndCity()));
		
		//APS3
		Aluno procura = new Aluno(email, empresa);
		System.out.println(lista.search(procura, new SearchByCompanyAndEmail()));
	}

}
