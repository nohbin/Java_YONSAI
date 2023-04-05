package day0315;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RabbitDrawing extends Frame {
	 public static void main(String[] args) {
	        new RabbitDrawing();
	    }
	    
	    public RabbitDrawing() {
	        setTitle("Rabbit Drawing");
	        setSize(400, 400);
	        addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	                dispose();
	                System.exit(0);
	            }
	        });
	        setVisible(true);
	    }
	    
	    public void paint(Graphics g) {
	    	 g.setColor(Color.WHITE);
	         g.fillRect(0, 0, getWidth(), getHeight());
	         g.setColor(Color.GRAY);
	         g.fillOval(100, 100, 200, 200);
	         g.setColor(Color.WHITE);
	         g.fillOval(135, 150, 20, 20);
	         g.fillOval(245, 150, 20, 20);
	         g.setColor(Color.BLACK);
	         g.drawArc(170, 200, 60, 40, 180, 180);
	         g.drawArc(180, 190, 40, 20, 180, 180);
	    }
	}

