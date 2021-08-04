import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;


public class Login extends JFrame implements ActionListener{

	
	 JLabel l1,l2;
	 JTextField t1;
	 JPasswordField p1;
	 JButton b1,b2,b3;
	 public Login(String title)
	 {
		  super(title);
		  setSize(800,200);
		  setLocationRelativeTo(this);
		  setDefaultCloseOperation(EXIT_ON_CLOSE);
		  setLayout(new FlowLayout());
	     l1=new JLabel("Enter Username");
	     l2=new JLabel("Enter Password");
	     
	     t1=new JTextField(10);
	     
	     p1=new JPasswordField(10);
	     b1=new JButton("Login");
	     b2=new JButton("RESET");
	     b3=new JButton("New USer");	     
	     add(l1);add(t1);add(l2);add(p1);add(b1);add(b2);add(b3);
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
	    
	 } 
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{
			String s1=t1.getText();
			char ch[]=p1.getPassword();
			String s2=String.copyValueOf(ch);
			String usertype="";
			int i=0;
			String query ="select * from login where username=? and password=?";
			try {
				PreparedStatement ps=(PreparedStatement) DBInfo.con.prepareStatement(query);
				ps.setString(1, s1);
				ps.setString(2,s2);
				ResultSet res=ps.executeQuery();
				 while(res.next())
				 {
					 i=1;
					 usertype=res.getString("usertype");
				 }
				
			}
			catch(Exception re)
			{
				re.printStackTrace();
			}
			if(i==1 && usertype.equalsIgnoreCase("admin"))
			{
				System.out.println("Admin login done");
			    reset();
			}
			if(i==1 && usertype.equalsIgnoreCase("faculty"))
			{
				System.out.println("faculty login done");
			    reset();
			}
			if(i==0)
			{
				System.out.println("Failed");
			}
			
			
			
			
				
		}

		if(e.getSource()==b2)
		{
			reset();
			
		}
		if(e.getSource()==b3)
		{
			Registration res=new Registration("New USer");
			res.setVisible(true);
		}
		}
	 
	public void reset()
		{
			t1.setText(null);p1.setText(null);
			
		}
		
	
	 public static void main(String args[])
	{
		new Login("Login").setVisible(true);
	}

	
	 
	
 
}
