package Smartphone.Navegador;

import java.util.regex.Pattern;

import NavegadorInternet.NavegadorInternet;

public class Navegador implements NavegadorInternet{
	
	private String status = null;
	@Override
	public void exibirPagina(String url) {
		// TODO Auto-generated method stub
        boolean isMatch = Pattern.compile("^(https?:\\/\\/)?(?:www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b(?:[-a-zA-Z0-9()@:%_\\+.~#?&\\/=]*)$")
                .matcher(url)
                .find(); 
 
		if(url.isEmpty() || !isMatch) {
			throw new RuntimeException("Url inválida");
		}else {
			this.status = url;
			System.out.println("Acessando pagina "+ url);
		}
	}

	@Override
	public void adicionarNovaAba() {
		// TODO Auto-generated method stub
		System.out.println("Adicionado nova aba vazia");
		this.status = null;
	}

	@Override
	public void atualizarPagina() {
		// TODO Auto-generated method stub
		System.out.println();
		if(this.status == null) {
			System.out.println("Atualizando aba vazia");
		}else {
			System.out.println("Pagina " + this.status + " atualizada com sucesso");
		}
	}

}
