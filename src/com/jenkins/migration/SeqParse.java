package com.jenkins.migration;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SeqParse {
	
	public void SeqParseLoop (String level, JSONObject jobj){
		
		JSONParser parser = new JSONParser();
		
	    	  try {
	    		  
					JSONArray a = (JSONArray)parser.parse(jobj.get(level).toString());

					  for (Object o : a)
					  {
					    JSONObject views = (JSONObject) o;

					    String type = (String) views.get("_class");
					    System.out.println(type);

					    String name = (String) views.get("name");
					    System.out.println(name);

					    String url = (String) views.get("url");
					    System.out.println(url);
					  }
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	
}
