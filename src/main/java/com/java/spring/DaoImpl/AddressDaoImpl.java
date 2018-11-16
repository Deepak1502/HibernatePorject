package com.java.spring.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.entity.UserAddress;
import com.java.spring.dao.AddressDao;

@ComponentScan(basePackages = "com.java.spring.configuration")
@ComponentScan(basePackages = "com.java.spring.dao")
@Repository
public class AddressDaoImpl implements AddressDao{

	@Autowired
    private SessionFactory sessionFactory;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void addAddress(UserAddress userAddress) {
		/*Session session = sessionFactory.getCurrentSession();
        session.save(userAddress);*/
        hibernateTemplate.saveOrUpdate(userAddress);
		
	}

	@Override
	public List<UserAddress> getUserAddress() {
		// TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<UserAddress> list= session.createCriteria(UserAddress.class).list();
        return list;
	}

	@Override
	public UserAddress findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		UserAddress userAddress=(UserAddress) session.get(UserAddress.class,id);
        return userAddress;
	}

	@Override
	public UserAddress updateAddress(UserAddress userAddress, int id) {
		Session session = sessionFactory.getCurrentSession();
		UserAddress address=session.get(UserAddress.class, id);
		address.setAddressLine1(userAddress.getAddressLine1());
		address.setAddressLine2(userAddress.getAddressLine2());
		address.setCity(userAddress.getCity());
		address.setCountry(userAddress.getCountry());
		address.setState(userAddress.getState());
		address.setZipcode(userAddress.getZipcode());
		return address;
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		UserAddress address=session.get(UserAddress.class, id);
		session.delete(address);
	}

}
