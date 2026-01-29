package br.com.lanhouse.sys.modelo;

import br.com.lanhouse.sys.exceptions.PrecoInvalidoException;

public class JogoFisico extends Jogo implements Vendavel{
	private double peso;
	private int estoque;
	
	public JogoFisico(int id, String titulo, String plataforma, double preco, double peso, int estoque) {
		super(id, titulo, plataforma, preco);
		this.peso = peso;
		this.estoque = estoque;
		setPreco(preco);
	}
	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	@Override
	public void setPreco(double preco) throws PrecoInvalidoException{
		if(preco<0) {
			throw new PrecoInvalidoException("Preço negativo, tente novamente");
		}
		super.setPreco(preco);
	}
	public double calcularDesconto() {
		return (peso/100) * 0.01 * getPreco();
	}
	@Override
	public boolean vender(int quantidade) {
		if(quantidade>estoque) {
			return false;
		}
		this.estoque=estoque-quantidade;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + "\nPreco: " + getPreco() + "\nPeso Gramas: " + getPeso();
	}
}
