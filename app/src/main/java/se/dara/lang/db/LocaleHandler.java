package se.dara.lang.db;


import android.content.Context;

import java.util.HashMap;

import se.dara.lang.integration.ServerConnector;

/**
 * Created by Dara on 2015-06-11.
 */
public class LocaleHandler {

    private String currentlang = "LangA";
    final SqliteController sqliteController;
    final ServerConnector serverConnector;

    HashMap<String, String> localeCache;

    public LocaleHandler(Context applicationContext) {
        sqliteController = new SqliteController(applicationContext);
        serverConnector = new ServerConnector();
    }

    public void downloadLanguages(){
        sqliteController.storeLanguage(serverConnector.downloadLanguage("LangA"));
        sqliteController.storeLanguage(serverConnector.downloadLanguage("LangB"));
    }

    public void toggleLanguage(){
        currentlang = currentlang.equals("LangA") ? "LangB" : "LangA";
    }

    public void cacheLanguage() {
        localeCache = sqliteController.getLanguage(currentlang);
    }

    public String getString(String identifier){
        return localeCache.get(currentlang+"_"+identifier);
    }
}
