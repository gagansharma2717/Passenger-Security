import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
public class DeletePassengerDetails implements ActionListener
{
	JPanel panel;
	Font headingFont;
	JLabel headingLabel,passidLabel,passnameLabel,passaddressLabel,passcityLabel,passcontactLabel,passemailLabel,passwordLabel;
	JTextField passnameText,passcityText,passcontactText,passemailText,passwordText;
	JScrollPane addressScroll;
	JTextArea addressTextarea;
	JComboBox idCombo;
	JButton deleteButton, resetButton;
	JSeparator sp;
	public DeletePassengerDetails()
	{
		panel=new JPanel();
		
		headingFont=new Font("Times New Roman", Font.BOLD+Font.ITALIC, 50);
		
		headingLabel=new JLabel("Delete Passenger Details");
		passidLabel=new JLabel("Passenger Id: ");
		passnameLabel=new JLabel("Enter Passenger Name : ");
		passaddressLabel=new JLabel("Enter Passenger Address : ");
		passcityLabel=new JLabel("Enter Passenger City : ");
		passcontactLabel=new JLabel("Enter Passenger Contact : ");
		passemailLabel=new JLabel("<html>Enter Email ID : <br>(Optional)</html>");
		passwordLabel=new JLabel("Enter Password : ");
	
		passnameText=new JTextField(10);
		passcontactText=new JTextField(10);
		passemailText=new JTextField(10);
		passcityText=new JTextField(10);				
		passwordText=new JTextField(10);
		addressTextarea=new JTextArea(5,10);
		addressTextarea.setLineWrap(true);
		addressTextarea.setWrapStyleWord(true);
				
		addressScroll=new JScrollPane(addressTextarea);
		
		idCombo=new JComboBox();
		idCombo.insertItemAt("none", 0);
		idCombo.setSelectedIndex(0);
	
		idCombo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt) 
			{
				if(idCombo.getSelectedIndex()==0)
				{
					passnameText.setText("");
					addressTextarea.setText("");
					passcityText.setText("");
					passcontactText.setText("");
					passemailText.setText("");
					passwordText.setText("");
				}
				try
				{	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:GaganExpress");
					String tmp=(String) idCombo.getSelectedItem();
					PreparedStatement ps=con.prepareStatement("select name,address,city,phone,email,password from PassengerDetails where passengerId=?");
					ps.setString(1,tmp);
					ResultSet rs=ps.executeQuery();	//insert, update, delete
					if(rs.next())
					{
						String name=rs.getString("name");
						String address=rs.getString("address");
						String city=rs.getString("city");
						String phone=rs.getString("phone");
						String email=rs.getString("email");
						String password=rs.getString("password");
						
						passnameText.setText(name.toString().trim());
						addressTextarea.setText(address.toString().trim());
						passcityText.setText(city.toString().trim());
						passcontactText.setText(phone.toString().trim());
						passemailText.setText(email.toString().trim());
						passwordText.setText(password.toString().trim());
					}
				}
				catch(Exception ee)
				{
				}		
			}
		});
		deleteButton=new JButton("Delete");
		deleteButton.setFocusPainted(false);
		resetButton=new JButton("Reset");
		resetButton.setFocusPainted(false);
		headingLabel.setBounds(10,10,700,55);
		headingLabel.setFont(headingFont);
		
		sp = new JSeparator();
		sp.setBackground(Color.BLACK);
		 	
		sp.setBounds(0,80,1500,30);
		passidLabel.setBounds(10,100,190,30);
		idCombo.setBounds(190,100,190,30);
		passnameLabel.setBounds(10,140,190,30);
		passnameText.setBounds(190,140,190,30);
		passaddressLabel.setBounds(10,180,190,30);
		addressScroll.setBounds(190,180,190,60);
		passcityLabel.setBounds(10,260,190,30);
		passcityText.setBounds(190,260,190,30);
		passcontactLabel.setBounds(10,300,190,30);
		passcontactText.setBounds(190,300,190,30);
		passemailLabel.setBounds(10,340,190,30);
		passemailText.setBounds(190,340,190,30);
		passwordLabel.setBounds(10,380,150,30);
		passwordText.setBounds(190,380,180,30);
		deleteButton.setBounds(50,430,120,30);
		resetButton.setBounds(200,430,120,30);
	
		
		deleteButton.addActionListener(this);
		resetButton.addActionListener(this);
		
		panel.setLayout(null);
		panel.add(headingLabel);
		panel.add(sp);
		panel.add(passidLabel);
		panel.add(idCombo);
		panel.add(passnameLabel);
		panel.add(passnameText);
		panel.add(passaddressLabel);
		panel.add(addressScroll);
		panel.add(passcityLabel);
		panel.add(passcityText);
		panel.add(passcontactLabel);
		panel.add(passcontactText);
		panel.add(passemailLabel);
		panel.add(passemailText);
		panel.add(passwordLabel);
		panel.add(passwordText);
		panel.add(deleteButton);
		panel.add(resetButton);
		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:GaganExpress");
			PreparedStatement ps=con.prepareStatement("select * from PassengerDetails");
			ResultSet rs=ps.executeQuery();	//insert, update, delete
			while(rs.next())
			{
				String id=rs.getString("passengerID");
				idCombo.addItem(id);
			}
		}
		catch(Exception ee)
		{
		}	
	}
	public JPanel getPanel()
	{
		return panel;
	}
	public void actionPerformed(ActionEvent evt) 
	{
		if(evt.getSource()==deleteButton)
		{
			if(idCombo.getSelectedIndex()==0)
		{
				JOptionPane.showMessageDialog(panel,"Please Select passenger Id to update the passenger details...");
		}		
			else if(passnameText.getText().equals(""))
		{
			JOptionPane.showMessageDialog(panel, "Name is required!");
			passnameText.requestFocus();
		}
		else if(addressTextarea.getText().equals(""))
		{
			JOptionPane.showMessageDialog(panel, "Address is required!");
			addressTextarea.requestFocus();
		}
		else if(passcityText.getText().equals(""))
		{
			JOptionPane.showMessageDialog(panel, "City is required!");
			passcityText.requestFocus();
		}
	
		else if(passcontactText.getText().equals(""))
		{
			JOptionPane.showMessageDialog(panel, "Contact is required!");
			passcontactText.requestFocus();
		}
		else if(passwordText.getText().equals(""))
		{
			JOptionPane.showMessageDialog(panel, "Contact is required!");
			passwordText.requestFocus();
		}
		else
		{
			String sPhoneNumber = passcontactText.getText();
			String email=passemailText.getText();
			Pattern pattern = Pattern.compile("\\d{10}");
			String pattern2="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			Pattern pattern23=Pattern.compile(pattern2);
			Matcher matcher = pattern.matcher(sPhoneNumber);
			Matcher matcher2=pattern23.matcher(email);

	      if (!matcher.matches())
	      {
	    	  JOptionPane.showMessageDialog(panel,"Invalid Phone Number");
	      }
	      else if(!matcher2.matches())
	      {
	    	  JOptionPane.showMessageDialog(panel,"Invalid Email Id");
	      	} 
	      else {
	    	  try
	    	  {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:GaganExpress");
				PreparedStatement ps=con.prepareStatement("DELETE PassengerDetails WHERE passengerID ='"+idCombo.getSelectedItem()+"'");
				int i=ps.executeUpdate();//insert, update, delete
				if(i>0)
				{
				JOptionPane.showMessageDialog(panel, "Record Deleted Successfully!");
				idCombo.setSelectedIndex(0);
				passnameText.setText("");
				addressTextarea.setText(" ");
				passcityText.setText("");
				passcontactText.setText("");
				passemailText.setText("");
				passwordText.setText("");
			}
		}
		catch(Exception ee)
		{
		}
	      }
		}
	}
	if(evt.getSource()==resetButton)
	{
		idCombo.setSelectedIndex(0);
		passnameText.setText("");
		addressTextarea.setText(" ");
		passcityText.setText("");
		passcontactText.setText("");
		passemailText.setText("");
		passwordText.setText("");
	}	
}		
} 