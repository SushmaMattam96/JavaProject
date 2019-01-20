package com.cg.ts.model;

public class TruckBean {
	private int truckid;
	private String trucktype;
	private String origin;
	private String destination;
	private float charges;
	private int availableNos;
	public int getTruckid() {
		return truckid;
	}
	public void setTruckid(int truckid) {
		this.truckid = truckid;
	}
	public String getTrucktype() {
		return trucktype;
	}
	public void setTrucktype(String trucktype) {
		this.trucktype = trucktype;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public float getCharges() {
		return charges;
	}
	public void setCharges(float charges) {
		this.charges = charges;
	}
	public int getAvailableNos() {
		return availableNos;
	}
	public void setAvailableNos(int availableNos) {
		this.availableNos = availableNos;
	}
	public TruckBean(int truckid, String trucktype, String origin, String destination, float charges,
			int availableNos) {
		super();
		this.truckid = truckid;
		this.trucktype = trucktype;
		this.origin = origin;
		this.destination = destination;
		this.charges = charges;
		this.availableNos = availableNos;
	}
	public TruckBean() {
		
	}

}
