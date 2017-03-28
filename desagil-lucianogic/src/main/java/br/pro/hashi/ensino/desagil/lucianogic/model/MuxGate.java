package br.pro.hashi.ensino.desagil.lucianogic.model;

public class MuxGate extends Gate {
	private NandGate nandGate0;
	private NandGate nandGate1;
	private NandGate nandGate2;
	private NotGate notGate;
	private Emitter a;
	private Emitter b;
	private Emitter sel;
	
	public MuxGate() {
		super(3);
		nandGate0 = new NandGate();
		nandGate1 = new NandGate();
		nandGate2 = new NandGate();
		notGate = new NotGate();
		name = "Mux";
	}
	@Override
	public boolean read() {
		return nandGate2.read();
	}
	@Override
	protected void doConnect(Emitter emitter, int index) {
		
		if (index == 0) {
			a = emitter;
			nandGate0.connect(a, 0);
			nandGate2.connect(nandGate0, 0);
			
		}
		
		if (index == 1) {
			b = emitter;
			nandGate1.connect(b, 1);
			nandGate2.connect(nandGate1,1);
			

		}
		
		if (index == 2){
			sel = emitter;
			notGate.connect(sel, 0);
			nandGate1.connect(sel, 0);
			nandGate0.connect(notGate, 1);
			nandGate2.connect(nandGate1, 1);
			nandGate2.connect(nandGate0, 0);
			
			
		}
	}
}

