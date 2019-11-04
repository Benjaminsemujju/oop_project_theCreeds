package org.iuea.oop.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import com.toedter.calendar.JDateChooser;


public class LandingPage extends JPanel {	
	
	public  LandingPage() {
		
		
		JFrame Landing = new JFrame();//mainPanel F
		 Landing.setTitle("Student Information");
		 Landing.setSize(700,400);
		 Landing.setLocationRelativeTo(null);
		
		
		 JMenuBar mb = new  JMenuBar();  //MENU BAR 
		 mb.setBorder( BorderFactory.createMatteBorder(0,1,1,0,Color.BLACK));
		 Landing.setJMenuBar(mb);
		
		 JMenu m = new JMenu("            Action          "); 
		 mb.add(m);		 
		 JMenu k = new JMenu("            Help          ");
		 mb.add(k);
		 
		 JMenuItem Lg = new JMenuItem("         Log Out       ");//logout item		
		 m.add(Lg);
		 
		 JPanel mainPanel,FooterPanel,SidePanel,BtnPanel,TPanel,AddSec,dd;
		 
		 mainPanel = new JPanel();//mainPanel PANEL
		 mainPanel.setBackground(Color.white);
		 mainPanel.setLayout(new BorderLayout());
		 Landing.getContentPane().add(mainPanel);
		 
		 
		 Lg.addActionListener(new ActionListener() {//LOG OUT LISTENER
				@Override
				public void actionPerformed(ActionEvent e) {													
					Landing.setVisible(false);
					 new LoginView();
				}       
		 });
		 
		
		 FooterPanel = new JPanel();		  //footer part
		 JLabel leb = new JLabel("Copy right creed 2019");
		 FooterPanel.setBorder( BorderFactory.createMatteBorder(1,0,0,0,Color.BLACK));
		 FooterPanel.add(leb);
		 mainPanel.add(FooterPanel,BorderLayout.SOUTH);
		 
		
		 SidePanel = new JPanel(); //side bar
		 SidePanel.setBackground(Color.gray);
		 SidePanel.setBorder( BorderFactory.createMatteBorder(0,0,0,1,Color.BLACK));	
		 SidePanel.setVisible(true);
		 mainPanel.add(SidePanel,BorderLayout.WEST);
		 
		 
		 BtnPanel = new JPanel();//button part		
		 BtnPanel.setLayout(new GridLayout(0,1));
		 SidePanel.setVisible(true);
		 SidePanel.add(BtnPanel);
		 
		 JButton student,b2,b3,b4;//SIDE BAR CONTENT
		 student = new JButton("Students");	
		
		 BtnPanel.add(student);
		 b2 = new JButton("Course");		
		 BtnPanel.add(b2);
		 b3 = new JButton("Course Units");		
		 BtnPanel.add(b3);
		 b4 = new JButton("Lecturers");			
		 BtnPanel.add(b4);
		 
			 TPanel = new JPanel();	// Student addition	
			 TPanel.setVisible(false);
			 TPanel.setLayout(new FlowLayout(FlowLayout.CENTER,40,10));				
			JButton AddBtn,EditBtn,Delt;// TABLE BUTTONS
			AddBtn =new JButton("Add");
			AddBtn.setBackground(Color.GREEN);			
			EditBtn =new JButton("Edit");
			EditBtn.setBackground(Color.ORANGE);			
			Delt =new JButton("Delete");
			Delt.setBackground(Color.RED);			
			TPanel.add(AddBtn);
			TPanel.add(EditBtn);
			TPanel.add(Delt);			

			
			JTable table = new JTable();// table part			
			//INITIAL DATA SET
			Object[] columnHeads = new String[] { "Registration" , "First Name","Last Name","Sex","DOB",};			
			String[][] Students = new String[][] {
					{ "Registration", "First Name","Last Name","Sex","DOB" },
					{  "044/BIT", "Stone","Tumusime","Male","06/21/1982", },	
					{  "158/BSSE-S", "Ben","Ssemuju","Male","04/18/1995", },	
					{  "178/BIT" , "Sarah","Tunia","Female","03/10/1970",},					
					};
					
					DefaultTableModel model = new DefaultTableModel() {
						public boolean isCellEditable(int row, int col) { //DISABLES THE EDITING OF THE TABLE
							return false;
							}
							};										
			
			table.setBackground(Color.white);
			table.setForeground(Color.black);				
				
					model.setDataVector(Students, columnHeads);
					table.setModel(model);
					TPanel.add(table, BorderLayout.CENTER); 
					mainPanel.add(TPanel);					 
										
					student.addActionListener(new ActionListener() {						
						@Override
						public void actionPerformed(ActionEvent e) {													
							TPanel.setVisible(true);						
						}          
						});					
					
					AddSec = new JPanel();//addition part
					AddSec.setVisible(false);
					AddSec.setLayout(new BorderLayout());	
					dd = new JPanel();				
					dd.setLayout(null);						  
					
					JLabel r= new JLabel();//RegNo. 
					r.setText("Registration: "); 
					r.setBounds(150	, 190, 90, 20);
					dd.add(r);		
					
				JLabel b= new JLabel();//User Name part
					b.setText("First Name: "); 
					b.setBounds(150	, 30, 90, 20);
					dd.add(b);					
					
					JTextField p = new JTextField(); //	Text field part
						p.setBounds(300,30, 120, 25);
						dd.add(p);
					
					JLabel Lb= new JLabel();//last name part
					Lb.setText("Last Name: "); 
					Lb.setBounds(150, 70, 90, 20);
					dd.add(Lb);					
					
					JTextField Lp = new JTextField();	 				
						Lp.setBounds(300, 70, 120, 25);
						dd.add(Lp);
					
					JLabel x= new JLabel();
					x.setText("Sex: "); 
					x.setBounds(150, 110, 90, 20);
					dd.add(x);
					
					String sex[]={"Male","Female"}; //adding a jcombobox 
					JComboBox gd = new JComboBox(sex);    
					gd.setBounds(300, 110, 120, 25);
					dd.add(gd);					
					
					JLabel dob= new JLabel();//DOB part
					dob.setText("Date of Birth: "); 
					dob.setBounds(150, 150, 120, 20);
					dd.add(dob);					
					  
					  JDateChooser dateChooser = new JDateChooser();//date library				
					  dateChooser.setDateFormatString("MM/dd/yyyy"); //FOR SPECIFYING THE DATE
					  dateChooser.setBounds(300, 150, 120, 25);
					  dd.add(dateChooser);										
					
					JTextField rt = new JTextField();
					rt.setBounds(300,190, 120, 25);
					dd.add(rt);						
					JButton SubmitBtn = new JButton("Submit"); //Submit button
					SubmitBtn.setBounds(120, 250, 120, 40);
					SubmitBtn.setBackground(Color.GREEN);
					dd.add(SubmitBtn);					
					
					Object[] row  =new Object[5];	//SPECIFYING THE NO. OF COLUMS IN A ROW				
					SubmitBtn.addActionListener(new ActionListener() {							
						@Override
						public void actionPerformed(ActionEvent e) {
							AddSec.setVisible(false);
							TPanel.setVisible(true);							
							row[0] =  rt.getText();//REG	
							row[1] = p.getText(); //F name
							row[2] = Lp.getText();//L name
							row[3] = gd.getSelectedItem();//sex
							row[4] = dateChooser.getDate();//dob
											
							model.addRow(row);		//ADDING THE NEW ROW TO THE TABLE						
							rt.setText("");//REG	
							p.setText(""); //F name
							Lp.setText("");//L name
							gd.setSelectedItem("");//sex
							dateChooser.setDate(null);//dob
							 
						}          
						});						
				
					EditBtn.addActionListener(new ActionListener() {//edit btn							
						@Override
						public void actionPerformed(ActionEvent e) {
							table.setVisible(true);
					    	AddBtn.setVisible(false);
							Delt.setVisible(false);
							EditBtn.setVisible(false);
							
							mainPanel.remove(table);
							//JTable table2 = new JTable();// table part
							DefaultTableModel model2 = new DefaultTableModel() {
								public boolean isCellEditable(int row, int col) { 
									return true;
									}
									};	
									
									Object[] columnHeads2 = new String[] {};			
									String[][] Students2 = new String[][] {};
									 columnHeads2 =  columnHeads;
									 Students2 = Students;								
					
								table.setBackground(Color.white);
								table.setForeground(Color.black);				
						
							model2.setDataVector(Students2, columnHeads2);
						
							table.setModel(model2);
							TPanel.add(table, BorderLayout.CENTER); 
							mainPanel.add(TPanel);					 
												
			
					JButton done = new JButton("DONE"); //TAKES YOU BACK TO mainPanel LANDING PAGE
					done.setBackground(Color.GREEN);					
					TPanel.add(done);					
					done.addActionListener(new ActionListener() {							
						@Override
						public void actionPerformed(ActionEvent e) {
							table.setVisible(true);
					    	AddBtn.setVisible(true);
							Delt.setVisible(true);
							EditBtn.setVisible(true);						
							done.setVisible(false);	
							
							
							
						}});										
						}          
						});	
					
					//DELETE SECTION OF THE TABLE
					Delt.addActionListener(new ActionListener() {							
						@Override
						public void actionPerformed(ActionEvent e) {//makes the buttons visible
							table.setVisible(true);
					    	AddBtn.setVisible(false);
							Delt.setVisible(false);
							EditBtn.setVisible(false);
							
							table.addMouseListener(new java.awt.event.MouseAdapter() {
							    @Override
							    public void mouseClicked(java.awt.event.MouseEvent evt) {				    	
							    							        
							        int Trow = table.getSelectedRow();
							        int Tcol  = table.getSelectedColumn();							        
							     // model.removeRow(Trow); //enables the deleting of a row
							      ((DefaultTableModel) table.getModel()).removeRow(Trow);
							      return;
							    }
							});							
			
					JButton DD = new JButton("DONE DELETING");//TAKES YOU BACK TO mainPanel LANDING PAGE
					DD.setBackground(Color.GREEN);					
					TPanel.add(DD);					
					DD.addActionListener(new ActionListener() {							
						@Override
						public void actionPerformed(ActionEvent e) {
							table.setVisible(true);
					    	AddBtn.setVisible(true);
							Delt.setVisible(true);
							EditBtn.setVisible(true);						
							DD.setVisible(false);										
							
						}});										
						}          
						});						
				
						//Cancel button
						JButton cb = new JButton("Cancel"); 
						cb.setBounds(340, 250, 120, 40);
						cb.setBackground(Color.RED);
						
						cb.addActionListener(new ActionListener() {	//CANCEL ACTION EVENT						
							@Override
							public void actionPerformed(ActionEvent e) {
								AddSec.setVisible(false);
								TPanel.setVisible(true);	
																		
								
							}});
						dd.add(cb);					
						AddSec.add(dd);	//adding to AddSec panel	
						
						 // Add btn ADDING TO TABLE							
						AddBtn.addActionListener(new ActionListener() {							
							@Override
							public void actionPerformed(ActionEvent e) {													
								TPanel.setVisible(false);
								mainPanel.add(AddSec,BorderLayout.CENTER); //adding to mainPanel panel
								AddSec.setVisible(true);						
							}          
							});		 
		 
		 Landing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 Landing.setVisible(true); //setting the LandPage visible		 
	}
}
