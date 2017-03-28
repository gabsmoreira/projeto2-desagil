package br.pro.hashi.ensino.desagil.lucianogic.model;

public abstract class Gate implements Receiver, Emitter {
	public int size;
	protected String name;

	
	protected Gate(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
	
	@Override
	public void connect(Emitter emitter, int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		doConnect(emitter, index);
	}
	
	public String toString() {
		return name;
	}
	
	protected abstract void doConnect(Emitter emitter, int index);
}
