package ua.controller.user;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.File;
import java.io.IOException;
import java.security.Principal;

import javax.inject.Inject;
import javax.validation.Valid;

import ua.entity.Category;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ua.dto.filter.BasicFilter;
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
import ua.entity.Country;
import ua.entity.MeasureString;
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
import ua.service.TypeProductService;
import ua.service.UserService;
import ua.service.ShopingCartService;
import ua.validator.ProductValidator;

@Controller
@RequestMapping("/user/product")
@SessionAttributes(names="userProduct")
public class ProductUserController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ModelService modelService;
	
	@Autowired
	private MeasureService measureService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ShopingCartService shopingCartService;
	
	@Autowired
	private ProducerService producerService;

	@Autowired
	private TypeProductService typeProductService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private CategoryService categoryService;
	



	@InitBinder("product")
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(ua.entity.Model.class, new ModelEditor(modelService));
		binder.registerCustomEditor(MeasureString.class, new MeasureEditor(measureService));
		binder.registerCustomEditor(User.class, new UserEditor(userService));
		binder.registerCustomEditor(ShopingCart.class, new ShopingCartEditor(shopingCartService));
		binder.registerCustomEditor(Producer.class, new ProducerEditor(producerService));
		binder.registerCustomEditor(TypeProduct.class, new TypeProductEditor(typeProductService));
		binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.setValidator(new ProductValidator(productService));
//		binder.setValidator(new ProductValidator());
	}
	
	@ModelAttribute("product")
	public ProductForm getForm(){
		return new ProductForm();
	}
	
	@ModelAttribute("filter")
	public ProductFilter getFilter(){
		return new ProductFilter();
	}
	

	@RequestMapping
//	public String show(Model model, @PageableDefault Pageable pageable){
	public String show(SessionStatus status, Model model, @ModelAttribute("filter") ProductFilter filter, @PageableDefault Pageable pageable){	

		model.addAttribute("page", productService.findAll( filter, pageable));
		model.addAttribute("models", modelService.findAll());
		model.addAttribute("measures", measureService.findAll());
		model.addAttribute("listProducts", productService.findAll());
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("typeProducts", typeProductService.findAll());
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("shopingCarts", shopingCartService.findAll());

		status.setComplete();
		return "user-product";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @ModelAttribute("filter") ProductFilter filter, @PageableDefault Pageable pageable){
//	public String delete(@PathVariable int id,  @PageableDefault Pageable pageable){	
		productService.delete(id);
		return "redirect:/user/product"+getParams(filter, pageable);
//		return "redirect:/user/product"+getParams(pageable);
//		return "redirect:/user/product";
	}
	


	@RequestMapping("/add/{id}")
	public String add(@PathVariable int id, @ModelAttribute("filter") ProductFilter filter, @PageableDefault Pageable pageable){
//	public String delete(@PathVariable int id,  @PageableDefault Pageable pageable){	
		productService.addToOrder(id);
		return "redirect:/user/product"+getParams(filter, pageable);

	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getProduct(SessionStatus status, @PathVariable("id") int id, Model model) {
	    model.addAttribute("product", productService.findOne(id));
	    model.addAttribute("models", modelService.findAll());
		model.addAttribute("measures", measureService.findAll());
		model.addAttribute("listProducts", productService.findAll());
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("typeProducts", typeProductService.findAll());
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("shopingCarts", shopingCartService.findAll());
//	    model.addAttribute("product", productService.findById(id));
	    status.setComplete();
	    return "user-productUnit";
	}
	
	
	@GetMapping("/buyPR/{productId}") //PRINCIPAL method
	public String buyPR(Principal principal , @PathVariable int productId){

		String username = principal.getName();
		int userId = userService.findOne(username).getId().intValue();
		userService.addToShopingCart(userId, productId);
		return "redirect:/user/product";
	}
	
	
	
	
	@GetMapping("/buyNA/{productId}")
	public String buyNA(@CookieValue(defaultValue="0", name="userId") int userId, @PathVariable int productId){
		
		userService.addToShopingCart(userId, productId);
		int cartId = shopingCartService.findOneCartByUserId(userId).getId().intValue();
		return "redirect:/user/shopingCart/"+cartId;
	}
	

	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("product") @Valid ProductForm productForm, BindingResult br, Model model, SessionStatus sessionStatus, @ModelAttribute("filter") ProductFilter filter, @PageableDefault Pageable pageable){
		if(br.hasErrors()){
			model.addAttribute("page", productService.findAll( filter, pageable));
			model.addAttribute("models", modelService.findAll());
			model.addAttribute("measures", measureService.findAll());
			model.addAttribute("producers", producerService.findAll());
			model.addAttribute("typeProducts", typeProductService.findAll());
			model.addAttribute("countries", countryService.findAll());
			model.addAttribute("categories", categoryService.findAll());
			model.addAttribute("shopingCarts", shopingCartService.findAll());
			return "user-product";
		}
		productService.save(productForm);
		sessionStatus.setComplete();
//		return "redirect:/user/product";
//		return "redirect:/user/product"+getParams(pageable);
		return "redirect:/user/product"+getParams(filter, pageable);
	}



/*	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @ModelAttribute("filter") ProductFilter filter, @PageableDefault Pageable pageable){
//		model.addAttribute("products", productService.findAll());
		model.addAttribute("product", productService.findOne(id));
		model.addAttribute("page", productService.findAll( filter, pageable));
		model.addAttribute("models", modelService.findAll());
		model.addAttribute("measures", measureService.findAll());
		return "user-product";
	}*/
	
	private String getParams(ProductFilter filter, Pageable pageable ){
		StringBuilder buffer = new StringBuilder();
		buffer.append("?page=");
		buffer.append(String.valueOf(pageable.getPageNumber()+1));
		buffer.append("&size=");
		buffer.append(String.valueOf(pageable.getPageSize()));
		if(pageable.getSort()!=null){
			buffer.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order)->{
				buffer.append(order.getProperty());
				if(order.getDirection()!=Direction.ASC)
				buffer.append(",desc");
			});
		}
		if(!filter.getSearch().isEmpty()){
			buffer.append("&search=");
			buffer.append(filter.getSearch());
		}
	
		if(!filter.getMaxPrice().isEmpty()){
			buffer.append("&maxPrice=");
			buffer.append(filter.getMaxPrice());
		}
		if(!filter.getMinPrice().isEmpty()){
			buffer.append("&minPrice=");
			buffer.append(filter.getMinPrice());
		}
		for(Integer id : filter.getModelIds()){
			buffer.append("&modelIds=");
			buffer.append(id);
		}
		if(!filter.getDescription().isEmpty()){
			buffer.append("&description=");
			buffer.append(filter.getDescription());
		}
		for(Integer id : filter.getMeasureIds()){
			buffer.append("&measureIds=");
			buffer.append(id);
		}
		
		for(Integer id : filter.getTypeProductIds()){
			buffer.append("&typeProductIds=");
			buffer.append(id);
		}
		for(Integer id : filter.getCategoryIds()){
			buffer.append("&categoryIds=");
			buffer.append(id);
		}
		
		for(Integer id : filter.getCountryIds()){
			buffer.append("&countryIds=");
			buffer.append(id);
		}
		for(Integer id : filter.getProducerIds()){
			buffer.append("&producerIds=");
			buffer.append(id);
		}
		

		return buffer.toString();
	}
	


	
}
