package com.appx.work.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

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
	String startNumbers;

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
	 * @return the startNumbers
	 */
	public String getStartNumbers() {
		return startNumbers;
	}

	/**
	 * @param startNumbers
	 *            the startNumbers to set
	 */
	public void setStartNumbers(String startNumbers) {
		this.startNumbers = startNumbers;
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

}
