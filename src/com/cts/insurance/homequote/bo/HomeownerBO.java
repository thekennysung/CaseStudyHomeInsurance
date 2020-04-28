/**
 * This Business Object class is used to for Homeowner Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;

import java.sql.SQLException;

import com.cts.insurance.homequote.dao.HomeownerDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Homeowner;

public class HomeownerBO {

	/**
	 * @param quoteId
	 * @param lastName
	 * @param dob
	 * @param emailAddress
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public Homeowner getHomeownerInfo(final int quoteId) throws HomequoteBusinessException{

		final HomeownerDAO HomeownerDAO = new HomeownerDAO();
       //Fill code here
		Homeowner h1 = new Homeowner();
		try {
			h1 = HomeownerDAO.getHomeowner(quoteId);
			
		}catch (HomequoteSystemException e){
			throw new HomequoteBusinessException(e.getMessage());
		
		}
		
		return h1; //return Object
	}
	/**
	 * @param homeowner
	 * @throws HomequoteBusinessException
	 * @throws SQLException
	 */
	public void saveHomeownerInfo(final Homeowner homeowner) throws HomequoteBusinessException, SQLException{

		final HomeownerDAO HomeownerDAO = new HomeownerDAO();
        //Fill code here
		try{
			HomeownerDAO.saveHomeowner(homeowner);	
			
		}catch (HomequoteSystemException e) {
				e.printStackTrace();
		
		}
		
	}
}
