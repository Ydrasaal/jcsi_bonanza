/**
 * 
 */
package jcsi.bootstrap;

import jcsi.dataAccess.CRUD.CRUDManager;
import jcsi.dataAccess.DAO.CartDAO;
import jcsi.dataAccess.DAO.CategoryDAO;
import jcsi.dataAccess.DAO.ClientDAO;
import jcsi.dataAccess.DAO.ProductDAO;
import jcsi.gui.WindowView;
import jcsi.orm.entity.Cart;
import jcsi.orm.entity.Client;
import jcsi.orm.entity.Content;
import jcsi.orm.entity.Coordinates;
import jcsi.orm.entity.Product;

/**
 * @author kapous_c
 *
 */

public class Main {

	public Main() {
	}

	public static void main(String[] args) {

		WindowView view = new WindowView();
		
		view.setSize(800, 600);
		view.setLocation(150, 100);
		view.setVisible(true);
		
		Client c1 = new Client();
		c1.setEmail("tango@charlie.plon");
		c1.setFirstName("Serge");
		c1.setLastName("Zitrou");
		c1.setPhone("18");
		
		Coordinates coo = new Coordinates();
		coo.setAddress("77 avenue du Ciel");
		coo.setCity("Farmville");
		coo.setCountry("Donnmork");
		c1.setCoordinates(coo);

		Cart c = new Cart();
		c1.addCart(c);
		
		Product p1 = new Product();
		p1.setName("Gouigoui rebondissant");
		p1.setPrice(.5);
		p1.setCategory(CategoryDAO.INSTANCE.getByName("Truc en plastoc"));
		c.addContent(new Content(p1, 2));
		c.addContent(new Content(ProductDAO.INSTANCE.getByName("Caribou mécanique"), 6));
		
		CRUDManager.createOrUpdate(c1);
		
		
		System.out.println(ClientDAO.INSTANCE.getAllByLastName("Zorbier").toString());
		
		System.out.println(CartDAO.INSTANCE.getAllByPaymentState(false).toString());
		

		System.err.println("All is well.");
	}
	
}
