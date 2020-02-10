import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class DisplayImages {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*
		
		JFrame frame = new JFrame();
		BufferedImage myPicture = ImageIO.read(new File("/Users/prasanth/Desktop/icon-sample.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setVisible(true);
		picLabel.setPreferredSize(new Dimension(20,20));
		
		BufferedImage myPicture2 = ImageIO.read(new File("/Users/prasanth/Desktop/icon-2.png"));
		JLabel picLabel2 = new JLabel(new ImageIcon(myPicture2));
		picLabel2.setVisible(true);
		picLabel2.setPreferredSize(new Dimension(20,20));
		
		frame.add(picLabel);
		frame.add(picLabel2);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 200));
        frame.pack();
        frame.setVisible(true);
        */
		
		 JFrame f=new JFrame("Image Display");
		 ImageIcon pic1 = new ImageIcon ("/Users/prasanth/Desktop/icon-sample.png");
		 ImageIcon pic2 = new ImageIcon ("/Users/prasanth/Desktop/icon-2.png");
		 ImageIcon pic3 = new ImageIcon ("/Users/prasanth/Desktop/icon-3.jpeg");

		JLabel label1, label2, label3;
		
		JPanel subPanel1 = new JPanel();

		label1 = new JLabel (pic1, SwingConstants.CENTER);
		label2 = new JLabel (pic2, SwingConstants.LEFT);
		label3 = new JLabel (pic3, SwingConstants.CENTER);

		subPanel1.add (label1);
		subPanel1.add (label2);
		subPanel1.add (label3);

		f.setSize(500,500);
		f.setVisible(true);  
		f.add(subPanel1);
		System.out.println("Success.....");
		
		
		JFrame user=new JFrame("User Input");
		JPanel userPanel = new JPanel();
		JButton submit = new JButton("SUBMIT");
		JTextField input = new JTextField("icon-2");
		
		userPanel.add(submit);
		userPanel.add(input);
		user.setSize(500,500);
		user.setVisible(true);  
		user.add(userPanel);
		
		submit.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    String buttonToRemove = input.getText();
			    switch (buttonToRemove) {
			    case "1":
			    	label1.setVisible(false);
			    	break;
			    case "2":
			    	label2.setVisible(false);
			    	break;
			    	case "3":
			    	label3.setVisible(false);
			    	break;
			    	default:
			    }
			    	
			  } 
			} );
		

	}

}
