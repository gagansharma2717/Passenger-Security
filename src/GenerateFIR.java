import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
public class GenerateFIR implements ActionListener
{
	JPanel panel;
	Font headingFont;
	JLabel headingLabel,firidLabel;
	JTextField firidText;
	JButton printButton, resetButton;
	JSeparator sp;
	String firno=null;
	public GenerateFIR()
	{
		panel=new JPanel();
		
		headingFont=new Font("Times New Roman", Font.BOLD+Font.ITALIC, 50);
	    
		headingLabel=new JLabel("Generate FIR");
		firidLabel=new JLabel("Enter FIR Number : ");

		firidText=new JTextField(10);
		
		printButton=new JButton("Print");
		printButton.setFocusPainted(false);
		resetButton=new JButton("Reset");
		resetButton.setFocusPainted(false);
		
		sp = new JSeparator();
		sp.setBackground(Color.BLACK);
		 	
		sp.setBounds(0,80,1500,30);
		headingLabel.setBounds(10,10,500,50);
		headingLabel.setFont(headingFont);
		firidLabel.setBounds(10,120,180,30);
		firidText.setBounds(150,120,180,30);
		printButton.setBounds(100,170,80,30);
		resetButton.setBounds(200,170,80,30);
		
		printButton.addActionListener(this);
		resetButton.addActionListener(this);
		
		panel.setLayout(null);
		panel.add(headingLabel);
		panel.add(sp);
		panel.add(firidLabel);
		panel.add(firidText);
		panel.add(printButton);
		panel.add(resetButton);
	}
	public JPanel getPanel()
	{
		return panel;
	}
	public void actionPerformed(ActionEvent evt) 
	{
		if(evt.getSource()==printButton)
		{
			try
			{	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:GaganExpress");
				PreparedStatement ps=con.prepareStatement("select FID from FIRDetails where FID=?");
				ps.setString(1,firidText.getText().toString());
				ResultSet rs=ps.executeQuery();	//insert, update, delete
				if(rs.next())
				{
					firno=rs.getString("FID");
				}
			}
			catch(Exception ee)
			{
			}
			if(firidText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(panel, "FIR Number is required!");
				firidText.requestFocus();
			}
			else if(firidText.getText().equals(firno))
			{
				String firno=firidText.getText();
				new FIRFormat(firno);
			}
			else
			JOptionPane.showMessageDialog(panel,"FIR Number Not Found...");
			firidText.setText("");
			firidText.requestFocus();
		}
		if(evt.getSource()==resetButton)
		{
			firidText.setText("");
			firidText.requestFocus();
		}
}
}