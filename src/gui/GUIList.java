package gui;
import datastructure.List_type;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;

public class GUIList extends JPanel {
	
	private List_type newList = new List_type();
	private JTextField Demo_Chart;
	private JTextField Demo_Description;
	
	public GUIList() 
	{
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel("LIST");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel des = new JLabel("List description");
		des.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		JButton listButton = new JButton("List");
		container.add(listButton);
		
		
		// Add action listeners to the buttons
        listButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				// Close the store window
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(GUIList.this);
				frame.dispose();

				// Create a new window
				JFrame listFrame = new JFrame();
				Container cp = listFrame.getContentPane();
				cp.setLayout(new BorderLayout());

				cp.add(createMenuBar(), BorderLayout.NORTH);
				cp.add(CreateMain(), BorderLayout.CENTER); // Blank canvas to show animation
				cp.add(createOperations(), BorderLayout.SOUTH);



				listFrame.setVisible(true);
				listFrame.setTitle("List");
				listFrame.setSize(1200, 400);
            }
        });
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(des);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		

		
	}


	JPanel createOperations() 
	{
		JPanel operations = new JPanel();
		operations.setLayout(new GridLayout(1, 5, 10, 10));

		JButton create = new JButton("Create");
		JButton insert = new JButton("Insert");
		JButton sort = new JButton("Sort");
		JButton find = new JButton("Find");
		JButton delete = new JButton("Delete");
		
		create.addActionListener(new ActionListener() 
		{
	        public void actionPerformed(ActionEvent e) 
	        {
	            createlist();
	        }
	        
	    });
		
		insert.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				insertANum();
			}
		});
		

		operations.add(create);
		operations.add(insert);
		operations.add(sort);
		operations.add(find);
		operations.add(delete);
		
		

		return operations;
	

	}
	
	JPanel CreateMain()
	{
		JPanel DemoList = new JPanel();
		DemoList.setLayout(new BoxLayout(DemoList, BoxLayout.Y_AXIS));
		DemoList.add(new JLabel("List Demonstration: "));
		Demo_Chart = new JTextField(100);
		Demo_Chart.setEditable(false);
		DemoList.add(Demo_Chart);
		DemoList.add(new JLabel("List Description: "));
		Demo_Description = new JTextField(100);
		Demo_Description.setEditable(false);
		DemoList.add(Demo_Description);
		
		return DemoList;
		
	}
	
	public void createlist()
	{
		String input = JOptionPane.showInputDialog(GUIList.this, "Enter items (comma-separated):");
		String[] items = input.split(",");
		
		for(int i = 0; i < items.length; ++i) 
		{
			newList.add(Integer.parseInt(items[i]));
		}
		
		Demo_Chart.setText("The list contain:" + newList.printSt());
		Demo_Description.setText("The list has been created");
		

	}
	
	JPanel insertANum()
	{
		JPanel Insert = new JPanel();
		Insert.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Insert.add(new JLabel("Number: "));
		Insert.add(new JTextField(100));
		Insert.add(new JLabel("Index: "));
		 = new JTextField(100);
		Demo_Description.setEditable(false);
		DemoList.add(Demo_Description);
		
		
		return Insert;
	}
	

	
	JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
        JMenu optionMenu = new JMenu("Option");
        
        JMenuItem helpMenuItem = new JMenuItem("Help");
        helpMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
	
	
}

