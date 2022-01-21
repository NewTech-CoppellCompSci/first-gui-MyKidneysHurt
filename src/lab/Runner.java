package lab;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Runner {
	public static void main(String[]args ) {
		
		createGUI();
		
	}
	
	private static void createGUI() {
		//Array list that holds all of the houses
		ArrayList<House> houses = new ArrayList<House>();
		final JFrame frame = new JFrame("Realtor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setSize(1200, 1500);
		
		//Setup houses adding to list
		Address address1 = getAddressFor("2617 Prospect Ave", "", "Fort Worth", "Tx", "76164");
		House house1 = getHouseForData(address1, 2045, 6, 4.0, 270000, 7013, 300, 200, 0, 0, new ImageIcon("src/lab/House1.jpg"));

		houses.add(house1);
		
		Address address2 = getAddressFor("3735 El Campo Ave", "", "Fort Worth", "Tx", "76107");
		House house2 = getHouseForData(address2, 3080, 5, 4.0, 619000, 6011, 300, 200, 300, 0, new ImageIcon("src/lab/House2.jpg"));
		
		houses.add(house2);
		
		Address address3 = getAddressFor("4024 Avenue M", "", "Fort Worth", "Tx", "76105");
		House house3 = getHouseForData(address3, 5206, 7, 4.0, 570000, 16988, 300, 200, 0, 200, new ImageIcon("src/lab/House3.jpg"));
		
		houses.add(house3);
		
		Address address4 = getAddressFor("5413 Sierra Ridge Dr", "", "Fort Worth", "Tx", "76123");
		House house4 = getHouseForData(address4, 3160, 5, 4.0, 374990, 6621, 300, 200, 300, 200, new ImageIcon("src/lab/House4.jpg"));
		
		houses.add(house4);
		
		Address address5 = getAddressFor("2133 Fairview St", "", "Fort Worth", "Tx", "76111");
		House house5 = getHouseForData(address5, 3036, 5, 3.0, 409900, 6185, 300, 200, 0, 400, new ImageIcon("src/lab/House5.jpg"));
		
		houses.add(house5);
		
		Address address6 = getAddressFor("8416 Smokey Creek Pass", "", "Fort Worth", "Tx", "76179");
		House house6 = getHouseForData(address6, 2501, 5, 3.0, 289900, 21780, 300, 200, 300, 400, new ImageIcon("src/lab/House6.jpg"));
		
		houses.add(house6);
		
		Address address7 = getAddressFor("16720 Stallion Shores Ct", "", "Lindale", "Tx", "75771");
		House house7 = getHouseForData(address7, 2768, 5, 3.0, 595000, 44431, 300, 200, 0, 600, new ImageIcon("src/lab/House7.jpg"));
		
		houses.add(house7);
		
		Address address8 = getAddressFor("5287 Bent Hook Dr", "", "Frisco", "Tx", "75036");
		House house8 = getHouseForData(address8, 4130, 5, 5.0, 695000, 14375, 300, 200, 300, 600, new ImageIcon("src/lab/House8.jpg"));
		
		houses.add(house8);
		
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(620, 200, 555, 400);	
		
		for(House house : houses){ //Creates a button for each house and adds it to the frame
			JButton houseButton = house.renderHouse(imageLabel);
			frame.add(houseButton);
		}
		
		frame.add(imageLabel);
		frame.setLayout(null);
		frame.setVisible(true);
		imageLabel.requestFocus(); //Makes it so that the first button isn't immediately focused on

	}
	
	/**
	 * 
	 * creates address with given data
	 * 
	 * @param addressLine1
	 * @param addressLine2
	 * @param city
	 * @param state
	 * @param zip
	 * @return new Address object
	 */
	private static Address getAddressFor(String addressLine1, String addressLine2, String city, String state, String zip) {
		return new Address(addressLine1, addressLine2, city, state, zip);
	}
	
	/**
	 * 
	 * creates house with given data
	 * 
	 * @param address
	 * @param sqFt
	 * @param bedrooms
	 * @param bathrooms
	 * @param cost
	 * @param lotSize
	 * @param width
	 * @param height
	 * @param xPosition
	 * @param yPosition
	 * @param image
	 * @return new House object
	 */
	private static House getHouseForData(Address address,int sqFt, int bedrooms, double bathrooms, double cost, int lotSize, int width, int height, int xPosition, int yPosition, ImageIcon image) {
		return new House(address, sqFt, bedrooms, bathrooms, cost, lotSize, width, height, xPosition, yPosition, image);
	}
}
