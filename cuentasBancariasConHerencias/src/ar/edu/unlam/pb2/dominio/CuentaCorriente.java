package ar.edu.unlam.pb2.dominio;

public class CuentaCorriente extends Cuenta{

	private Double descubierto;
	private Integer comision;
	
	public CuentaCorriente() {
		super();
		this.descubierto =150.0;
		this.comision = 5;
	}

	@Override
	public Boolean extraer(Double cantidadAExtraer) {

		Boolean sePudoExtraer=false;
		Double auxiliar=0.0;
		//operacion para saber con el descubierto podemos sacar la plata pensando en el porcentaje

		Double montoTotalDisponible=super.saldo + this.descubierto;
		Double cantidadTotalAExtraer=cantidadAExtraer + cantidadAExtraer*0.05;
		
		if(super.saldo>= cantidadAExtraer) {
			super.saldo-=cantidadAExtraer;
			sePudoExtraer=true;
		}else if(this.descubierto>=cantidadAExtraer && saldo==0) {
			auxiliar=(((cantidadAExtraer - super.saldo )* comision) / 100) + cantidadAExtraer;
			this.descubierto-= auxiliar;
			sePudoExtraer=true;
		}else if((montoTotalDisponible)>=(cantidadTotalAExtraer)) {
			saldo-=cantidadTotalAExtraer;
			descubierto-=Math.abs(saldo);
			saldo= saldo+ Math.abs(saldo);
			sePudoExtraer=true;
		}
		
		return sePudoExtraer;
	}

	public Double getDescubierto() {
		return this.descubierto;
	}
	
}
