/**
 * 
 */
package jcsi.bootstrap;

import java.util.List;

import jcsi.dataAccess.CRUD.CRUDManager;
import jcsi.dataAccess.DAO.CategoryDAO;
import jcsi.dataAccess.DAO.ClientDAO;
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
		
		//CRUDManager.createOrUpdate(cl);
		//CRUDManager.createOrUpdate(p);
		
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
		pp.setCategory(CategoryDAO.getInstance().getById(cat.getId()));
		

		//CRUDManager.createOrUpdate(cll);
		//CRUDManager.createOrUpdate(pp);

		List<Client> loh = ClientDAO.getInstance().getAllByLastName("Savon");
		
		if (loh != null) {
			System.out.println("Proceeding to dump " + loh.size() + " results");
			for (Client clicli : loh) {
				System.out.println(clicli.toString());
			}
		} else {
			System.out.println("CACA");
		}
		
		/*
		System.err.println(cl.toString());
		System.err.println(c.toString());
		System.err.println(p.toString());
		*/
		
		//List list = CRUDManager.query("from Client");
		
		
		//Client touco = (Client) list.get(0);
		
		/* 
		TRACE,
		DEBUG,
		INFO,
		WARN,
		ERROR
		FATAL
		*/
		
		/*
		Logger log = Logger.getLogger("main");
		log.setLevel(Level.INFO);
		log.info("COucou");
		log.warning("Warning.");
		
		throw new BadConfException();
		 */
		
		//Client touco = ClientDAO.getInstance().getById(0);
		//CRUDManager.session.saveOrUpdate(cl);

		/*
		touco.setEmail("zouzou@hotmail.lol");
		
		Client taco = new Client();
		
		List<AEntity> l = new ArrayList<AEntity>();
		l.add(taco);
		l.add(touco);

		CRUDManager.createOrUpdateAll(new ArrayList<AEntity>());
		CRUDManager.createOrUpdateAll(new HashSet<AEntity>());
		CRUDManager.createOrUpdateAll(taco, touco);
		
		*/
		System.err.println("All is well.");
	}

}
