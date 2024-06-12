package unlam.pb2.dominio;

public abstract class Empleado {

	private static final Integer salarioPorCantidadHijos = 200;
	protected Boolean esCasado;
	protected Integer cuil;
	protected String razonSocial;
	protected Integer aniosAntiguedad;
	protected Integer cantidadHijos;
	
	public Empleado(Boolean esCasado, Integer cuil, String razonSocial, Integer aniosAntiguedad,
			Integer cantidadHijos) {
		super();
		this.esCasado = esCasado;
		this.cuil = cuil;
		this.razonSocial = razonSocial;
		this.aniosAntiguedad = aniosAntiguedad;
		this.cantidadHijos = cantidadHijos;
	}

	protected abstract Integer getCantidadPorHora();
	
	protected Boolean esCasado() {
		return this.esCasado;
	}
	
	protected final Integer empleadoCasado() {
		return 100;
	}
	
	protected Integer salarioFamiliar() {
		return cantidadHijos*salarioPorCantidadHijos;
	}
	
	protected abstract Integer antiguedad();
	
	
	public Integer calcularSalario(Integer cantidadDeHoras) {
		
		Integer salario= antiguedad() + salarioFamiliar() + (getCantidadPorHora()*cantidadDeHoras);
		
		if(esCasado()) {
			salario+= empleadoCasado();
		}
		
		return salario;
	}

}
