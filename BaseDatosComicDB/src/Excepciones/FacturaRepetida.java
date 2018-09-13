package Excepciones;

public class FacturaRepetida extends Exception {

	private static final long serialVersionUID = 1L;

	public FacturaRepetida() {
		super("Ya existe una factura a ese nombre .");
	}
}
