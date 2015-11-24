package app;

import java.awt.BorderLayout;

public class visaoProduto extends MolduraAbstrata {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public visaoProduto() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloProduto(), BorderLayout.CENTER);
		
	}

}
