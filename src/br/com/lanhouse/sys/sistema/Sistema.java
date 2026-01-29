package br.com.lanhouse.sys.sistema;
import br.com.lanhouse.sys.exceptions.PrecoInvalidoException;
import br.com.lanhouse.sys.modelo.*;
import br.com.lanhouse.sys.teclado.Teclado;

public class Sistema {
	public static void main(String[] args) {
		Jogo[] jogos = new Jogo[10];
		int op;
		do {
			System.out.println("\n--Sistema de gerenciamento de jogos--");
			System.out.println("\n1- Cadastrar");
			System.out.println("\n2- Realizar venda");
			System.out.println("\n3- Listar jogos");
			System.out.println("\n4- Sair");
		    op=Teclado.lerInteiro("\nDigite uma opção");
		    switch(op) {
		    case 1:
		    	cadastrar(jogos);
		    	break;
		    case 2:
		    	venda(jogos);
		    	break;
		    case 3:
		    	listar(jogos);
		    	break;
		    case 4:
		    	System.out.println("Encerrando o programa");
		    	System.exit(op);
		    default:
		    	System.out.println("Opção inválida digite novamente");
		    }
		} while(op!=5);
	}
	private static void cadastrar(Jogo[] jogos) {
		int tipojogo=Teclado.lerInteiro("Digite 1- Jogo físico ou 2- Jogo Digital");
		if(tipojogo!=1 && tipojogo!=2) {
			System.out.println("Opção inválida, digite novamente");
		}
		else {
		int id = Teclado.lerInteiro("Digite o id do jogo");
		String titulo=Teclado.lerString("Digite o nome do jogo");
		String plataforma=Teclado.lerString("Digite o nome da plataforma");
		double preco=Teclado.lerDouble("Digite o preço");
		if(tipojogo==1) {
			double peso=Teclado.lerDouble("Digite o peso do jogo em gramas");
			int estoque=Teclado.lerInteiro("Digite a quantidade em estoque");
		    try {
		    	JogoFisico fisico = new JogoFisico(id, titulo, plataforma, preco, peso, estoque);
		    	fisico.setPreco(fisico.calcularDesconto());
		    	for(int i=0;i<jogos.length;i++) {
				if(jogos[i]==null) {
					jogos[i]=fisico;
					System.out.println("Jogo cadastrado com sucesso");
					return;
				}
				System.out.println("Limite atingido");
			}
		} catch (PrecoInvalidoException e) {
			System.out.println("Erro no cadastramento do jogo físico " + e.getMessage());
		   }
		}
		else { 
			double tamanhoDownload=Teclado.lerDouble("Digite o tamanho do download");
			String tipoLicenca=Teclado.lerString("Digite qual é o tipo de licença");
			try {
				JogoDigital digital = new JogoDigital(id, titulo, plataforma, preco, tamanhoDownload, tipoLicenca);
				for(int i=0;i<jogos.length;i++) {
					if(jogos[i]==null) {
						jogos[i]=digital;
						System.out.println("Jogo digital cadastrado com sucesso");
						return; 
					}
					System.out.println("Limite atingido");
				}
			} catch (PrecoInvalidoException e) {
				System.out.println("Erro para cadastrar jogo digital " + e.getMessage());
			}
		}
	   }
	}
		
	private static void venda(Jogo[] jogos) {
		if(jogos[0]==null) {
			System.out.println("Nenhum jogo cadastado, cadastre primeiro");
		}
		else {
			int id=Teclado.lerInteiro("Digite o id do jogo para pesquisa");	
			int quantidade=Teclado.lerInteiro("Digite a quantidade de jogos a serem vendidos");
			for(int i=0;i<jogos.length;i++) {
				if(jogos[i]!=null && jogos[i].getId()==id) {
					if(jogos[i].vender(quantidade)) {
						System.out.println("Venda realizada com sucesso ");
					}
					else {
						System.out.println("Quantidade insuficiente em estoque");
						}
					}
				}
			}
	}
	private static void listar(Jogo[] jogos) {
		if(jogos[0]==null) {
			System.out.println("Nenhum jogo cadastrado, cadastre primeiro");
		}
		else {
		System.out.println("Listando os jogos cadastrados"); 
		for(int i=0;i<jogos.length;i++) {
			if(jogos[i]!=null) {
				System.out.println(jogos[i]);
			}
		 }
	   }
	}
}