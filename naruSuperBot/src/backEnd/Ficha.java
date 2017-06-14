package backEnd;

import java.util.ArrayList;

public class Ficha {
	private String nome;

	private int lvl;
	private String KekkeiGenkai;
	private String alinhamento;
	private String jogador;
	private String vinculo;
	private String fraqueza;
	private ArrayList<Integer> atributos;
	private int pv;
	private int pc;
	private String determina;
	private double ryo;

	public Ficha(String nome, int lvl, String kekkeiGenkai, String alinhamento, String jogador, String vinculo,
			String fraqueza, ArrayList<Integer> atributos, int pv, int pc, String determina, double ryo) {
		
		this.nome = nome;
		this.lvl = lvl;
		if(kekkeiGenkai!=null)
		KekkeiGenkai = kekkeiGenkai;
		this.alinhamento = alinhamento;
		this.jogador = jogador;
		this.vinculo = vinculo;
		this.fraqueza = fraqueza;
		this.atributos = atributos;
		this.pv = pv;
		this.pc = pc;
		this.determina = determina;
		this.ryo = ryo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getKekkeiGenkai() {
		return KekkeiGenkai;
	}

	public void setKekkeiGenkai(String kekkeiGenkai) {
		KekkeiGenkai = kekkeiGenkai;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public String getAlinhamento() {
		return alinhamento;
	}

	public void setAlinhamento(String alinhamento) {
		this.alinhamento = alinhamento;
	}

	public String getJogador() {
		return jogador;
	}

	public void setJogador(String jogador) {
		this.jogador = jogador;
	}

	public String getVinculo() {
		return vinculo;
	}

	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}

	public String getFraqueza() {
		return fraqueza;
	}

	public void setFraqueza(String fraqueza) {
		this.fraqueza = fraqueza;
	}

	public ArrayList<Integer> getAtributos() {
		return atributos;
	}

	public void setAtributos(ArrayList<Integer> atributos) {
		this.atributos = atributos;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public String getDetermina() {
		return determina;
	}

	public void setDetermina(String determina) {
		this.determina = determina;
	}

	public double getRyo() {
		return ryo;
	}

	public void setRyo(double ryo) {
		this.ryo = ryo;
	}

}
