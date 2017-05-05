/**
 * 
 */
package com.jenkins.migration;

//import java.io.BufferedReader;
import java.io.FileInputStream;
//import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
//import java.util.logging.Level;
//import java.util.logging.Logger;




/**
 * @author SUNBAAT
 *
 */
public class URLConnectionReader {
	
	public String getConfig() throws Exception  {
		String result=null;
		try{
        //String returnString = null;
		Properties prop = new Properties();
		String fileName = "./resources/config.properties";
		InputStream inputstream = new FileInputStream(fileName);
		prop.load(inputstream);
		//System.out.println("URL" + prop.getProperty("app.URL"));
        String userpass = prop.getProperty("app.userpass");

		//String authString = name + ":" + password;
		//System.out.println("auth string: " + authString);
		//byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
		//String authStringEnc = new String(authEncBytes);
		//System.out.println("Base64 encoded auth string: " + authStringEnc);

        //int timeout =200;
		URL url = new URL(prop.getProperty("app.URL"));
		/*HttpURLConnection c = null;
		 try {
		        URL u = new URL(prop.getProperty("app.URL"));
		        c = (HttpURLConnection) u.openConnection();
		        c.setRequestMethod("GET");
		        c.setRequestProperty("Content-length", "0");
		        c.setRequestProperty("Authorization", "Basic " + userpass);
		        c.setUseCaches(false);
		        c.setAllowUserInteraction(false);
		        c.setConnectTimeout(timeout);
		        c.setReadTimeout(timeout);
		        c.connect();
		        int status = c.getResponseCode();

		        switch (status) {
		            case 200:
		            case 201:
		                BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
		                StringBuilder sb = new StringBuilder();
		                String line;
		                while ((line = br.readLine()) != null) {
		                    sb.append(line+"\n");
		                }
		                br.close();
		                return sb.toString();
		        }

		    } catch (MalformedURLException ex) {
		        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
		    } catch (IOException ex) {
		        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
		    } finally {
		       if (c != null) {
		          try {
		              c.disconnect();
		          } catch (Exception ex) {
		             Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
		          }
		       }
		    }*/
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
		//System.out.println(sb.toString());
		ParseJSON objparse = new ParseJSON();
		objparse.ConvertJSON(sb.toString());
		result = sb.toString();
		/*URL urljenkins = new URL("");
        URLConnection yc = urljenkins.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
        	returnString =  returnString + inputLine;
        in.close();
        */
		
	}
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
		return result;
    }

}
