package com.appx.work.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "APPX_SERIES")
public class Series extends BaseEntity {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NUMSER_SEQ")
	@SequenceGenerator(name = "NUMSER_SEQ", sequenceName = "NUMSER_SEQ", initialValue = 1, allocationSize = 1)
	@Basic(optional = false)
	private Long id;

	public Series() {

	}

	@Size(max = 255)
	private String series;

	private String answer;

	private String start;

	private String increment;

	private String options;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "defn_id")
	@JsonIgnore
	private SeriesDefinition defintion;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the defintion
	 */
	public SeriesDefinition getDefintion() {
		return defintion;
	}

	/**
	 * @param defintion
	 *            the defintion to set
	 */
	public void setDefintion(SeriesDefinition defintion) {
		this.defintion = defintion;
	}

	/**
	 * @return the series
	 */
	public String getSeries() {
		return series;
	}

	/**
	 * @param series
	 *            the series to set
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
	 * @param answer
	 *            the answer to set
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
	 * @param start
	 *            the start to set
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
	 * @param increment
	 *            the increment to set
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
	 * @param options
	 *            the options to set
	 */
	public void setOptions(String options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
