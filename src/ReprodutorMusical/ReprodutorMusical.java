package ReprodutorMusical;

public interface ReprodutorMusical<T> {
	
	public void tocar();
	
	public void pausar();
	
	public T selecionarProximaMusica();
	
	public T selecionarMusicaAnterior();
	
	public void adicionar(T musica);
	
	
}
