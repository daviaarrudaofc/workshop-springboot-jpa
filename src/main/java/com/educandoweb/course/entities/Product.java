package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id // como ela é auto incrementada no database tem que ter o generateVaule
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	
	@ManyToMany //mapeamento para as duas coleções que se relacionam,para trasnformar na tab de associação do modelo relacional
	@JoinTable(//diz qual é a tabela intermediária usada para relacionar as duas entidades.
			
		    name = "tb_product_category", // nome da tabela intermediária que relaciona Product e Category
		    
		    joinColumns = @JoinColumn(name = "product_id"), // chave estrangeira que referencia Product
		    
		    inverseJoinColumns = @JoinColumn(name = "category_id") // chave estrangeira que referencia Category
		)
	private Set<Category> categories = new HashSet<>();			//representa um conjunto o SET,para garantir que o mesmo produto n possua com mais de uma ocorrencia da categoria
												// e para garantir q a coleção n começa nula, e sim instanciada
	public Product() {
		
	}
	public Product(Long id, String name, String description, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
