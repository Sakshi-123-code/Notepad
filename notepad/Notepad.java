package notepad;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.Buffer;
import javax.swing.filechooser.*;
public class Notepad  extends JFrame implements ActionListener
{

	JTextArea area;
	JScrollPane pane;
	String text;
	Notepad()
	{
		setBounds(0,0,1366,1050);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem newdoc = new JMenuItem("New");
		newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		newdoc.addActionListener(this);
		JMenuItem open = new JMenuItem("Open");
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		open.addActionListener(this);
		JMenuItem save = new JMenuItem("Save");
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		save.addActionListener(this);
		JMenuItem print = new JMenuItem("Print");
		print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		print.addActionListener(this);
		JMenuItem exit = new JMenuItem("Exit");
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0));
		exit.addActionListener(this);
		file.add(newdoc);
		file.add(open);
		file.add(save);
		file.add(print);
		file.add(exit);
		
				
		JMenu edit = new JMenu("Edit");
		JMenuItem copy = new JMenuItem("Copy");
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		copy.addActionListener(this);
		JMenuItem paste = new JMenuItem("Paste");
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
		paste.addActionListener(this);
		JMenuItem cut = new JMenuItem("Cut");
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		cut.addActionListener(this);
		JMenuItem selectall = new JMenuItem("Select All");
		selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		selectall.addActionListener(this);
		edit.add(copy);
		edit.add(cut);
		edit.add(paste);
		edit.add(selectall);
		
		JMenu help = new JMenu("Help");
		JMenuItem about = new JMenuItem("About the Notepad");
		about.addActionListener(this);
	    help.add(about);
		
		
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(help);
		setJMenuBar(menuBar);
		
		area = new JTextArea();
		area.setFont(new Font("SAN SERIF",Font.PLAIN,20));
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		pane = new JScrollPane(area);
		pane.setBorder(BorderFactory.createEmptyBorder());
		add(pane,BorderLayout.CENTER);
		setVisible(true);
		
		
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("New"))
		{
			area.setText("");
			
		}
		
		else if(e.getActionCommand().equals("Open"))
		{
			JFileChooser choose = new JFileChooser();
			choose.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files","txt");
			choose.addChoosableFileFilter(restrict);
			int action = choose.showOpenDialog(this);
			if(action!=JFileChooser.APPROVE_OPTION)
			{
				return;
			}
			File file = choose.getSelectedFile();
			try
			{
				
				BufferedReader reader = new BufferedReader(new FileReader(file));
				area.read(reader, null);
			}catch(Exception ae)
			{
				
			}
		}
		else if(e.getActionCommand().equals("Save"))
		{
			JFileChooser saveas = new JFileChooser();
			saveas.setApproveButtonText("Save");
			int action= saveas.showOpenDialog(this);
			if(action!=JFileChooser.APPROVE_OPTION)
			{
				return;
			}
			File filename = new File(saveas.getSelectedFile()+".txt"); 
			BufferedWriter outfile = null;
			try
			{
				
				outfile = new BufferedWriter(new FileWriter(filename));
				area.write(outfile);
			}catch(Exception ae)
			{
				
			}
		}
			else if(e.getActionCommand().equals("Print"))
			{
				try
				{
					area.print();
				}catch(Exception ae)
				{
					
				}
			}
			
			else if(e.getActionCommand().equals("Exit"))
			{
				System.exit(0);
			}
			
			else if(e.getActionCommand().equals("Copy"))
			{
				text = area.getSelectedText();
			}
			
			else if(e.getActionCommand().equals("Paste"))
			{
				area.insert(text, area.getCaretPosition());
			}
			
			else if(e.getActionCommand().equals("Cut"))
			{
				text = area.getSelectedText();
				area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
			}
			
			else if(e.getActionCommand().equals("Select All"))
			{
				area.selectAll();
			}
			
			else if(e.getActionCommand().equals("About the Notepad"))
			{
				new About().setVisible(true);
			}
		}
		
	

	public static void main(String[] args)
	{
		new Notepad();
	
	}
	
}
