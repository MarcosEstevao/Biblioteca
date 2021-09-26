package biblioteca;

import java.util.Date;

import javax.swing.JOptionPane;

public class Emprestimo {
	private String tituloLivro;
	private String autorLivro;
	private Date dtEmprestimo;
	private Date dtDevolucao;
	private int numeroPaginas;
	private Aluno aluno;
	
	public Emprestimo() {
		
	}
	
	public Emprestimo(String nmLivro, Date dtEmprestimo, Aluno aluno, String nmAutorLivro, int qtPaginasLivro) {
		this.tituloLivro = nmLivro;
		this.autorLivro = nmAutorLivro;		
		this.numeroPaginas = qtPaginasLivro;
		this.aluno = aluno;
		this.dtEmprestimo = dtEmprestimo;	
		this.dtDevolucao = null;
		
	}
	
	public String getTituloLivro() {
		return tituloLivro;
	}
	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}
	public String getAutorLivro() {
		return autorLivro;
	}
	public void setAutorLivro(String autorLivro) {
		this.autorLivro = autorLivro;
	}
	public Date getDtDevolucao() {
		return dtDevolucao;
	}

	public void setDtDevolucao(Date dtDevolucao) {
		this.dtDevolucao = dtDevolucao;
	}

	public Date getDtEmprestimo() {
		return dtEmprestimo;
	}

	public void setDtEmprestimo(Date dtEmprestimo) {
		this.dtEmprestimo = dtEmprestimo;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}	
	public void visualizarDadosEmprestimo(Emprestimo emprestimo) {
		JOptionPane.showMessageDialog(null, "Título do livro: " +emprestimo.getTituloLivro()+
		"\n Autor do livro: " +emprestimo.getAutorLivro()+
		"\n Data do emprestimo: " +emprestimo.getDtEmprestimo()+
		"\n Número de páginas: " +emprestimo.getNumeroPaginas()+
		"\n O livro está em emprestimo com o aluno: " +emprestimo.aluno.getNomeAluno());
	}
	public void devolverLivro(Emprestimo emprestimo, Date dtDevolucao) {
		long diferencaMS = dtDevolucao.getTime() - dtEmprestimo.getTime();
	    long diferencaSegundos = diferencaMS / 1000;
	    long diferencaMinutos = diferencaSegundos / 60;
	    long diferencaHoras = diferencaMinutos / 60;
	    long diferencaDias = diferencaHoras / 24;
		
	    if(diferencaDias < 3) {
	    	limparDevolucao(emprestimo);
	    	JOptionPane.showMessageDialog(null,"Devolução realizada com sucesso");
	    } else {	
	    	String resposta;
	    	JOptionPane.showMessageDialog(null,"É necessário pagar uma multa para realizar a devolução "
	    			+ "\nO valor da multa é: R$" +(diferencaDias - 3) * 2);
	    	
	    	resposta = JOptionPane.showInputDialog("O Aluno pagou a multa? Digite a palavra 'Sim' caso a mesma foi paga.");	
	    	if (resposta.equalsIgnoreCase("sim")){
	    		limparDevolucao(emprestimo);
				JOptionPane.showMessageDialog(null,"Devolução realizada com sucesso");
	    	} else {
	    		JOptionPane.showMessageDialog(null,"Favor pagar a multa.");
	    	}
	    }	    	
	}
	public void limparDevolucao(Emprestimo emprestimo) {
		emprestimo.setTituloLivro("");
		emprestimo.setAutorLivro("");
		emprestimo.aluno.setNomeAluno("");
		emprestimo.setNumeroPaginas(0);
		emprestimo.aluno.setMatriculaAluno(0);
		emprestimo.setDtEmprestimo(null);	
		emprestimo.setDtDevolucao(null);
	}
}
