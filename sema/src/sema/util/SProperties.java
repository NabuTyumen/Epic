package sema.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

public class SProperties {
	
	private static final ResourceBundle sema = ResourceBundle.getBundle ("sema.sema");
	private static final Locale defaultLocale = Locale.forLanguageTag(sema.getString("language.default"));
	private static final String host = sema.getString("mdb.host");
	private static final int port = Integer.parseInt(sema.getString("mdb.port"));
	private static final String db = sema.getString("mdb.db");
	private static final long size = Long.parseLong(sema.getString("mdb.size"));
	private static HashMap<String,Locale> locales = new HashMap<String, Locale>() ; 
	
	public static Locale getLocale(String language){
		if(locales.get(language) == null){
			if("fr".equals(language))
			locales.put(language, Locale.forLanguageTag("fr-FR"));
			else if("ru".equals(language))
			locales.put(language, Locale.forLanguageTag("ru-RU"));			
			else if("en".equals(language))
			locales.put(language, Locale.forLanguageTag("en-EN"));
			if("es".equals(language))
			locales.put(language, Locale.forLanguageTag("es-ES"));	
		}
		return locales.get(language);
	}
	
	public static String getTableName(String name, Locale locale) {
		StringBuffer sb = new StringBuffer();
		sb.append(name);
		sb.append(".");
		sb.append(locale.getLanguage());
			return sb.toString();
		}

	public static Locale getDefaultLocale() {
		return defaultLocale;
	}

	public static String getHost() {
		return host;
	}

	public static int getPort() {
		return port;
	}

	public static String getDb() {
		return db;
	}

	public static long getSize() {
		return size;
	}

	public static String getString(String key) {
		return sema.getString(key);
	}
	
	public static int getInt(String key) {
		return Integer.parseInt(sema.getString(key));
	}
	


}
