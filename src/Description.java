import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
public class Description implements ActionListener
{
	JFrame f;
	JPanel panel,topPanel,bottomPanel;
	JLabel headingLabel;
	BorderLayout border;
	JScrollPane desScroll;
	JTextArea desTextarea;
	JButton okButton,cancelButton;
	Font headingFont;
	ViewComplaint vcmp;
	public Description(String id)
	{
		f=new JFrame();   
		panel=new JPanel();	    
		topPanel=new JPanel();
		topPanel.setPreferredSize(new Dimension(30, 80));
		bottomPanel=new JPanel();
		bottomPanel.setPreferredSize(new Dimension(30,50));
		
		headingLabel=new JLabel("Description");
	

		desTextarea=new JTextArea(5,10);
		desTextarea.setLineWrap(true);
		desTextarea.setWrapStyleWord(true);
		desTextarea.setEditable(false);
		
		desScroll=new JScrollPane(desTextarea);
		
	    okButton=new JButton("Ok");
	    cancelButton=new JButton("Cancel");
	    headingFont=new Font("Times New Roman", Font.BOLD+Font.ITALIC, 50);
	    headingLabel.setBounds(10,10,500,50);
	    headingLabel.setFont(headingFont);
	    border=new BorderLayout();
	  
	    f.add(panel);
	    panel.setLayout(border);
	    panel.add(topPanel, BorderLayout.NORTH);
	    panel.add(bottomPanel, BorderLayout.SOUTH);
	    bottomPanel.add(okButton);
	    bottomPanel.add(cancelButton);
		bottomPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0,Color.BLACK));
	    topPanel.setLayout(null);
	    topPanel.add(headingLabel);
	    panel.add(desScroll,BorderLayout.CENTER);
	    vcmp=new ViewComplaint();
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:GaganExpress");
			PreparedStatement ps=con.prepareStatement("select * from FIRDetails where FID=?");
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();	//insert, update, delete
			while(rs.next())
			{
				String description=rs.getString("description");
				desTextarea.setText(description);
			}
		}
		catch(Exception ee)
		{
		}
	   
	    okButton.addActionListener(this);
	    cancelButton.addActionListener(this);
	    
	    Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		
		f.setLocation((d.width-700)/2,(d.height-400)/2);
	    f.setSize(700,400);
	    f.setResizable(false);
		f.setVisible(true); 
}
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==okButton)
		{
			f.dispose();
		}
		else if(evt.getSource()==cancelButton)
		{
			  String message = " Do You Want to Quit ? ";
              String title = "Quit";
              int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
              if (reply == JOptionPane.YES_OPTION)
              {
                  f.dispose();
              }
		}
	}
}