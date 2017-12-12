package model;

public class Aluno {
	private String matricula;
	private String nome;
	private String email;
	private int idade;
	private String sexo;
	private String empresa;
	private String cidade;

	public Aluno(String matricula, String nome, String email, String idade, String sexo, String empresa,
			String cidade) {
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.idade = Integer.parseInt(idade);
		this.sexo = sexo;
		this.empresa = empresa;
		this.cidade = cidade;
	}

	public Aluno(String nome, String email, int idade, String cidade) {
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.cidade = cidade;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public int getIdade() {
		return idade;
	}

	public String getSexo() {
		return sexo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public String getCidade() {
		return cidade;
	}

	@Override
	public String toString() {
		return "Aluno [Matricula=" + matricula + ", Nome=" + nome + ", E-mail=" + email + ", Idade=" + idade + ", Sexo="
				+ sexo + ", Empresa=" + empresa + ", Cidade=" + cidade + "]";
	}

}