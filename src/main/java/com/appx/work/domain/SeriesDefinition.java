package com.appx.work.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "APPX_SERDEFN")
public class SeriesDefinition extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 96285180113476324L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NUM_SEQUENCE")
	@SequenceGenerator(name = "NUM_SEQUENCE", sequenceName = "NUM_SEQUENCE", initialValue = 1, allocationSize = 1)
	@Basic(optional = false)
	private Long id;

	/**
	 * Each rule has a name
	 */
	@Size(max = 100)
	private String name;

	/**
	 * Each rule has description Multi-lingual
	 */
	@Size(max = 255)
	private String description;

	/**
	 * Category of the rule
	 */
	@Size(max = 50)
	private String category;

	/**
	 * Explanation on how rule is arranged. Multi-Lingual
	 */
	@Size(max = 255)
	private String explanation;

	/**
	 * Encoded series
	 */
	@Size(max = 255)
	private String encodedSeries;

	/**
	 * Comma separated list of applicable start numbers.
	 * 
	 */
	@Size(max = 255)
	String startNumber;

	/**
	 * Comma separated list of variable values applicable.
	 */
	@Size(max = 255)
	String varValues;

	/**
	 * Difficulty
	 */
	int level;

	/**
	 * Increment defined for the expression
	 */
	int increment = 1;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "APPX_DEFN_SERIES", joinColumns = {
			@JoinColumn(name = "defn_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "ser_id", referencedColumnName = "id") })
	private Set<Series> series;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the explanation
	 */
	public String getExplanation() {
		return explanation;
	}

	/**
	 * @param explanation
	 *            the explanation to set
	 */
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	/**
	 * @return the encodedSeries
	 */
	public String getEncodedSeries() {
		return encodedSeries;
	}

	/**
	 * @param encodedSeries
	 *            the encodedSeries to set
	 */
	public void setEncodedSeries(String encodedSeries) {
		this.encodedSeries = encodedSeries;
	}

	

	/**
	 * @return the startNumber
	 */
	public String getStartNumber() {
		return startNumber;
	}

	/**
	 * @param startNumber the startNumber to set
	 */
	public void setStartNumber(String startNumber) {
		this.startNumber = startNumber;
	}

	/**
	 * @return the varValues
	 */
	public String getVarValues() {
		return varValues;
	}

	/**
	 * @param varValues
	 *            the varValues to set
	 */
	public void setVarValues(String varValues) {
		this.varValues = varValues;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the increment
	 */
	public int getIncrement() {
		return increment;
	}

	/**
	 * @param increment
	 *            the increment to set
	 */
	public void setIncrement(int increment) {
		this.increment = increment;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/**
	 * @return the series
	 */
	public Set<Series> getSeries() {
		return series;
	}

	/**
	 * @param series the series to set
	 */
	public void setSeries(Set<Series> series) {
		this.series = series;
	}

	
	
}
