package Smartphone.ReprodutorMusical;

public class PlayList {
	private Musica musica = null;
	private PlayList next = null;
	private PlayList prev = null;
	
	
	public PlayList(){}
	
	public PlayList(Musica musica) {
		this.musica = musica;
	}
	
	
	
	public Musica getMusica() {
		return musica;
	}
	public void setMusica(Musica musica) {
		this.musica = musica;
	}
	
	public PlayList getNext() {
		return next;
	}
	
	public void setNext(PlayList next) {
		this.next = next;
	}
	
	public PlayList getPrev() {
		return prev;
	}
	
	public void setPrev(PlayList prev) {
		this.prev = prev;
	}
	
	
	
	
}
