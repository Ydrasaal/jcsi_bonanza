package jcsi.configuration;

import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

import jcsi.exception.BadConfException;

public final class ConfLoader {

	private static ConfLoader INSTANCE = null;
	private HashMap<String, String> configuration = null;
	
	private ConfLoader() {
	}
	
	public static synchronized ConfLoader getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ConfLoader();
		}
		return INSTANCE;
	}
	
	public void load() {
		try {
			Scanner scanner =  new Scanner(Paths.get(new File("").getAbsolutePath().concat("\\dbmanager.conf")));
			String tmpName[] = new String [2];
			configuration = new HashMap<String, String>();
			while (scanner.hasNextLine()) {
				Scanner lineScanner = new Scanner(scanner.nextLine());
				lineScanner.useDelimiter("=");
				if (lineScanner.hasNext()) {
					tmpName[0] = lineScanner.next();
					if (lineScanner.hasNext()) {
						tmpName[1] = lineScanner.next();
					} else {
						tmpName[1] = "";
					}
					configuration.put(tmpName[0], tmpName[1]);
				}
				lineScanner.close();
			}
			scanner.close();
		} catch (Exception e) {
			throw new BadConfException();
		}
	}
	
	public String getConf(String option) {
		String tmp = null;
		try {
			tmp = configuration.get(option);
		} catch (RuntimeException e) {
			throw new BadConfException();
		}
		return tmp;
	}
	
	@Override
	public String toString() {
		if (configuration != null) {
			return configuration.toString();
		} else {
			return ("null");
		}
	}
}
