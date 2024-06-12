package unlam.pb2.dominio;

import java.util.ArrayList;
import java.util.Iterator;

public class Sistema {
	
	private ArrayList <Empleado> empleados= new ArrayList<Empleado>();

	public void agregarEmpleado(Empleado tipoEmpleado) {
		empleados.add(tipoEmpleado);
	}

	public Integer cantidadTotalEmpleados() {
		Integer cantidadTotalEmpleados=0;
		
		for (int i = 0; i < empleados.size(); i++) {
			cantidadTotalEmpleados++;
		}
		
		return cantidadTotalEmpleados;
	}
	
}
