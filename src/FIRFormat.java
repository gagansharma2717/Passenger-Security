import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.sql.*;
import javax.swing.*;
public class FIRFormat implements ActionListener
{
	JFrame f2;
	JPanel panel,centerPanel,topPanel,bottomPanel;
	Font headingFont;
	ImageIcon logoIcon;
	JLabel logoLabel,websiteLabel,compaddressLabel,compphoneLabel,compemailLabel,headingLabel,dateLabel,timeLabel,firLabel,passengeridLabel,nameLabel, addressLabel,cityLabel,phoneLabel,emailLabel,inchargeLabel,statusLabel,snameLabel;
	JLabel websiteLabel2,compaddressLabel2,compphoneLabel2,compemailLabel2,dateLabel2,timeLabel2,firLabel2,passengeridLabel2,nameLabel2, addressLabel2,cityLabel2,phoneLabel2,emailLabel2,inchargeLabel2,statusLabel2,snameLabel2;
	JButton printButton,cancelButton;
	JScrollPane desScroll;
	JTextArea desTextarea;
	JSeparator sp,sp4;
	BorderLayout border,border2;
	String name=null,station=null;

	public FIRFormat(String passengerno)
	{
		f2=new JFrame("Generate FIR");
		f2.setAlwaysOnTop(true);
		panel=new JPanel();
		topPanel=new JPanel();
		topPanel.setPreferredSize(new Dimension(30, 260));
		centerPanel=new JPanel();
		bottomPanel=new JPanel();
		bottomPanel.setPreferredSize(new Dimension(30,100));
		
		headingFont=new Font("Times New Roman", Font.BOLD+Font.ITALIC, 40);
	    
		logoIcon=new ImageIcon("Images/railtop.png");
		
		logoLabel=new JLabel(logoIcon);
		websiteLabel=new JLabel("Website :");
		headingLabel=new JLabel("Indian Railways");
		compaddressLabel=new JLabel("Address :");
		compphoneLabel=new JLabel("Contact :");
		compemailLabel=new JLabel("Email-Address :");
		dateLabel=new JLabel("Date :");
		timeLabel=new JLabel("Time :");
		passengeridLabel=new JLabel("Passenger Id     : ");
		firLabel=new JLabel("FIR No.              : ");
		nameLabel=new JLabel("Full Name           : ");
		addressLabel=new JLabel("Address          : ");
		cityLabel=new JLabel("State/City       : ");
		phoneLabel=new JLabel("Phone Number   : ");
		emailLabel=new JLabel("Email Address  : ");
		inchargeLabel=new JLabel("Station Incharge :");
		statusLabel=new JLabel("Status :");
		snameLabel=new JLabel("Station :");

		websiteLabel2=new JLabel("www.indianrail.gov.in");
		compaddressLabel2=new JLabel();
		compphoneLabel2=new JLabel();
		compemailLabel2=new JLabel("mr@rb.railnet.gov.in");
		dateLabel2=new JLabel();
		timeLabel2=new JLabel();
		passengeridLabel2=new JLabel();
		firLabel2=new JLabel();
		nameLabel2=new JLabel();
		addressLabel2=new JLabel();
		cityLabel2=new JLabel();
		phoneLabel2=new JLabel();
		emailLabel2=new JLabel();
		inchargeLabel2=new JLabel();
		statusLabel2=new JLabel();
		snameLabel2=new JLabel();
		
		printButton=new JButton("Print");
		printButton.setFocusPainted(false);
		cancelButton=new JButton("Cancel");
		cancelButton.setFocusPainted(false);
		
		desTextarea=new JTextArea(5,10);
		desTextarea.setLineWrap(true);
		desTextarea.setWrapStyleWord(true);
		desTextarea.setEditable(false);
		
		desScroll=new JScrollPane(desTextarea);
		sp = new JSeparator();
		sp.setBackground(Color.BLACK);
		sp4 = new JSeparator();
		sp4.setBackground(Color.BLACK);
		border=new BorderLayout();
		border2=new BorderLayout();
		f2.add(panel);

		panel.setLayout(border);
		panel.add(topPanel, BorderLayout.NORTH);
		panel.add(bottomPanel, BorderLayout.SOUTH);
		panel.add(centerPanel,BorderLayout.CENTER);
	
		centerPanel.setLayout(border2);
		centerPanel.add(desScroll);
		topPanel.setLayout(null);
		bottomPanel.setLayout(null);
		
		logoLabel.setBounds(500,3,200,140);
		headingLabel.setBounds(10,5,500,50);
		headingLabel.setFont(headingFont);
		
		snameLabel.setBounds(10,40,100,50);
		compaddressLabel.setBounds(10,58,100,50);
		compemailLabel.setBounds(10,76,100,50);
		compphoneLabel.setBounds(10,94,100,50);
		websiteLabel.setBounds(10,112,100,50);
		firLabel.setBounds(30,150,180,30);
		passengeridLabel.setBounds(30,175,180,30);
		nameLabel.setBounds(30,200,180,30);
		phoneLabel.setBounds(30,225,100,30);
		emailLabel.setBounds(298,225,180,30);
		addressLabel.setBounds(298,150,180,30);
		cityLabel.setBounds(298,200,180,30);
		dateLabel.setBounds(550,150,180,30);
		timeLabel.setBounds(551,175,180,30);
		sp.setBounds(0,145,1500,30);		
		
		snameLabel2.setBounds(60,40,250,50);
		compaddressLabel2.setBounds(60,58,250,50);
		compemailLabel2.setBounds(90,76,200,50);
		compphoneLabel2.setBounds(58,94,100,50);
		websiteLabel2.setBounds(58,112,150,50);
		firLabel2.setBounds(150,150,180,30);
		passengeridLabel2.setBounds(150,175,180,30);
		nameLabel2.setBounds(150,200,180,30);
		phoneLabel2.setBounds(150,225,100,30);
		emailLabel2.setBounds(390,225,200,30);
		addressLabel2.setBounds(390,150,180,30);
		cityLabel2.setBounds(390,200,200,30);
		dateLabel2.setBounds(600,150,180,30);
		timeLabel2.setBounds(600,175,180,30);
		
		topPanel.add(websiteLabel);
		topPanel.add(compaddressLabel);
		topPanel.add(compphoneLabel);
		topPanel.add(compemailLabel);
		topPanel.add(logoLabel);
		topPanel.add(headingLabel);
		topPanel.add(snameLabel);
		topPanel.add(firLabel);
		topPanel.add(passengeridLabel);
		topPanel.add(nameLabel);
		topPanel.add(addressLabel);
		topPanel.add(cityLabel);
		topPanel.add(phoneLabel);
		topPanel.add(emailLabel);
		topPanel.add(dateLabel);
		topPanel.add(timeLabel);
		topPanel.add(sp);
		
		topPanel.add(websiteLabel2);
		topPanel.add(compaddressLabel2);
		topPanel.add(compphoneLabel2);
		topPanel.add(compemailLabel2);
		topPanel.add(snameLabel2);
		topPanel.add(firLabel2);
		topPanel.add(passengeridLabel2);
		topPanel.add(nameLabel2);
		topPanel.add(addressLabel2);
		topPanel.add(cityLabel2);
		topPanel.add(phoneLabel2);
		topPanel.add(emailLabel2);
		topPanel.add(dateLabel2);
		topPanel.add(timeLabel2);

		inchargeLabel.setBounds(40,10,100,30);
		inchargeLabel2.setBounds(138,10,100,30);		
		statusLabel.setBounds(550,10,100,30);
		statusLabel2.setBounds(600,10,100,30);
		sp4.setBounds(0,50,1500,30);
		printButton.setBounds(230,60,100,30);
		cancelButton.setBounds(350,60,100,30);
		
		bottomPanel.add(inchargeLabel);
		bottomPanel.add(statusLabel);	
		bottomPanel.add(inchargeLabel2);
		bottomPanel.add(statusLabel2);
		bottomPanel.add(sp4);
		bottomPanel.add(printButton);
		bottomPanel.add(cancelButton);
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:GaganExpress");
			PreparedStatement ps=con.prepareStatement("select * from FIRDetails where FID=?");
			ps.setString(1,passengerno);
			ResultSet rs=ps.executeQuery();	//insert, update, delete
			while(rs.next())
			{
				String FID=rs.getString("FID");
				name=rs.getString("name");
				station=rs.getString("station");
				String description=rs.getString("description");
				String status=rs.getString("status");
				String date=rs.getString("date");
				String time=rs.getString("time");
				firLabel2.setText(FID);
				snameLabel2.setText(station);
				desTextarea.setText(description);
				statusLabel2.setText(status);
				dateLabel2.setText(date);
				timeLabel2.setText(time);
			}
		}
		catch(Exception ee)
		{
		}
	try
	{	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:GaganExpress");
		PreparedStatement ps=con.prepareStatement("select * from passengerDetails where name=?");
		ps.setString(1,name);
		ResultSet rs=ps.executeQuery();	//insert, update, delete
		if(rs.next())
		{
			String id=rs.getString("passengerID");
			String name=rs.getString("name");
			String address=rs.getString("address");
			String city=rs.getString("city");
			String phone=rs.getString("phone");
			String email=rs.getString("email");
			
			passengeridLabel2.setText(id);
			nameLabel2.setText(name);
			addressLabel2.setText(address);
			cityLabel2.setText(city);
			phoneLabel2.setText(phone);
			emailLabel2.setText(email);
		}
	}
	catch(Exception ee)
	{
	}	
	
