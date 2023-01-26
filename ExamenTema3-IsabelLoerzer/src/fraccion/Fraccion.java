package fraccion;

// Clase que define una fracción
/**Clase que define una fracción, teniendo un numerador y
 * denominador y sabiendo que el divisor (denominador) debe 
 * ser un número distinto de 0.
 * 
 * @author Isabel Katharina Loerzer
 * @version 1.0
 *
 */
public class Fraccion {
	// Numerador
	/**
	 * Variable global numérica, refirida al numerador de una
	 * fracción.
	 */
	private int num;

	// Denominador
	/**
	 * Variable global numérica, referida al denominador de una 
	 * fracción.
	 */
	private int den;

	// Constructor por defecto
	/**
	 * Método no estático sin parámetros que inicializa la variable
	 * numerador como 0 y la variable denominador como 1.
	 */
	public Fraccion() { // debe generar el valor neutro que es 0/1
		num = 0;
		den = 1;

	}

	// Constructor con parámetros
	/**
	 * Método no estático con parámetros numéricos que devuelve otro
	 * método con la fracción simplificada. En caso de que el denominador
	 * sea 0, pasa a ser 1.
	 * 
	 * @param num se refiere al numerador
	 * @param den se refiere al denominador (divisor)
	 * @throws en caso de que el denominador sea 0 pasa a ser 1
	 * @return simplificar() devuelve un método que imprime la fracción 
	 * simplificada.
	 */
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0)
			this.den = 1;
		else
			this.den = den;
		// devuelvo la fracci�n simplificada
		simplificar();
	}
	
	// Constructor copia
	/**
	 * Método que copia la fracción y devuelve una constante. Es decir,
	 * hace que las variables numerador y denominador pasen a ser variables
	 * constantes.
	 * 
	 * @param f variable referida a una constante.
	 */
	public Fraccion(final Fraccion f) {
		num = f.num;
		den = f.den;
	}

	// getters y setters
	/**
	 * Método set que muestra la variable numerador.
	 * 
	 * @param num se refiere al numerador.
	 */
	public void setNum(int num) {
		this.num = num;

	}
	
	/**
	 * Método get que permite modificar la variable numerador.
	 * 
	 * @return num devuelve el numerador.
	 */
	public int getNum() {
		return num;

	}

	/**
	 *  Método set que muestra la variable denominador.
	 * 
	 * @param den se refiere al denominador
	 */
	public void setDen(int den) {
		this.den = den;
	}
	
	/**
	 * Método get que permite modificar la variable numerador.
	 * 
	 * @return den devulve el denominador
	 */
	public int getDen() {
		return den;
	}

	// Cálculo del máximo común divisor por el algoritmo de Euclides
	/**
	 * Método sin parámetros que calcula el máximo común divisor por el
	 * algoritmo de Euclides.
	 * 
	 * @return u devuelve el valor absoluto del numerador.
	 */
	private int mcd() {
		int u = (Math.abs(num)); // valor absoluto del numerador
		int v = (Math.abs(den)); // valor absoluto del denominador
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}

	// método para simplificar fracciones
	/**
	 * Método void (que no devuelve nada) que simplifica la fracción 
	 * utilizando el máximo común divisor.
	 */
	public void simplificar() {
		int n = mcd();
		num = num / n;
		den = den / n;
	}

	// Método toString
	/**
	 * Método que devuelve un mensaje numerador/denominador.
	 * 
	 * @return mensaje Mensaje que devuelve el método.
	 */
	public String toString() {
		String mensaje = num + "/" + den;
		return mensaje;

	}

	// suma de fracciones
	/**
	 * Método con parámetro f que suma dos fracciones.
	 * 
	 * @param f variable constante fracción
	 * @return aux devuelve el resultado de la suma, simplificada.
	 */
	public Fraccion sumar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den + den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	// Restar fracciones
	/**
	 *  Método con parámetro f que resta dos fracciones.
	 *  
	 * @param f variable constante fracción
	 * @return aux devuelve el resultado de la resta, simplificada.
	 */

	public Fraccion restar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den - den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

//Multiplicar fracciones
	/**
	 * Método con parámetro f que multiplica dos fracciones.
	 * 
	 * @param f variable constante fracción
	 * @return aux devuelve el resultado de la multiplicación, simplificada.
	 */

	public Fraccion multiplicar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

//Dividir fracciones
	/**
	 * Método con parámetro f que divide dos fracciones.
	 * 
	 * @param f variable constante fracción
	 * @return aux devuelve el resultado de la multiplicación, simplificada
	 */

	public Fraccion dividir(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den;
		aux.den = den * f.num;
		aux.simplificar();
		return aux;

	}

}
