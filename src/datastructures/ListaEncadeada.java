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
		
		//M�todo para adicionar antes
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
		
		//M�todo para adicionar depois
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
	
	//M�todo que verifica se a head da lista est� vazia
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
	
	//M�todo que serve para adicionar um elemento � lista
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
			System.out.println("Arquivo n�o encontrado" + e);
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

	// Cria um elemento tempor�rio com a mesma refer�ncia da cabe�a e percorre
	// todos os elementos
	// a procura de um n� da lista que tenha o elemento igual ao inserido no
	// m�todo
	/*
	 * public int procura(T elemento){ No itr = head; int i = 0; for(itr = head;
	 * itr.proximo !=null; itr = itr.proximo) { if(itr.dado == elemento) return
	 * i; else i++; } return -1;//Caso n�o tenha encontrado o elemento }
	 */

	
	//M�todo para impress�o dos elementos
	public T search(T key, Comparator<T> cmp) {

		return null;
	}
	
	//M�todo para impress�o dos objetos
	public void printObjects() {
		ListaEncadeada<T>.No i = head;
		while (i != null) {
			System.out.println(i.dado);
			i = i.proximo;
		}
	}
}