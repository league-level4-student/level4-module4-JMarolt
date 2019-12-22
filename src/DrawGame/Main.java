package DrawGame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main implements ActionListener, MouseListener, MouseMotionListener, ChangeListener{

	public static final int width = 700;
	public static final int height = 500;
	public static final int sidePanel = 200;
	public static Color currentColor = Color.black;
	private JFrame f;
	private JPanel p;
	private JLabel th;
	private JSlider s;
	Map map = new Map();
	public static int mouseX;
	public static int mouseY;
	public static int thickness;
	Timer timer;

	public Main() {
		f = new JFrame();
		f.setTitle("a random drawing game that i dont know what to call oof");
		f.setResizable(false);
		p = new JPanel(null) {
			public void paintComponent(Graphics g) {
				map.draw(g);
			}
		};
		th = new JLabel("Thickness");
		th.setText("Thickness");
		th.setLocation(width - (sidePanel - (sidePanel/2)), 60);
		s = new JSlider();
		s.setBounds(0, 0, sidePanel - 10, 50);
		s.setLocation(width - sidePanel + 5, 0);
		s.setMajorTickSpacing(10);
		s.setMinorTickSpacing(1);
		s.setMinimum(0);
		s.setMaximum(50);
		s.setPaintLabels(true);
	    s.setPaintTicks(true);
	    s.setPaintTrack(true);
	    s.setAutoscrolls(true);
	    s.setVisible(true);
	    s.addChangeListener(this);
		f.addMouseMotionListener(this);
		f.addMouseListener(this);
		timer = new Timer(0, this);
		f.setPreferredSize(new Dimension(width, height));
		p.add(s);
		p.add(th);
		f.add(p);
		

		f.pack();
		f.setVisible(true);
		// Transparent 16 x 16 pixel cursor image.
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

		// Create a new blank cursor.
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		    cursorImg, new Point(0, 0), "blank cursor");

		// Set the blank cursor to the JFrame.
		f.getContentPane().setCursor(blankCursor);
		timer.start();
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
		thickness = s.getValue();
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
	}

}
