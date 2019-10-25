package org.iuea.oop.views;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JPanel {	
		public LoginView() {
			
			//Creating a window
			JFrame frame = new JFrame();			
			frame.setTitle("Login Page");			
			frame.setLayout(null);
			 frame.setSize(550,300);
			 frame.setLocationRelativeTo(null);
			
			
			//User Name Label
			JLabel label = new JLabel("User Name :");
			label.setBounds(150, 60, 80, 30);
			frame.add(label);
			

			//Password Label
			JLabel label2 = new JLabel("Password :");
			label2.setBounds(150, 90, 80, 30);
			frame.add(label2);
			
			//USer Name Input
			JTextField  UserInput = new JTextField();
			UserInput.setBounds(250, 60, 120, 20);
			frame.add(UserInput);
			
			//Password Input
			JPasswordField pwd = new JPasswordField();
			pwd.setBounds(250, 95, 120, 20);
			frame.add(pwd);
			
			////Login Button
			JButton log = new JButton("Log In");		
			log.setBounds(100, 150, 120, 20);
			//action listener
			log.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {				
					//System.out.println("logged in");
					//Label for login confirmation
					
					String Name = "stone";		
					String Pwd = "stone";   
					String Input = UserInput.getText();			
					String PwdInput = pwd.getText();	 		
							
					Pattern pat = Pattern.compile(Name );  
					Matcher mat = pat.matcher(Input );  
								
					boolean confirm = mat.matches();  
					//System.out.println(confirm); 
								
					Pattern ptt = Pattern.compile(Pwd );  
					Matcher mtt = ptt.matcher(PwdInput );  
							
					boolean access = mtt.matches();  
					//System.out.println(access); 
					
					
					
					//if user information is right 
					if(confirm && access )JOptionPane.showMessageDialog(null,"User Logged in Successfully !!!");
						
					
					//if user information is wrong			
					else JOptionPane.showMessageDialog(null,"UserName & Password doesn't match as expected !!!");
					
				}
			
			});
			
			frame.add(log);
			
			////Cancel Button
			JButton cc = new JButton("Cancel");
			cc.setBounds(300, 150, 120, 20);
			cc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//System.out.println("cancel");

					frame.setVisible(false); //cancels the main window
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				}
			
			});
			frame.add(cc);
			
			
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			
		} 

	}



