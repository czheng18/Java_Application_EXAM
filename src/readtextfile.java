import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class readtextfile {
	JList list;
	JFrame frame;
	JButton button;

	public readtextfile() {
	}

	public void readtolist() {
		String fileName = "shapes.txt";

		String line = null;

		try {

			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			Vector<String> lines = new Vector<String>();
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				lines.add(line);

			}
			list = new JList(lines);
			button = new JButton("get info");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					String n;
					n = list.getSelectedValue().toString();
					if (n == "circle: 0 6 yellow") {
						try {
							Toolkit toolkit = Toolkit.getDefaultToolkit();
							URL po = getClass().getResource("yc.jpg");
							Image img = toolkit.getImage(po);
							img = img.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
							ImageIcon icon = new ImageIcon(img);
							JButton btn = new JButton(icon);
							JOptionPane.showMessageDialog(null, " ", n, JOptionPane.INFORMATION_MESSAGE, icon);
						} catch (Exception ex) {
							;
						}
					}

				}
			});
			frame = new JFrame("Shapes");
			frame.add(list);
			frame.add(button, BorderLayout.EAST);
			frame.setVisible(true);
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");

		}
	}
}
