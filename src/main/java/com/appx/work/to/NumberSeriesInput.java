package com.appx.work.to;

import java.io.Serializable;

public class NumberSeriesInput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NumberSeriesInput() {	}

	int startNo;
	
	int var1;
	
	int var2;
	
	String script;

	/**
	 * @return the startNo
	 */
	public int getStartNo() {
		return startNo;
	}

	/**
	 * @param startNo the startNo to set
	 */
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	/**
	 * @return the var1
	 */
	public int getVar1() {
		return var1;
	}

	/**
	 * @param var1 the var1 to set
	 */
	public void setVar1(int var1) {
		this.var1 = var1;
	}

	/**
	 * @return the var2
	 */
	public int getVar2() {
		return var2;
	}

	/**
	 * @param var2 the var2 to set
	 */
	public void setVar2(int var2) {
		this.var2 = var2;
	}

	/**
	 * @return the script
	 */
	public String getScript() {
		return script;
	}

	/**
	 * @param script the script to set
	 */
	public void setScript(String script) {
		this.script = script;
	}
	
	
	
}
