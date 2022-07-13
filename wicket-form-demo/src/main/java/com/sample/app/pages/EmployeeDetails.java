package com.sample.app.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import com.sample.app.dto.Employee;
import com.sample.app.util.EmployeeUtil;

public class EmployeeDetails extends WebPage {
	private static final long serialVersionUID = 1L;

	private Label label;
	private TextField textField;

	private Employee emp = new Employee();

	public EmployeeDetails() {
		Form form = new Form("employeeDetailsForm");

		textField = new TextField<>("empId", new PropertyModel<>(emp, "id"));

		form.add(textField);

		label = new Label("empName", new PropertyModel<>(emp, "name"));
		this.add(label);

		form.add(new Button("getEmpName") {
			@Override
			public void onSubmit() {
				Integer empId = (Integer) textField.getModelObject();

				emp = EmployeeUtil.byId(empId);

				label.setDefaultModelObject(emp.getName());
				
			}
		});

		this.add(form);

	}

}