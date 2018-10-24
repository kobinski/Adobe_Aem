package com.adobe.aem.guides.wknd.core.pojo;
import org.apache.sling.api.resource.Resource;

import com.adobe.cq.sightly.WCMUsePojo;
/*
 * este pojo es para controloar el header y el footer que hereden de la home-page y todo lo que se edite sea en la home-page
 * estos componentes heredan del home a article y en article se ve todo lo que se ha modificado en la home-page
 */
public class Valores extends WCMUsePojo {

	 String footer;
	 String home_page;
	 String parent;
	 String title;
	 String ruta;
	 String rutaheader;
	 Resource resChildItems ;
	 String prueba;
	 
	 
	 
	 @Override
	public void activate() throws Exception {
	  footer=getResource().getParent().getName();
	  parent=getCurrentPage().getParent().getParent().getName();
	  home_page= getCurrentPage().getParent().getName();
	 	getParent();
	
	 }
	public String getHome_page()  {
		return home_page;
		}
	
	public String getParent()  {
		return parent;	
		}
	
	public String getFooter()  {
		return footer;	
		}

	 public String getRuta() {
		 ruta= "/content/wknd/"+parent+"/"+home_page+"/jcr:content/"+"footer";
		 return ruta ;
	   } 
	 
	 public String getRutaheader() {
		 rutaheader= "/content/wknd/"+parent+"/"+home_page+"/jcr:content/"+"header";
		 return rutaheader ;
	   } 
	 
	 public String getTitle() {
		 return title;
	 }
	 
	 
	 
}