package cn.lzh.a_hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itheima.domain.Customer;
import cn.itheima.utils.HibernateUtils;

/**
 * hql语法
 * 
 *
 */
public class Demo {
	
	//基本语法
	@Test
	public void fun1(){
		Session session=HibernateUtils.openSession();
		Transaction tx=session.beginTransaction();
		//------------------------------
		String hql="from Customer";
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		System.out.println(list);
		
		
		//----------------------
		tx.commit();
		session.close();
		
	}
	//排序语法
		@Test
		public void fun2(){
			Session session=HibernateUtils.openSession();
			Transaction tx=session.beginTransaction();
			//------------------------------
			String hql="from Customer order by cust_id asc";
			String hq2="from Customer order by cust_id desc";
			Query query = session.createQuery(hq2);
			List<Customer> list = query.list();
			System.out.println(list);
			
			
			//----------------------
			tx.commit();
			session.close();
			
		}
		//条件查询
				@Test
				public void fun3(){
					Session session=HibernateUtils.openSession();
					Transaction tx=session.beginTransaction();
					//------------------------------
					String hql="from Customer where cust_id=?";
					String hq2="from Customer order by cust_id desc";
					Query query = session.createQuery(hql);
					 Query a = query.setParameter(0, 1l);
					 List<Customer> list = query.list();
						System.out.println(list);
					
					
					//----------------------
					tx.commit();
					session.close();
					
				}
				//fenye查询
				@Test
				public void fun4(){
					Session session=HibernateUtils.openSession();
					Transaction tx=session.beginTransaction();
					//------------------------------
					String hql="from Customer";
					String hq2="from Customer order by cust_id desc";
					Query query = session.createQuery(hql);
					query.setFirstResult(0);
					query.setMaxResults(3);
					 List<Customer> list = query.list();
						System.out.println(list);
					
					
					//----------------------
					tx.commit();
					session.close();
					
				}
				//tognji查询
				@Test
				public void fun5(){
					Session session=HibernateUtils.openSession();
					Transaction tx=session.beginTransaction();
					//------------------------------
					String hql="select count(*) from Customer";
					String hq2="select sum(cust_id) from Customer";
					String hq3="select avg(cust_id) from Customer";
					String hq4="select max(cust_id) from Customer";
					String hq5="select min(cust_id) from Customer";
					Query query = session.createQuery(hq2);
				    
					Number number = (Number) query.uniqueResult();
					 
					System.out.println(number);
					
					
					//----------------------
					tx.commit();
					session.close();
					
				}
				//投影查询
				@Test
				public void fun6(){
					Session session=HibernateUtils.openSession();
					Transaction tx=session.beginTransaction();
					//------------------------------
					String hql="select cust_name from Customer";
					Query query = session.createQuery(hql);
					 
					 List<Customer> list = query.list();
						System.out.println(list);
					
					
					//----------------------
					tx.commit();
					session.close();
					
				}

}
