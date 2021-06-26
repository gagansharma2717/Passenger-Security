import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class AddComplaint implements ActionListener,Runnable
{
	GregorianCalendar gc;
	Thread datetimeThread;
	JPanel panel;
	Font headingFont;
	JLabel headingLabel,firidLabel,incidentLabel,desLabel,statusLabel,locLabel,stationLabel,passengeridLabel,passengernameLabel,passengeraddressLabel,passengercityLabel,passengercontactLabel,dateLabel,timeLabel,passengeremailLabel;
	JTextField firidText,incidentText,locText,passengercityText,passengernameText,passengercontactText,dateText,timeText,passengeremailText;
	JScrollPane addressScroll,desScroll;
	JTextArea addressTextarea,desTextarea;
	JButton saveButton, resetButton;
	JComboBox passengeridCombo,stationCombo,statusCombo;
	JSeparator sp;
	public AddComplaint()
	{
		panel=new JPanel();
	
		headingLabel=new JLabel("Add Complaint Details");
		dateLabel=new JLabel("Date:");
		timeLabel=new JLabel("Time:");
		firidLabel=new JLabel("FIR Id: ");
		incidentLabel=new JLabel("Incident : ");
		desLabel=new JLabel("Description : ");
		statusLabel=new JLabel("Status : ");
		locLabel=new JLabel("Location : ");
		stationLabel=new JLabel("Nearest Station : ");
		passengeridLabel=new JLabel("Passenger Id: ");
		passengernameLabel=new JLabel("Enter Passenger's Name : ");
		passengeraddressLabel=new JLabel("Enter Passenger's Address : ");
		passengercityLabel=new JLabel("Enter Passenger's City : ");
		passengercontactLabel=new JLabel("Enter Passenger's Contact : ");
		passengeremailLabel=new JLabel("<html>Enter Email ID : <br>(Optional)</html>");
	
		dateText=new JTextField(10);
		timeText=new JTextField(10);
		firidText=new JTextField(10);
		incidentText=new JTextField(10);  
		locText=new JTextField(10);
		passengernameText=new JTextField(10);
		passengernameText.setText(null);
		passengercityText=new JTextField(10);
		passengercontactText=new JTextField(10);
		passengeremailText=new JTextField(10);
		
		addressTextarea=new JTextArea(5,10);
		addressTextarea.setLineWrap(true);
		addressTextarea.setWrapStyleWord(true);
		
		desTextarea=new JTextArea(5,10);
		desTextarea.setLineWrap(true);
		desTextarea.setWrapStyleWord(true);
		
		addressScroll=new JScrollPane(addressTextarea);
		desScroll=new JScrollPane(desTextarea);
		
		saveButton=new JButton("Save Details");
		saveButton.setFocusPainted(false);
		resetButton=new JButton("Reset");
		resetButton.setFocusPainted(false);
		
		passengeridCombo=new JComboBox();
		passengeridCombo.insertItemAt("none", 0);
		passengeridCombo.setSelectedIndex(0);
		stationCombo=new JComboBox();
		stationCombo.insertItemAt("none", 0);
		stationCombo.setSelectedIndex(0);
		String status[]={"Pending","Completed"};
		statusCombo=new JComboBox(status);
		statusCombo.insertItemAt("none", 0);
		statusCombo.setSelectedIndex(0);
	
		sp = new JSeparator();
		sp.setBackground(Color.BLACK);
		headingFont=new Font("Times New Roman", Font.BOLD+Font.ITALIC, 50);
		    
		headingLabel.setBounds(10,10,500,50);
		headingLabel.setFont(headingFont);
		sp.setBounds(0,80,1500,30);
		
		dateLabel.setBounds(900,100,180,30);
		dateText.setBounds(950,100,100,30);
		timeLabel.setBounds(900,140,180,30);
		timeText.setBounds(950,140,100,30);
		firidLabel.setBounds(10,100,180,30);
		firidText.setBounds(190,100,180,30);
		incidentLabel.setBounds(10,140,180,30);
		incidentText.setBounds(190,140,180,30);
		locLabel.setBounds(10,180,180,30);
		locText.setBounds(190,180,180,30);
		stationLabel.setBounds(10,220,180,30);
		stationCombo.setBounds(190,220,180,30);
		statusLabel.setBounds(10,260,180,30);
		statusCombo.setBounds(190,260,180,30);
		desLabel.setBounds(10,300,180,30);
		desScroll.setBounds(190,300,180,100);

		saveButton.setBounds(350,440,120,30);
		resetButton.setBounds(500,440,120,30);
		
		passengeridLabel.setBounds(440,100,180,30);
		passengeridCombo.setBounds(630,100,180,30);
		passengernameLabel.setBounds(440,140,180,30);
		passengernameText.setBounds(630,140,180,30);
		passengeraddressLabel.setBounds(440,180,180,30);
		addressScroll.setBounds(630,180,180,80);
		passengercityLabel.setBounds(440,270,180,30);
		passengercityText.setBounds(630,270,180,30);
		passengercontactLabel.setBounds(440,310,180,30);
		passengercontactText.setBounds(630,310,180,30);
		passengeremailLabel.setBounds(440,350,180,30);
		passengeremailText.setBounds(630,350,180,30);
		
		saveButton.addActionListener(this);
		resetButton.addActionListener(this);
		passengeridCombo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt) 
			{	
				if(passengeridCombo.getSelectedIndex()==0)
				{	
				passengernameText.setText("");
				addressTextarea.setText("");
				passengercityText.setText("");
				passengercontactText.setText("");
				passengeremailText.setText("");
					
				}
				try
				{	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:GaganExpress");
					String tmp=(String) passengeridCombo.getSelectedItem();
					PreparedStatement ps=con.prepareStatement("select name,address,city,phone,email from PassengerDetails where passengerId=?");
					ps.setString(1,tmp);
					ResultSet rs=ps.executeQuery();	//insert, update, delete
					if(rs.next())
					{
						String name=rs.getString("name");
						String passengeraddress=rs.getString("address");
						String city=rs.getString("city");
						String phone=rs.getString("phone");
						String passengeremail=rs.getString("email");
						
						passengernameText.setText(name);
						addressTextarea.setText(passengeraddress.toString().trim());
						passengercityText.setText(city);
						passengercontactText.setText(phone);
						passengeremailText.setText(passengeremail.toString().trim());
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
		panel.add(dateLabel);
		panel.add(dateText);
		panel.add(timeLabel);
		panel.add(timeText);
		panel.add(firidLabel);
		panel.add(firidText);
		panel.add(incidentLabel);
		panel.add(incidentText);
		panel.add(locLabel);
		panel.add(statusLabel);
		panel.add(desLabel);
		panel.add(desScroll);
		panel.add(statusCombo);
		panel.add(locText);
		panel.add(stationLabel);
		panel.add(stationCombo);
		panel.add(passengeridLabel);
		panel.add(passengeridCombo);
		panel.add(passengernameLabel);
		panel.add(passengernameText);
		panel.add(passengeraddressLabel);
		panel.add(addressScroll);
		panel.add(passengercityLabel);
		panel.add(passengercityText);
		panel.add(passengercontactLabel);
		panel.add(passengercontactText);
		panel.add(passengeremailLabel);
		panel.add(passengeremailText);
		
		panel.add(saveButton);
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
				passengeridCombo.addItem(id);
			}
		}
		catch(Exception ee)
		{
		}
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:GaganExpress");
			PreparedStatement ps=con.prepareStatement("select * from StationDetails");
			ResultSet rs=ps.executeQuery();	//insert, update, delete
			while(rs.next())
			{
				String name=rs.getString("name");
				stationCombo.addItem(name);
			}
		}
		catch(Exception ee)
		{
		}
		datetimeThread=new Thread(this);
		datetimeThread.start();
}
	public JPanel getPanel()
	{
		return panel;
	}
	public void actionPerformed(ActionEvent evt) 
	{
		if(evt.getSource()==saveButton)
		{
			if(passengeridCombo.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(panel,"Please Select Passenger Id to add the passenger...");
			}
			else if(firidText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(panel, "FIR ID is required!");
				firidText.requestFocus();
			}
			else if(incidentText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(panel, "Incident is required!");
				incidentText.requestFocus();
			}
			else if(statusCombo.getSelectedItem().equals("none"))
			{
				JOptionPane.showMessageDialog(panel, "Location is required!");
				statusCombo.requestFocus();
			}
			else if(desTextarea.getText().equals(""))
			{
				JOptionPane.showMessageDialog(panel, "Description is required!");
				desTextarea.requestFocus();
			}
			else if(locText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(panel, "Status is required!");
				locText.requestFocus();
			}
			else if(stationCombo.getSelectedItem().equals("none"))
			{
				JOptionPane.showMessageDialog(panel, "Nearest Station is required!");
				stationCombo.requestFocus();
			}
			else
			{
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:GaganExpress");
					PreparedStatement ps=con.prepareStatement("insert into FIRDetails (FID, name, description, status, incident, location, station, date, time) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
					ps.setString(1, firidText.getText());
					ps.setString(2, passengernameText.getText());
					ps.setString(3, desTextarea.getText());
					ps.setString(4, statusCombo.getSelectedItem().toString().trim());
					ps.setString(5, incidentText.getText());
					ps.setString(6, locText.getText());
					ps.setString(7, stationCombo.getSelectedItem().toString().trim());
					ps.setString(8, dateText.getText().toString().trim());
					ps.setString(9, timeText.getText().toString().trim());
					int i=ps.executeUpdate();//insert, update, delete
					if(i>0)
					{
						JOptionPane.showMessageDialog(panel, "Record Inserted Successfully!");
						passengeridCombo.setSelectedIndex(0);
						firidText.setText("");
						incidentText.setText("");
						statusCombo.setSelectedIndex(0);
						locText.setText("");
						desTextarea.setText("");
						stationCombo.setSelectedIndex(0);
							
						passengernameText.setText("");
						addressTextarea.setText("");
						passengercityText.setText("");
						passengercontactText.setText("");
						passengeremailText.setText("");
					}
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(panel, "Cannot Insert Duplicate FIR Id");
					firidText.requestFocus();
				}
			}
			}
		if(evt.getSource()==resetButton)
		{
			passengeridCombo.setSelectedIndex(0);
			firidText.setText("");
			incidentText.setText("");
			statusCombo.setSelectedIndex(0);
			locText.setText("");
			desTextarea.setText("");
			stationCombo.setSelectedIndex(0);
				
			passengernameText.setText("");
			addressTextarea.setText("");
			passengercityText.setText("");
			passengercontactText.setText("");
			passengeremailText.setText("");
			firidText.requestFocus();
		}
}
public void run() {
			try {
				while(true)
				{
					gc=new GregorianCalendar();
					int DD=gc.get(Calendar.DATE);
					int MM=gc.get(Calendar.MONTH);
					int YYYY=gc.get(Calendar.YEAR);
					dateText.setText(DD+"/"+MM+"/"+YYYY);
					dateText.setCaretColor(Color.WHITE);
					int hh=gc.get(Calendar.HOUR);
					if(hh==0) 
					{
						hh=12;
					}
					int mm=gc.get(Calendar.MINUTE);
					int ampm=gc.get(Calendar.AM_PM);
					if(ampm==1)
					{	
					timeText.setText(hh+":"+mm+" PM");
					Thread.sleep(1000);
					}
					else
					{
						timeText.setText(hh+":"+mm+" AM");
						Thread.sleep(1000);
					}
					timeText.setCaretColor(Color.WHITE);
				}
			} catch (Exception e) 
			{
			}
	}
		
}