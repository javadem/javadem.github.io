package ua.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.dto.filter.ProductFilter;
import ua.dto.form.ProductForm;
import ua.editor.CategoryEditor;
import ua.editor.CountryEditor;
import ua.editor.MeasureEditor;
import ua.editor.ModelEditor;
import ua.editor.ProducerEditor;
import ua.editor.ShopingCartEditor;
import ua.editor.TypeProductEditor;
import ua.editor.UserEditor;
import ua.entity.Category;
import ua.entity.Country;
import ua.entity.Measure;
import ua.entity.Payment;
import ua.entity.Producer;
import ua.entity.ShopingCart;
import ua.entity.TypeProduct;
import ua.entity.User;
import ua.service.CategoryService;
import ua.service.CountryService;
import ua.service.MeasureService;
import ua.service.ModelService;
import ua.service.ProducerService;
import ua.service.ProductService;
import ua.service.ShopingCartService;
import ua.service.TypeProductService;
import ua.service.UserService;
import ua.validator.ProductValidator;


@Entity
@Table(name="payment"/*, indexes=@Index(columnList = "_name")*/)
public class Payment extends AbstractClass {

	
	@Column(name="_email")
	private String email;
	
	@Column(name="_amount")
	private String amount ;
	
	@Column(name="_text", length = 10000)
	private String text;
	
	@OneToOne
	@JoinColumn(name = "shopingCart_id")
	private ShopingCart shopingCart ;
	
/*	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_shopingCart")
	private ShopingCart shopingCart ;*/
	

	public Payment() {
		
	}

	public Payment(String email, String amount, String text) {
		super();
		this.email = email;
		this.amount = amount;
		this.text = text;
	}

	
	
	public Payment(String email, String amount, String text,
			ShopingCart shopingCart) {
		super();
		this.email = email;
		this.amount = amount;
		this.text = text;
		this.shopingCart = shopingCart;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String string) {
		this.amount = string;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ShopingCart getShopingCart() {
		return shopingCart;
	}

	public void setShopingCart(ShopingCart shopingCart) {
		this.shopingCart = shopingCart;
	}

	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	
}
