package br.pro.hashi.ensino.desagil.lucianogic.model;

public class XorGate extends Gate {
	private NandGate nandGate_0;
	private NandGate nandGate_1;
	private NandGate nandGate_2;
	private NandGate nandGate_3;
	
	public XorGate() {
		super(2);
		nandGate_0 = new NandGate();
		nandGate_1 = new NandGate();
		nandGate_2 = new NandGate();
		nandGate_3 = new NandGate();
	}

	@Override
	public boolean read() {
		return nandGate_3.read();
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		nandGate_0.connect(emitter, index);
		
		nandGate_1.connect(emitter, index);
		nandGate_1.connect(nandGate_0, 1);
		
		nandGate_2.connect(nandGate_0, 0);
		nandGate_2.connect(emitter, index);
		
		nandGate_3.connect(nandGate_1, 0);
		nandGate_3.connect(nandGate_2, 1);
		
	}
}
