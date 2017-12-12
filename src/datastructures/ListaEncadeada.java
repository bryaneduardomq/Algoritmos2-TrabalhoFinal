package datastructures;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import model.Aluno;

public class ListaEncadeada<T> {

	public class No {
		private T dado;
		private No proximo;
		private No anterior;
		
		
		//Construtor da classe
		public No(T dado) {
			this.dado = dado;
			this.proximo = proximo;
			this.anterior = anterior;
			}
		
		//Método para adicionar antes
		public void addBefore(T dado) {
			No novoNo = new No(dado);
			No anterior = this.anterior;
			novoNo.proximo = this;
			if (anterior == null) {
				head = novoNo;
			} else {
				anterior.proximo = novoNo;
			}
			this.anterior = novoNo;
		}
		
		//Método para adicionar depois
		public void addAfter(T dado) {
			No novoNo = new No(dado);
			No proximo = this.proximo;
			novoNo.anterior = this;
			if (proximo == null) {
				tail = novoNo;
			} else {
				proximo.anterior = novoNo;
			}
			this.proximo = novoNo;
		}

	}

	private No head;
	private No tail;
	
	//Método que verifica se a head da lista está vazia
	public boolean isEmpty() {
		return head == null;
	}

	public void addFirst(T dado) {
		No novo = new No(dado);
		if (head != null) {
			head.anterior = novo;
		} else {
			tail = novo;
		}
		novo.proximo = head;
		head = novo;
	}
	
	//Método que serve para adicionar um elemento à lista
	public void append(T dado) {
		No novo = new No(dado);
		if (tail != null) {
			tail.proximo = novo;
		} else {
			head = novo;
		}
		novo.anterior = tail;
		tail = novo;
	}

	public static <T> ListaEncadeada<T> loadFromFile() throws IOException {
		BufferedReader reader = null;
		String linha = null;
		int i = 0;
		ListaEncadeada lista = new ListaEncadeada<Aluno>();
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("data/alunos.csv")));

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado" + e);
		}

		while ((linha = reader.readLine()) != null) {
			String dadosAluno[] = linha.split(",");
			String matricula = dadosAluno[0];
			String nome = dadosAluno[1];
			String email = dadosAluno[2];
			String idade = dadosAluno[3];
			String sexo = dadosAluno[4];
			String empresa = dadosAluno[5];
			String cidade = dadosAluno[6];
			Aluno aluno = new Aluno(matricula, nome, email, idade, sexo, empresa, cidade);
			if (i == 0) {
				lista.addFirst(aluno);
			} else {
				lista.append(aluno);
			}
			i++;

		}
		reader.close();
		return lista;
	}

	// Cria um elemento temporário com a mesma referência da cabeça e percorre
	// todos os elementos
	// a procura de um nó da lista que tenha o elemento igual ao inserido no
	// método
	/*
	 * public int procura(T elemento){ No itr = head; int i = 0; for(itr = head;
	 * itr.proximo !=null; itr = itr.proximo) { if(itr.dado == elemento) return
	 * i; else i++; } return -1;//Caso não tenha encontrado o elemento }
	 */

	
	//Método para impressão dos elementos
	public T search(T key, Comparator<T> cmp) {

		return null;
	}
	
	//Método para impressão dos objetos
	public void printObjects() {
		ListaEncadeada<T>.No i = head;
		while (i != null) {
			System.out.println(i.dado);
			i = i.proximo;
		}
	}
}