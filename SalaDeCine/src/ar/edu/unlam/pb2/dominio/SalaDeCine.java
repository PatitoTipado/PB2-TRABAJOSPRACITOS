package ar.edu.unlam.pb2.dominio;

import java.util.Arrays;

public class SalaDeCine {

	private static final Integer VACIO = 0;
	private static final Integer UTILIZADA = 1;
	private Integer cantidadDeFilas;
	private Integer cantidadDeColumnas;
	private Integer butacasDeCine[][];

	public SalaDeCine(int cantidadDeFilas, int cantidadDeColumnas) {
		this.cantidadDeFilas = cantidadDeFilas;
		this.cantidadDeColumnas = cantidadDeColumnas; // son cosas que usare despues
		this.butacasDeCine = new Integer[this.cantidadDeFilas][this.cantidadDeColumnas];
		prepararButacas();
	}

	private void prepararButacas() {
		for (int i = 0; i < this.cantidadDeFilas; i++) {
			for (int j = 0; j < this.cantidadDeColumnas; j++) {
				butacasDeCine[i][j] = VACIO;
			}

		}
	}

	public Boolean consultarSiLaSalaEstaVacia() {

		Boolean estaVacia = true;
		Integer i = 0;
		Integer j = 0;

		while (estaVacia && this.cantidadDeFilas > i) {
			while (estaVacia && this.cantidadDeColumnas > j) {

				if ((this.butacasDeCine[i][j].equals(UTILIZADA))) {
					estaVacia = false;
				}

				j++;

			}
			i++;

		}

		return estaVacia;
	}

	public Boolean consultarSiLaButacaEstaVacia(Integer filaConsultada, Integer columnaConsultada) {

		Boolean estaVacia = false;

		if (siEstaDentroDelParametro(filaConsultada, columnaConsultada)
				&& this.butacasDeCine[filaConsultada][columnaConsultada].equals(VACIO)) {
			estaVacia = true;
		}

		return estaVacia;
	}

	private boolean siEstaDentroDelParametro(int filaConsultada, int columnaConsultada) {

		Boolean dentroDelParametro = false;

		if (filaConsultada > -1 && filaConsultada < cantidadDeFilas && columnaConsultada > -1
				&& columnaConsultada < this.cantidadDeColumnas) {
			dentroDelParametro = true;
		}

		return dentroDelParametro;
	}

	public Boolean utilizarButaca(Integer fila, Integer butaca) {

		Boolean sePudoUtilizar = false;

		if (consultarSiLaButacaEstaVacia(fila, butaca)) {
			this.butacasDeCine[fila][butaca] = UTILIZADA;
			sePudoUtilizar = true;
		}

		return sePudoUtilizar;
	}

	public Boolean sePuedeAcomodarContinuamente(Integer fila, Integer butaca, Integer cantidadContinua) {

		Boolean sePuedeAcomodarlos = false;
		Integer auxiliar = butaca;

		if (this.siEstaDentroDelParametro(fila, butaca)) {

			sePuedeAcomodarlos = true;

			for (int i = 0; i < cantidadContinua && sePuedeAcomodarlos; i++) {

				if (this.consultarSiLaButacaEstaVacia(fila, auxiliar)) {
					sePuedeAcomodarlos = true;
				} else {
					sePuedeAcomodarlos = false;
				}

				auxiliar++;
			}
		}

		return sePuedeAcomodarlos;
	}

	public Integer cantidadDeButacasTotalesDisponibles() {
		Integer butacasDisponibles = 0;

		for (int i = 0; i < butacasDeCine.length; i++) {
			for (int j = 0; j < butacasDeCine.length; j++) {

				if (this.butacasDeCine[i][j].equals(VACIO)) {
					butacasDisponibles++;
				}

			}
		}

		return butacasDisponibles;
	}

	//TODO: me falta este solo 
	public Integer cantidadDeButacasTotalesOcupadas() {
		Integer butacasOcupadas = 0;

		for (int i = 0; i < butacasDeCine.length; i++) {
			for (int j = 0; j < butacasDeCine.length; j++) {

				if (this.butacasDeCine[i][j].equals(UTILIZADA)) {
					butacasOcupadas++;
				}

			}
		}

		return butacasOcupadas;
	}

	public Integer getCantidadDeFilas() {
		return cantidadDeFilas;
	}

	public Integer getCantidadDeColumnas() {
		return cantidadDeColumnas;
	}

	public static Integer getVacio() {
		return VACIO;
	}

	public static Integer getUtilizada() {
		return UTILIZADA;
	}

	public Integer[][] getButacasDeCine() {
		return butacasDeCine;
	}

	@Override
	public String toString() {
		return "SalaDeCine [cantidadDeFilas=" + cantidadDeFilas + ", cantidadDeColumnas=" + cantidadDeColumnas
				+ ", butacasDeCine=" + Arrays.toString(butacasDeCine) + "]";
	}
}
