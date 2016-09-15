package com.appx.work.to;

import java.io.Serializable;

public class NumberSeriesResult implements Serializable {

	// -1 = Failure
	// 1 = Sucess

	int status;

	int statusReason;

	String seriesFunction;

	String seriesInstruction;

	String series;

	public NumberSeriesResult() {

	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatusReason() {
		return statusReason;
	}

	public void setStatusReason(int statusReason) {
		this.statusReason = statusReason;
	}

	public String getSeriesFunction() {
		return seriesFunction;
	}

	public void setSeriesFunction(String seriesFunction) {
		this.seriesFunction = seriesFunction;
	}

	public String getSeriesInstruction() {
		return seriesInstruction;
	}

	public void setSeriesInstruction(String seriesInstruction) {
		this.seriesInstruction = seriesInstruction;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

}
