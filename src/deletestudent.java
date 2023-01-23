
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;    
import java.sql.*;

class deletest implements ActionListener
{
	JFrame f ;
	JLabel l1,l2;
	JButton b1;
	JTextField t1;
	private JLabel image_label;

	public deletest()
	{
		f = new JFrame("Front page");   
		l1 = new JLabel("ADMISSION MANAGEMENT SYSTEM");
		l1.setFont(new Font("Serif", Font.BOLD, 35));
		l2 = new JLabel("Name");
		l1.setFont(new Font("Serif", Font.PLAIN, 35));
		//image_label.setIcon(new ImageIcon(this.getClass().getResource("download.png")));
		b1 = new JButton("Delete");
		t1 = new JTextField();
		l2.setFont(new Font("Serif", Font.BOLD, 15));
		b1.setFont(new Font("Serif", Font.BOLD, 10));

		b1.addActionListener(this);

		t1.setBounds(320,250,150,30);
		l1.setBounds(130,30,600,30);
		l2.setBounds(230,250,100,30);
		b1.setBounds(320,400,100,30);
		
		f.add(l1);
		f.add(b1);
		f.add(l2);
		f.add(t1);

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
				 JOptionPane.showMessageDialog(f,"Enter Name of student to delete");
			 }
			 else
			 {
				try{
					String name = t1.getText();
					Connection con;
					Class.forName("com.mysql.cj.jdbc.Driver");  
						con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/world","root","qwerty");
						Statement st=con.createStatement();
						//String query = "Select * from admin where user="+name+" and password="+password+";";
						String query = String.format("delete from student where name=\"%s\";",name);
						int rs=st.executeUpdate(query);
						JOptionPane.showMessageDialog(f,"Student " + name + " Deleted");
                        adminHome ab=new adminHome();
						JOptionPane.showMessageDialog(f,"Admin");
						f.setVisible(false);
					}
					catch(Exception f){
						System.out.println(f);
					}
			 }
		 }
	 }
    private void JOptionPane(String string) {
    }
}

public class deletestudent
{
	public static void main(String[] args) 
	{

		deletest ab = new deletest();
	}
}