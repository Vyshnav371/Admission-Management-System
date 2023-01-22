
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;

import java.awt.*;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class Check_Event
{
    JFrame f;
    JLabel l1,l2;
    Check_Event()
    {
        f = new JFrame("Check Movies List");

        l1 = new JLabel("ADMISSION MANAGEMENT SYSTEM");
        l2 = new JLabel("CURRENTLY ENROLLED STUDNETS");

        l1.setFont(new Font("Serif", Font.BOLD, 35));
        l2.setFont(new Font("Serif", Font.PLAIN, 30));
        l1.setBounds(130,30,600,30);
        l2.setBounds(100,100,600,35);

        f.add(l1);
        f.add(l2);
        try {
    		Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/world","root","qwerty");
            java.sql.Statement st=con.createStatement();
            String sql="select from student";
            ResultSet rs=st.executeQuery(sql);
            String name,address,dob,gender,aeeemarks,class12;
            ResultSetMetaData rsmd=rs.getMetaData();
            while(rs.next()) {
                name=rs.getString(1);
                address=rs.getString(2);
                dob=rs.getString(3);
                gender=rs.getString(4);
                aeeemarks=rs.getString(5);
                class12=rs.getString(6);
                String[] row= {name,address,dob,gender,aeeemarks,class12};
                tbModel.addRow(row);
            }
    	} catch (ClassNotFoundException e1) {
    		e1.printStackTrace();
    	} 
        f.getContentPane().setBackground(Color.orange);
        f.setLayout(null);
        f.setSize(800,600);
        f.setVisible(true);
    }

}


public class Check_Event_List
{
    public static void main(String[] args)
    {
        Check_Event c1 = new Check_Event();
    }

}
