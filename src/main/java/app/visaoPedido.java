package app;

import java.awt.BorderLayout;

public class visaoPedido extends MolduraAbstrata {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public visaoPedido() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloPedido(), BorderLayout.CENTER);
		
	}

}
