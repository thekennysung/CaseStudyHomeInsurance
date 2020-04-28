/**
 * This DAO class is used to for Homeowner Information
 *
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Homeowner;
import com.cts.insurance.homequote.util.HomeInsuranceConstants;
import com.cts.insurance.homequote.util.SqlQueries;

public class HomeownerDAO {
	
	private final static Logger LOG = Logger.getLogger(HomeownerDAO.class);

	/**
	 * @param homeowner
	 * @throws SQLException 
	 * 
	 */
	public void saveHomeowner(final Homeowner homeowner) throws HomequoteSystemException, SQLException
	{
		LOG.info("HomeownerDAO.saveHomeowner - starts");
		Connection conn = null;
		//Fill code here
		final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.MYSQL);
		
		try {
			PreparedStatement stmt = null;
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(SqlQueries.SAVE_HOMEOWNER);			
			
			
			stmt.setInt(1, homeowner.getQuoteId()); 
			stmt.setString(2, homeowner.getFirstName()); 
			stmt.setString(3, homeowner.getLastName()); 
			stmt.setString(4, homeowner.getDob()); 
			stmt.setString(5, homeowner.getIsRetired()); 
			stmt.setString(6, homeowner.getSsn()); 
			stmt.setString(7, homeowner.getEmailAddress()); 
			
			stmt.executeUpdate();
			
		}catch (ClassNotFoundException | IOException | SQLException e) {
			throw new HomequoteSystemException (e.getMessage());
	
		}finally{
			conn.close();
		}
	}
	

	/**
	 * @param homeowner
	 * 
	 */
	public Homeowner getHomeowner(final int quoteId) throws HomequoteSystemException
	{
		LOG.info("HomeownerDAO.getHomeowner - starts");
		Connection conn = null;
		Homeowner homeowner = new Homeowner();
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		//Fill code here
		final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.MYSQL);
		
		try {
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(SqlQueries.GET_HOMEOWNER);
	
			stmt.setInt(1, quoteId);
			resultSet= stmt.executeQuery();
			
			while (resultSet.next()){
				homeowner.setQuoteId(resultSet.getInt("QUOTE_ID"));
				homeowner.setFirstName(resultSet.getString("FIRST_NAME"));
				homeowner.setLastName(resultSet.getString("LAST_NAME"));
				homeowner.setDob(resultSet.getString("DOB"));
				homeowner.setIsRetired (resultSet.getString("IS_RETIRED"));
				homeowner.setSsn(resultSet.getString("SSN"));
				homeowner.setEmailAddress(resultSet.getString("EMAIL_ADDRESS"));
			}
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
		}
		
		return homeowner; //return Object
	}

}
