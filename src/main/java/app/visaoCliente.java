package app;

import java.awt.BorderLayout;

public class visaoCliente extends MolduraAbstrata {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public visaoCliente() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloCliente(), BorderLayout.CENTER);
		
	}

}
