import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
public class StationDetails implements ActionListener
{
	JPanel panel;
	Font headingFont;
	JLabel headingLabel,nameLabel, addressLabel, cityLabel, phoneLabel,stationidLabel,inchargeLabel;
	JTextField nameText,cityText,phoneText,stationidText,inchargeText;
	JScrollPane addressScroll;
	JTextArea addressTextarea;
	JButton saveButton, resetButton;
	JSeparator sp; 
	public StationDetails()
	{
		panel=new JPanel();
		
		headingFont=new Font("Times New Roman", Font.BOLD+Font.ITALIC, 50);
		
		headingLabel=new JLabel("Add Station Details");
		stationidLabel=new JLabel("Station Id: ");
		nameLabel=new JLabel("Enter Station Name : ");
		addressLabel=new JLabel("Enter Station Address : ");
		cityLabel=new JLabel("Enter City : ");
		phoneLabel=new JLabel("Enter Phone Number : ");
		inchargeLabel=new JLabel("<html>Enter Station Incharge : ");
	
		stationidText=new JTextField(10);
		nameText=new JTextField(10);
		cityText=new JTextField(10);
		phoneText=new JTextField(10);
		inchargeText=new JTextField(10);
		
		addressTextarea=new JTextArea(5,10);
		addressTextarea.setLineWrap(true);
		addressTextarea.setWrapStyleWord(true);
		
		addressScroll=new JScrollPane(addressTextarea);
			
		saveButton=new JButton("Save Details");
		resetButton=new JButton("Reset");
	
		headingLabel.setBounds(10,10,500,50);
		headingLabel.setFont(headingFont);
		
		sp = new JSeparator();
		sp.setBackground(Color.BLACK);
		 	
		sp.setBounds(0,80,1500,30);
		stationidLabel.setBounds(10,100,180,30);
		stationidText.setBounds(190,100,180,30);
		nameLabel.setBounds(10,140,180,30);
		nameText.setBounds(190,140,180,30);
		addressLabel.setBounds(10,180,180,30);
		addressScroll.setBounds(190,180,180,60);
		cityLabel.setBounds(10,250,180,30);
		cityText.setBounds(190,250,180,30);
		phoneLabel.setBounds(10,290,180,30);
		phoneText.setBounds(190,290,180,30);
		inchargeLabel.setBounds(10,330,180,30);
		inchargeText.setBounds(190,330,180,30);
				
		saveButton.setBounds(50,380,120,30);
		saveButton.setFocusPainted(false);
		resetButton.setBounds(200,380,120,30);
		resetButton.setFocusPainted(false);

		saveButton.addActionListener(this);
		resetButton.addActionListener(this);
	
		panel.setLayout(null);
		panel.add(headingLabel);
		panel.add(sp);
		panel.add(stationidLabel);
		panel.add(stationidText);
		panel.add(nameLabel);
		panel.add(nameText);
		panel.add(addressLabel);
		panel.add(addressScroll);
		panel.add(cityLabel);
		panel.add(cityText);
		panel.add(phoneLabel);
		panel.add(phoneText);
		panel.add(inchargeLabel);
		panel.add(inchargeText);
		panel.add(saveButton);
		panel.add(resetButton);
	}
	public JPanel getPanel()
	{
		return panel;
	}
		public void actionPerformed(ActionEvent evt) 
	{
		if(evt.getSource()==saveButton)
		{
			if(nameText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(panel, "Staion Name is required!");
				nameText.requestFocus();
			}
			else if(addressTextarea.getText().equals(""))
			{
				JOptionPane.showMessageDialog(panel, "Station Address is required!");
				addressTextarea.requestFocus();
			}
			else if(cityText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(panel, "City is required!");
				cityText.requestFocus();
			}
			else if(phoneText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(panel, "Contact is required!");
				phoneText.requestFocus();
			}
			else
			{
				String sPhoneNumber = phoneText.getText();
				Pattern pattern = Pattern.compile("\\d{10}");
				Matcher matcher = pattern.matcher(sPhoneNumber);
				
		      if (!matcher.matches())
		      {
		    	  JOptionPane.showMessageDialog(panel,"Invalid Phone Number");
		      } 
		      else {
		    	  try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:GaganExpress");
					PreparedStatement ps=con.prepareStatement("insert into StationDetails values(?,?,?,?,?,?)");					
					ps.setString(1, stationidText.getText());
					ps.setString(2, nameText.getText());
					ps.setString(3, addressTextarea.getText());
					ps.setString(4, cityText.getText());
					ps.setString(5, phoneText.getText());
					ps.setString(6, inchargeText.getText());
					int i=ps.executeUpdate();//insert, update, delete
					if(i>0)
					{
						JOptionPane.showMessageDialog(panel, "Record Inserted Successfully!");
						stationidText.setText("");
						nameText.setText("");
						addressTextarea.setText(" ");
						cityText.setText(" ");
						phoneText.setText(" ");
						inchargeText.setText(" ");
					}
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(panel, "Cannot Insert Duplicate Station Id");
					stationidText.requestFocus();
				}
			}
			}
		}
		else if(evt.getSource()==resetButton)
		{
			stationidText.setText("");
			nameText.setText("");
			addressTextarea.setText(" ");
			cityText.setText(" ");
			phoneText.setText(" ");
			inchargeText.setText(" ");
			stationidText.requestFocus();
		}
}
}