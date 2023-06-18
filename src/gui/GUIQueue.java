package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIQueue extends JPanel {
	public GUIQueue() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel("QUEUE");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel des = new JLabel("Queue description");
		des.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton listButton = new JButton("Queue");
		container.add(listButton);
		
		// Add action listeners to the buttons
        listButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//Việc cần làm: viết 1 hàm tạo ra 1 JPanel mới chứa các operations
            }
        });
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(des);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}
}