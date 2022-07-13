package com.sample.app.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class HelloWorld extends WebPage {
	
	private static final long serialVersionUID = 1L;

	public HelloWorld() {
		add(new Label("helloMessage", "Hello, Wicket!!!!!!"));
	}
}
