package unlam.pb2.dominio;

public class Gerente extends EmpleadoPlantaPermanente {

	private final Integer valorAntiguedadPorAnio=150;
	
	public Gerente(Boolean esCasado, Integer cuil, String razonSocial, Integer aniosAntiguedad, Integer cantidadHijos) {
		super(esCasado, cuil, razonSocial, aniosAntiguedad, cantidadHijos);
	}
	
	@Override
	protected Integer getCantidadPorHora() {
		return 400;
	}

	@Override
	protected Integer antiguedad() {
		return this.aniosAntiguedad*valorAntiguedadPorAnio ;
	}


}
