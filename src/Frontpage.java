
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;    
import java.sql.*;

class Frontpagee implements ActionListener
{
	JFrame f ;
	JLabel l1,l2,l3,l4;
	JButton b1,b5;
	JTextField t1,t2;
	private JLabel image_label;

	public Frontpagee()
	{
		f = new JFrame("Front page");   
		l1 = new JLabel("ADMISSION MANAGEMENT SYSTEM");
		l1.setFont(new Font("Serif", Font.BOLD, 35));
		l2 = new JLabel("USERNAME:-");
		l3 = new JLabel("PASSWORD:-");
		l4 = new JLabel();
		l4.setText("IF YOU ARE A NEW USER PLEASE REGISTER HERE:-");
		l1.setFont(new Font("Serif", Font.PLAIN, 35));
		//image_label.setIcon(new ImageIcon(this.getClass().getResource("download.png")));
		b1 = new JButton("LOG IN");
		b5 = new JButton("REGISTER");
		t1 = new JTextField();
		t2 = new JTextField();
		l2.setFont(new Font("Serif", Font.BOLD, 15));
		l3.setFont(new Font("Serif", Font.BOLD, 15));
		b1.setFont(new Font("Serif", Font.BOLD, 10));
		b5.setFont(new Font("Serif", Font.BOLD, 10));

		b1.addActionListener(this);
		b5.addActionListener(this);

		t1.setBounds(320,250,150,30);
		t2.setBounds(320,300,150,30);
		l1.setBounds(130,30,600,30);
		l2.setBounds(230,250,100,30);
		l3.setBounds(230,300,120,30);
		l4.setBounds(180,170,320,30);
		b1.setBounds(320,400,100,30);
		b5.setBounds(500,170,100,30);
		
		f.add(l1);
		f.add(b1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(t1);
		f.add(t2);
		f.add(b5);

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
	public void actionPerformed(ActionEvent e)
	 {

		 if (e.getSource() == b1)
		 {


			 if(t1.getText().equals(""))
			 {
				 JOptionPane.showMessageDialog(f,"Please Enter Your Username !");
			 }
			 else if(t2.getText().equals("") )
			 {
				 JOptionPane.showMessageDialog(f,"Please Enter Your Password !!!");
			 }
			 else
			 {
				try{
					String name = t1.getText();
					String password = t2.getText();
					Connection con;
					Class.forName("com.mysql.cj.jdbc.Driver");  
						con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/swing","root","qwerty");
						Statement st=con.createStatement();
						//String query = "Select * from admin where user="+name+" and password="+password+";";
						String query = String.format("Select * from admin where user=\"%s\" and password=\"%s\";",name,password);
						System.out.println("COnnected");
						ResultSet rs=st.executeQuery(query);
						if (rs.next() == false) {
							System.out.println("ResultSet in empty in Java");
							JOptionPane.showMessageDialog(f,"Invalid Credentials");
						}
						else{
							String type = rs.getString(3);
							if(type.equals("admin")){
								adminHome ab=new adminHome();
								JOptionPane.showMessageDialog(f,"Admin");
								f.setVisible(false);
							}
							else{
								System.out.println(type);
								studentHome ab=new studentHome();
								JOptionPane.showMessageDialog(f,"User");
								f.setVisible(false);
							}
						}
					}
					catch(Exception f){
						System.out.println(f);
					}
			 }
		 }

		 if (e.getSource() == b5)
		 {
			 Signinn abc = new Signinn();

		 }

	 }
}

public class Frontpage
{
	public static void main(String[] args) 
	{

		Frontpagee ab = new Frontpagee();
	}
}