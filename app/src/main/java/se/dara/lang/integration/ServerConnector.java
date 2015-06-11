package se.dara.lang.integration;

import java.util.HashMap;

/**
 * Created by Dara on 2015-06-11.
 */
public class ServerConnector {

    public HashMap<String, String> downloadLanguage(String langName) {
        HashMap<String, String> lang = new HashMap<>();

        lang.put(langName+"_String1","This is String #1 in lang: " + langName);
        lang.put(langName+"_String2","This is String #2 in lang: " + langName);
        lang.put(langName+"_String3","This is String #3 in lang: " + langName);
        lang.put(langName+"_String4","This is String #4 in lang: " + langName);
        lang.put(langName+"_String5","This is String #5 in lang: " + langName);
        lang.put(langName+"_String6","This is String #6 in lang: " + langName);
        lang.put(langName+"_String7","This is String #7 in lang: " + langName);
        lang.put(langName+"_String8","This is String #8 in lang: " + langName);
        lang.put(langName+"_String9","This is String #9 in lang: " + langName);
        lang.put(langName+"_String10","This is String #10 in lang: " + langName);
        lang.put(langName+"_String11","This is String #11 in lang: " + langName);
        lang.put(langName+"_String12","This is String #12 in lang: " + langName);
        lang.put(langName+"_String13","This is String #13 in lang: " + langName);
        lang.put(langName+"_String14","This is String #14 in lang: " + langName);
        lang.put(langName+"_String15","This is String #15 in lang: " + langName);


        return lang;
    }
}
