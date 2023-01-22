
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Signinn implements ActionListener
{
	JFrame f ;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JButton b1,b2;
	JTextField t1,t2,t3,t4,t5,t6;
	JOptionPane O1;

	public Signinn()
	{
		 f = new JFrame("Front page");
		l1 = new JLabel("ADMISSION MANAGMENT SYSTEM");
		l7 = new JLabel("USER NAME:-");
		l2 = new JLabel("PHONE NO:-");
		l8 = new JLabel("EMAIL ID:-");
		l3 = new JLabel("CITY:-");
		l5 = new JLabel("STATE:-");
		l6 = new JLabel("SET PASSWORD:-");
		l4 = new JLabel();
		l4.setText("PLEASE ENTER YOUR DETAILS HERE:-");
		l1.setFont(new Font("Serif", Font.BOLD, 35));
		l4.setFont(new Font("Serif", Font.BOLD, 17));
		l7.setFont(new Font("Serif", Font.BOLD, 20));
		l2.setFont(new Font("Serif", Font.BOLD, 20));
		l8.setFont(new Font("Serif", Font.BOLD, 20));
		l3.setFont(new Font("Serif", Font.BOLD, 20));
		l5.setFont(new Font("Serif", Font.BOLD, 20));
		l6.setFont(new Font("Serif", Font.BOLD, 20));
		b1 = new JButton("REGISTER");
		b2 = new JButton("RESET");

		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();
		t6 = new JTextField();

		O1 = new JOptionPane("All fields are mandatory... Please Fill it..");

		l1.setBounds(130,30,800,30);
		l4.setBounds(180,80,370,30);
		l7.setBounds(150,200,200,30);
		l2.setBounds(150,240,200,30);
		l8.setBounds(150,280,200,30);
		l3.setBounds(150,320,200,30);
		l5.setBounds(150,360,200,30);
		l6.setBounds(150,400,200,30);
		t1.setBounds(350,200,150,30);
		t2.setBounds(350,240,150,30);
		t3.setBounds(350,280,150,30);
		t4.setBounds(350,320,150,30);
		t5.setBounds(350,360,150,30);
		t6.setBounds(350,400,150,30);
		b1.setBounds(250,460,100,30);
		b2.setBounds(430,460,100,30);
		
		
		f.add(l1);
		f.add(b1);
		f.add(b2);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(t1);
		f.add(t2);
		f.add(l6);
		f.add(l5);
		f.add(l7);
		f.add(l8);
		f.add(t3);
		f.add(t4);
		f.add(t5);
		f.add(t6);

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
		b2.addActionListener(this);
		b1.addActionListener(this);
	}
	 private void add(JLabel background) {
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == b1)
		{
			if(t1.getText().equals("") ||t2.getText().equals("") ||t3.getText().equals("") ||t4.getText().equals("") ||t5.getText().equals("") ||t6.getText().equals(""))
			{
				JOptionPane.showMessageDialog(f,"All fields are mandatory... Please Fill it..");
			}
			else
			{
				try{ 
					String user = t1.getText();
					String password = t6.getText();
                    Class.forName("com.mysql.cj.jdbc.Driver");  
                    Connection con=DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/swing","root","qwerty");  
                    //here sonoo is database name, root is username and password  
                    PreparedStatement ps = con.prepareStatement("insert into admin values(?,?,?);") ;
                    ps.setString(1, user);
                    ps.setString(2, password);
                    ps.setString(3, "student");
                    int i = ps.executeUpdate();
                    System.out.println(i);
                    con.close();  
                }catch(Exception f){
                    System.out.println(f);
                }  
				JOptionPane.showMessageDialog(f,"Successfully Registered...");
				f.setVisible(false);
			}

			// USE JDBC concept and store all the data in CUSTOMER_DETAILS table ;
		}
		if(e.getSource() == b2)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
		}
	}


}

public class Signin
{
	public static void main(String[] args) 
	{
		Signinn ab = new Signinn();
	}
}