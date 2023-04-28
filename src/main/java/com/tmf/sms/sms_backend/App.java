package com.tmf.sms.sms_backend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tmf.sms.sms_backend.model.Concept;
import com.tmf.sms.sms_backend.services.CourseServices;
import com.tmf.sms.sms_backend.services.ServiceImplementation;


public class App 
{
    public static void main( String[] args )
    {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml"); 
        SessionFactory sf = config.buildSessionFactory();
		/*
		 * Session session = sf.openSession(); Concept concept = new Concept();
		 * concept.setConceptDescription("Explaining all OOPs concepts");
		 * concept.setConceptName("OOPs"); concept.setDuration(4.0);
		 * 
		 * Transaction tx = session.beginTransaction(); session.save(concept);
		 * tx.commit(); session.close();
		 * System.out.println("Data has been inserted successfully..");
		 */
    }
}
