package ar.edu.unlam.pb2.dominio;

public class Supermercado {

	private Double saldoSupermercado = 0.0;

	public Boolean comprar(Alicia alicia, Alimento alimento) throws NoPudoComprarloExeptions {

		if (alicia.getSaldo() >= alimento.getValor()) {
			alicia.pagarAlimento(alimento.getValor());
			this.cobrarAlimento(alimento.getValor());
			return alicia.adquirirAlimento(alimento);
		}
		throw new NoPudoComprarloExeptions();
	}

	private void cobrarAlimento(Double valor) {
		this.saldoSupermercado += valor;
	}

}
