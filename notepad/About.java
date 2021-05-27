package notepad;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
public class About extends JFrame implements ActionListener
{
	About()
	{
		setBounds(500,120,600,500);
		setLayout(null);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("notepad/windows 7 icon.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 200,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(50, 20, 500, 100);
		add(l1);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("notepad/notepad.png"));
		Image i5 = i4.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel l2 = new JLabel(i6);
		l2.setBounds(50, 180, 70, 70);
		add(l2);
		
		JLabel l3 = new JLabel("<html>Coding Technology<br>Youtube Version 2021<br>Coding Technology, All Rights Reserved<br><br>Notepad is a word processing program<br>which allows changing of text in computer file, <br>Notepad is simple text editor for basic text editing program<br>which enables computer users to create documents</html>");
		l3.setBounds(150,130,500, 300);
		l3.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
		add(l3);
	
		JButton b1 = new JButton("OK");
		b1.setBounds(490,410,80,25);
		b1.addActionListener(this);
		add(b1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
	
		this.setVisible(false);
		
	}
	
	public static void main(String args[])
	{
		new About().setVisible(true);
	}


	

}
