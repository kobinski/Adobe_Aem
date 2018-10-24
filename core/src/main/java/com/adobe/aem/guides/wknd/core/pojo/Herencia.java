package com.adobe.aem.guides.wknd.core.pojo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.sling.api.resource.Resource;

import com.adobe.aem.guides.wknd.core.models.ModelsArticle;
import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.wcm.api.Page;

public class Herencia extends WCMUsePojo {
	private Map<String,String>listGeneral;
	private Resource res;
	private Page page;
	private List<ModelsArticle> subPageChildrenArticle;
	private String routeArticle;
	private ModelsArticle modelsartcile;
	String title ;
	String path;
	 String article;
	 String buttonLinkHomePage;
	 String buttonLinkArticle;
	 String avoidRegression;
	 String avoidRegressionArticle;
	 String [] pagelistchild;
	@Override
	/*
	 * (non-Javadoc)
	 * @see com.adobe.cq.sightly.WCMUsePojo#activate()
	 */
	
	public void activate() throws Exception {
		listarPage();
		title = getResource().getValueMap().get("title",String.class);
		path = getResource().getPath();
	  article=getResource().getPath();
	  buttonLinkHomePage= getCurrentPage().getPath()+".html";
	  buttonLinkArticle= getCurrentPage().getPath()+".html";
	  regressionHome();
	  regressionArticle();
	  this.pagelistchild = res.getValueMap().get("home-page", String[].class);
	  getSubPageChildrenArticle();
	}
	
	/*
	 * Este pojo lista las pages desde el home-page comprueba cuantos hijos hay obtiene el resultado de article y se añade al valor del boton
	 * se añade condiciones para que no se salga de la page deseada y solo refresque la mismma page
	 */
	public void listarPage() {
		listGeneral = new HashMap<>();
		Page parentPage= getCurrentPage();
		Iterator<Page> it = parentPage.listChildren();
		while(it.hasNext()) {
			Page subPage = it.next();
			if(subPage != null) {
				listGeneral.put(subPage.getName(), subPage.getPath());
				}
				subPage.getName().equals("article");{
					routeArticle= subPage.getPath() ;
					
				}
		}
	}
	
	public Map<String, String> getListGeneral() {
		return listGeneral;
	}
	
	public List<ModelsArticle> getPageList(Page parentPage) {
		List<ModelsArticle> list = new ArrayList<>();
		Iterator<Page> it = parentPage.listChildren();
		while(it.hasNext()) {
			Page subPage = it.next();
			ModelsArticle modelsarticle = subPage.adaptTo(ModelsArticle.class);
			list.add(modelsarticle);
		}
		return list;
	}

	public void regressionHome() {
		avoidRegression= "/content/wknd/en/home-page.html";
		if(buttonLinkHomePage!=null && !avoidRegression.equals(buttonLinkHomePage)) {
			buttonLinkHomePage= getCurrentPage().getParent().getPath()+".html";
		}else {
			buttonLinkHomePage= getCurrentPage().getPath()+".html";
		}
	}
	public void regressionArticle() {
		avoidRegressionArticle= "/content/wknd/en/home-page/article.html";
		if(buttonLinkArticle!=null && !avoidRegressionArticle.equals(buttonLinkArticle)) {
			//
			buttonLinkArticle=  routeArticle+".html";
		}else {
			buttonLinkArticle= getCurrentPage().getPath()+".html";
		}
	}

	public String getTitle() {
		return title;	
		}
	public String getArticle()  {
		return article;	
		}
	public String getPath()  {
		return path;	
		}
	
	public String getButtonLinkHome() {
		return buttonLinkHomePage;
	}
	public String getButtonLinkArticle() {
		return buttonLinkArticle;
	}
	
	public List<ModelsArticle> getSubPageChildrenArticle() {
		return subPageChildrenArticle;
	}
	public String getPrueba() {
		return routeArticle;
	}
}
