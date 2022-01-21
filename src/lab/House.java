package lab;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class House {
	private Address _address;
	private int _sqFt;
	private int _bedrooms;
	private double _bathrooms;
	private double _cost;
	private int _lotSize;
	private int _width;
	private int _height;
	private int _xPosition;
	private int _yPosition;
	private ImageIcon _image;
	
	//All of the parameters for the house and button
	public House (Address address, int sqFt, int bedrooms, double bathrooms, double cost, int lotSize, int width, int height, int xPosition, int yPosition, ImageIcon image) {
		this._address = address;
		this._sqFt = sqFt;
		this._bedrooms = bedrooms;
		this._bathrooms = bathrooms;
		this._cost = cost;
		this._lotSize = lotSize;
		this._width = width;
		this._height = height;
		this._xPosition = xPosition;
		this._yPosition = yPosition;
		this._image = image;
	}
	
	
	

	public Address getAddress() { return _address; }
	public int getHouseSqft() { return _sqFt; }
	public int getNumberBedrooms() { return _bedrooms; }
	public double getNumberBathrooms() { return _bathrooms; }
	public double getCost() { return _cost; }
	public int getLotSize() { return _lotSize; }
	public ImageIcon getImage() { return _image; }
	
	/**
	 * 
	 * Creates a new button for this house 
	 * 
	 * focusListener adds a feature that reveals certain information when focused on or not 
	 * and resets the image labels icon to this houses image
	 * 
	 * focusGained gives the user the property details
	 * focusLost gives the user the address details
	 * 
	 * @param imageLabel
	 * @return a new JButton
	 */
	public JButton renderHouse(JLabel imageLabel) {
		JButton houseButton = new JButton(getAddressLabel());    
		houseButton.setBounds(_xPosition, _yPosition, _width, _height);
        houseButton.addFocusListener(new FocusListener() {
        	@Override
        	public void focusGained(FocusEvent event) {
        		houseButton.setText(getPropertyDetails());
        		ImageIcon scaledPic = new ImageIcon(_image.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), 1));
        		imageLabel.setIcon(scaledPic);
        	}

			@Override
			public void focusLost(FocusEvent e) {
				houseButton.setText(getAddressLabel());
			}
        });
		return houseButton;
		
	}
	
	/**
	 * 
	 * Brings all of the address information into a string so that it can be used in focusLost
	 * 
	 * ("</html>") tags are added so i can use the line break tags for the JButton
	 * 
	 * @return result of the information
	 */
	private String getAddressLabel() {
		StringBuilder result = new StringBuilder();
		
		result.append("<html>");	
		result.append(_address.getLine1()).append("<br />");
		
		if(!_address.getLine2().isEmpty()) {
			result.append(_address.getLine2()).append("<br />");
		}
	
		result.append(_address.getState()).append("<br />");
		result.append(_address.getCity()).append("<br />");
		result.append(_address.getZip()).append("<br />");
		result.append("</html>");
		
		return result.toString();
	}
	
	/**
	 * 
	 * Brings all of the house detail information into a string so that it can be used in focusGained
	 * 
	 * ("</html>") tags are added so i can use the line break tags for the JButton
	 * 
	 * @return result of the information
	 */
	private String getPropertyDetails() {
		StringBuilder result = new StringBuilder();
		result.append("<html>");
		result.append("Square Feet: ").append(_sqFt).append("<br />");
		result.append("Bedrooms: ").append(_bedrooms).append("<br />");
		result.append("Bathrooms: ").append(_bathrooms).append("<br />");
		result.append("Cost: $").append(_cost).append("<br />");
		result.append("Lot Size: ").append(_lotSize).append("<br />");
		result.append("</html>");
		return result.toString();
	}
}
