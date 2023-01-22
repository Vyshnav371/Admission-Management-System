import java.awt.Container;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class Passenger_Detail extends JFrame {
	Container c;
    JButton details;
    String[] locations= {"Mumbai","Chennai","Kochi","Kolkata","Patna","Telangana","Amritsar","Guwahati","Bhubaneswar","Gaya","New Delhi","Ahmedabad","Bengaluru","Mangalore","Kozhikode","Thiruvananthapuram","Nagpur","Jaipur","Lucknow","Kannur","Surat"};
	private JTable table;
	Passenger_Detail(){
    	setTitle("Passenger Details");
		setSize(1920,1080);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	     
	    c=getContentPane();
	    c.setLayout(null);
    	
    	details=new JButton("Details");
    	details.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try {
    				details(e);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
    		}
    	});
    	details.setBounds(102,177,98,43);
    	c.add(details);
    	
    	table = new JTable();
    	table.setRowMargin(12);
    	table.setRowHeight(40);
    	table.setFont(new Font("Tahoma", Font.PLAIN, 19));
    	table.setModel(new DefaultTableModel(
    		new Object[][] {
    			{"Name","Address","DOB","Gender","AEEE Marks","Class 12 Marks"},
    		},
    		new String[] {
    			"Flight Id", "Airline Id", "Airport Id", "Date", "From_Location", "To_location", "New column"
    		}
    	) {
    		boolean[] columnEditables = new boolean[] {
    			false, false, false, false, false, false, false
    		};
    		public boolean isCellEditable(int row, int column) {
    			return columnEditables[column];
    		}
    	});
    	table.getColumnModel().getColumn(0).setResizable(false);
    	table.getColumnModel().getColumn(0).setPreferredWidth(90);
    	table.getColumnModel().getColumn(1).setResizable(false);
    	table.getColumnModel().getColumn(1).setPreferredWidth(90);
    	table.getColumnModel().getColumn(2).setResizable(false);
    	table.getColumnModel().getColumn(2).setPreferredWidth(90);
    	table.getColumnModel().getColumn(3).setResizable(false);
    	table.getColumnModel().getColumn(3).setPreferredWidth(90);
    	table.getColumnModel().getColumn(4).setResizable(false);
    	table.getColumnModel().getColumn(4).setPreferredWidth(90);
    	table.getColumnModel().getColumn(5).setResizable(false);
    	table.getColumnModel().getColumn(5).setPreferredWidth(90);
    	table.getColumnModel().getColumn(6).setResizable(false);
    	table.setBounds(21, 231, 1862, 785);
    	getContentPane().add(table);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setBounds(0, 0, 21, 1041);
        getContentPane().add(panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.BLACK);
        panel_1.setBounds(21, 0, 1883, 20);
        getContentPane().add(panel_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.BLACK);
        panel_2.setBounds(1883, 0, 21, 1030);
        getContentPane().add(panel_2);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.BLACK);
        panel_3.setBounds(21, 1020, 1896, 21);
        getContentPane().add(panel_3);
        
        
       
        JButton backbutton = new JButton("Back");
        backbutton.setForeground(Color.WHITE);
        backbutton.setBackground(new Color(165, 42, 42));
        backbutton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		back(e);
        	}
        });
        backbutton.setBounds(21, 22, 99, 32);
        getContentPane().add(backbutton);
    	
    	
        ImageIcon background_image=new ImageIcon("C:\\bannerTop.jpg");
        Image img=background_image.getImage();
        Image tempimag=img.getScaledInstance(1920,1080,Image.SCALE_SMOOTH);
        background_image=new ImageIcon(tempimag);
        JLabel background=new JLabel("",background_image,JLabel.CENTER);
        background.setBounds(0,0,1920,400);
        getContentPane().add(background);
        setVisible(true);
    }
	public void back(ActionEvent e) {
		adminHomepage ap=new adminHomepage();
		ap.show();	
		dispose();
	}
    
   
    
    public void details(ActionEvent e) throws SQLException {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","qwerty");
    	} catch (ClassNotFoundException e1) {
    		e1.printStackTrace();
    		
    	} 
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","qwerty");
    	Statement st= conn.createStatement();

    	String sql="select * from student";
    
    	ResultSet rs=st.executeQuery(sql);
    	
    	int i=table.getRowCount();
        ResultSetMetaData rsmd=rs.getMetaData();
        DefaultTableModel tbModel=(DefaultTableModel) table.getModel();
        for(int j=0;j<i;j++) {
        	tbModel.removeRow(0);
        }
        int cols=rsmd.getColumnCount();
        String[] colName=new String[cols];
        for(int j=0;i<cols;i++)
        {
        	colName[j]=rsmd.getColumnName(j+1);
        }
        tbModel.setColumnIdentifiers(colName);
        String name,address,dob,gender,aeeemarks,class12;
         int p=0;
         String[] collName= {"Name","Address","DOB","Gender","AEEE Marks","Class 12 Marks"};
         tbModel.addRow(collName);
        while(rs.next()) {
        	table.getColumnModel().getColumn(p).setPreferredWidth(200);
        	name=rs.getString(1);
        	address=rs.getString(2);
        	dob=rs.getString(3);
        	gender=rs.getString(4);
        	aeeemarks=rs.getString(5);
        	class12=rs.getString(6);
        	String[] row= {name,address,dob,gender,aeeemarks,class12};
        	tbModel.addRow(row);
        	p++;
        }

        }
    }