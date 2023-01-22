import java.awt.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;


class Contactt
{
	JFrame f = new JFrame("Team Memebers");
	JLabel l6 = new JLabel("CONTACT US:-");
	JLabel l1 = new JLabel("Vyshnav Unnikrishnan");
	JLabel l2 = new JLabel("Varun Subramaniam");
	JLabel l3 = new JLabel("Govind Krishna");
	JLabel l4 = new JLabel("Devenandan R");
	JLabel l7 = new JLabel("FOR MORE INFORMATION CONTACT US-");
	Contactt() throws Exception
	{
		l1.setFont(new Font("Serifff", Font.PLAIN, 20));
		l2.setFont(new Font("Serifff", Font.PLAIN, 20));
		l3.setFont(new Font("Serifff", Font.PLAIN, 20));
		l4.setFont(new Font("Serifff", Font.PLAIN, 20));
		l6.setFont(new Font("Serif", Font.BOLD, 35));
		l7.setFont(new Font("Serif", Font.PLAIN, 25));
		l6.setBounds(270,30,300,40);
		l7.setBounds(130,100,600,40);
		l1.setBounds(300,190,200,40);
		l2.setBounds(300,230,200,40);
		l3.setBounds(300,270,200,40);
		l4.setBounds(300,310,200,40);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l6);
		f.add(l7);
		ImageIcon background_image=new ImageIcon("C:\\bannerTop.png");
        Image img=background_image.getImage();
        Image tempimag=img.getScaledInstance(1280,720,Image.SCALE_SMOOTH);
        background_image=new ImageIcon(tempimag);
        JLabel background=new JLabel("",background_image,JLabel.CENTER);
        background.setBounds(0,0,800,600);
        f.add(background);
		//f.getContentPane().setBackground(Color.white);
		f.setLayout(null);
		f.setSize(800,600);
		f.setVisible(true);
	}
	 private void add(JLabel background) {
	}
}
public class Contact
{
	public static void main(String[] args) throws Exception// throws Exception
	{
		Contactt c = new Contactt();
	}
}

