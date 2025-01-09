package com.hibernate.criteria.HIbernate_Criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.mysql.cj.x.protobuf.MysqlxCrud.Projection;

public class App 
{
	public static void main( String[] args )
	{
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		//Criteria(I)

		//1.fetch operation
		Criteria criteria = session.createCriteria(Product.class); //Deprecated 
		List<Product> products = criteria.list();
		for(Product product: products) {
			System.out.println(product);
		}

		
		//2.fetch operation for particular data using Restictions
		Criteria criteria1 = session.createCriteria(Product.class); 
		
		//criteria1.add(Restrictions.eq("productId",1));
		//criteria1.add(Restrictions.gt("productId",3));
		//criteria1.add(Restrictions.lt("productId",3));
		//criteria1.add(Restrictions.between("productId", 2, 3));
		//criteria1.add(Restrictions.like("productName", "watch"));
		
		List<Product> products1 = criteria1.list();
		for(Product product: products1) {
			System.out.println(product);
		}

		//3.fetch operation for particular data using Projection 
		Criteria criteria2 = session.createCriteria(Product.class);
		
		criteria2.setProjection(Projections.property("productName"));

		List<String> products2 = criteria2.list();
		System.out.println("Fetching productNames");
		for(String product: products2) {
			System.out.println(product);
		}
		
		criteria2.setProjection(Projections.property("productPrice"));

		List<Integer> products3 = criteria2.list();
		System.out.println("Fetching productPrice");
		for(Integer product: products3) {
			System.out.println(product);
		}
		

		

		tran.commit();
		session.close();
		sf.close();


	}
}
