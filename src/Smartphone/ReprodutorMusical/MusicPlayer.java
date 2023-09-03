package Smartphone.ReprodutorMusical;

import java.util.ArrayList;
import java.util.List;

import ReprodutorMusical.ReprodutorMusical;


// Cria uma lista de reprodução implementando a interface ReprotorMusical para utilizar os metódos da mesma;
public class MusicPlayer implements ReprodutorMusical<Musica>{
	
	private PlayList musicaAtual;
	private PlayList First = null;
	private PlayList Last = null;
	
	public MusicPlayer(){
		this.musicaAtual = this.First;
	}
	
	@Override
	
	// Implementa o método tocar para tocas a musica
	public void tocar() {
		// TODO Auto-generated method stub
		if(musicaAtual == null && First == null && Last == null) {
			throw new RuntimeException("Nada na lista de reprodução");
		}
		System.out.println("Tocando: " + musicaAtual.getMusica().getNome() + "-" + musicaAtual.getMusica().getArtista());
	}

	@Override
	public void pausar() {
		// TODO Auto-generated method stub
		if(musicaAtual == null && First == null && Last == null) {
			throw new RuntimeException("Nada na lista de reprodução");
		}
		System.out.println("Pausando Música");
	}

	@Override
	// Implementa o metodo para selecionar a proxima musica da lista de reprodução
	public Musica selecionarProximaMusica() {
		if(this.musicaAtual.getNext() == null) {
			throw new RuntimeException("Sem musica para reproduzir");
		}
		this.musicaAtual = this.musicaAtual.getNext();
		return this.musicaAtual.getMusica();
	}

	@Override
	// Implementa o metodo para selecionar a musica anterior da lista de reprodução
	public Musica selecionarMusicaAnterior() {
		// TODO Auto-generated method stub
		if(this.musicaAtual.getPrev() == null) {
			throw new RuntimeException("Sem musica para reproduzir");
		}
		this.musicaAtual = this.musicaAtual.getPrev();
		return musicaAtual.getMusica();
	}

	
	// Implemantação do metodo add, para adicionar musicas a uma playlist.
	@Override
	public void adicionar(Musica musica) {
		// TODO Auto-generated method stub
		PlayList elemento = new PlayList(musica);
		
		if(First == null && Last == null) {
			this.musicaAtual = elemento;
			
			First = Last = musicaAtual;
			First.setPrev(null);
			Last.setPrev(null);
			First.setNext(null);
			Last.setNext(null);
		}else {
			Last.setNext(elemento);
			elemento.setPrev(Last);
			Last=elemento;
			First.setPrev(null);
			Last.setNext(null);
		}
	}

	// Vai exbir os itens na lista de reprodução
	public List<Musica> exibirLista() {
		if(musicaAtual == null && First == null && Last == null) {
			throw new RuntimeException("Lista Vazia");
		}
		
		List<Musica> musicas = new ArrayList<>();
		PlayList element = First;
		do {
			musicas.add(element.getMusica());
			element = element.getNext();
		}while(element != null);
		
		return musicas;
	}
	

}
