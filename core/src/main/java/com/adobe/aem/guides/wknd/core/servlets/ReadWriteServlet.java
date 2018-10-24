package com.adobe.aem.guides.wknd.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@SuppressWarnings("deprecation")
@Component(
    service = Servlet.class,
    property = {
    	  Constants.SERVICE_DESCRIPTION + "=Last Article test Servlet",
        "sling.servlet.extensions="+"html",
        "sling.servlet.selectors=miservlet2",
        "sling.servlet.methods=GET",
        "sling.servlet.metatype="+"true", 
        "sling.servlet.resourceTypes=wknd/components/page/article",
        
    }
)

public class ReadWriteServlet extends SlingAllMethodsServlet  {

	

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(ReadWriteServlet.class);

	 
   @Override
   protected void doGet(final SlingHttpServletRequest req,
           final SlingHttpServletResponse resp) throws ServletException, IOException {
        	try {
           JSONObject PropertiesList = new JSONObject();
           
						PropertiesList.put("titulo","prueba titulo desde servlet");
						PropertiesList.put("descripcion","prueba descripcion desde servlet");
						resp.addHeader("Acces-Control-Allow-Origin", "");
						resp.setCharacterEncoding("utf8");
						resp.setContentType("application/json");
						resp.getOutputStream().print( PropertiesList.toString());
					} catch (JSONException e) {				
						e.printStackTrace();
					}
   }
	
 
   @Override
   protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException
   {
       // POST Implementation
   }
}