package se.dara.lang.integration;

import java.util.HashMap;

/**
 * Created by Dara on 2015-06-11.
 */
public class ServerConnector {

    public HashMap<String, String> downloadLanguage(String langName, int langLength) {
        HashMap<String, String> lang = new HashMap<>();

        for(int ii = 0; ii<langLength; ii++) {
            lang.put(langName+"_String"+ii,"This is String #"+ii+" in lang: " + langName);
        }
        return lang;
    }
}
