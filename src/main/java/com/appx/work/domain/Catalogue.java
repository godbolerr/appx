package com.appx.work.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Objects;

@Entity
@Table(name = "APPX_CATALOGUE")
public class Catalogue extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 96285180113476324L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAT_SEQUENCE")
	@SequenceGenerator(name = "CAT_SEQUENCE", sequenceName = "CAT_SEQUENCE", initialValue = 1, allocationSize = 1)
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

	/*
	 * @NotNull(message = "{error.catalogue.name.null}")
	 * 
	 * @NotEmpty(message = "{error.catalogue.name.empty}")
	 */
	@Size(max = 100, message = "{error.catalogue.name.max}")
	@Column(name = "NAME", length = 100)
	private String name;

	@NotNull(message = "{error.catalogue.catalogueName.null}")
	@NotEmpty(message = "{error.catalogue.catalogueName.empty}")
	@Size(max = 100, message = "{error.catalogue.catalogueName.max}")
	@Column(name = "CATALOGUENAME", length = 100)
	private String catalogueName;

	/**
	 * @return the catalogueName
	 */
	public String getCatalogueName() {
		return catalogueName;
	}

	/**
	 * @param catalogueName
	 *            the catalogueName to set
	 */
	public void setCatalogueName(String catalogueName) {
		this.catalogueName = catalogueName;
	}

	@Size(max = 250, message = "{error.catalogue.desc.max}")
	@Column(name = "DESCRIPTION", length = 250)
	private String description;

	@NotNull(message = "{error.catalogue.status.null}")
	@NotEmpty(message = "{error.catalogue.status.empty}")
	@Size(max = 20, message = "{error.catalogue.status.max}")
	@Column(name = "STATUS", length = 20)
	private String status;

	@Column(name = "ENVID", length = 10)
	private Long environmentId;

	@Column(name = "T24_APPLICATION_VERSION", length = 100)
	private String t24applicationVersion;

	public Catalogue() {
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return String.format("%s(id=%d, name='%s', description=%s, status=%s)", this.getClass().getSimpleName(),
				this.getId(), this.getCatalogueName(), this.getDescription(), this.getStatus());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;

		if (o instanceof Catalogue) {
			final Catalogue other = (Catalogue) o;
			return Objects.equal(getId(), other.getId()) && Objects.equal(getDescription(), other.getDescription())
					&& Objects.equal(getCatalogueName(), other.getCatalogueName())
					&& Objects.equal(getStatus(), other.getStatus());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId(), getDescription(), getCatalogueName(), getStatus());
	}

	/**
	 * @return the t24applicationVersion
	 */
	public String getT24applicationVersion() {
		return t24applicationVersion;
	}

	/**
	 * @param t24applicationVersion
	 *            the t24applicationVersion to set
	 */
	public void setT24applicationVersion(String t24applicationVersion) {
		this.t24applicationVersion = t24applicationVersion;
	}

}
