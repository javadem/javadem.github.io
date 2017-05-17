package ua.service.implementation;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import ua.entity.Product;
import ua.entity.ShopingCart;
import ua.repository.MeasureRepository;
import ua.repository.ModelRepository;
import ua.repository.ProductRepository;
import ua.repository.UserRepository;
import ua.service.FileWriter;
import ua.service.FileWriter.Folder;
import ua.service.ProductService;
import ua.service.specification.ProductSpecification;
import ua.dto.filter.ProductFilter;
import ua.dto.form.ProductForm;




@Service
public class ProductServiceImpl implements ProductService {
	

	@Autowired
	private ProductRepository  productRepository;
	
	@Autowired
	private ModelRepository  modelRepository;
	
	@Autowired
	private MeasureRepository  measureRepository;
	
	@Autowired
	private FileWriter fileWriter;
	
	@Autowired
	private UserRepository  userRepository;
	

	public ProductServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductServiceImpl(ProductRepository productRepository, ModelRepository modelRepository,
			MeasureRepository measureRepository, FileWriter fileWriter) {
		super();
		this.productRepository = productRepository;
		this.modelRepository = modelRepository;
		this.measureRepository = measureRepository;
		this.fileWriter = fileWriter;
	}


	public ProductRepository getProductRepository() {
		return productRepository;
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public ModelRepository getModelRepository() {
		return modelRepository;
	}

	public void setModelRepository(ModelRepository modelRepository) {
		this.modelRepository = modelRepository;
	}

	public MeasureRepository getMeasureRepository() {
		return measureRepository;
	}

	public void setMeasureRepository(MeasureRepository measureRepository) {
		this.measureRepository = measureRepository;
	}
	
	public FileWriter getFileWriter() {
		return fileWriter;
	}

	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	
	
	@Override
	public Product findOneProductById(int id) {
		// TODO Auto-generated method stub
		return productRepository.findOne(id);
	}

	

		// MUST RETURN ProductForm	
		@Override
		@Transactional(readOnly=true)
		public ProductForm findOne(int id) {
//			// TODO Auto-generated method stub
			ProductForm productForm = new ProductForm();
			Product product = productRepository.findOne(id);
			productForm.setId(product.getId());
			productForm.setNameProduct(product.getNameProduct());
			productForm.setModel(product.getModel());
			productForm.setDescription(product.getDescription());
			productForm.setPrice(product.getPrice().toString());
			productForm.setMeasure(product.getMeasure());
			productForm.setFile(product.getFile());
			return productForm;
		}
	
	@Override
//	@Transactional(readOnly=true)
	public List<Product> findAll() {
	
		return productRepository.findAll();
	}


	@Override
	public void delete(int id) {
		
		productRepository.delete(id);
	}

	@Override
	public Product findOne(String name) {
		return productRepository.findByName(name);
	}



	@Override
	@Transactional
	public void save(ProductForm productForm) {
				
//		Product product = productRepository.findOne(productForm.getId());
		Product product = new Product();
		product.setId(productForm.getId());
		product.setNameProduct(productForm.getNameProduct());
		product.setModel(productForm.getModel());
		product.setDescription(productForm.getDescription());
		product.setPrice(new BigDecimal(productForm.getPrice().replace(',', '.')));
		product.setMeasure(productForm.getMeasure());

		productRepository.saveAndFlush(product);
		
		if(fileWriter.write(Folder.ITEM, productForm.getFile(), product.getId())){
//			
			if(product.getVersion()==null)product.setVersion(0);
			else product.setVersion(product.getVersion()+1);
		}
//		productRepository.saveAndFlush(product);
//		productRepository.save(product);
		
	}
	
	
	
	

	@Override
	@Transactional
	public void update(int id) {
		// TODO Auto-generated method stub
		Product product = productRepository.findOne(id);
		ProductForm productForm = findOne(id);
//		product.setId(productForm.getId());
		product.setNameProduct(productForm.getNameProduct());
		product.setModel(productForm.getModel());
		product.setDescription(productForm.getDescription());
		product.setPrice(new BigDecimal(productForm.getPrice().replace(',', '.')));
		product.setMeasure(productForm.getMeasure());

		productRepository.saveAndFlush(product);
		
		if(fileWriter.write(Folder.ITEM, productForm.getFile(), product.getId())){
//			
			if(product.getVersion()==null)product.setVersion(0);
			else product.setVersion(product.getVersion()+1);
		}
	}

	


	@Override
	public Page<Product> findAll(ProductFilter filter, Pageable pageable) {
		Page<Product> products = productRepository.findAll(new ProductSpecification(filter), pageable);
		return products;
	}



	@Override
	@Transactional
	@RequestMapping("/add/{id}")
	public List<Product> addToOrder(int id) {
		List<Product> listProducts = new ArrayList<>();
		listProducts.add(getProductRepository().findOne(id));
	return listProducts;
	}

	
	@Override
	public int findCount(int id) {
		Integer count = productRepository.findCount(id);
		if(count==null)return 0;
		return count;
	}


	
	@Override
	public List<Product> findByUserId(int userId) {
		// TODO Auto-generated method stub
		return productRepository.findProductByUserId(userId);
	}

	@Override
	public List<Product> findProductsByCartId(int cartId) {
		// TODO Auto-generated method stub
		return productRepository.findProductByCartId(cartId);
	}



}
