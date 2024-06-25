package ar.edu.unlam.pb2.dominio;

import java.util.*;

public class Inmoviliaria {

	private List <Propiedad> propiedades= new ArrayList<Propiedad>();
	private Set <Cliente> clientes = new LinkedHashSet<Cliente>();
	
	public Boolean agregarPropiedad(Propiedad nuevaPropiedad) {
		return propiedades.add(nuevaPropiedad);
	}
	
	public Propiedad buscarPorCodigoPropiedad(Integer codigo) {
		
		Propiedad PropiedadBuscada=null; 
		
		for (Propiedad propiedad : propiedades) {
			if(codigo.equals(propiedad.getCodigo())) {
				PropiedadBuscada= propiedad;
			}
		}
		
		return PropiedadBuscada;
	}
	
	public Boolean eliminarPorCodigo(Integer codigo) {
		
		Boolean sePudoEliminar=false;
		
		if(buscarPorCodigoPropiedad(codigo)!=null) {
			propiedades.remove(buscarPorCodigoPropiedad(codigo));
		}
		
		return sePudoEliminar;
	}
	
	public boolean agregarCliente(Cliente nuevoCliente) {
		return clientes.add(nuevoCliente);
	}
	
	public List<Propiedad> obtenerPropiedadesOrdenadasPorPrecio() {
		
		Collections.sort(propiedades, new PropiedadValorComparatorPorPrecio());
		
		return this.propiedades;
	}
	
	public List<Propiedad> obtenerPropiedadesOrdenadasPorUbicacion() {
		
		Collections.sort(propiedades, new PropiedadValorComparatorPorUbicacion());
		
		return this.propiedades;
	}

	public List<Propiedad> filtrarPorPrecio(Integer precio) {
		
		List <Propiedad> filtradaPorPrecio= new ArrayList<Propiedad> ();
	
		for (int i = 0; i < propiedades.size(); i++) {
			if(precio>propiedades.get(i).valor) {
				filtradaPorPrecio.add(propiedades.get(i));
			}
		}
		
		return filtradaPorPrecio;
	}
	
	public List<Propiedad> filtrarUbicacion(String ubicacion) {
		
		List <Propiedad> filtradaPorUbicacion= new ArrayList<Propiedad> ();
	
		for (int i = 0; i < propiedades.size(); i++) {
			if(ubicacion.equals(propiedades.get(i).getUbicacion())) {
				filtradaPorUbicacion.add(propiedades.get(i));
			}
		}
		
		return filtradaPorUbicacion;
	}

	public List<Propiedad> filtrarPorVenta() {
		
		List <Propiedad> filtradaPorVenta= new ArrayList<Propiedad> ();
	
		for (int i = 0; i < propiedades.size(); i++) {
			if((propiedades.get(i).getestaEnVenta())) {
				filtradaPorVenta.add(propiedades.get(i));
			}
		}
		
		return filtradaPorVenta;
	}

	public List<Propiedad> filtrarPorAlquiler() {
		
		List <Propiedad> filtradaPorVenta= new ArrayList<Propiedad> ();
	
		for (int i = 0; i < propiedades.size(); i++) {
			if((propiedades.get(i).getestaEnAlquiler())) {
				filtradaPorVenta.add(propiedades.get(i));
			}
		}
		
		return filtradaPorVenta;
	}
	
	public Boolean venderPropiedad(Cliente comprador, Integer codigoDePropiedad) {
		
		Boolean venderPropiedad=false;
		
		if(comprador==null || buscarPorCodigoPropiedad(codigoDePropiedad)==null) {
			return venderPropiedad;
		}
		
		//se que es fuerza bruta, pero no se me ocurrio otra forma en este momento
		for (Cliente cliente : clientes) {
			for (int i = 0; i < cliente.getPropiedades().size(); i++) {
				if(cliente.getPropiedades().get(i).equals(buscarPorCodigoPropiedad(codigoDePropiedad))) {
					//para la accion de vender debo adquirir el dinero y borra la propiedad de mi nombre
					cliente.cobrarPropiedad(cliente.getPropiedades().get(i).getValor());
					cliente.getPropiedades().remove(i);
					venderPropiedad=true;
				}
			}
		}
		
		//luego de tratar con el vendedor se la agregamos a el comprador y le restamos el saldo
		comprador.agregarPropiedad(buscarPorCodigoPropiedad(codigoDePropiedad));
		comprador.restarSaldo(buscarPorCodigoPropiedad(codigoDePropiedad).getValor());
		
		return venderPropiedad;
	}
	
	public Boolean alquilarPropiedad(Cliente alquilador, Integer codigoDePropiedad) {
		
		Boolean alquilarPropiedad=false;
		
		if(alquilador==null || buscarPorCodigoPropiedad(codigoDePropiedad)==null) {
			return alquilarPropiedad;
		}
				
		//luego de tratar con el vendedor se la agregamos a el comprador y le restamos el saldo
		if(buscarPorCodigoPropiedad(codigoDePropiedad).agregarInquilino(alquilador)) {
			alquilarPropiedad=true;
		}
		
		return alquilarPropiedad;
	}


}