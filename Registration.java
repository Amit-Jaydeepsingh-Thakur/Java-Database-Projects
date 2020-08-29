package linda;

import java.util.*;
import java.lang.*;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.sql.*;
  

class MyFrame 
    extends JFrame 
    implements ActionListener { 
  
    // Components of the Form 
    private Container c; 
    private JLabel title; 
    private JLabel name; 
    private JTextField tname; 
    private JLabel mno; 
    private JTextField tmno;
    private JLabel course; 
    private JTextField text_course;
    private JLabel gender; 
    private JRadioButton male; 
    private JRadioButton female; 
    private ButtonGroup gengp; 
    private JLabel dob; 
    private JComboBox date; 
    private JComboBox month; 
    private JComboBox year; 
    private JLabel add; 
    private JTextArea tadd; 
    private JCheckBox term; 
    private JButton record_add; 
    private JButton record_delete;
    private JButton record_update;
    private JTextArea tout; 
    private JLabel res; 
    private JTextArea resadd;
    private database db;
    private JLabel pk;
    private JTextField text_pk;
    
    
    private String dates[] 
        = { "1", "2", "3", "4", "5", 
            "6", "7", "8", "9", "10", 
            "11", "12", "13", "14", "15", 
            "16", "17", "18", "19", "20", 
            "21", "22", "23", "24", "25", 
            "26", "27", "28", "29", "30", 
            "31" }; 
    private String months[] 
        = { "Jan", "feb", "Mar", "Apr", 
            "May", "Jun", "July", "Aug", 
            "Sup", "Oct", "Nov", "Dec" }; 
    private String years[] 
        = { "1995", "1996", "1997", "1998", 
            "1999", "2000", "2001", "2002", 
            "2003", "2004", "2005", "2006", 
            "2007", "2008", "2009", "2010", 
            "2011", "2012", "2013", "2014", 
            "2015", "2016", "2017", "2018", 
            "2019" }; 
  
    // constructor, to initialize the components 
    // with default values. 
    public MyFrame() 
    { 
        setTitle("Student Registration Form"); 
        setBounds(300, 90, 900, 600); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("Registration Form"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 30); 
        title.setLocation(300, 30); 
        c.add(title); 
  
        name = new JLabel("Name"); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(100, 20); 
        name.setLocation(100, 100); 
        c.add(name); 
  
        tname = new JTextField(); 
        tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname.setSize(190, 20); 
        tname.setLocation(200, 100); 
        c.add(tname); 
  
        mno = new JLabel("Mobile"); 
        mno.setFont(new Font("Arial", Font.PLAIN, 20)); 
        mno.setSize(100, 20); 
        mno.setLocation(100, 150); 
        c.add(mno); 
  
        tmno = new JTextField(); 
        tmno.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tmno.setSize(150, 20); 
        tmno.setLocation(200, 150); 
        c.add(tmno); 
        
        //
        course = new JLabel("Course"); 
        course.setFont(new Font("Arial", Font.PLAIN, 20)); 
        course.setSize(100, 20); 
        course.setLocation(100, 200); 
        c.add(course); 
  
        text_course = new JTextField(); 
        text_course.setFont(new Font("Arial", Font.PLAIN, 15)); 
        text_course.setSize(150, 20); 
        text_course.setLocation(200, 200); 
        c.add(text_course); 
        //
        
        pk = new JLabel("Id"); 
        pk.setFont(new Font("Arial", Font.PLAIN, 20)); 
        pk.setSize(100, 20); 
        pk.setLocation(100, 250); 
        c.add(pk); 
  
        text_pk = new JTextField(); 
        text_pk.setFont(new Font("Arial", Font.PLAIN, 15)); 
        text_pk.setSize(150, 20); 
        text_pk.setLocation(200, 250); 
        c.add(text_pk);
        
         
        dob = new JLabel("DOB"); 
        dob.setFont(new Font("Arial", Font.PLAIN, 20)); 
        dob.setSize(100, 20); 
        dob.setLocation(100, 300); 
        c.add(dob); 
  
        date = new JComboBox(dates); 
        date.setFont(new Font("Arial", Font.PLAIN, 15)); 
        date.setSize(50, 20); 
        date.setLocation(200, 300); 
        c.add(date); 
  
        month = new JComboBox(months); 
        month.setFont(new Font("Arial", Font.PLAIN, 15)); 
        month.setSize(60, 20); 
        month.setLocation(250, 300); 
        c.add(month); 
  
        year = new JComboBox(years); 
        year.setFont(new Font("Arial", Font.PLAIN, 15)); 
        year.setSize(60, 20); 
        year.setLocation(320, 300); 
        c.add(year); 
  
        add = new JLabel("Address"); 
        add.setFont(new Font("Arial", Font.PLAIN, 20)); 
        add.setSize(100, 20); 
        add.setLocation(100, 350); 
        c.add(add); 
  
        tadd = new JTextArea(); 
        tadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tadd.setSize(150, 20); 
        tadd.setLocation(200, 350); 
        tadd.setLineWrap(true); 
        c.add(tadd); 
  
        term = new JCheckBox("Accept Terms And Conditions."); 
        term.setFont(new Font("Arial", Font.PLAIN, 15)); 
        term.setSize(250, 20); 
        term.setLocation(150, 400); 
        c.add(term); 
  
        record_add = new JButton("Add"); 
        record_add.setFont(new Font("Arial", Font.PLAIN, 15)); 
        record_add.setSize(100, 20); 
        record_add.setLocation(130, 450); 
        record_add.addActionListener(this); 
        c.add(record_add); 
  
        record_delete = new JButton("Delete"); 
        record_delete.setFont(new Font("Arial", Font.PLAIN, 15)); 
        record_delete.setSize(100, 20); 
        record_delete.setLocation(240, 450); 
        record_delete.addActionListener(this); 
        c.add(record_delete);
        
        record_update = new JButton("Update"); 
        record_update.setFont(new Font("Arial", Font.PLAIN, 15)); 
        record_update.setSize(100, 20); 
        record_update.setLocation(360, 450); 
        record_update.addActionListener(this); 
        c.add(record_update);
  
        tout = new JTextArea(); 
        tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tout.setSize(300, 400); 
        tout.setLocation(500, 100); 
        tout.setLineWrap(true); 
        tout.setEditable(false); 
        c.add(tout); 
  
        res = new JLabel(""); 
        res.setFont(new Font("Arial", Font.PLAIN, 20)); 
        res.setSize(500, 25); 
        res.setLocation(100, 500); 
        c.add(res); 
  
        resadd = new JTextArea(); 
        resadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
        resadd.setSize(200, 75); 
        resadd.setLocation(580, 175); 
        resadd.setLineWrap(true); 
        c.add(resadd); 
  
        setVisible(true); 
        
        db=new database();
        
    } 
  
    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == record_add) { 
            if (term.isSelected()) { 
                String data1; 
                String data 
                    = "Id : "
                            + text_pk.getText() + "\n"+
                      "Name : "
                      + tname.getText() + "\n"
                      + "Mobile : "
                      + tmno.getText() + "\n" 
                	  + "Course :"
                	  + text_course.getText() + "\n" ;
                String data2 
                    = "DOB : "
                      + (String)date.getSelectedItem() 
                      + "/" + (String)month.getSelectedItem() 
                      + "/" + (String)year.getSelectedItem() 
                      + "\n"; 
  
                String data3 = "Address : " + tadd.getText(); 
                tout.setText(data + data2 + data3); 
                tout.setEditable(false);
                
                //Database Connection
                String s_id=text_pk.getText();
                int id=Integer.valueOf(s_id);
                String s_name=tname.getText();
                String s_mobile=tmno.getText();
                int act_mob=Integer.valueOf(s_mobile);
                String s_course=text_course.getText();
                db.add_records(id,s_name,act_mob,s_course);
                
                text_pk.setText("");
                tname.setText("");
                tmno.setText("");
                text_course.setText("");
                tadd.setText("");
                
                	
                res.setText("Registration Successfully.."); 
            } 
            else { 
                tout.setText(""); 
                resadd.setText(""); 
                res.setText("Please accept the"
                            + " terms & conditions.."); 
            } 
        } 
  
        else if (e.getSource() == record_delete) { 
            
            String s_id=text_pk.getText();
            int id=Integer.valueOf(s_id);
            
            db.delete_records(id);
            
            tname.setText("");
            tmno.setText("");
            text_course.setText("");
            text_pk.setText("");
            tadd.setText("");
            
            res.setText("Deleted Successfully..");
        }
        
        else if (e.getSource() == record_update) { 
        	
            String s_id=text_pk.getText();
            int id=Integer.valueOf(s_id);
            String s_name=tname.getText();
            String s_mobile=tmno.getText();
            //int act1_mob=Integer.valueOf(s_mobile);
            String s_course=text_course.getText();
            db.update_records(id,s_name,9828736,s_course);
                        
            text_pk.setText("");
            tname.setText("");
            tmno.setText("");
            text_course.setText("");
            tadd.setText("");
            
            res.setText("Updation Done in DB Successfully..");
        }
    } 
} 
  
