package br.com.lanhouse.sys.modelo;

public class JogoDigital extends Jogo implements Vendavel{
	private double tamanhoDownload;
	private String tipoLicenca;
	
	public JogoDigital(int id, String titulo, String plataforma, double preco, double tamanhoDownload, String tipoLicenca) {
		super(id, titulo, plataforma, preco);
		this.tamanhoDownload = tamanhoDownload;
		this.tipoLicenca = tipoLicenca;
	}
	
	public double getTamanhoDownload() {
		return tamanhoDownload;
	}

	public void setTamanhoDownload(double tamanhoDownload) {
		this.tamanhoDownload = tamanhoDownload;
	}

	public String getTipoLicenca() {
		return tipoLicenca;
	}

	public void setTipoLicenca(String tipoLicenca) {
		this.tipoLicenca = tipoLicenca;
	}

	@Override
	public boolean vender(int quantidade) {
		return true;
	}
	@Override
	public String toString() {
		return super.toString() +"\nPreco: " + 
	             "\nTamanho do download: " + getTamanhoDownload() + 
				"\nTipo de licença " + getTipoLicenca();
	}
	

}
