package com.linkedin.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.linkedin.CatalogItem;
import com.linkedin.CatalogLocal;

@RequestScoped
@Named
public class CatalogItemFormBean implements Serializable {

	@Inject
	private CatalogLocal catalogBean;
	
	@Inject
	private InventoryService inventoryService;
	
	private CatalogItem item = new CatalogItem();

	private List<CatalogItem> items = new ArrayList<>();
	
	private String searchText;
	
	public void searchByName() {
		this.items = this.catalogBean.searchByName(this.searchText);
	}

	public String addItem() {
		
		//long itemId = this.catalogBean.getItems().size() + 1; ne treba zbog toga sto ce baza sama odredivati Id

		this.catalogBean.addItem(new CatalogItem(this.item.getName(), this.item.getManufacturer(),
				this.item.getDescription(), this.item.getAvailableDate()));
		
		this.inventoryService.createItem(this.item.getItemId(), this.item.getName() );
		
		return "list?faces-redirect=true";
	}
	
	// ?? 
	public void init() {
		this.items = this.catalogBean.getItems();
	}

	public CatalogLocal getCatalogBean() {
		return catalogBean;
	}

	public void setCatalogBean(CatalogLocal catalogBean) {
		this.catalogBean = catalogBean;
	}

	public InventoryService getInventoryService() {
		return inventoryService;
	}

	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public CatalogItem getItem() {
		return item;
	}

	public void setItem(CatalogItem item) {
		this.item = item;
	}

	public List<CatalogItem> getItems() {
		return items;
	}

	public void setItems(List<CatalogItem> items) {
		this.items = items;
	}
}