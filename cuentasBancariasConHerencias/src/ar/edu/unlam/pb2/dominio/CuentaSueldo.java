package ar.edu.unlam.pb2.dominio;

public class CuentaSueldo extends Cuenta {

	public CuentaSueldo() {
		super();
	}

	@Override
	public Boolean extraer(Double cantidadAExtraer) {

		Boolean extraccion=false;
		
		if(this.saldo >= cantidadAExtraer) {
			extraccion=true;
			saldo-=cantidadAExtraer;
		}
		
		return extraccion;
	}
	
}
