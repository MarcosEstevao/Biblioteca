package biblioteca;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Biblioteca {
	 public static void main(String[] args) throws HeadlessException, ParseException {
		 int escolha = 1;
		 Emprestimo emprestimo = new Emprestimo();
		  do {
			 Menu();
			 escolha = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor"));			 
			 switch (escolha) {			
			 	case 1:
		 			emprestimo = cadastrarEmprestimo();
		 			break;
		 		case 2:
		 			emprestimo.visualizarDadosEmprestimo(emprestimo);	
		 			break;
		 		case 3:
		 			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		 			Date dataDevolucao = formato.parse(JOptionPane.showInputDialog("Informe a data de devolução"));
		 			emprestimo.devolverLivro(emprestimo, dataDevolucao);
		 			break;
		 		case 0:
		 			break;
		 		default:
		 			JOptionPane.showMessageDialog(null, "Favor informar um valor de acordo com o menu");
		 			break;
		 			
		 	}
		 } while (escolha != 0);
	 }
	 
	 public static Emprestimo cadastrarEmprestimo() throws HeadlessException, ParseException{		 	
	 		JOptionPane.showMessageDialog(null, "Informe o os dados do emprestimo");
	 		String nmAluno = JOptionPane.showInputDialog("Nome do Aluno: ");
	 		int matriculaAluno = Integer.parseInt(JOptionPane.showInputDialog("Número da Matrícula"));
	 		String nmLivro = JOptionPane.showInputDialog("Nome do livro");
	 		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
	 		Date dtEmprestimo = formato.parse(JOptionPane.showInputDialog("Data do emprestimo"));	 			 		
	 		String nmAutorLivro = JOptionPane.showInputDialog("Nome do autor");
	 		int qtPaginasLivro = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de páginas"));
	 		Aluno aluno = new Aluno(nmAluno, matriculaAluno);
	 		Emprestimo emprestimo = new Emprestimo(nmLivro, dtEmprestimo, aluno, nmAutorLivro, qtPaginasLivro);
	 		return emprestimo;
	 }
	 
	 public static void Menu() {	 
		 JOptionPane.showMessageDialog(null, "Bem vindo ao sistema, Favor entra com os dados: " + "\n" +
		 "1 para Realizar um novo emprestimo" + "\n" +
		 "2 para Visualizar os dados do emprestimo" + "\n" +
		 "3 Para Devolver o emprestimo" + "\n" +
		 "0 Para sair do sistema");
		 
	 }
}
