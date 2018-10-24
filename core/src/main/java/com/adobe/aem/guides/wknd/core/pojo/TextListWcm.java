package com.adobe.aem.guides.wknd.core.pojo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.aem.guides.wknd.core.bean.TextListMultifield;
import com.adobe.cq.sightly.WCMUsePojo;
/*
 * este pojo es de un componente nuevo que cree para probar obtener los diferentes valores de un multifield
 * tambien probe un bean para ver como era exactamente 
 */
public class TextListWcm extends WCMUsePojo{

	private String saludo;
	private static final Logger LOGGER = LoggerFactory.getLogger(TextListWcm.class);
	private Resource res;
	private List<TextListMultifield> listChildItems= new ArrayList<>();
	/*
	 * (non-Javadoc)
	 * @see com.adobe.cq.sightly.WCMUsePojo#activate()
	 */
	@Override
	public void activate() throws Exception {
		
		saludo = "hola desde el pojo";
		listMultifield();
	}

	
// este listado es un listado de objetos, primero se crea el archivo bean y dentro la TextListMultifield bean con los get y set
	public void listMultifield() {
		try {
			res=getResource().getChild("items");
			 Iterator<Resource>children= res.listChildren();
			 while(children.hasNext()) {
				 Resource childResource = children.next();
				 	if(childResource!=null) {
				 		String name, text, path;
				 		name= childResource.getName();
				 		text=childResource.getValueMap().get("text",String.class);
				 		path=childResource.getPath();
				 		if(name!=null && text!=null && path!=null) {
						 		TextListMultifield objeto = new TextListMultifield(name, text, path);
						 		listChildItems.add(objeto);
				 		}
				 	}
			 }
		}catch(Exception e) {
			LOGGER.error("Exception while Mulifield data{}", e.getMessage(),e);
		}
	}
	
		
	/**
	 * @return the listChildItems
	 */
	public List<TextListMultifield> getListChildItems() {
		return listChildItems;
	}


	/**
	 * @return the saludo
	 */
	public String getSaludo() {
		return saludo;
	}






}
