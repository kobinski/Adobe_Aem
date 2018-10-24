package com.adobe.aem.guides.wknd.core.bean;

public class TextListMultifield {
private String name;
private String text;
private String path;
/**
 * Constructor
 * @param name
 * @param text
 * @param path
 */
public TextListMultifield(String name, String text, String path) {

	this.name = name;
	this.text = text;
	this.path = path;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the text
 */
public String getText() {
	return text;
}
/**
 * @param text the text to set
 */
public void setText(String text) {
	this.text = text;
}
/**
 * @return the path
 */
public String getPath() {
	return path;
}
/**
 * @param path the path to set
 */
public void setPath(String path) {
	this.path = path;
}


}
