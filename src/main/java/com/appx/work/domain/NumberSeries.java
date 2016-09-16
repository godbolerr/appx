package com.appx.work.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
@Table(name = "APPX_NUMSERIES")
public class NumberSeries extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 96285180113476324L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NUM_SEQUENCE")
	@SequenceGenerator(name = "NUM_SEQUENCE", sequenceName = "NUM_SEQUENCE", initialValue = 1, allocationSize = 1)
	@Basic(optional = false)

	private Long id;

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

	@Size(max = 250)
	@Column(name = "Rule", length = 250)
	private String rule;

	/**
	 * First Number in the series
	 */
	int start;

	/**
	 * Step to be incremented with
	 */
	int step;

	/**
	 * How much to increment.
	 */
	int increment;

	/**
	 * Total number in the series.
	 */
	int total;

	/**
	 * Generated series
	 */
	String series;

	/**
	 * Difficulty
	 */
	int level;

	/**
	 * @return the rule
	 */
	public String getRule() {
		return rule;
	}

	/**
	 * @param rule
	 *            the rule to set
	 */
	public void setRule(String rule) {
		this.rule = rule;
	}

	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @return the step
	 */
	public int getStep() {
		return step;
	}

	/**
	 * @param step
	 *            the step to set
	 */
	public void setStep(int step) {
		this.step = step;
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

	/**
	 * @return the totalCount
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param totalCount
	 *            the totalCount to set
	 */
	public void setTotal(int totalCount) {
		this.total = totalCount;
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
	public List<Integer> getSeriesData() {
		
		List<Integer> list = new ArrayList<Integer>();

		if (series != null && series.contains(",")) {
			String[] sList = series.split(",");
			for (int i = 0; i < sList.length; i++) {
				list.add(Integer.parseInt(sList[i]));
			}
		}

		return list;

	}

**/
}
