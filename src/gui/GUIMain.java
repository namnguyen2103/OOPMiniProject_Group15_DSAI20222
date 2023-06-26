package gui;

import javax.swing.*;

import gui.GUIList;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class GUIMain extends JFrame {

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        // Create the application name label
        JLabel appNameLabel = new JLabel("Project 01");
        appNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        appNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        header.add(appNameLabel);

        // Create the application description label
        JLabel appDescriptionLabel = new JLabel("A short description about the project or something else");
        appDescriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        appDescriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        header.add(appDescriptionLabel);
        return header;
    }
	
	JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
        JMenu optionMenu = new JMenu("Option");
        
        JMenuItem helpMenuItem = new JMenuItem("Help");
        helpMenuItem.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	JOptionPane.showMessageDialog(new JFrame("Help"), "Some detailed explanation of the project and its usage.");
            }
        });
        optionMenu.add(helpMenuItem);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        optionMenu.add(exitMenuItem);        
        menuBar.add(optionMenu);
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        return menuBar;
	}

	
	JPanel createCenter() {		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1, 3, 10, 10));
		
		center.add(new GUIList());
		center.add(new GUIStack());
		center.add(new GUIQueue());		
		return center;
	}
	
	public GUIMain() {
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1200, 400);
	}
	
	public static void main(String [] args) {
		new GUIMain();
	}
}
