package com.jenkins.migration;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
public class URLConnectionReader {
	
	public String getConfig(String geturl, String userpass) throws Exception  {
		String result=null;
		try{
       
		URL url = new URL(geturl);
		URLConnection urlConnection = url.openConnection();
		urlConnection.setRequestProperty("Authorization", "Basic " + userpass);
		InputStream is = urlConnection.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);

		int numCharsRead;
		char[] charArray = new char[1024];
		StringBuffer sb = new StringBuffer();
		while ((numCharsRead = isr.read(charArray)) > 0) {
			sb.append(charArray, 0, numCharsRead);
		}
		
		ParseJSON objparse = new ParseJSON();
		objparse.ConvertJSON(sb.toString());
		result = sb.toString();
	}
		 catch (Exception e) {
				e.printStackTrace();
			}
        
		return result;
    }

}