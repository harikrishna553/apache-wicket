package com.sample.app.pages;

import java.util.Optional;
import java.util.Random;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

public class RandomString extends WebPage {
	private static final String RANDOM_STR_INPUT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

	private static final long serialVersionUID = 1L;

	private String randomStr = null;
	private Label label;

	public RandomString() {
		this.add(new AjaxFallbackLink<AjaxRequestTarget>("randomString") {

			@Override
			public MarkupContainer setDefaultModel(IModel model) {
				return null;
			}

			@Override
			public void onClick(Optional<AjaxRequestTarget> target) {

				// When Javascript is disabled in the browser, target is null.
				if (!target.isEmpty()) {
					randomStr = generateRandomString();
					AjaxRequestTarget ajaxRequestTarget = target.get();
					ajaxRequestTarget.add(label);
				}

			}

		});

		label = new Label("randomData", new PropertyModel(this, "randomStr"));
		label.setOutputMarkupId(true);
		this.add(label);
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