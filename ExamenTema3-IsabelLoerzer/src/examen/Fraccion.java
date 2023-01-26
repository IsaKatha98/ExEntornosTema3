package examen;

// Clase que define una fracción
public class Fraccion {
	// Numerador
	private int num;

	// Denominador
	private int den;

	// Constructor por defecto

	public Fraccion() { // debe generar el valor neutro que es 0/1
		num = 0;
		den = 1;

	}

	// Constructor con parámetros
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0) {
			this.den = 1;
			
		}else {
			this.den = den;
			
		}
		// devuelvo la fracci�n simplificada
		simplificar();
	}

	// Constructor copia
	public Fraccion(final Fraccion frac) {
		num = frac.num;
		den = frac.den;
	}

	// getters y setters

	public void setNum(int num) {
		this.num = num;

	}

	public int getNum() {
		return num;

	}

	public void setDen(int den) {
		this.den = den;
	}

	public int getDen() {
		return den;
	}

	// Cálculo del máximo común divisor por el algoritmo de Euclides
	private int maxComunDivisor() {
		int valorAbsNum = Math.abs(num); // valor absoluto del numerador
		int valorAbsDen = Math.abs(den); // valor absoluto del denominador
		if (valorAbsDen == 0) {
			valorAbsDen=1;
		}
		int result;
		while (valorAbsDen != 0) {
			result = valorAbsNum % valorAbsDen;
			valorAbsNum = valorAbsDen;
			valorAbsDen = result;
		}
		return valorAbsNum;
	}

	// método para simplificar fracciones
	public void simplificar() {
		int maxCD = maxComunDivisor();
		num = num / maxCD;
		den = den / maxCD;
	}

	// Método toString

	public String toString() {
		return num + "/" + den;

	}

	// suma de fracciones
	public Fraccion sumar(Fraccion frac) {
		Fraccion aux = new Fraccion();
		int cruce1 = num * frac.den;
		int cruce2 = den * frac.num;
		aux.num = cruce1 + cruce2;
		aux.den = den * frac.den;
		aux.simplificar();
		return aux;

	}

	// Restar fracciones

	public Fraccion restar(Fraccion frac) {
		Fraccion aux = new Fraccion();
		int cruce1 = num * frac.den;
		int cruce2 = den * frac.num;
		aux.num = cruce1 - cruce2;
		aux.den = den * frac.den;
		aux.simplificar();
		return aux;

	}

//Multiplicar fracciones

	public Fraccion multiplicar(Fraccion frac) {
		Fraccion aux = new Fraccion();
		aux.num = num * frac.num;
		aux.den = den * frac.den;
		aux.simplificar();
		return aux;

	}

//Dividir fracciones

	public Fraccion dividir(Fraccion frac) {
		Fraccion aux = new Fraccion();
		aux.num = num * frac.den;
		aux.den = den * frac.num;
		aux.simplificar();
		return aux;

	}

}
