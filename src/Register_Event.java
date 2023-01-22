
import javax.swing.*;
import java.awt.*;
import java.sql.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Register_an_Event implements ActionListener
{
    JFrame f ;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton b1,b2;
    JTextField t1;
    JOptionPane O1;
    JTextField c1,c2,c3,c4,c5,c6;

    public Register_an_Event()
    {
        f = new JFrame("ADDING STUDENT");
        l1 = new JLabel("ADMISSION MANAGEMENT SYSTEM");

        l7 = new JLabel("NAME:-");
        l2 = new JLabel("ADDRESS:-");
        l8 = new JLabel("DATE OF BIRTH:-");
        l3 = new JLabel("GENDER:-");
        l5 = new JLabel("AEEE MARKS");
        l6 = new JLabel("CLASS 12 MARKS");
        c1 = new JTextField(16);
        c2 = new JTextField(16);
        c3 = new JTextField(16);
        c4 = new JTextField(16);
        c5 = new JTextField(16);
        c1.setBounds(350,200,200,30);
        c2.setBounds(350,240,200,30);
        c3.setBounds(350,280,200,30);
        c4.setBounds(350,320,200,30);
        c5.setBounds(350,400,150,30);
        f.add(c1);
        f.add(c2);
        f.add(c3);
        f.add(c4);
        f.add(c5);

        l4 = new JLabel();
        l4.setText("ENTER DETAILS OF STUDENT:-");


        l1.setFont(new Font("Serif", Font.BOLD, 30));
        l4.setFont(new Font("Serif", Font.BOLD, 20));
        l7.setFont(new Font("Serif", Font.BOLD, 18));
        l2.setFont(new Font("Serif", Font.BOLD, 18));
        l8.setFont(new Font("Serif", Font.BOLD, 18));
        l3.setFont(new Font("Serif", Font.BOLD, 18));
        l5.setFont(new Font("Serif", Font.BOLD, 18));
        l6.setFont(new Font("Serif", Font.BOLD, 18));

        b1 = new JButton("ADD");
        b2 = new JButton("CANCEL");

        t1 = new JTextField();

        O1 = new JOptionPane("All fields are mandatory... Please Fill it..");

        l1.setBounds(130,30,600,30);
        l4.setBounds(180,100,370,30);
        l7.setBounds(150,200,200,30);
        l2.setBounds(150,240,200,30);
        l8.setBounds(150,280,200,30);
        l3.setBounds(150,320,200,30);
        l5.setBounds(150,360,200,30);
        l6.setBounds(150,400,200,30);

        t1.setBounds(350,360,150,30);
        b1.setBounds(250,800,100,30);
        b2.setBounds(430,800,100,30);

        f.add(l1);
        f.add(b1);
        f.add(b2);
        f.add(l2);
        f.add(l3);
        f.add(l4);

        f.add(t1);

        f.add(l6);
        f.add(l5);
        f.add(l7);
        f.add(l8);

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
        b1.addActionListener(this);
        b2.addActionListener(this);
	}
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == b1)
        {
            if(t1.getText().equals(""))
            {
                JOptionPane.showMessageDialog(f,"All fields are mandatory... Please Fill it..");
            }
            else
            {
                try{ 
                    String name = c1.getText();
                    String address = c2.getText();
                    String dob = c3.getText();
                    String gender = c4.getText();
                    int aeemarks = Integer.parseInt(t1.getText());
                    int class12 = Integer.parseInt(c5.getText());
                    Class.forName("com.mysql.cj.jdbc.Driver");  
                    Connection con=DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/world","root","qwerty");  
                    PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?,?);") ;
                    ps.setString(1, name);
                    ps.setString(2, address);
                    ps.setString(3, dob);
                    ps.setString(4, gender);
                    ps.setInt(5, aeemarks);   
                    ps.setInt(6, class12);
                    int i = ps.executeUpdate();
                    System.out.println(i);
                    con.close();  
                    JOptionPane.showMessageDialog(f,"Student Registered");
                    adminHome ab=new adminHome();
                }catch(Exception f){
                    System.out.println(f);
                }  
                JOptionPane.showMessageDialog(f,"Successfully Registered...");
                f.setVisible(false);
            }
        }
        if(e.getSource() == b2)
        {
            f.setVisible(false);
        }
    }


}

public class Register_Event
{
    public static void main(String[] args)
    {
        Register_an_Event ab = new Register_an_Event();
    }
}