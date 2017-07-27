package net.Sibsankar.OnlineShopingBackend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String descipation;
	@Column(name = "imege_url")
	private String imegeUrl;
	@Column(name = "is_active")
	private boolean active = true;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescipation() {
		return descipation;
	}

	public void setDescipation(String descipation) {
		this.descipation = descipation;
	}

	public String getImegeUrl() {
		return imegeUrl;
	}

	public void setImegeUrl(String imegeUrl) {
		this.imegeUrl = imegeUrl;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", descipation=" + descipation + ", imegeUrl=" + imegeUrl
				+ ", active=" + active + "]";
	}
  
}
