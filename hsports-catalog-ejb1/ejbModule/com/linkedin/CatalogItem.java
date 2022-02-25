
package com.linkedin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CATALOG_ITEM")
public class CatalogItem {

	@Id
	@Column(name = "CATALOG_ITEM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;

	@Size(min = 0, max = 3)
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(joinColumns = @JoinColumn(name="CATALOG_ITEM_ID")
		, inverseJoinColumns = @JoinColumn(name="ITEM_MANAGER_ID"))
	private List<ItemManager> itemManagers = new ArrayList<>();

	@NotBlank
	@Column(name = "NAME")
	private String name;

	@Pattern(regexp = "^[A-Za-z]*$", message = "Must be letters")
	@Column(name = "MANUFACTURER")
	private String manufacturer;

	@Pattern(regexp = "^[A-Za-z]{5,10}$", message = "Must be letters")
	@Column(name = "DESCRIPTION")
	private String description;

	@Future
	@Column(name = "AVAILABLE_DATE")
	private LocalDate availableDate;

	public CatalogItem() {

	}

	public CatalogItem(String name, String manufacturer, String description, LocalDate availableDate) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.description = description;
		this.availableDate = availableDate;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(LocalDate availableDate) {
		this.availableDate = availableDate;
	}

	public List<ItemManager> getItemManagers() {
		return itemManagers;
	}

	public void setItemManagers(List<ItemManager> itemManagers) {
		this.itemManagers = itemManagers;
	}

	@Override
	public String toString() {
		return "CatalogItem [itemId=" + itemId + ", name=" + name + ", manufacturer=" + manufacturer + ", description="
				+ description + ", availableDate=" + availableDate + "]";
	}

}

/*package com.linkedin;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="CATALOG_ITEM")
public class CatalogItem {

	@Id
	@Column(name="CATALOG_NAME_ID")
	@GeneratedValue(strategy=GenerationType.AUTO) // nije mi bas najjasnije
	private Long itemId;
	
	@Column(name="NAME")
	private String name;

	@Column(name="MANUFACTURER")
	private String manufacturer;

	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="AVAILABLE_DATE")
	private LocalDate availableDate;

	public CatalogItem() {
		
	}
	
	public CatalogItem(Long itemId, String name, String manufacturer, String description, LocalDate availableDate) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.manufacturer = manufacturer;
		this.description = description;
		this.availableDate = availableDate;
	}
	
	// Ne treba nam itemId jer necemo vise sami povecavati velicinu, nego ce baza sama određivati ID
	public CatalogItem(String name, String manufacturer, String description, LocalDate availableDate) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.description = description;
		this.availableDate = availableDate;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(LocalDate availableDate) {
		this.availableDate = availableDate;
	}

	@Override
	public String toString() {
		return "CatalogItem [itemId=" + itemId + ", name=" + name + ", manufacturer=" + manufacturer + ", description="
				+ description + ", availableDate=" + availableDate + "]";
	}

}*/