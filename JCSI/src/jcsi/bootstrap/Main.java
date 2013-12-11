/**
 * 
 */
package jcsi.bootstrap;

import jcsi.dataAccess.CRUD.CRUDManager;
import jcsi.dataAccess.DAO.CategoryDAO;
import jcsi.orm.entity.Cart;
import jcsi.orm.entity.Category;
import jcsi.orm.entity.Client;
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
		/*
		ConfLoader conf  = null;
		conf = ConfLoader.getInstance();
		conf.load();
		*/

		Client cl = new Client();
		cl.setEmail("zobi@coucou.com");
		cl.setFirstName("Guy");
		cl.setLastName("Zorbier");
		cl.setPhone("118-218");
		
		Coordinates coo = new Coordinates();
		coo.setAddress("32 rue boustifaille");
		coo.setCity("Nouillork");
		coo.setCountry("Fronce");
		cl.setCoordinates(coo);

		Cart c = new Cart();
		cl.addCart(c);
		
		Product p = new Product();
		p.setName("coin-coin en caoutchouc");
		p.setPrice(38.7);
		
		Category cat = new Category();
		cat.setName("Merde en plastoc");
		p.setCategory(cat);

		CRUDManager.createOrUpdate(cl);
		CRUDManager.createOrUpdate(p);

		Client cll = new Client();
		cll.setEmail("salou@coucou.com");
		cll.setFirstName("Josie");
		cll.setLastName("Savon");
		cll.setPhone("666");
		cll.setCoordinates(new Coordinates());
		cll.getCoordinates().setAddress("1 voie Do");
		cll.getCoordinates().setCity("Lossann Jelaiss");
		cll.getCoordinates().setCountry("Sousse");

		Product pp = new Product();
		pp.setName("vibro en mousse");
		pp.setPrice(786);
		pp.setCategory(CategoryDAO.INSTANCE.getById(cat.getId()));

		CRUDManager.createOrUpdate(cll);
		CRUDManager.createOrUpdate(pp);

		System.err.println("All is well.");
	}

}
