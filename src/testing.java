import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
class UserList extends JFrame {
    JFrame frame= new JFrame("Student List");
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);
    public UserList() {
        cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
        model.addColumn("Name");
        model.addColumn("Address");
        model.addColumn("Gender");
        model.addColumn("DOB");
        model.addColumn("AEEE Marks");
        model.addColumn("Class 12");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/world", "root", "qwerty");
            PreparedStatement pstm = con.prepareStatement("select * from student");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(
                    new Object[]{Rs.getString(1),
                                 Rs.getString(2),
                                 Rs.getString(3),
                                 Rs.getString(4),
                                 Rs.getString(5),
                                 Rs.getString(6)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        this.pack();
    }
}
public class testing {
    public static void main(String[] args){
        UserList frame = new UserList();
        frame.setTitle("Students List");
        frame.setSize(475, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}