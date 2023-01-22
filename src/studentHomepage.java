
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;    

class studentHome implements ActionListener
{
	JFrame f ;
	JLabel l1;
	JButton b3,b6,b7,b8,b9;

	public studentHome()
	{
		 f = new JFrame("Home page");
		l1 = new JLabel("ADMISSION MANAGEMENT SYSTEM");
		l1.setFont(new Font("Serif", Font.BOLD, 30));
		b3 = new JButton("Apply");
		b6 = new JButton("HOME");
		b7 = new JButton("ABOUT");
		b8 = new JButton("CONTACT US");
		b9 = new JButton("LOG OUT");
		l1.setBounds(130,30,600,30);
		b3.setBounds(30,320,170,30);
		b6.setBounds(150,120,100,30);
		b7.setBounds(270,120,100,30);
		b8.setBounds(390,120,120,30);
		b9.setBounds(540,120,120,30);
		f.add(l1);
		f.add(b3);
		f.add(b6);
		f.add(b7);
		f.add(b8);
		f.add(b9);

		b3.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);

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

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == b6)
		{
					// homepage
			f.setVisible(false);
			adminHome h1 = new adminHome();

		}
		if (e.getSource() == b7)
		{
			Aboutt a1 = new Aboutt();
		}
        if(e.getSource()==b3){
            Register_an_Event r1 = new Register_an_Event();
        }


		if (e.getSource() == b8)
		{
			try {
				Contactt abc = new Contactt();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		if (e.getSource() == b9)
		{
			f.setVisible(false);
		}

	}
}

public class studentHomepage
{
	public static void main(String[] args) 
	{
		studentHome ab = new studentHome();
	}

	public void show() {
	}
}

