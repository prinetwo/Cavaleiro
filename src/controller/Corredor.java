package controller;

public class Corredor {
	
	private int ID;
	private String conteudo;
	
	public Corredor(int ID, String conteudo){
		this.ID = ID;
		this.conteudo = conteudo;
	}
	
	public String getConteudo(){
		return conteudo;
	}
	
	public int getID(){
		return ID;
	}

}
