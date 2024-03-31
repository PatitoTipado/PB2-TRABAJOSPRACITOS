package ar.edu.unlam.pb2.interfaz;

import ar.edu.unlam.pb2.dominio.*;
import java.util.Scanner;

public class TestSalaDeCine {
	private static Scanner teclado = new Scanner(System.in);
	private static Scanner teclado1 = new Scanner(System.in);

	public static void main(String[] args) {

		mostrarMensaje("Sala de cine");
		Integer filas = ingresarEnteroConMensaje("ingrese la cantidad de filas");
		Integer butacas = ingresarEnteroConMensaje("ingrese la cantidad de butacas");

		SalaDeCine cine = new SalaDeCine(filas, butacas);
		boolean salir = false;
		do {

			MenuPrincipal opcion = ingresarOpcionMenu();

			switch (opcion) {

			case CONSULTAR_SI_LA_SALA_ESTA_VACIA:
				mostrarMensaje("La sala de cine esta vacia: " + cine.consultarSiLaSalaEstaVacia());
				break;
			case CONSULTAR_SI_LA_BUTACA_ESPECIFICA_ESTA_VACIA:
				consultarSiEstaVacia(cine);
				break;
			case OCUPAR_BUTACA:
				ocuparButaca(cine);
				break;
			case CONSULTAR_CANTIDAD_DE_BUTACAS_OCUPADAS:
				consultarButacasOcupadas(cine);
				break;
			case CONSULTAR_CANTIDAD_BUTACAS_VACIAS:
				consultarButacasVacias(cine);
				break;
			case CONSULTAR_SI_SE_PUEDE_ACOMODAR_GRUPO_CONTINUO:
				consultarSiPuedeEntrarGrupo(cine);
				break;
			case VER_SALA_DE_CINE:
				verSalaDeCine(cine);
				break;
			case SALIR:
				if (deseaSalir()) {
					salir = true;
				}
				break;

			}

		} while (!salir);

		terminarElPrograma();
	}

	private static void consultarSiPuedeEntrarGrupo(SalaDeCine cine) {
		Integer fila = ingresarEnteroConMensaje("ingresar la fila");
		Integer butaca = ingresarEnteroConMensaje("ingresa desde la butaca que quiere empezar a contar");
		Integer cantidadContinua = ingresarEnteroConMensaje("ingrese la cantidad continua de personas");
		mostrarMensaje("Se puede acomodar seguidamente al grupo: "
				+ cine.sePuedeAcomodarContinuamente(fila, butaca, cantidadContinua));
	}

	private static void consultarButacasOcupadas(SalaDeCine cine) {
		mostrarMensaje("La cantidad de butacas ocupadas es de: " + cine.cantidadDeButacasTotalesOcupadas());
	}

	private static void consultarButacasVacias(SalaDeCine cine) {
		mostrarMensaje("La cantidad de butacas vacias es de: " + cine.cantidadDeButacasTotalesDisponibles());
	}

	private static void ocuparButaca(SalaDeCine cine) {
		Integer fila = ingresarEnteroConMensaje("ingresa la fila");
		Integer butaca = ingresarEnteroConMensaje("ingrese la butaca de la fila anteriormente seleccionada");
		mostrarMensaje("Pudo ocuparse:" + cine.utilizarButaca(fila, butaca));
	}

	private static void verSalaDeCine(SalaDeCine cine) {
		for (int i = 0; i < cine.getCantidadDeFilas(); i++) {
			System.out.print("\n\n" + (i + 1) + ". fila\n");
			for (int j = 0; j < cine.getCantidadDeColumnas(); j++) {
				System.out.print(cine.getButacasDeCine()[i][j]);
			}
		}
		mostrarMensaje("\n");
	}

	private static void consultarSiEstaVacia(SalaDeCine cine) {
		Integer fila = ingresarEnteroConMensaje("ingresa la fila");
		Integer butaca = ingresarEnteroConMensaje("ingrese la butaca de la fila anteriormente seleccionada");
		mostrarMensaje("la butaca esta vacia: " + cine.consultarSiLaButacaEstaVacia(fila, butaca));
	}

	private static MenuPrincipal ingresarOpcionMenu() {
		menu();
		Boolean salir = false;
		Integer numero = -1;

		do {
			numero = ingresarEnteroConMensaje("\ningresa una opcion");
			if (numero > 0 && numero < MenuPrincipal.values().length + 1) {
				salir = true;
			}

		} while (!salir);

		return MenuPrincipal.values()[numero - 1];
	}

	private static void terminarElPrograma() {
		mensajeSalir();
		teclado.close();
		teclado1.close();
	}

	private static boolean deseaSalir() {
		int numero = ingresarEnteroConMensaje(
				"Si desea salir ingrese 0 \nSi desea seguir ingrese cualquier otro numero");
		return numero == 0;
	}

	private static void menu() {
		for (int i = 0; i < MenuPrincipal.values().length; i++) {
			mostrarMensaje((i + 1) + ". " + MenuPrincipal.values()[i]);
		}
	}

	private static void mensajeSalir() {
		mostrarMensaje("Salio del menu");
		mostrarMensaje("\n\nGracias por usar la sala de cine");
	}

	/*
	 * private static String mensaje() { return teclado.next(); }
	 */

	private static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}

	private static void mostrarMensajeError(String mensaje) {
		System.err.println(mensaje);
	}

	private static int ingresarEnteroConMensaje(String mensaje) {
		mostrarMensaje(mensaje);
		while (!teclado.hasNextInt()) {
			mostrarMensaje(mensaje);
			mostrarMensajeError("Ingrese un numero entero");
			teclado.nextLine();
		}
		return teclado.nextInt();
	}

}
