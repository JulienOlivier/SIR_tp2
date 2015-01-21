package fr.istic.tpjpa.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Maison")
public class classMetierHome {
	/*
	 * Variables globales
	 */
	private String adresse;
	private int superficie;
	private String IP;
	private classMetierPerson personne;
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getSuperficie() {
		return superficie;
	}
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	
	/*
	 * Génération de l'ID
	 */
	private Long id;
	
	@Id
	@GeneratedValue
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
	
	/*
	 * Jointures
	 */
	private List<Heater> heatrs;
	private List<ElectronicDevice> devices; 
	
	@OneToMany
	public List<Heater> getHeatrs() {
		return heatrs;
	}
	public void setHeatrs(List<Heater> heatrs) {
		this.heatrs = heatrs;
	}
	@OneToMany
	public List<ElectronicDevice> getDevices() {
		return devices;
	}
	public void setDevices(List<ElectronicDevice> devices) {
		this.devices = devices;
	}
	
	/*
	 * Constructeurs de la classe
	 */
	public classMetierHome(){
		this.heatrs = new ArrayList<Heater>();
		this.devices = new ArrayList<ElectronicDevice>();
	}
	@ManyToOne
	public classMetierPerson getPersonne(){
		return personne;
	}
	public void setPersonne (classMetierPerson personne){
		this.personne = personne;
	}
}
