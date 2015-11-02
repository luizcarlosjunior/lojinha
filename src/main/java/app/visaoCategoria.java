package app;

import java.awt.BorderLayout;

public class visaoCategoria extends MolduraAbstrata {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public visaoCategoria() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloCategoria(), BorderLayout.CENTER);
		
	}

}
