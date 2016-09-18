package com.appx.work.to;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class SeriesTO implements Serializable {
	
	private Long id;

	private String series;

	private String answer;

	private String start;

	private String increment;

	private String options;

	private SeriesDefinitionTO defintion;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the series
	 */
	public String getSeries() {
		return series;
	}

	/**
	 * @param series the series to set
	 */
	public void setSeries(String series) {
		this.series = series;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return the start
	 */
	public String getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(String start) {
		this.start = start;
	}

	/**
	 * @return the increment
	 */
	public String getIncrement() {
		return increment;
	}

	/**
	 * @param increment the increment to set
	 */
	public void setIncrement(String increment) {
		this.increment = increment;
	}

	/**
	 * @return the options
	 */
	public String getOptions() {
		return options;
	}

	/**
	 * @param options the options to set
	 */
	public void setOptions(String options) {
		this.options = options;
	}

	/**
	 * @return the defintion
	 */
	public SeriesDefinitionTO getDefintion() {
		return defintion;
	}

	/**
	 * @param defintion the defintion to set
	 */
	public void setDefintion(SeriesDefinitionTO defintion) {
		this.defintion = defintion;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	

}
