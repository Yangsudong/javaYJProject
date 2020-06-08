package javaYJProject;

import javafx.beans.property.SimpleIntegerProperty;

public class exchangeRate {
	private SimpleIntegerProperty krw;
	private SimpleIntegerProperty usd;
	private SimpleIntegerProperty eur;
	private SimpleIntegerProperty chy;
	private SimpleIntegerProperty jpy;

	public void setKrw(int krw) {
		this.krw.set(krw);
	}
	public int getKrw() {
		return this.krw.get();
	}
	public SimpleIntegerProperty krwProperty() {
		return this.krw;
	}
	
	public void setUsd(int usd) {
		this.usd.set(usd);
	}
	public int getUsd() {
		return this.usd.get();
	}
	public SimpleIntegerProperty usdProperty() {
		return this.usd;
	}
	
	public void setEur(int eur) {
		this.eur.set(eur);
	}
	public int getEur() {
		return this.eur.get();
	}
	public SimpleIntegerProperty eurProperty() {
		return this.eur;
	}
	
	public void setChy(int chy) {
		this.chy.set(chy);
	}
	public int getChy() {
		return this.chy.get();
	}
	public SimpleIntegerProperty chyProperty() {
		return this.chy;
	}
	
	public void setJpy(int jpy) {
		this.jpy.set(jpy);
	}
	public int getjpy() {
		return this.jpy.get();
	}
	public SimpleIntegerProperty jpyProperty() {
		return this.jpy;
	}
	
}
