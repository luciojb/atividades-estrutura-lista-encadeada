package nodos;

public class Produto {
	public int cod, quantidade;
	public double preco;
	public Produto prox;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Produto [cod=");
		builder.append(cod);
		builder.append(", quantidade=");
		builder.append(quantidade);
		builder.append(", preco= R$");
		builder.append(String.format("%.2f", preco));
		builder.append("]");
		return builder.toString();
	}

	
}