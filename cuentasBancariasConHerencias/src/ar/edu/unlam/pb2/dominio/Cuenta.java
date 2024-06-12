package ar.edu.unlam.pb2.dominio;

public abstract class Cuenta {

	protected Double saldo;
	
	protected Cuenta() {
		this.saldo=0.0;
	}	
	
	public Boolean depositar(Double cantidadAIngresar) {

		Boolean sePudoDepositar=false;
		
		if(cantidadAIngresar>0) {
			
			this.saldo+=cantidadAIngresar;
			sePudoDepositar=true;
			
		}
		
		return sePudoDepositar;
	}

	public Double getSaldo() {
		return this.saldo;
	}
	
	public abstract Boolean extraer(Double cantidadAExtraer);

}
