import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
public class UpdateComplaint implements ActionListener
{
	JPanel panel;
	Font headingFont;
	JLabel headingLabel,FidLabel,incidentLabel,locationLabel,stationLabel,statusLabel,descriptionLabel;
	JTextField incidentText,locationText,stationText;
	JScrollPane desScroll;
	JTextArea desTextarea;
	JComboBox FidCombo,statusCombo;
	JButton updateButton, resetButton;
	JSeparator sp;
	public UpdateComplaint()
	{
		panel=new JPanel();
		
		headingFont=new Font("Times New Roman", Font.BOLD+Font.ITALIC, 50);
		
		headingLabel=new JLabel("Update Complaint Details");
		FidLabel=new JLabel("FIR Id: ");
		incidentLabel=new JLabel("Enter Incident : ");
		locationLabel=new JLabel("Enter Location : ");
		stationLabel=new JLabel("Nearest Station : ");
		statusLabel=new JLabel("Status : ");
		descriptionLabel=new JLabel("Description : ");
		
		incidentText=new JTextField(10); 
		locationText=new JTextField(10);				
		stationText=new JTextField(10);	
		
		desTextarea=new JTextArea(5,10);
		desTextarea.setLineWrap(true);
		desTextarea.setWrapStyleWord(true);
				
		desScroll=new JScrollPane(desTextarea);
		
		FidCombo=new JComboBox();
		FidCombo.insertItemAt("none", 0);
		FidCombo.setSelectedIndex(0);
		String status[]={"Pending","Completed"};
		statusCombo=new JComboBox(status);
		statusCombo.insertItemAt("none", 0);
		statusCombo.setSelectedIndex(0);
	
		FidCombo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt) 
			{
				if(FidCombo.getSelectedIndex()==0)
				{
					incidentText.setText("");
					desTextarea.setText("");
					locationText.setText("");
					statusCombo.setSelectedItem("none");
					stationText.setText("");
				}
				try
				{	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:GaganExpress");
					String tmp=(String) FidCombo.getSelectedItem();
					PreparedStatement ps=con.prepareStatement("select incident,location,station,status,description from FIRDetails where FId=?");
					ps.setString(1,tmp);
					ResultSet rs=ps.executeQuery();	//insert, update, delete
					if(rs.next())
					{
						String incident=rs.getString("incident");
						String location=rs.getString("location");
						String station=rs.getString("station");
						String status=rs.getString("status");
						String description=rs.getString("description");
						
						incidentText.setText(incident.toString().trim());
						locationText.setText(location.toString().trim());
						stationText.setText(station.toString().trim());
						statusCombo.setSelectedItem(status.toString().trim());
						desTextarea.setText(description.toString().trim());
					}
				}
				catch(Exception ee)
				{
				}		
			}
		});
		updateButton=new JButton("Update");
		updateButton.setFocusPainted(false);
		resetButton=new JButton("Reset");
		resetButton.setFocusPainted(false);
		headingLabel.setBounds(10,10,700,55);
		headingLabel.setFont(headingFont);
		
		sp = new JSeparator();
		sp.setBackground(Color.BLACK);
		 	
		sp.setBounds(0,80,1500,30);
		FidLabel.setBounds(10,100,190,30);
		FidCombo.setBounds(190,100,190,30);
		incidentLabel.setBounds(10,140,190,30);
		incidentText.setBounds(190,140,190,30);
		locationLabel.setBounds(10,180,190,30);
		locationText.setBounds(190,180,190,30);
		stationLabel.setBounds(10,220,190,30);
		stationText.setBounds(190,220,190,30);
		statusLabel.setBounds(10,260,190,30);
		statusCombo.setBounds(190,260,190,30);
		descriptionLabel.setBounds(10,300,150,30);
		desScroll.setBounds(190,300,190,80);
		updateButton.setBounds(50,430,120,30);
		resetButton.setBounds(200,430,120,30);
	
		
		updateButton.addActionListener(this);
		resetButton.addActionListener(this);
		
		panel.setLayout(null);
		panel.add(headingLabel);
		panel.add(sp);
		panel.add(FidLabel);
		panel.add(FidCombo);
		panel.add(incidentLabel);
		panel.add(incidentText);
		panel.add(locationLabel);;
		panel.add(locationText);
		panel.add(stationLabel);
		panel.add(stationText);
		panel.add(statusLabel);
		panel.add(statusCombo);
		panel.add(descriptionLabel);
		panel.add(desScroll);
		panel.add(updateButton);
		panel.add(resetButton);
		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:GaganExpress");
			PreparedStatement ps=con.prepareStatement("select * from FIRDetails");
			ResultSet rs=ps.executeQuery();	//insert, update, delete
			while(rs.next())
			{
				String id=rs.getString("FID");
				FidCombo.addItem(id);
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
		if(evt.getSource()==updateButton)
		{
			if(FidCombo.getSelectedIndex()==0)
		{
				JOptionPane.showMessageDialog(panel,"Please Select FIR Id to update the complaint details...");
		}		
			else if(incidentText.getText().equals(""))
		{
			JOptionPane.showMessageDialog(panel, "Incident is required!");
			incidentText.requestFocus();
		}
		else if(locationText.getText().equals(""))
		{
			JOptionPane.showMessageDialog(panel, "Location is required!");
			locationText.requestFocus();
		}
		else if(stationText.getText().equals(""))
		{
			JOptionPane.showMessageDialog(panel, "Station Name is required!");
			stationText.requestFocus();
		}
		else if(statusCombo.getSelectedIndex()==0)
		{
			JOptionPane.showMessageDialog(panel, "Status is required!");
			statusCombo.requestFocus();
		}
		else if(desTextarea.getText().equals(""))
		{
			JOptionPane.showMessageDialog(panel, "Description is required!");
			desTextarea.requestFocus();
		}
	      else {
	    	  try
	    	  {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:GaganExpress");
				PreparedStatement ps=con.prepareStatement("UPDATE FIRDetails SET incident ='"+incidentText.getText()+"',location='"+locationText.getText()+"',station='"+stationText.getText()+"',status='"+statusCombo.getSelectedItem().toString().trim()+"',description='"+desTextarea.getText()+"' WHERE FID ='"+FidCombo.getSelectedItem()+"'");
				int i=ps.executeUpdate();//insert, update, delete
				if(i>0)
				{
				JOptionPane.showMessageDialog(panel, "Record Updated Successfully!");
				FidCombo.setSelectedIndex(0);
				stationText.setText("");
				statusCombo.setSelectedIndex(0);
				locationText.setText("");
				incidentText.setText("");
			}
		}
		catch(Exception ee)
		{
		}
	      }
		}

	if(evt.getSource()==resetButton)
	{
		FidCombo.setSelectedIndex(0);
		stationText.setText("");
		statusCombo.setSelectedIndex(0);
		locationText.setText("");
		incidentText.setText("");
	}	
}		
} 