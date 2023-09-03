package Smartphone.Telefone;

public class Contato implements Comparable<Contato>{
	private String nome;
	private int numero;
	
	public Contato(String nome, int numero) {
		this.nome = nome;
		this.numero=numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public int compareTo(Contato o) {
		// TODO Auto-generated method stub
		return this.nome.compareToIgnoreCase(o.getNome());
	}

	@Override
	public String toString() {
		return "\n[" + nome + "," + numero + "]";
	}
	
	
	
}
