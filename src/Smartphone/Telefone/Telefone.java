package Smartphone.Telefone;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import AparelhoTelefone.AparelhoTelefone;

public class Telefone implements AparelhoTelefone<Contato>{
	
	// Colocado a agenda com o tipo static para compartilhar a mesma agenda, independente da aplicação
	private static Set<Contato> agenda = new TreeSet<>();
	
	@Override
	public void ligar(Contato contato) {
		// TODO Auto-generated method stub
		if(contato == null) {
			throw new RuntimeException("Sem dados de contato para completar a ligação");
		}else {
			Contato contatoAgenda = null;
			if(contato.getNome() != null) {
				contatoAgenda = this.getContatoAgendaByNome(contato.getNome());
			}else {
				contatoAgenda = this.getContatoAgendaByNumber(contato.getNumero());
			}
			
			if(contatoAgenda == null && contato.getNumero() != 0) {
				System.out.println("Ligando para: " + contato.getNumero());
			}else if(contatoAgenda != null) {
				System.out.println("Ligando para: " + contatoAgenda.getNome() + "-" + contatoAgenda.getNumero());
			}else {
				throw new RuntimeException("Contato inválido");
			}
			
		}
	}

	@Override
	public void atender(Contato contato) {
		if(contato.getNome().isEmpty() && contato.getNumero() == 0) {
			System.out.println("Atendendo ligação de número desconhecido");
		}
		
		Contato contatoAgenda = null;
		
		if(contato.getNome() != null || !contato.getNome().isEmpty()) {
			contatoAgenda = this.getContatoAgendaByNome(contato.getNome());
		}else {
			contatoAgenda = this.getContatoAgendaByNumber(contato.getNumero());
		}
		
		if(contatoAgenda == null && contato.getNumero() != 0) {
			System.out.println("Atendendo Ligação de " + contato.getNumero() );
		}else if(contatoAgenda != null ){
			System.out.println("Atendendo Ligação de " + ((contatoAgenda == null) ? contato.getNumero() : contatoAgenda.getNome() + "-" + contatoAgenda.getNumero()) );
		}else {
			throw new RuntimeException("Contato inválido");
		}
	}

	@Override
	public void iniciarCorreioDeVoz() {
		// TODO Auto-generated method stub
		System.out.println("Iniciando Correio de Voz");
	}
	
	public void agenda(){
		if(Telefone.agenda.size() == 0) {
			System.out.println("Agenda Vazia");
		}else {
			System.out.println(agenda);
		}
	}
	
	public void AdicionarContatoAgenda(String nome, int numero) {
		if(numero == 0) {
			throw new RuntimeException("Numéro inválido");
		}
		Contato contato = new Contato(nome, numero);
		
		Telefone.agenda.add(contato);
	}
	
	private Contato getContatoAgendaByNumber(int numero) {
		if(numero == 0) {
			throw new RuntimeException("Informe o nome ou número de telefone para pesquisar na agenda");
		}
		Iterator<Contato> agIt = Telefone.agenda.iterator();
		Contato retContato = null;
		
		while(agIt.hasNext()) {
			Contato toCompare = agIt.next();
			if(toCompare.getNumero() == numero) {
				retContato = toCompare;
				break;
			}
		}
		
		return retContato;
	}
	
	private Contato getContatoAgendaByNome(String nome) {
		if(nome.isEmpty()) {
			throw new RuntimeException("Informe o nome ou número de telefone para pesquisar na agenda");
		}
		Iterator<Contato> agIt = Telefone.agenda.iterator();
		Contato retContato = null;
		
		while(agIt.hasNext()) {
			Contato toCompare = agIt.next();
			if(toCompare.getNome().equalsIgnoreCase(nome)) {
				retContato = toCompare;
				break;
			}
		}
		
		return retContato;
	}
}
