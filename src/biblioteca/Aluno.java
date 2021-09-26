package biblioteca;


public class Aluno {

	private String nomeAluno;
	private int matriculaAluno;
		
	public Aluno(int matricula) {
		this.nomeAluno = null;
		this.matriculaAluno = matricula;
	}
	
	public Aluno(String nome, int matricula) {
		this.nomeAluno = nome;
		this.matriculaAluno = matricula;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public int getMatriculaAluno() {
		return matriculaAluno;
	}

	public void setMatriculaAluno(int matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}
	
	public void visualizarDadosAluno() {
		System.out.println("Nome do aluno: " +nomeAluno + "\n" + "Matricula Aluno: " +matriculaAluno);
	}
}

