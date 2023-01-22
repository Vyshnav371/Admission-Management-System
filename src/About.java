
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;    

class Aboutt extends JFrame
{

	JLabel l1,l2,l3,l4,l5,l6,l7,l69;

	public Aboutt()
	{
		l1 = new JLabel("ABOUT");
		l2 = new JLabel();
		l3 = new JLabel();
		l4 = new JLabel();
		l5 = new JLabel();
		l6 = new JLabel();
		l7 = new JLabel();

		l2.setText("This is a simple JAVA Swing application that handles admission management");
		l3.setText("Features: ");
		l4.setText("Minimilistic UI");
		l5.setText("Easy to use");
		l6.setText("TBD");
		l7.setText("TBD");
		l1.setFont(new Font("Serif", Font.BOLD, 35));
		l2.setFont(new Font("Seriffff", Font.PLAIN, 20));
		l3.setFont(new Font("Seriffff", Font.PLAIN, 20));
		l4.setFont(new Font("Seriffff", Font.PLAIN, 20));
		l5.setFont(new Font("Seriffff", Font.PLAIN, 20));
		l6.setFont(new Font("Seriffff", Font.PLAIN, 20));
		l7.setFont(new Font("Seriffff", Font.PLAIN, 20));

		l1.setBounds(290,30,200,30);
		l2.setBounds(100,100,700,30);
		l3.setBounds(100,150,700,25);
		l4.setBounds(100,170,700,25);
		l5.setBounds(100,190,700,25);
		l6.setBounds(100,240,700,25);
		l7.setBounds(100,260,700,25);
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		
		getContentPane().setBackground(Color.yellow);
		setLayout(null);
		setSize(800,600);
		setVisible(true);
	}
}
public class About 
{
	public static void main(String[] args) 
	{
		Aboutt ab = new Aboutt();	
	}
}