	try
	{	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:GaganExpress");
		PreparedStatement ps=con.prepareStatement("select * from StationDetails where name=?");
		ps.setString(1,station);
		ResultSet rs=ps.executeQuery();	//insert, update, delete
		if(rs.next())
		{
			String address=rs.getString("address");
			String phone=rs.getString("phone");	
			String incharge=rs.getString("incharge");
			
			compaddressLabel2.setText(address);
			compphoneLabel2.setText(phone);
			inchargeLabel2.setText(incharge);
		}
	}
	catch(Exception ee)
	{
	}			

		printButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		
		topPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.BLACK));
		centerPanel.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2,Color.BLACK));
		bottomPanel.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2,Color.BLACK));
		
		topPanel.setBackground(Color.white);	
		bottomPanel.setBackground(Color.white);
		
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		
		f2.setLocation((d.width-700)/2,(d.height-715)/2);
		f2.setSize(700,700);
		f2.setUndecorated(true);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f2.setVisible(true);
		
	}
	public JPanel getPanel()
	{
		return panel;
	}
	public void actionPerformed(ActionEvent evt) 
	{
		f2.setAlwaysOnTop(false);
		final PrinterJob jpb = PrinterJob.getPrinterJob();
		jpb.setJobName("Print Data");
		if(evt.getSource()==printButton)
		{
			jpb.setPrintable(new Printable() 
			{
				public int print(Graphics pg, PageFormat pf, int pageNum) throws PrinterException 
				{
					if(pageNum>0)
					{
						return Printable.NO_SUCH_PAGE;
					}
					 	
						Dimension dim = f2.getSize();
				        double cHeight = dim.getHeight();
				        double cWidth = dim.getWidth();

				        // get the bounds of the printable area
				        double pHeight = pf.getImageableHeight();
				        double pWidth = pf.getImageableWidth();

				        double pXStart = pf.getImageableX();
				        double pYStart = pf.getImageableY();

				        double xRatio = pWidth / cWidth;
				        double yRatio = pHeight / cHeight;

				        Graphics2D g2 = (Graphics2D)pg;
				        g2.translate(pXStart, pYStart);
				        g2.scale(xRatio, yRatio);
				        
				        f2.paint(g2);
				        return Printable.PAGE_EXISTS;
				}
			});
			boolean ok = jpb.printDialog();
			if(ok)
			{
				try
				{
					jpb.print();
				}
				catch (PrinterException kl) 
				{
				}
			}
		}
		else if(evt.getSource()==cancelButton)
		{
			f2.dispose();
		}
		}
	}