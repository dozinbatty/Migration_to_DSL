package com.jenkins.migration;
import org.json.simple.JSONObject;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public class ParseJSON {

	public void ConvertJSON(String jsonString){
		 JSONParser parser = new JSONParser();
		
	    	  try {
				JSONObject jobject = (JSONObject)parser.parse(jsonString.toString());
				   SeqParse readXML = new SeqParse();
				   readXML.SeqParseLoop("views", jobject);
					
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
