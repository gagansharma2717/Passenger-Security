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
public class DeleteStationDetails implements ActionListener
{
	JPanel panel;
	Font headingFont;
	JLabel headingLabel,stationidLabel,nameLabel, addressLabel, cityLabel, phoneLabel,inchargeLabel;
	JTextField nameText,cityText, phoneText,inchargeText;
	JScrollPane addressScroll;
	JTextArea addressTextarea;
	JButton deleteButton, resetButton;
	JComboBox idCombo;
	JSeparator sp;
	public DeleteStationDetails()
	{
		panel=new JPanel();
		headingFont=new Font("Times New Roman", Font.BOLD+Font.ITALIC, 50);
		
		headingLabel=new JLabel("Delete Station Details");
		stationidLabel=new JLabel("Station Id:");
		nameLabel=new JLabel("Enter Station Name : ");
		addressLabel=new JLabel("Enter Customer's Address : ");
		cityLabel=new JLabel("Enter City : ");
		phoneLabel=new JLabel("Enter Phone Number : ");
		inchargeLabel=new JLabel("Enter Station Incharge : ");
		
		nameText=new JTextField(10);
		nameText.setText("");
		cityText=new JTextField(10);
		cityText.setText("");
		phoneText=new JTextField(10);
		phoneText.setText("");
		inchargeText=new JTextField(10);
		inchargeText.setText("");
		
		addressTextarea=new JTextArea(5,10);
		addressTextarea.setLineWrap(true);
		addressTextarea.setWrapStyleWord(true);
		
		addressScroll=new JScrollPane(addressTextarea);
		
		deleteButton=new JButton("Delete");
		deleteButton.setFocusPainted(false);
		resetButton=new JButton("Reset");
		resetButton.setFocusPainted(false);
		
		idCombo=new JComboBox();
		idCombo.insertItemAt("none", 0);
		idCombo.setSelectedIndex(0);
		
		headingLabel.setBounds(10,10,700,50);
		headingLabel.setFont(headingFont);
		
		sp = new JSeparator();
		sp.setBackground(Color.BLACK);
		 	
		sp.setBounds(0,80,1500,30);
		stationidLabel.setBounds(10,100,180,30);
		idCombo.setBounds(190,100,180,30);
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
				
		deleteButton.setBounds(50,380,120,30);
		resetButton.setBounds(200,380,120,30);
		
		deleteButton.addActionListener(this);
		resetButton.addActionListener(this);
		
		idCombo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt) 
			{
				if(idCombo.getSelectedIndex()==0)
				{	
				nameText.setText("");
				addressTextarea.setText("");
				cityText.setText("");
				phoneText.setText("");
				inchargeText.setText("");
				}
				try
				{	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:GaganExpress");
					String tmp=(String) idCombo.getSelectedItem();
					PreparedStatement ps=con.prepareStatement("select name,address,city,phone,incharge from StationDetails where stationId=?");
					ps.setString(1,tmp);
					ResultSet rs=ps.executeQuery();	//insert, update, delete
					if(rs.next())
					{
						String name=rs.getString("name");
						String address=rs.getString("address");
						String city=rs.getString("city");
						String phone=rs.getString("phone");
						String incharge=rs.getString("incharge");
						
						nameText.setText(name.toString().trim());
						addressTextarea.setText(address.toString().trim());
						cityText.setText(city.toString().trim());
						phoneText.setText(phone.toString().trim());
						inchargeText.setText(incharge.toString().trim());
					}
				}
				catch(Exception ee)
				{
				}		
			}
		});
		panel.setLayout(null);
		panel.add(headingLabel);
		panel.add(sp);
		panel.add(stationidLabel);
		panel.add(idCombo);
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
		panel.add(deleteButton);
		panel.add(resetButton);
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:GaganExpress");
			PreparedStatement ps=con.prepareStatement("select * from StationDetails");
			ResultSet rs=ps.executeQuery();	//insert, update, delete
			while(rs.next())
			{
				String id=rs.getString("stationID");
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
				JOptionPane.showMessageDialog(panel,"Please Select Station Id to update the station details...");
		}
		else if(nameText.getText().equals(""))
		{
			JOptionPane.showMessageDialog(panel, "Name is required!");
			nameText.requestFocus();
		}
		else if(addressTextarea.getText().equals(""))
		{
			JOptionPane.showMessageDialog(panel, "Address is required!");
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
				PreparedStatement ps=con.prepareStatement("DELETE StationDetails WHERE stationID ='"+idCombo.getSelectedItem()+"'");
				int i=ps.executeUpdate();//insert, update, delete
				if(i>0)
				{
				JOptionPane.showMessageDialog(panel, "Record Deleted Successfully!");
				idCombo.setSelectedIndex(0);
				nameText.setText("");
				addressTextarea.setText(" ");
				cityText.setText("");
				phoneText.setText("");
				inchargeText.setText("");
				}
		}
		catch(Exception ee)
		{
		}
	      }
		}
	}
		else if(evt.getSource()==resetButton)
	{
		idCombo.setSelectedIndex(0);
		nameText.setText("");
		addressTextarea.setText(" ");
		cityText.setText(" ");
		phoneText.setText(" ");
		inchargeText.setText(" ");
	}
}
}
