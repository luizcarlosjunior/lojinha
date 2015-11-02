package app;

import java.awt.BorderLayout;

public class Categoria extends MolduraAbstrata {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Categoria() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloCategoria(), BorderLayout.CENTER);
		
	}

}
