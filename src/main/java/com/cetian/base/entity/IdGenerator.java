/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: IdGenerator.java 
 * @date 2018年3月21日 上午10:11:27 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.entity;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

/**
 * @ClassName:  IdGenerator   
 * @Description:TODO
 * @date:  2018年3月21日 上午10:11:27
 * @author: zangrong
 * 
 */
public class IdGenerator implements Configurable,IdentifierGenerator {  
  
    public String dataCenterID;  
    public String idLength;  
  
	/* (non-Javadoc)
	 * @see org.hibernate.id.IdentifierGenerator#generate(org.hibernate.engine.spi.SharedSessionContractImplementor, java.lang.Object)
	 */
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
		return null;
	}


	/* (non-Javadoc)
	 * @see org.hibernate.id.Configurable#configure(org.hibernate.type.Type, java.util.Properties, org.hibernate.service.ServiceRegistry)
	 */
	@Override
	public void configure(Type type, Properties params, ServiceRegistry registry) throws MappingException {
		
	} 

}
