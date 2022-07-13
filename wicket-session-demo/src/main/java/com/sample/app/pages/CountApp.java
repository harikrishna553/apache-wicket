package com.sample.app.pages;

import java.io.Serializable;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;

public class CountApp extends WebPage {
	private static final long serialVersionUID = 1L;

	private Label label;

	private Integer count = 0;

	public CountApp() {
		Form form = new Form("countForm");

		label = new Label("clickCount", new PropertyModel<>(this, "count"));
		this.add(label);

		form.add(new Button("click") {
			@Override
			public void onSubmit() {
				Session session = this.getSession();

				Serializable clickCount = session.getAttribute("clickCount");
				if (clickCount == null) {
					session.setAttribute("clickCount", Integer.valueOf(1));
					label.setDefaultModelObject(1);
					return;
				}

				Integer clickCountInt = (Integer) clickCount;
				clickCountInt++;
				session.setAttribute("clickCount", clickCountInt);
				label.setDefaultModelObject(clickCountInt);
			}
		});

		this.add(form);

	}

}