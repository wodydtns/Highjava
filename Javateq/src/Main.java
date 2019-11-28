import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame{
	private JTextField textField = new JTextField(30);
	private JButton button = new JButton("검색");
	private JPanel panel = new JPanel();
	private GoogleAPI googleAPI = new GoogleAPI();
	private String location = "서울";
	private JLabel googleMap = new JLabel();
	public Main() {
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Google Maps");
		setVisible(true);
		
		panel.add(textField);
		panel.add(button);
		button.addMouseListener(new Event());
				
		add(BorderLayout.NORTH,panel);
		pack();
	}
	public void setMap(String location) {
		googleAPI.downloadMap(location);
		googleMap.setIcon((googleAPI.getMap(location)));
		googleAPI.fileDelete(location);
		add(BorderLayout.SOUTH,googleMap);
		pack();
	}
	public class Event implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			setMap(textField.getText());
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
