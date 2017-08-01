package tbx.web.ui.main.page.ui.controllers;





import tbx.web.ui.connectors.VaadinConnector;


import com.vaadin.ui.UI;


public class MainUIController
{

	private UI				ui;
	private VaadinConnector	vaadinConnector;

	public MainUIController( UI ui )
	{

		this.ui = ui;
		this.vaadinConnector = new VaadinConnector( ui );
	}
	
	
}