// Driver Code 
class database{
	public Connection con;
	public Statement stmt;
	public ResultSet rs;
	public PreparedStatement insert;
	public database()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/linda","root","");
			Statement stmt=con.createStatement();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	public void get_records(){
		int CC;
        try {
        	
            insert = con.prepareStatement("SELECT * FROM record");
            ResultSet Rs = insert.executeQuery();
            
   
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            

            while (Rs.next()) {
                //Vector v2 = new Vector();
           
                for (int ii = 1; ii <= CC; ii++) {
                    System.out.println(Rs.getString("id")+" "+Rs.getString("name")+" "+Rs.getString("mobile")+" "+Rs.getString("course"));
                    
                
                }

                //DFT.addRow(v2);
            }
        } catch (Exception e) {
        	System.out.println(e);
        }
	}
	
	public void add_records(int id,String name,int mob,String course_name) {
		System.out.println("add_records");
		try {
            insert = con.prepareStatement("insert into record (id,name,mobile,course)values(?,?,?,?)");
            insert.setInt(1,id);
            insert.setString(2,name);
            insert.setInt(3,mob);
            insert.setString(4,course_name);
            insert.executeUpdate();
      
          //table_update();
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
	}
	
	public void delete_records(int id) {
		System.out.println("delete_records");
		try {
			insert = con.prepareStatement("delete from record where id = ?");
	        
	        insert.setInt(1,id);
	        insert.executeUpdate();
	        //JOptionPane.showMessageDialog(this, "Record Delete");
		}
		
		catch (SQLException ex) {
			System.out.println(ex);
		}
	}
	
	public void update_records(int s_id,String s_name,int s_mob,String s_course) {
		System.out.println("Update's_records");
		try {
	        insert = con.prepareStatement("update record set name= ?,mobile= ?,course= ? where id= ?");
            insert.setString(1,s_name);
            insert.setInt(2,s_mob);
            insert.setString(3,s_course);
            insert.setInt(4,s_id);
            insert.executeUpdate();
		}
		
		catch (SQLException ex) {
			System.out.println(ex);
		}
	}
	
	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


class Registration { 
  
    public static void main(String[] args) throws Exception 
    { 
    	//Create Front-End
        MyFrame f = new MyFrame();
        
        database db=new database();
        
        //db.add_records(4,"B",939939393,"PO");
        db.get_records();
    } 
} 
