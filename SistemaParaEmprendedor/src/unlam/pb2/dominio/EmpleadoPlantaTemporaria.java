package unlam.pb2.dominio;

public class EmpleadoPlantaTemporaria extends Empleado {

	public EmpleadoPlantaTemporaria(Boolean esCasado, Integer cuil, String razonSocial, Integer cantidadHijos) {
		super(esCasado, cuil, razonSocial, 0, cantidadHijos);
	}

	@Override
	protected Integer getCantidadPorHora() {
		return 200;
	}

	@Override
	protected Integer antiguedad() {
		return this.aniosAntiguedad;
	}

}
