package ar.edu.unlam.pb2.dominio;

public class CajaDeAhorro extends Cuenta{
	
	private Integer cantidadDeVecesQueSacoDinero=0;
	
	public CajaDeAhorro() {
		super();
	}

	@Override
	public Boolean extraer(Double cantidadAExtraer) {

		Boolean extraccion=false;
		
		if(this.saldo >= cantidadAExtraer) {
			extraccion=true;
			saldo-=cantidadAExtraer;
			cantidadDeVecesQueSacoDinero++;
		}
		if(this.cantidadDeVecesQueSacoDinero>=6) {
			saldo-=6;
		}
		
		return extraccion;
	}

}
