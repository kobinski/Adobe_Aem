/*
 * esta es el servelet que venia de ejempplo en este proyecto, me la carge en su momento para ver que pasaba entre un servelet y un ajax
 * esta no es la original si da fallos me la cargo
 * otra cosa tiene el ejemplo de unos log o looger como quieras llamarlo
 * */


package com.adobe.aem.guides.wknd.core.servlets;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleServlet extends SlingSafeMethodsServlet {

  private static final long serialVersionUid = 1L;
  private static final Logger LOG = LoggerFactory.getLogger(SimpleServlet.class);

  @Override
  protected void doGet(SlingHttpServletRequest req, SlingHttpServletResponse resp) throws ServletException, IOException {
      //final Resource resource = req.getResource();
     
  	
     
  }
}
