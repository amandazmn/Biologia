package sistemaTraducaoCodGenetico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Gene {
	private String nome;
	private String sequencia;
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSequencia() {
		return sequencia;
	}
	public void setSequencia(String sequencia) {
		this.sequencia = sequencia;
	}
	
	public String getmRNA() {
		return sequencia.replace('T', 'U');
	}
	
	public String getProteina() {
		
		String mRNA = getmRNA();
		String proteina = "";
		for(int i=0;i<mRNA.length();i+=3) {
			String codon = mRNA.substring(i, i+3);
			
			String aa = "";
			if(codon.equals("UUU") || codon.equals("UUC")) {
				aa = "F";
			} else if (codon.equals("UUA") || codon.equals("UUG")) {
				aa = "L";
			} else if (codon.equals("UAA") || codon.equals("UAG") || codon.equals("UGA")) {
				aa = "*";
			} 
			proteina=proteina+aa;
			
			System.out.print(codon + " ");
		}
		System.out.println();
		return proteina;
	}
	
	public static void main(String[] args) {
		Gene a = new Gene();
		a.sequencia="TTTTTATTCTTGTAATAG";
		System.out.println("mRNA     "+ a.getmRNA());
		System.out.println("Proteina "+ a.getProteina());
	}
	
	
}
