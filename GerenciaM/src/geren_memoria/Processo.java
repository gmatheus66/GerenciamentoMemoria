package geren_memoria;

public class Processo {
	
	private int end_base;
	private int end_limite;
	
	private boolean in_memoria; // indica se esta na memoria principal(true) ou na secundaria(false)
	
	private int end_swap;
		

	public Processo(int end_base, int end_limite) {
		this.setEnd_base(end_base);
		this.setEnd_limite(end_limite);
		
	}

	public int getEnd_base() {
		return end_base;
	}

	public void setEnd_base(int end_base) {
		this.end_base = end_base;
	}

	public int getEnd_limite() {
		return end_limite;
	}

	public void setEnd_limite(int end_limite) {
		this.end_limite = end_limite;
	}

	public boolean isIn_memoria() {
		return in_memoria;
	}

	public void setIn_memoria(boolean in_memoria) {
		this.in_memoria = in_memoria;
	}

	public int getEnd_swap() {
		return end_swap;
	}

	public void setEnd_swap(int end_swap) {
		this.end_swap = end_swap;
	}
	
	
	
}
