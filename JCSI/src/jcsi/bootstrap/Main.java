/**
 * 
 */
package jcsi.bootstrap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;

import jcsi.dataAccess.DAO.CategoryDAO;
import jcsi.dataAccess.DAO.ClientDAO;
import jcsi.exception.BadConfException;
import jcsi.gui.WindowView;
import jcsi.log.UniLogger;
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

	public static void main(String[] args) throws IOException {
		WindowView view = new WindowView();
		
		view.setSize(800, 600);
		view.setLocation(150, 100);
		view.setVisible(true);
		
		UniLogger logg = UniLogger.getInstance(view);
		
		//Logger logg = Logger.getLogger("main");
		logg.error("This is an error");
		for (int i = 0; i < 20; ++i) {
			logg.info("Some Information");
		}

	//	view.log.append(sw.toString());		

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
		throw new BadConfException();
	}
}
