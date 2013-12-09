/**
 * 
 */
package jcsi.bootstrap;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import jcsi.dataAccess.HSessionFactory;
import jcsi.dataAccess.CRUD.CRUDManager;
import jcsi.dataAccess.DAO.ClientDAO;
import jcsi.exception.BadConfException;
import jcsi.orm.entity.AEntity;
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
		// TODO Auto-generated method stub
		/*
		ConfLoader conf  = null;
		conf = ConfLoader.getInstance();
		conf.load();
		*/
		
		//TODO HOW THE FUCK DOES THIS ID THING WORKS ?
		
		/*
		Client cl = new Client();
		cl.setEmail("zobi@coucou.com");
		cl.setFirstName("Guy");
		cl.setLastName("Zorbier");
		cl.setPhone("118-218");
		cl.setCoordinates(new Coordinates());
		Cart c = new Cart();
		cl.addCart(c);
		cl.getCoordinates().setAddress("32 rue boustifaille");
		cl.getCoordinates().setCity("Nouillork");
		cl.getCoordinates().setCountry("Fronce");
		
		Product p = new Product();
		p.setName("coin-coin en caoutchouc");
		p.setPrice(38.7);
		p.setCategory(new Category());
		p.getCategory().setName("Merde en plastoc");
		 */
		/*
		Client cll = new Client();
		cll.setEmail("salou@coucou.com");
		cll.setFirstName("Jean");
		cll.setLastName("Savon");
		cll.setPhone("666");
		cll.setCoordinates(new Coordinates());
		Cart cc = new Cart();
		cll.addCart(cc);
		cll.getCoordinates().setAddress("1 voie Do");
		cll.getCoordinates().setCity("Lossann Jelaiss");
		cll.getCoordinates().setCountry("Sousse");
		
		Product pp = new Product();
		pp.setName("vibro en mousse");
		pp.setPrice(786);
		pp.setCategory(new Category());
		pp.getCategory().setName("Merde en plastoc");
		*/
				
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
		
		Logger log = Logger.getLogger("main");
		log.setLevel(Level.INFO);
		log.info("COucou");
		log.warning("Warning.");
		
		throw new BadConfException();

		//Client touco = ClientDAO.getInstance().getById(0);
		//System.out.println(touco.toString());

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
		//System.err.println("All is well.");
	}

}
