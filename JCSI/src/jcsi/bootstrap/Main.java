/**
 * 
 */
package jcsi.bootstrap;

import java.io.Console;

import jcsi.dataAccess.HSessionFactory;
import jcsi.dataAccess.CRUD.CRUDManager;
import jcsi.orm.entity.Client;

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
		CRUDManager.getInstance().testOpen();
		Client cl = new Client();
		cl.setName("coquin");
		CRUDManager.getInstance().testClose();
		System.err.println("All is well.");
	}

}
