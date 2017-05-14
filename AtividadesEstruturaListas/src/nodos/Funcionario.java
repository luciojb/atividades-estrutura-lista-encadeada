package nodos;

public class Funcionario {
	public String nome;
	public double salario;
	public Funcionario prox;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Funcionario [nome=");
		builder.append(nome);
		builder.append(", salario= R$");
		builder.append(String.format("%.2f", salario));
		builder.append("]");
		return builder.toString();
	}
	
	
}
