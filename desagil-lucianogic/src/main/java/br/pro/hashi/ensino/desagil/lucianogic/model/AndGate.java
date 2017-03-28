package br.pro.hashi.ensino.desagil.lucianogic.model;

public class AndGate extends Gate {
	private NandGate nandGate_0;
	private NandGate nandGate_1;


	public AndGate() {
		super(2);
		name = "And";
		nandGate_0 = new NandGate();
		nandGate_1 = new NandGate();	
	}

	@Override
	public boolean read() {
		return nandGate_1.read();
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		nandGate_0.connect(emitter, index);
		
		nandGate_1.connect(nandGate_0, 0);
		nandGate_1.connect(nandGate_0, 1);
		
	}
}
