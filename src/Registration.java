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


public class Registration extends JFrame implements ActionListener{

	
	 JLabel l1,l2,l3;
	 JTextField t1,t3;
	 JPasswordField p1;
	 JButton b1,b2;
	 public Registration(String title)
	 {
		  super(title);
		  setSize(800,200);
		  setLocationRelativeTo(this);
		  setDefaultCloseOperation(EXIT_ON_CLOSE);
		  setLayout(new FlowLayout());
	     l1=new JLabel("Enter Username");
	     l2=new JLabel("Enter Password");
	     l3=new JLabel("Enter  UserType");
	     t1=new JTextField(10);
	     t3=new JTextField(10);
	     p1=new JPasswordField(10);
	     b1=new JButton("SAVE");
	     b2=new JButton("RESET");
	     add(l1);add(t1);add(l2);add(p1);add(l3);add(t3);add(b1);add(b2);
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	 } 
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{
			String s1=t1.getText();
			char ch[]=p1.getPassword();
			String s2=String.copyValueOf(ch);
			String s3=t3.getText();
			int i=0;
			String query ="insert into login(username,password,usertype) values(?,?,?)";
			try {
				PreparedStatement ps=(PreparedStatement) DBInfo.con.prepareStatement(query);
				ps.setString(1, s1);
				ps.setString(2,s2);
				ps.setString(3, s3);
				 i=ps.executeUpdate();
				
			}
			catch(Exception re)
			{
				re.printStackTrace();
			}
			if(i==1)
			{
				JOptionPane.showMessageDialog(getParent(), "Registration Done","Succes",JOptionPane.INFORMATION_MESSAGE);
			    reset();
			}
			else
			{
				JOptionPane.showMessageDialog(getParent(), "Registration Failed","Error",JOptionPane.ERROR_MESSAGE);
               
			}
				
		}
		else{
			reset();
			}
		}
	 
	public void reset()
		{
			t1.setText(null);p1.setText(null);
			t3.setText(null);
		}
		
	
	 public static void main(String args[])
	{
		new Registration("Registration Page").setVisible(true);
	}

	
	 
	
 
}
