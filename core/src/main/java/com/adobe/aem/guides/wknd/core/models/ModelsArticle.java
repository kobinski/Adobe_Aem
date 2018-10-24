package com.adobe.aem.guides.wknd.core.models;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;

@Model(adaptables=Resource.class)
public class ModelsArticle {
	
   

  
   
   @Inject @Named("jcr:title") @Default(values="no falles")
   private String title;
 /* @Inject @Named("jcr:content/image-three")
 	private Resource imageThreeResource;
 	private Image imageThree;*/
   
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
   
	
 
  

/*	public void activate() throws Exception {
		
	// Previews
			if (this.imageThreeResource!=null) {
				this.imageThree = new Image(imageThreeResource);
				this.imageThree.setSelector(".img");
			}
			 getImageThree();
			
	}*/
	
/*	public Image getImageThree() {
		return imageThree;
	}
   */
}