package unlam.pb2.dominio;

public class EmpleadoPlantaPermanente extends Empleado{
	
	private final Integer valorAntiguedadPorAnio=100;

	public EmpleadoPlantaPermanente(Boolean esCasado, Integer cuil, String razonSocial, Integer aniosAntiguedad,
			Integer cantidadHijos) {
		super(esCasado, cuil, razonSocial, aniosAntiguedad, cantidadHijos);
	}

	@Override
	protected Integer getCantidadPorHora() {
		return 300;
	}

	@Override
	protected Integer antiguedad() {
		return this.aniosAntiguedad*valorAntiguedadPorAnio ;
	}

}
