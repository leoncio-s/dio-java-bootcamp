package Smartphone;

import Smartphone.Navegador.Navegador;
import Smartphone.ReprodutorMusical.MusicPlayer;
import Smartphone.ReprodutorMusical.Musica;
import Smartphone.Telefone.Contato;
import Smartphone.Telefone.Telefone;

public class Iphone {
	
	private static void iPod() {
		MusicPlayer player = new MusicPlayer();

		player.adicionar(new Musica("Musica 1", "Artista 1", 3.20));
		player.adicionar(new Musica("Musica 2", "Artista 1", 3.20));
		player.adicionar(new Musica("Musica 3", "Artista 3", 3.20));
		player.adicionar(new Musica("Musica 4", "Artista 1", 3.20));
		player.adicionar(new Musica("Musica 5", "Artista 1", 3.20));
		player.adicionar(new Musica("Musica 6", "Artista 2", 3.20));
		player.adicionar(new Musica("Musica 7", "Artista 2", 3.20));
		player.adicionar(new Musica("Musica 1", "Artista 1", 3.20));

		System.out.println(player.exibirLista());
		
		player.tocar();
		
		player.pausar();
		
		System.out.println("Proxima musica: " + player.selecionarProximaMusica());
		System.out.println("Proxima musica: " + player.selecionarProximaMusica());
		System.out.println("Proxima musica: " + player.selecionarProximaMusica());
		System.out.println("Proxima musica: " + player.selecionarProximaMusica());
		System.out.println("Proxima musica: " + player.selecionarProximaMusica());
		
		System.out.println("Voltando para: " + player.selecionarMusicaAnterior());
		
		player.tocar();
		
		System.out.println(player.exibirLista());
	}
	
	private static void telefone() {
		Telefone telefone = new Telefone();
		
		telefone.ligar(new Contato(null, 3220));
		telefone.agenda();
		telefone.AdicionarContatoAgenda("João", 3220);
		telefone.AdicionarContatoAgenda("Pedro", 4340);
		telefone.AdicionarContatoAgenda("José", 5230);
		
		telefone.agenda();
		telefone.ligar(new Contato(null, 3220));
		
		telefone.atender(new Contato("Pedro", 3220));
		
		telefone.iniciarCorreioDeVoz();
	}
	
	private static void navegador() {
		Navegador navegador = new Navegador();
		
		navegador.adicionarNovaAba();
		
		navegador.exibirPagina("google.com.br");
		
		navegador.atualizarPagina();
		
		navegador.adicionarNovaAba();
		
		navegador.atualizarPagina();
		
		navegador.exibirPagina("TESTE"); // retorna RuntimeException
		
//		navegador.exibirPagina(null); // retorna NullPointerException
		
	}
	
	public static void main(String[] arg) {
		
		System.out.println("---------------------IPOD-----------------------");
		iPod();
		System.out.println("-------------------TELEFONE---------------------");
		telefone();
		System.out.println("------------------NAVEGADOR---------------------");
		navegador();
	}
}
