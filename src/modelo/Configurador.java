package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurador {

	public static Properties getMenuData() throws IOException {
		FileInputStream fs = new FileInputStream(new File("menu.ini"));
		Properties pr = new Properties();
		pr.load(fs);
		return pr;
	}

}
