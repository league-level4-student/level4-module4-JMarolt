package DrawGame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
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
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;

/*
 * 
 * code so poorly organized not even I can find where i put things
 * 
 */

public class Main extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	public static final int width = 700;
	public static final int height = 500;
	public static final int sidePanel = 200;
	public static Color currentColor = Color.black;
	public static Color eraserColor = Color.black;
	public static State currentState = State.MARKER;
	public static String drawObject;
	private JFrame f;
	private JPanel p;
	private JSlider s;
	private JSlider r;
	private JSlider g;
	private JSlider b;
	private JLabel red;
	private JLabel green;
	private JLabel blue;
	private JLabel status;
	private JLabel timeLeft;
	private JButton pen;
	private JButton e;
	private JButton clear;
	private JButton fill;
	private Map map = new Map();
	public static int mouseX;
	public static int mouseY;
	public static int thickness;
	public static int radius = thickness / 2;
	private Eraser eraser;
	public static boolean erase = false;
	public static boolean filling = false;
	public static boolean eraseAll = false;
	ArrayList<Circle> circles = new ArrayList<Circle>();
	public static int seconds = 120;
	public static int minutes = 2;
	String time = minutes + ":" + seconds/minutes;
	int millis = 0;
	Timer timer;

	public Main() {
		f = new JFrame();
		f.setTitle("a random drawing game that i dont know what to call oof");
		f.setResizable(false);
		eraser = new Eraser(mouseX, mouseY, thickness);
		p = new JPanel(null) {
			public void paintComponent(Graphics g) {
				map.draw(g);
				for (Circle c : circles) {
					c.paint(g);
				}
				if(erase) {
					eraser.draw(g);
				}else {
					map.paint(g);
				}
				g.setColor(Color.BLACK);
				g.drawRect(width - sidePanel + 5, 360, 184, 100);
				g.setColor(currentColor);
				g.fillRect(width - sidePanel + 6, 361, 183, 99);
				
			}
		};
		/*
		 * JLabels
		 */
		red = new JLabel("R");
		red.setBounds(width - sidePanel + 5, 200, 20, 20);
		green = new JLabel("G");
		green.setBounds(width - sidePanel + 5, 250, 20, 20);
		blue = new JLabel("B");
		blue.setBounds(width - sidePanel + 5, 300, 20, 20);
		status = new JLabel("Status :" + currentState);
		status.setBounds(width - sidePanel + 20, 150, 200, 25);
		timeLeft = new JLabel(time);
		timeLeft.setBounds(width - sidePanel + 5, 175, 35, 35);
		/*
		 * Thickness JSlider
		 */
		s = new JSlider();
		s.setBounds(0, 0, sidePanel - 10, 50);
		s.setLocation(width - sidePanel + 5, 0);
		s.setMajorTickSpacing(10);
		s.setMinorTickSpacing(1);
		s.setMinimum(0);
		s.setMaximum(50);
		s.setValue(10);
		s.setPaintLabels(true);
		s.setPaintTicks(true);
		s.setPaintTrack(true);
		s.setAutoscrolls(true);
		s.setVisible(true);
		/*
		 * RGB JSliders
		 */
		r = new JSlider();
		r.setBounds(0, 0, sidePanel - 25, 50);
		r.setLocation(width - sidePanel + 15, 200);
		r.setMajorTickSpacing(50);
		r.setMinorTickSpacing(10);
		r.setMinimum(0);
		r.setMaximum(255);
		r.setValue(255);
		r.setPaintLabels(true);
		r.setPaintTicks(true);
		r.setPaintTrack(true);
		r.setAutoscrolls(true);
		r.setVisible(true);
		// green
		g = new JSlider();
		g.setBounds(0, 0, sidePanel - 25, 50);
		g.setLocation(width - sidePanel + 15, 250);
		g.setMajorTickSpacing(50);
		g.setMinorTickSpacing(10);
		g.setMinimum(0);
		g.setMaximum(255);
		g.setValue(255);
		g.setPaintLabels(true);
		g.setPaintTicks(true);
		g.setPaintTrack(true);
		g.setAutoscrolls(true);
		g.setVisible(true);
		// blue
		b = new JSlider();
		b.setBounds(0, 0, sidePanel - 25, 50);
		b.setLocation(width - sidePanel + 15, 300);
		b.setMajorTickSpacing(50);
		b.setMinorTickSpacing(10);
		b.setMinimum(0);
		b.setMaximum(255);
		b.setValue(255);
		b.setPaintLabels(true);
		b.setPaintTicks(true);
		b.setPaintTrack(true);
		b.setAutoscrolls(true);
		b.setVisible(true);
		/*
		 * JButtons
		 */
		pen = new JButton("1");
		pen.setBounds(550, 50, 50, 50);
		e = new JButton("2");
		e.setBounds(600, 50, 50, 50);
		clear = new JButton("3");
		clear.setBounds(550, 100, 50, 50);
		fill = new JButton("4");
		fill.setBounds(600, 100, 50, 50);
		
		

		f.addMouseMotionListener(this);
		f.addMouseListener(this);
		timer = new Timer(0, this);
		f.setPreferredSize(new Dimension(width, height));
		p.add(s);
		p.add(r);
		p.add(g);
		p.add(b);
		p.add(red);
		p.add(green);
		p.add(blue);
		p.add(pen);
		p.add(e);
		p.add(clear);
		p.add(fill);
		p.add(status);
		p.add(timeLeft);
		f.add(p);
		
		/*
		 * 
		 * setting button action listeners
		 * 
		 */
		
		pen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				erase = false;
				eraseAll = false;
				filling = false;
			}
		});
		e.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				erase = true;
				eraseAll = false;
				filling = false;
			}
		});
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				circles.removeAll(circles);
				eraseAll = true;
				erase = false;
				filling = false;
			}
		});
		fill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filling = true;
				erase = false;
				eraseAll = false;
			}
		});

		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		/*
		 * 
		 * WANT: Put all values of the file into an array so it makes it easy to grab an element out of the array and use
		 * 
		 */
		
		Scanner file = new Scanner("Objects.txt");
		
		int random = (int)Math.random() * 4;
		
		boolean reached = false;
		
		int num = random;
		
		while(reached = false) {
			while(num != 0) {
				if(file.hasNext() && num == 1) {
					drawObject = file.next();
					reached = true;
				}
				num--;
			}
		}
		
		String question = JOptionPane.showInputDialog(drawObject + "/ Do you want to draw this? \nIf you don't, type randomize.");
		
		if(question.toLowerCase().equals("randomize")) {
			random = (int)Math.random() * 4;
		}
		
		System.out.println("Draw: " + drawObject);
		
		System.out.println("1) Marker \n2) Eraser \n3) Erase ALL \n4) Fill");

		/*
		 * 
		 * Fix Above
		 * 
		 */
		
		timer.start();
	}

	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(erase) {
			for(int i = 0; i < circles.size(); i++) {
				if((circles.get(i).x >= mouseX - thickness && circles.get(i).x <= mouseX + thickness) && (circles.get(i).y <= mouseY + thickness && circles.get(i).y >= mouseY - thickness)) {
					circles.remove(i);
				}
			}
		}else {
			if (mouseX < 500) {
				circles.add(new Circle(e.getX(), e.getY(), thickness, currentColor));
			}
		}
		p.repaint();
		// these are mac measurements
		//mouseX = e.getX() - 6;
		//mouseY = e.getY() - 30;
		// these are windows measurements
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// these are mac measurements
		//mouseX = e.getX() - 6;
		//mouseY = e.getY() - 30;
		// these are windows measurements
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(erase) {
			for(int i = 0; i < circles.size(); i++) {
				if((circles.get(i).x >= mouseX - radius && circles.get(i).x <= mouseX + radius) && (circles.get(i).y <= mouseY + radius && circles.get(i).y >= mouseY - radius)) {
					circles.remove(i);
				}
			}
		}else {
			if (mouseX < 500) {
				circles.add(new Circle(e.getX(), e.getY(), thickness, currentColor));
			}
		}
		if(filling) {
			circles.add(new Circle(e.getX(), e.getY(), 5000, currentColor));			
		}
		p.repaint();
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
		currentColor = new Color(r.getValue(), g.getValue(), b.getValue());
		if (mouseX < (width - sidePanel)) {

			BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

			Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0),
					"blank cursor");

			f.getContentPane().setCursor(blankCursor);
		} else {
			f.getContentPane().setCursor(getCursor());
		}
		
		if(erase) {
			currentState = State.ERASER;
		}else if(filling) {
			currentState = State.FILL;
		}else if(eraseAll){
			currentState = State.ERASE;
		}else {
			currentState = State.MARKER;
		}
		
		status.setText("Status: " + currentState);
		
		millis++;
		
		if(millis == 1000) {
			seconds--;
			millis = 0;
		}
		
		if(seconds == 0 && minutes > 0) {
			minutes--;
			seconds = 60;
		}else if(seconds == 0 && minutes == 0){
			System.out.println("times up!");
		}else {
			
		}

	}

}