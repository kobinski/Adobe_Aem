package com.adobe.aem.guides.wknd.core.pojo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;
/*
 * Este pojo procesa un multifield del dialog captura los items que genera el multifield
 * los procesa y obtengo los valores insertados en el dialg sea uno dos tres etc.
 * en el html del componente footer recorro la lista almacenada y la imprimo 
 * 
 */
public class MultifieldHeaderWcm extends WCMUsePojo{
	 private Resource res;
	 private List<String> items= new ArrayList<String>();	
	 private static final Logger LOGGER  = LoggerFactory.getLogger(Valores.class);
	@Override
	public void activate() throws Exception {
		
	 	MultiFieldItems();
	}
	
public void MultiFieldItems(){
		
		try {
			res=getResource().getChild("items");
			Iterator<Resource>children =res.listChildren();
			while(children.hasNext()) {
				 Resource childResource = children.next();
				 if(childResource!=null) {
					 String childResourceValue = childResource.getValueMap().get("text",String.class);
					 if(childResourceValue!=null) {
						items.add(childResourceValue);
					 }
					 
				 }
				
			}
		}catch(Exception e){
			LOGGER.error("Exception while Multifield data {}", e.getMessage(), e);
		}
	}
/**
 * @return the items
 */
public List<String> getItems() {
	return items;
}
}
