package br.pro.hashi.ensino.desagil.lucianogic.model;

public class OrGate extends Gate {
	private NandGate nandGate_0;
	private NandGate nandGate_1;
	private NandGate nandGate_2;

	public OrGate() {
		super(2);
		nandGate_0 = new NandGate();
		nandGate_1 = new NandGate();
		nandGate_2 = new NandGate();
		
	}

	@Override
	public boolean read() {
		return nandGate_2.read();
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		nandGate_0.connect(emitter, index);
		
		
		nandGate_1.connect(emitter, 0);
		nandGate_1.connect(emitter, 1);
		
		nandGate_2.connect(nandGate_0, 0);
		nandGate_2.connect(nandGate_1, 1);
		
	}
}