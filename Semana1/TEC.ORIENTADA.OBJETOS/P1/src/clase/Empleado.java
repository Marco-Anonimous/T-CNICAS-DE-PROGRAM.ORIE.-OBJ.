package clase;

public class Empleado {
private String cod, nom, arealaboral;
private double sue;
private int he,afilia;

public Empleado(String cod, String nom, String arealaboral, double sue, int he, int afilia) {
	this.cod = cod;
	this.nom = nom;
	this.arealaboral = arealaboral;
	this.sue = sue;
	this.he = he;
	this.afilia = afilia;
}

public String getCod() {
	return cod;
}

public void setCod(String cod) {
	this.cod = cod;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getArealaboral() {
	return arealaboral;
}

public void setArealaboral(String arealaboral) {
	this.arealaboral = arealaboral;
}

public double getSue() {
	return sue;
}

public void setSue(double sue) {
	this.sue = sue;
}

public int getHe() {
	return he;
}

public void setHe(int he) {
	this.he = he;
}

public int getAfilia() {
	return afilia;
}

public void setAfilia(int afilia) {
	this.afilia = afilia;
}

public double MontoHE() {
	return sue * he / 240 ;
}
public double SueldoBruto(){
	return sue+MontoHE();
}
public double DsctoAFP() {
	return 0.11 * SueldoBruto();
}
public double DsctoSNP() {
	return 0.06 * SueldoBruto();
}
public double dsctoEESALUD() {
	return 0.03 * SueldoBruto();
}
public double SN() {
	if(afilia == 0)//SUELDO POR AFP SI ES 0
		return SueldoBruto() -dsctoEESALUD() -  DsctoAFP();
	else // SUELDO POR SNP SI ES 1 
		return SueldoBruto() -dsctoEESALUD() -  DsctoSNP();
}










}









