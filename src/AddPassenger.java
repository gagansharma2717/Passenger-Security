import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class AddPassenger implements ActionListener
{
	JPanel panel;
	Font headingFont;
	JLabel headingLabel,passidLabel,passnameLabel,passaddressLabel,passcityLabel,passcontactLabel,passemailLabel,passwordLabel;
	JTextField passidText,passnameText,passcityText,passcontactText,passemailText,passwordText;
	JScrollPane addressScroll;
	JTextArea addressTextarea;
	JButton saveButton, resetbutton;
	JSeparator sp;
	String id=null;
	public AddPassenger()
	{
		panel=new JPanel();
		
		headingLabel=new JLabel("Add Passenger Details");
		passidLabel=new JLabel("Passenger Id: ");
		passnameLabel=new JLabel("Enter Passenger Name : ");
		passaddressLabel=new JLabel("Enter Passenger Address : ");
		passcityLabel=new JLabel("Enter Passenger City : ");
		passcontactLabel=new JLabel("Enter Passenger Contact : ");
		passemailLabel=new JLabel("<html>Enter Email ID : <br>(Optional)</html>");
		passwordLabel=new JLabel("Enter Password : ");
		passidText=new JTextField(10);
		passnameText=new JTextField(10);
		passcontactText=new JTextField(10);
		passemailText=new JTextField(10);
		passcityText=new JTextField(10);				
		passwordText=new JTextField(10);
		addressTextarea=new JTextArea(5,10);
		addressTextarea.setLineWrap(true);
		addressTextarea.setWrapStyleWord(true);
					
		addressScroll=new JScrollPane(addressTextarea);
		
		saveButton=new JButton("Save Details");
		saveButton.setFocusPainted(false);
		resetbutton=new JButton("Reset");
		resetbutton.setFocusPainted(false);
		sp = new JSeparator();
		sp.setBackground(Color.BLACK);
		headingFont=new Font("Times New Roman", Font.BOLD+Font.ITALIC, 50);
		    
		headingLabel.setBounds(10,10,500,55);
		headingLabel.setFont(headingFont);
		sp.setBounds(0,80,1500,30);
		
		passidLabel.setBounds(10,100,180,30);
		passidText.setBounds(190,100,180,30);
		passnameLabel.setBounds(10,140,180,30);
		passnameText.setBounds(190,140,180,30);
		passaddressLabel.setBounds(10,180,180,30);
		addressScroll.setBounds(190,180,180,70);
		passcityLabel.setBounds(10,260,180,30);
		passcityText.setBounds(190,260,180,30);
		passcontactLabel.setBounds(10,300,180,30);
		passcontactText.setBounds(190,300,180,30);
		passemailLabel.setBounds(10,340,180,30);
		passemailText.setBounds(190,340,180,30);
		passwordLabel.setBounds(10,380,150,30);
		passwordText.setBounds(190,380,180,30);
		saveButton.setBounds(50,430,120,30);
		resetbutton.setBounds(200,430,120,30);
		
		saveButton.addActionListener(this);
		resetbutton.addActionListener(this);
			
		panel.setLayout(null);
		panel.add(headingLabel);
		panel.add(sp);
		panel.add(passidLabel);
		panel.add(passidText);
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
		panel.add(saveButton);
		panel.add(resetbutton);
	}
	public JPanel getPanel()
	{
		return panel;
	}
	public void actionPerformed(ActionEvent evt) 
	{
		if(evt.getSource()==saveButton)
		{
			if(passnameText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(panel, "Passenger Name is required!");
				passnameText.requestFocus();
			}
			else if(addressTextarea.getText().equals(""))
			{
				JOptionPane.showMessageDialog(panel, "Passenger Address is required!");
				addressTextarea.requestFocus();
			}
			else if(passcityText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(panel, "Passenger City is required!");
				passcityText.requestFocus();
			}
			else if(passcontactText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(panel, "Passenger Contact is required!");
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
					PreparedStatement ps2 = con.prepareStatement("insert into PassengerDetails (passengerID, name, address, city, phone, email,password) values (?, ?, ?, ?, ?, ?, ?)");
					ps2.setString(1,passidText.getText());
					ps2.setString(2, passnameText.getText());					
					ps2.setString(3, addressTextarea.getText());					
					ps2.setString(4, passcityText.getText());					
					ps2.setString(5, passcontactText.getText());					
					ps2.setString(6, passemailText.getText());					
					ps2.setString(7, passwordText.getText());
					int s = ps2.executeUpdate();
					if(s>0)
					{
						JOptionPane.showMessageDialog(panel, "Record Inserted Successfully!");	
						passidText.setText("");
						passnameText.setText("");
						addressTextarea.setText("");
						passcityText.setText("");
						passcontactText.setText("");
						passemailText.setText("");
					}
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(panel, "Cannot Insert Duplicate Passenger Id");
					passidText.requestFocus();
				}
			}
			}
			
		}
		if(evt.getSource()==resetbutton)
		{	
			passidText.setText("");
			addressTextarea.setText("");
			passcityText.setText("");
			passnameText.setText("");
			addressTextarea.setText("");
			passcontactText.setText("");
			passemailText.setText("");
			passwordText.setText("");
			passidText.requestFocus();
			
		}
}
}	