package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;




import ua.dto.filter.ProducerFilter;
import ua.dto.form.PaymentForm;
import ua.entity.Payment;
import ua.entity.Producer;

public interface PaymentService {

	Payment findOne(int id);
	
	List<Payment> findAll();
	
	Payment save(int id);
	
	void delete(int id);
	
	Payment save(Payment payment) ;

	Payment findOnePaymentByCartId(int id);
	
	List<Payment> findAllPaymentsByCartId(int id);
}
