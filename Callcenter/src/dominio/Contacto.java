package dominio;

import java.util.Objects;

public class Contacto {

	private String nombre, apellido, Email;
	private Integer celular, codigoAlfanumerico, codigoPostal, localidad;
	private Provincias provincia;
	private boolean deseaSerLlamadoNuevamente, esCliente;

	public Contacto(String nombre, String apellido, String email, Integer celular, Integer codigoAlfanumerico,
			Integer codigoPostal, Integer localidad, Provincias provincia) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.Email = email;
		this.celular = celular;
		this.codigoAlfanumerico = codigoAlfanumerico;
		this.codigoPostal = codigoPostal;
		this.localidad = localidad;
		this.provincia = provincia;
		this.deseaSerLlamadoNuevamente = true;
		this.esCliente = false;

	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return Email;
	}

	public Integer getCelular() {
		return celular;
	}

	public Integer getCodigoAlfanumerico() {
		return codigoAlfanumerico;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public Integer getLocalidad() {
		return localidad;
	}

	public Provincias getProvincia() {
		return provincia;
	}

	public boolean isDeseaSerLlamadoNuevamente() {
		return deseaSerLlamadoNuevamente;
	}

	public boolean isCliente() {
		return esCliente;
	}

	public void quieroSerCliente() {
		this.esCliente = true;
	}

	public void quieroDejarDeSerLlamado() {
		this.deseaSerLlamadoNuevamente = false;
	}

	public void quieroSerLlamado() {
		this.deseaSerLlamadoNuevamente = true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Email, apellido, celular, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		return Objects.equals(Email, other.Email) && Objects.equals(apellido, other.apellido)
				&& Objects.equals(celular, other.celular) && Objects.equals(nombre, other.nombre);
	}

}
