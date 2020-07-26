package com.consommi.tounsi.models;

import java.util.List;

public class ModelKPI {
	private int TotalNumberOfSuppliers;
	private int TotalNumberOfCustumers;
	private int TotalNumberOfOrders;
	private int TotalNumberOfComplaints;
	private int TotalNumberOfDeliveries;
	private int TotalNumberOfEvents;
	private List<ModelProductSales> TopSelledPoducts;
	public int getTotalNumberOfSuppliers() {
		return TotalNumberOfSuppliers;
	}
	public void setTotalNumberOfSuppliers(int totalNumberOfSuppliers) {
		TotalNumberOfSuppliers = totalNumberOfSuppliers;
	}
	public int getTotalNumberOfCustumers() {
		return TotalNumberOfCustumers;
	}
	public void setTotalNumberOfCustumers(int totalNumberOfCustumers) {
		TotalNumberOfCustumers = totalNumberOfCustumers;
	}
	public int getTotalNumberOfOrders() {
		return TotalNumberOfOrders;
	}
	public void setTotalNumberOfOrders(int totalNumberOfOrders) {
		TotalNumberOfOrders = totalNumberOfOrders;
	}
	
	public int getTotalNumberOfComplaints() {
		return TotalNumberOfComplaints;
	}
	public void setTotalNumberOfComplaints(int totalNumberOfComplaints) {
		TotalNumberOfComplaints = totalNumberOfComplaints;
	}
	public int getTotalNumberOfDeliveries() {
		return TotalNumberOfDeliveries;
	}
	public void setTotalNumberOfDeliveries(int totalNumberOfDeliveries) {
		TotalNumberOfDeliveries = totalNumberOfDeliveries;
	}
	public int getTotalNumberOfEvents() {
		return TotalNumberOfEvents;
	}
	public void setTotalNumberOfEvents(int totalNumberOfEvents) {
		TotalNumberOfEvents = totalNumberOfEvents;
	}
	public List<ModelProductSales> getTopSelledPoducts() {
		return TopSelledPoducts;
	}
	public void setTopSelledPoducts(List<ModelProductSales> topSelledPoducts) {
		TopSelledPoducts = topSelledPoducts;
	}
}
