package br.pro.hashi.ensino.desagil.lucianogic.model;

import java.awt.event.KeyEvent;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

import br.pro.hashi.ensino.desagil.lucianogic.model.Gate;

public class GateView extends JPanel implements ItemListener {

	private static final long serialVersionUID = 1L;
	private	JCheckBox eField;
	private	JCheckBox eField2;
	private	JCheckBox eField3;
	private JCheckBox resultField;
	boolean A;
	boolean B;
	boolean C;
	public int size;
	public Switch switcher1;
	public Switch switcher2;
	public Switch switcher3;
	
	private Gate gate;
	
	public GateView(Gate gate) {
		this.gate = gate;
		
		JLabel eLabel = new JLabel("Entrada:");
		JLabel resultLabel = new JLabel("Saída:");
		
		switcher1 = new Switch(); 
		switcher2 = new Switch();
		switcher3 = new Switch();
		
		eField = new JCheckBox("A");
		eField.setMnemonic(KeyEvent.VK_C); 
		eField.setSelected(false);
		
		eField2 = new JCheckBox("B");
		eField2.setMnemonic(KeyEvent.VK_C); 
		eField2.setSelected(false);

		eField3 = new JCheckBox("Sel");
		eField3.setMnemonic(KeyEvent.VK_C); 
		eField3.setSelected(false);
		
		resultField = new JCheckBox();

		eField.addItemListener(this);
		eField2.addItemListener(this);
		eField3.addItemListener(this);

		resultField.setEnabled(false);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		if (gate.size == 1) {
			add(eLabel);
			add(eField);
			add(resultLabel);
			add(resultField);
			gate.connect(switcher1, 0);
		}
		else if (gate.size == 2) {
			add(eLabel);
			add(eField);
			add(eField2);
			add(resultLabel);
			add(resultField);
			gate.connect(switcher1, 0);
			gate.connect(switcher2, 1);
		}
		else {
			add(eLabel);
			add(eField);
			add(eField2);
			add(eField3);
			add(resultLabel);
			add(resultField);
			gate.connect(switcher1, 0);
			gate.connect(switcher2, 1);
			gate.connect(switcher3, 2);

			}
		resultField.setSelected(gate.read());
	}
			
	@Override
	public void itemStateChanged(ItemEvent e) {
	    Object source = e.getItemSelectable();
	    
	    if (source == eField) {
	    	A = eField.isSelected();
	    	switcher1.setOn(A);
	    }
	    else if (source == eField2) {
	    	B = eField2.isSelected();
	    	switcher2.setOn(B);
	    }
	    else if (source == eField3) {
	    	C = eField3.isSelected();
	    	switcher3.setOn(C);
	    }
	    	
		System.out.println(gate.read());
		resultField.setSelected(gate.read());
		resultField.setEnabled(false);
		
		
	  }

	}

