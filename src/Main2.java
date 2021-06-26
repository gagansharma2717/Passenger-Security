import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main2 implements ActionListener 
{
	JFrame frame;
	JPanel mainPanel, topPanel, bottomPanel,leftPanel;
	ImageIcon logoIcon,addstationIcon,viewstationIcon,updatestationIcon,deletestationIcon,addpassengerIcon,viewpassengerIcon,updatepassengerIcon,deletepassengerIcon,addcomplaintIcon,viewcomplainticon,updatecomplaintIcon,deletecomplaintIcon;
	JButton addstationButton,viewstationButton,updatestationButton,deletestationButton,addpassengerButton,viewpassengerButton,updatepassengerButton,deletepassengerButton,addcomplaintButton,viewcomplaintButton,updatecomplaintButton,deletecomplaintButton;
	JLabel logoLabel,stationLabel,searchLabel,passengerLabel,complaintLabel,addstationLabel,viewstationLabel,updatestationLabel,deletestationLabel,addpassengerLabel,viewpassengerLabel,updatepassengerLabel,deletepassengerLabel,addcomplaintLabel,viewcomplaintLabel,updatecomplaintLabel,deletecomplaintLabel;
	JButton generateButton,closeButton;
	JSeparator startsp,stsp,passsp,searsp,comsp,endsp;
	Font headingFont, labelFont, textFont;
	//Layout
	BorderLayout border;
	FlowLayout flow;
	//Classes	
	BlankPanel blank;
	StationDetails as;
	ViewStationDetails vsd;
	UpdateStationDetails usd;
	DeleteStationDetails dsd;
	AddPassenger addpass;
	ViewPassengerDetails vpassd;
	UpdatePassengerDetails uppd;
	DeletePassengerDetails delpd;
	AddComplaint acom;
	ViewComplaint vcom;
	UpdateComplaint ucom;
	DeleteComplaint dcom;
	GenerateFIR gfr;
	public Main2()
	{
		frame=new JFrame("Passenger Security");

		mainPanel=new JPanel();
		topPanel=new JPanel();
		topPanel.setPreferredSize(new Dimension(30, 135));
		bottomPanel=new JPanel();
		bottomPanel.setPreferredSize(new Dimension(30, 60));
		
		logoIcon=new ImageIcon("Images/railtop.png");
		addstationIcon=new ImageIcon("Images/rail.png");
		viewstationIcon=new ImageIcon("Images/viewstation.png");
		updatestationIcon=new ImageIcon("Images/updatestation.png");
		deletestationIcon=new ImageIcon("Images/deletestation.png");
		addpassengerIcon=new ImageIcon("Images/addpassenger.png");
		viewpassengerIcon=new ImageIcon("Images/viewpassenger.png");
		updatepassengerIcon=new ImageIcon("Images/updatepassenger.png");
		deletepassengerIcon=new ImageIcon("Images/deletepassenger.png");
		addcomplaintIcon=new ImageIcon("Images/addcomplaint.png");
		viewcomplainticon=new ImageIcon("Images/viewcomplaint.png");
		updatecomplaintIcon=new ImageIcon("Images/updatecomplaint.png");
		deletecomplaintIcon=new ImageIcon("Images/deletecomplaint.png");
		
		addstationButton=new JButton(addstationIcon);
		addstationButton.setPreferredSize(new Dimension(48,48));
		viewstationButton=new JButton(viewstationIcon);
		viewstationButton.setPreferredSize(new Dimension(48,48));
		updatestationButton=new JButton(updatestationIcon);
		updatestationButton.setPreferredSize(new Dimension(48,48));
		deletestationButton=new JButton(deletestationIcon);
		deletestationButton.setPreferredSize(new Dimension(48,48));
		addpassengerButton=new JButton(addpassengerIcon);
		addpassengerButton.setPreferredSize(new Dimension(48,48));
		viewpassengerButton=new JButton(viewpassengerIcon);
		viewpassengerButton.setPreferredSize(new Dimension(48,48));
		updatepassengerButton=new JButton(updatepassengerIcon);
		updatepassengerButton.setPreferredSize(new Dimension(48,48));
		deletepassengerButton=new JButton(deletepassengerIcon);
		deletepassengerButton.setPreferredSize(new Dimension(48,48));
		addcomplaintButton	=new JButton(addcomplaintIcon);
		addcomplaintButton.setPreferredSize(new Dimension(48,48));		
		viewcomplaintButton=new JButton(viewcomplainticon);
		viewcomplaintButton.setPreferredSize(new Dimension(48,48));
		updatecomplaintButton=new JButton(updatecomplaintIcon);
		updatecomplaintButton.setPreferredSize(new Dimension(48,48));
		deletecomplaintButton=new JButton(deletecomplaintIcon);
		deletecomplaintButton.setPreferredSize(new Dimension(48,48));
		
		stationLabel=new JLabel("Station");
		searchLabel=new JLabel("Search");
		passengerLabel=new JLabel("Passenger");
		complaintLabel=new JLabel("Complaint");
		
		addstationLabel=new JLabel("<html>Add<br>Station<br>Details</html>");
		viewstationLabel=new JLabel("<html>View<br>Station<br>Details</html>");
		updatestationLabel=new JLabel("<html>Update<br>Station<br>Details</html>");
		deletestationLabel=new JLabel("<html>Delete<br>Station<br>Details</html>");
		addpassengerLabel=new JLabel("<html>Add<br>Passenger<br>Details</html>");
		viewpassengerLabel=new JLabel("<html>View<br>Passenger<br>Details</html>");
		updatepassengerLabel=new JLabel("<html>Update<br>Passenger<br>Details</html>");
		deletepassengerLabel=new JLabel("<html>Delete<br>Passenger<br>Details</html>");
		addcomplaintLabel=new JLabel("<html>Add<br>Complaint<br>Details</html>");
		viewcomplaintLabel=new JLabel("<html>View<br>Complaint<br>Details</html>");
		updatecomplaintLabel=new JLabel("<html>Update<br>Complaint<br>Details</html>");
		deletecomplaintLabel=new JLabel("<html>Delete<br>Complaint<br>Details</html>");
		
		logoLabel=new JLabel(logoIcon);
		
		generateButton=new JButton("Generate FIR");
		generateButton.setFocusPainted(false);
		
		closeButton=new JButton("Close");
		closeButton.setFocusPainted(false);
		
		startsp = new JSeparator();
		startsp.setBackground(Color.BLACK);
		stsp = new JSeparator(SwingConstants.VERTICAL);
		stsp.setBackground(Color.BLACK);
		passsp = new JSeparator(SwingConstants.VERTICAL);
		passsp.setBackground(Color.BLACK);
		searsp = new JSeparator(SwingConstants.VERTICAL);
		searsp.setBackground(Color.BLACK);
		comsp = new JSeparator(SwingConstants.VERTICAL);
		comsp.setBackground(Color.BLACK);
		endsp = new JSeparator(SwingConstants.VERTICAL);
		endsp.setBackground(Color.BLACK);

		headingFont=new Font("Curlz MT", Font.BOLD+Font.ITALIC, 30);
		labelFont=new Font("Times New Roman", Font.BOLD, 18);
		textFont=new Font("Tahoma", Font.ITALIC, 25);
		
		stationLabel.setFont(labelFont);
		searchLabel.setFont(labelFont);
		passengerLabel.setFont(labelFont);
		complaintLabel.setFont(labelFont);
			
		border=new BorderLayout();
		flow=new FlowLayout(FlowLayout.LEFT);
		
		frame.add(mainPanel);
		
		mainPanel.setLayout(border);
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		blank=new BlankPanel();
		mainPanel.add(blank.getPanel(), BorderLayout.CENTER);
		topPanel.setLayout(null);
		startsp.setBounds(0,23,751,190);	
		stationLabel.setBounds(100,0,100,30);
		addstationButton.setBounds(10,30,48,48);
		addstationLabel.setBounds(15,85,56,48);
		viewstationButton.setBounds(70,30,48,48);
		viewstationLabel.setBounds(75,85,56,48);
		updatestationButton.setBounds(130,30,48,48);
		updatestationLabel.setBounds(135,85,56,48);
		deletestationButton.setBounds(190,30,48,48);
		deletestationLabel.setBounds(195,85,56,48);
		stsp.setBounds(250,0,190,190);	
			
		searchLabel.setBounds(240,0,100,30);
		passsp.setBounds(340,0,190,190);
	
		passengerLabel.setBounds(330,0,100,30);
		addpassengerButton.setBounds(260,30,48,48);
		addpassengerLabel.setBounds(265,85,48,48);
		viewpassengerButton.setBounds(320,30,48,48);
		viewpassengerLabel.setBounds(325,85,56,48);
		updatepassengerButton.setBounds(380,30,48,48);	
		updatepassengerLabel.setBounds(385,85,56,48);
		deletepassengerButton.setBounds(440,30,48,48);	
		deletepassengerLabel.setBounds(445,85,56,48);
		comsp.setBounds(500,0,190,190);	
		
		complaintLabel.setBounds(580,0,100,30);
		addcomplaintButton.setBounds(510,30,48,48);
		addcomplaintLabel.setBounds(515,85,56,48);
		viewcomplaintButton.setBounds(570,30,48,48);	
		viewcomplaintLabel.setBounds(575,85,56,48);
		updatecomplaintButton.setBounds(630,30,48,48);	
		updatecomplaintLabel.setBounds(635,85,56,48);
		deletecomplaintButton.setBounds(690,30,48,48);	
		deletecomplaintLabel.setBounds(695,85,56,48);
		endsp.setBounds(750,0,190,190);
		
		logoLabel.setBounds(1130,0,300,133);
		topPanel.add(startsp);
		topPanel.add(stationLabel);
		topPanel.add(addstationButton);
		topPanel.add(addstationLabel);
		topPanel.add(viewstationButton);
		topPanel.add(viewstationLabel);
		topPanel.add(updatestationButton);
		topPanel.add(updatestationLabel);
		topPanel.add(deletestationButton);
		topPanel.add(deletestationLabel);
		topPanel.add(stsp);
	
		topPanel.add(passengerLabel);
		topPanel.add(addpassengerButton);
		topPanel.add(addpassengerLabel);
		topPanel.add(viewpassengerButton);
		topPanel.add(viewpassengerLabel);
		topPanel.add(updatepassengerButton);
		topPanel.add(updatepassengerLabel);
		topPanel.add(deletepassengerButton);
		topPanel.add(deletepassengerLabel);
		topPanel.add(searsp);
		topPanel.add(complaintLabel);
		topPanel.add(addcomplaintButton);
		topPanel.add(addcomplaintLabel);
		topPanel.add(viewcomplaintButton);
		topPanel.add(viewcomplaintLabel);
		topPanel.add(updatecomplaintButton);
		topPanel.add(updatecomplaintLabel);
		topPanel.add(deletecomplaintButton);
		topPanel.add(deletecomplaintLabel);
		topPanel.add(comsp);	
		topPanel.add(endsp);		
		topPanel.add(logoLabel);
		
		bottomPanel.setLayout(null);
		generateButton.setBounds(550,10,150,40);
		closeButton.setBounds(710,10,150,40);
		
		bottomPanel.add(generateButton);
		bottomPanel.add(closeButton);

		generateButton.setFont(labelFont);
		closeButton.setFont(labelFont);

		topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,Color.BLACK));
		bottomPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0,Color.BLACK));
		
		addstationButton.addActionListener(this);
		viewstationButton.addActionListener(this);
		updatestationButton.addActionListener(this);
		deletestationButton.addActionListener(this);
		addpassengerButton.addActionListener(this);
		viewpassengerButton.addActionListener(this);
		updatepassengerButton.addActionListener(this);
		deletepassengerButton.addActionListener(this);
		addcomplaintButton.addActionListener(this);
		viewcomplaintButton.addActionListener(this);
		updatecomplaintButton.addActionListener(this);
		deletecomplaintButton.addActionListener(this);
		generateButton.addActionListener(this);
		closeButton.addActionListener(this);
		closeButton.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent event)
			{
			  if (event.getClickCount() == 2) {
				  String message = " Do You Want to Quit ? ";
	                String title = "Quit";
	                int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
	                if (reply == JOptionPane.YES_OPTION)
	                {
	                    System.exit(0);
	                }
			  }
			}
			public void mouseEntered(MouseEvent arg0)
			{
			}
			public void mouseExited(MouseEvent arg0) 
			{
			}
			public void mousePressed(MouseEvent arg0)
			{
			}
			public void mouseReleased(MouseEvent arg0) 
			{
			}
		});
		frame.setSize(500, 500);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String args[])
	{
		 try 
		  {
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         }
		  catch (Exception e) {
        }
		new Main2();
	}
	public void actionPerformed(ActionEvent evt) 
	{
		if(evt.getSource()==addstationButton)
		{	
			mainPanel.removeAll();
			mainPanel.add(topPanel, BorderLayout.NORTH);
			mainPanel.add(bottomPanel, BorderLayout.SOUTH);
			as= new StationDetails();
			mainPanel.add(as.getPanel(), BorderLayout.CENTER);
			mainPanel.revalidate();
			mainPanel.repaint();
		}
		else if(evt.getSource()==viewstationButton)
		{
			mainPanel.removeAll();
			mainPanel.add(topPanel, BorderLayout.NORTH);
			mainPanel.add(bottomPanel, BorderLayout.SOUTH);
			vsd=new ViewStationDetails();
			mainPanel.add(vsd.getPanel(),BorderLayout.CENTER);
			mainPanel.revalidate();
			mainPanel.repaint();
		}
		else if(evt.getSource()==updatestationButton)
		{
			mainPanel.removeAll();
			mainPanel.add(topPanel, BorderLayout.NORTH);
			mainPanel.add(bottomPanel, BorderLayout.SOUTH);
			usd=new UpdateStationDetails();
			mainPanel.add(usd.getPanel(),BorderLayout.CENTER);
			mainPanel.revalidate();
			mainPanel.repaint();
		}
		else if(evt.getSource()==deletestationButton)
		{
			mainPanel.removeAll();
			mainPanel.add(topPanel, BorderLayout.NORTH);
			mainPanel.add(bottomPanel, BorderLayout.SOUTH);
			dsd=new DeleteStationDetails();
			mainPanel.add(dsd.getPanel(),BorderLayout.CENTER);
			mainPanel.revalidate();
			mainPanel.repaint();
		}
		else if(evt.getSource()==addpassengerButton)
		{
			mainPanel.removeAll();
			mainPanel.add(topPanel, BorderLayout.NORTH);
			mainPanel.add(bottomPanel, BorderLayout.SOUTH);
			addpass=new AddPassenger();
			mainPanel.add(addpass.getPanel(),BorderLayout.CENTER);
			mainPanel.revalidate();
			mainPanel.repaint();
		}
		else if(evt.getSource()==viewpassengerButton)
		{
			mainPanel.removeAll();
			mainPanel.add(topPanel, BorderLayout.NORTH);
			mainPanel.add(bottomPanel, BorderLayout.SOUTH);
			vpassd=new ViewPassengerDetails();
			mainPanel.add(vpassd.getPanel(),BorderLayout.CENTER);
			mainPanel.revalidate();
			mainPanel.repaint();
		}
		else if(evt.getSource()==updatepassengerButton)
		{
			mainPanel.removeAll();
			mainPanel.add(topPanel, BorderLayout.NORTH);
			mainPanel.add(bottomPanel, BorderLayout.SOUTH);
			uppd=new UpdatePassengerDetails();
			mainPanel.add(uppd.getPanel(),BorderLayout.CENTER);
			mainPanel.revalidate();
			mainPanel.repaint();
		}
		else if(evt.getSource()==deletepassengerButton)
		{
			mainPanel.removeAll();
			mainPanel.add(topPanel, BorderLayout.NORTH);
			mainPanel.add(bottomPanel, BorderLayout.SOUTH);
			delpd=new DeletePassengerDetails();
			mainPanel.add(delpd.getPanel(),BorderLayout.CENTER);
			mainPanel.revalidate();
			mainPanel.repaint();
		}
		else if(evt.getSource()==addcomplaintButton)
		{
			mainPanel.removeAll();
			mainPanel.add(topPanel, BorderLayout.NORTH);
			mainPanel.add(bottomPanel, BorderLayout.SOUTH);
			acom=new AddComplaint();
			mainPanel.add(acom.getPanel(),BorderLayout.CENTER);
			mainPanel.revalidate();
			mainPanel.repaint();
			
		}
		else if(evt.getSource()==viewcomplaintButton)
		{
			mainPanel.removeAll();
			mainPanel.add(topPanel, BorderLayout.NORTH);
			mainPanel.add(bottomPanel, BorderLayout.SOUTH);
			vcom=new ViewComplaint();
			mainPanel.add(vcom.getPanel(),BorderLayout.CENTER);
			mainPanel.revalidate();
			mainPanel.repaint();
			
		}
		else if(evt.getSource()==updatecomplaintButton)
		{
			mainPanel.removeAll();
			mainPanel.add(topPanel, BorderLayout.NORTH);
			mainPanel.add(bottomPanel, BorderLayout.SOUTH);
			ucom=new UpdateComplaint();
			mainPanel.add(ucom.getPanel(),BorderLayout.CENTER);
			mainPanel.revalidate();
			mainPanel.repaint();
			
		}
		else if(evt.getSource()==deletecomplaintButton)
		{
			mainPanel.removeAll();
			mainPanel.add(topPanel, BorderLayout.NORTH);
			mainPanel.add(bottomPanel, BorderLayout.SOUTH);
			dcom=new DeleteComplaint();
			mainPanel.add(dcom.getPanel(),BorderLayout.CENTER);
			mainPanel.revalidate();
			mainPanel.repaint();	
		}
		else if(evt.getSource()==generateButton)
		{
			mainPanel.removeAll();
			mainPanel.add(topPanel, BorderLayout.NORTH);
			mainPanel.add(bottomPanel, BorderLayout.SOUTH);
			gfr=new GenerateFIR();
			mainPanel.add(gfr.getPanel(),BorderLayout.CENTER);
			mainPanel.revalidate();
			mainPanel.repaint();
		}
			else if(evt.getSource()==closeButton)
		{
			mainPanel.removeAll();
			mainPanel.add(topPanel, BorderLayout.NORTH);
			mainPanel.add(bottomPanel, BorderLayout.SOUTH);
			blank=new BlankPanel();
			mainPanel.add(blank.getPanel(),BorderLayout.CENTER);
			mainPanel.revalidate();
			mainPanel.repaint();
		}
	}
}	