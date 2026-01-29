package br.com.lanhouse.sys.modelo;

public class Jogo implements Vendavel {
	private int id;
	private String titulo;
	private String plataforma;
	private double preco;
	
	public Jogo(int id, String titulo, String plataforma, double preco) {
		this.id = id;
		this.titulo = titulo;
		this.plataforma = plataforma;
		this.preco = preco;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	@Override
	
	public String toString() {
		return  "\nJogo: " + getTitulo() +
				"\nPlataforma " +getPlataforma();
	}

	@Override
	public boolean vender(int quantidade) {
		return false;
	}
}