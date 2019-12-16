package DrawGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;

public class Main implements ActionListener, MouseListener, MouseMotionListener {

	public static final int width = 700;
	public static final int height = 500;
	public static final int sidePanel = 200;
	public static Color currentColor = Color.black;
	private JFrame f;
	private JPanel p;
	private JSlider s;
	Map map = new Map();
	public static int mouseX;
	public static int mouseY;
	public static int thickness = 10;
	Timer timer;

	public Main() {
		f = new JFrame();
		f.setTitle("'_'");
		f.setResizable(false);
		p = new JPanel() {
			public void paintComponent(Graphics g) {
				map.draw(g);
			}

		};
		s = new JSlider();
		s.setMinimum(5);
		s.setMaximum(50);
		s.setSize(180, 20);
		f.addMouseMotionListener(this);
		f.addMouseListener(this);
		timer = new Timer(0, this);
		f.setPreferredSize(new Dimension(width, height));
		f.add(p);
		f.add(s);

		f.pack();
		f.setVisible(true);
		timer.start();
		System.out.println("yeet");
	}

	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX() - 6;
		mouseY = e.getY() - 30;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//these are mac measurements
		mouseX = e.getX() - 6;
		mouseY = e.getY() - 30;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		p.repaint();
		System.out.println("test");
	}

}
