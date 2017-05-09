package com.jenkins.migration;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public class ParseJSON {

	public void ConvertJSON(String jsonString){
		 JSONParser parser = new JSONParser();
		
	      //String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
			
	     // try{
	    	  
	    	  //System.out.println(jsonString);
	    	  try {
				JSONObject jobject = (JSONObject)parser.parse(jsonString.toString());
				//for (int i = 0; i < jobject.size(); i++) {

				System.out.println(jobject.get("_class").toString());
				System.out.println(jobject.get("assignedLabels").toString());
					System.out.println(jobject.get("mode").toString());
					System.out.println(jobject.get("nodeDescription").toString());
					System.out.println(jobject.get("nodeName").toString());
					System.out.println(jobject.get("numExecutors").toString());
					System.out.println(jobject.get("views").toString());
					//System.out.println(jobject.get("views").toString());
					JSONArray jarray = (JSONArray)parser.parse(jobject.get("views").toString());
					for (int i = 0; i < jarray.size(); i++) {
						System.out.println(jarray.get(i).toString());	
					}
					
					//ArrayList<String> arraylist = new ArrayList<>();
					//arraylist.add(jobject.get("views").toString())
					//System.out.println(jobject.get("description").toString());
					//System.out.println(jobject.get("jobs").toString());
					//JSONArray jobarray = new JSONArray();
					//jobarray.add(jobject.get("jobs"));
					//for (int i = 0; i < jobarray.size(); i++) {
					//	System.out.println(jobarray.get(i).toString());
					//}
				//}
				
				//System.out.println(((JSONObject)jarray.get(0)).get("jobs"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	  //System.out.println(((JSONObject)array.get(0)).get("jobs"));
	    	  
	    	  
	    	  /*
	    	  JSONObject jObject = new JSONObject(jsonString);
	    	  Iterator<?> keys = (Iterator<?>) jObject.keySet();

	    	  while( keys.hasNext() ) {
	    	      String key = (String)keys.next();
	    	      if ( jObject.get(key) instanceof JSONObject ) {

	    	      }
	    	  }
	    	  */
	         //Object obj = parser.parse(jsonString);
	         //JSONParser parser = new JSONParser();
	         //Object obj  = parser.parse(jsonString);
	         //JSONArray array= getJsonObjectOrJsonArray(obj);
	         //for (int i = 0; i < array.size(); i++) {
			//		System.out.println(array.get(i).toString());
			//	}
	         /*
	         JSONArray array1 = new JSONArray();
	         array1.add(obj);
	         for (int i = 0; i < array1.size(); i++) {
				System.out.println(array1.get(i).toString());
			}*/
	         //JSONArray array = (JSONArray)obj;
				
	        /* System.out.println("The 2nd element of array");
	         System.out.println(array.get(1));
	         System.out.println();

	         JSONObject obj2 = (JSONObject)array.get(1);
	         System.out.println("Field \"1\"");
	         System.out.println(obj2.get("1"));   
	         
	         
	         System.out.println("#######################################################");
	         
	         String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
	         s = "{}";
	         obj = parser.parse(s);
	         System.out.println(obj);

	         s = "[5,]";
	         obj = parser.parse(s);
	         System.out.println(obj);

	         s = "[5,,2]";
	         obj = parser.parse(s);
	         System.out.println(obj);*/
	      /*}catch(ParseException pe){
			
	         System.out.println("position: " + pe.getPosition());
	         System.out.println(pe);
	      }*/
	}
	
}
