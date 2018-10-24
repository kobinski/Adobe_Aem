package com.adobe.aem.guides.wknd.core.pojo;

import java.util.ArrayList;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.wcm.foundation.Image;

public class ImageWcm extends WCMUsePojo{
	private Resource res;
	private Image image;
	private List<String>imagenes= new ArrayList<String>();
	private String image0;
	private String image1;
	private String image2;
	private String image3;
	private static final Logger LOGGER  = LoggerFactory.getLogger(Valores.class);
	
	@Override
	public void activate() throws Exception {
		imageList();
		
	}
	/*
	 * Este pojo esta declarado en el componente articlesinline, su funcion es ver si hay image en el dialog, si es asi lo procesa lo comprueba
	 * y en el html se muestra el valor obtenido de dicha imagen. 
	 */
	public void imageList() {
		try {
			if(image0==null) {
			res=getResource().getChild("image");
				if(res!=null) {
					String chlidResourceImage = res.getValueMap().get("fileReference", String.class);
					if(chlidResourceImage!=null) {
						 image0=chlidResourceImage;
						 
					}
				}
		}
			//comprueba que la imagen0 no esta vacia en caso de estar vacia no se puede insertar la image1 hasta que no se cumpla el requesito
			if(image0!=null) {
				res=getResource().getChild("image1");
				if(res!=null) {
					String chlidResourceImage = res.getValueMap().get("fileReference", String.class);
					if(chlidResourceImage!=null) {
						image1=chlidResourceImage;
					}
				}
			}
		//comprueba que la imagen0 y la image1 no esta vacia en caso de estar vacia no se puede insertar la image1 hasta que no se cumpla el requesito
			if(image0!=null && image1!=null) {
				res=getResource().getChild("image2");
				if(res!=null) {
					String chlidResourceImage = res.getValueMap().get("fileReference", String.class);
					if(chlidResourceImage!=null) {
						image2=chlidResourceImage;
					}
				}
			}
		//comprueba que la imagen0, image1,image2 no esta vacia en caso de estar vacia no se puede insertar la image1 hasta que no se cumpla el requesito
			if(image0!=null && image1!=null && image2!=null) {
				res=getResource().getChild("image3");
				if(res!=null) {
					String chlidResourceImage = res.getValueMap().get("fileReference", String.class);
					if(chlidResourceImage!=null) {
						image3=chlidResourceImage;
					}
				}
			}
		}catch(Exception e) {
			LOGGER.error("Exception while image dialog error {}", e.getMessage(), e);
		}
	}
	/**
	 * @return the image0
	 */
	public String getImage0() {
		return image0;
	}
	/**
	 * @return the image1
	 */
	public String getImage1() {
		return image1;
	}
	/**
	 * @return the image2
	 */
	public String getImage2() {
		return image2;
	}
	/**
	 * @return the image3
	 */
	public String getImage3() {
		return image3;
	}
	
}
