/*
 * Classe Produto
 * serve para modelar o produto
 * Luiz Carlos Szpikula Junior
 * 29/10/2015 20:20
 */

package MODEL;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Produto {
	int id;
	String codigo_de_barras;
	String categoria;
	String descricao;
	String unidade;
	Float custo;
	Float margem_de_lucro;
	
	public Produto(){}
	
	public Produto(Integer id, String codigo_de_barras, String categoria, String descricao, String unidade, Float custo, Float margem_de_lucro) {
		this.id = id;
		this.codigo_de_barras = codigo_de_barras;
		this.categoria = categoria;
		this.descricao = descricao;
		this.unidade = unidade;
		this.custo = custo;
		this.margem_de_lucro = margem_de_lucro;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo_de_barras() {
		return codigo_de_barras;
	}
	public void setCodigo_de_barras(String codigo_de_barras) {
		this.codigo_de_barras = codigo_de_barras;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public Float getCusto() {
		return custo;
	}
	public void setCusto(Float custo) {
		this.custo = custo;
	}
	public Float getMargem_de_lucro() {
		return margem_de_lucro;
	}
	public void setMargem_de_lucro(Float margem_de_lucro) {
		this.margem_de_lucro = margem_de_lucro;
	}

	public boolean testa_validade() {
		boolean valido = true;
		
		valido = !codigo_de_barras.isEmpty();
		valido = !descricao.isEmpty();
		
		return valido;
	}
	
	public float getValor() {

        float valor = this.custo + this.margem_de_lucro;
        
        int casasDecimais = 2;
        BigDecimal aNumber = new BigDecimal(valor);
        aNumber = aNumber.setScale(casasDecimais, BigDecimal.ROUND_HALF_UP);
        double value = aNumber.doubleValue();
        
		return (float) value;
	}
	
	public String getValorFormatado(){
		return NumberFormat.getCurrencyInstance().format( getValor() );
	}
	
	
}
