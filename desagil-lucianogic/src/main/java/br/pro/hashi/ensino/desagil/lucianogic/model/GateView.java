package br.pro.hashi.ensino.desagil.lucianogic.model;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener; 
import java.net.URL;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;

import br.pro.hashi.ensino.desagil.lucianogic.model.Gate;

public class GateView extends FixedPanel implements ItemListener, ActionListener, MouseListener{

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
	public LED led;
	private Gate gate;
	private Image image;
	public JButton button;
	private Graphics g;
	int x;
	int y;
	Color color;
	
	public GateView(Gate gate) {
		super(370,220);
		this.gate = gate;
		led = new LED(255,0,0);
		led.connect(gate, 0);
		x = 225;
		y = 80;
		
		image = loadImage(gate.toString());	
		JLabel eLabel = new JLabel("");
		JLabel resultLabel = new JLabel("");
		
		switcher1 = new Switch(); 
		switcher2 = new Switch();
		switcher3 = new Switch();
		
		eField = new JCheckBox("");
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
		this.addMouseListener(this);
		
		if (gate.size == 1) {
			add(eLabel,100,85,20,20);
			add(eField,100,85,20,20);
			//add(resultLabel,215,70,50,50);
			//add(resultField,215,70,50,50);
			gate.connect(switcher1, 0);
		}
		else if (gate.size == 2) {
			add(eLabel,90,60,20,60);
			add(eField,90,70,20,20);
			add(eField2,90,100,20,20);
			//add(resultLabel,215,70,50,50);
			//add(resultField,215,70,50,50);
			gate.connect(switcher1, 0);
			gate.connect(switcher2, 1);
		}
		else {
			add(eLabel,90,60,20,60);
			add(eField,97,65,20,20);
			add(eField2,97,95,20,20);			
			add(eField3,165,125,20,20);
			//add(resultLabel,0,10,10,10);
			//add(resultField,0,10,10,10);
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
	    	
		//System.out.println(led.isOn());
		this.repaint();
		//resultField.setSelected(gate.read());
		//resultField.setEnabled(false);
		
		
		
	  }
	private Image loadImage(String filename) {
		URL url = getClass().getResource("/img/" + filename + ".png");
		ImageIcon icon = new ImageIcon(url);
		return icon.getImage();
	}


	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image, 115, 60, 120, 70, null);
		color = new Color(led.getR(),led.getG(),led.getB());
		if (led.isOn() == true){
			g.setColor(color);
			g.fillOval(225,80,30,30);
		}
		else{
			g.setColor(Color.black);
			g.fillOval(225,80,30,30);

		}
		
		
		

		// Evita bugs visuais em alguns sistemas operacionais.
		getToolkit().sync();
    }


	@Override
	public void mouseClicked(MouseEvent e) {
	    int screenX = e.getXOnScreen();
	    int screenY = e.getYOnScreen();
	    //System.out.println(screenX + " " +screenY);
	    if ( screenX>=225 && screenX<= 260 ) {
	    	if ( screenY>=155  && screenY<= 180){
	    		Color color = JColorChooser.showDialog(this, null, null);
	    		System.out.println(color);

	    		if(color != null) {
	    			led = new LED(color.getRed(),color.getGreen(),color.getBlue());
	    			led.connect(gate, 0);
	    			this.repaint();
	    			//g.setColor(color);
	    			//g.fillOval(225,80,30,30);
	    		}
	    	}
	    	} 
	    	
	    }
	  

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	}

