package com.sample.app.pages;

import java.util.Random;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

public class RandomString extends WebPage {
	private static final String RANDOM_STR_INPUT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

	private static final long serialVersionUID = 1L;

	private String randomStr = null;

	public RandomString() {
		this.add(new Link("randomString") {

			@Override
			public void onClick() {
				randomStr = generateRandomString();
			}

			@Override
			public MarkupContainer setDefaultModel(IModel model) {
				return null;
			}

		});

		this.add(new Label("randomData", new PropertyModel(this, "randomStr")));
	}

	private static String generateRandomString() {

		final StringBuilder salt = new StringBuilder();
		final Random rnd = new Random();
		while (salt.length() < 25) {
			final int index = (int) (rnd.nextFloat() * RANDOM_STR_INPUT.length());
			salt.append(RANDOM_STR_INPUT.charAt(index));
		}
		return salt.toString();

	}

}