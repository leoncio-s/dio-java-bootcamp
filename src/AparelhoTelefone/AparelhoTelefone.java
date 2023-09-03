package AparelhoTelefone;

public interface AparelhoTelefone<T> {
	public void ligar(T contato);
	
	public void atender(T contato);
	
	public void iniciarCorreioDeVoz();
}
