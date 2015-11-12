package app;

import java.awt.BorderLayout;

public class visaoUsuario extends MolduraAbstrata {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public visaoUsuario() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloUsuario(), BorderLayout.CENTER);
		
	}

}
