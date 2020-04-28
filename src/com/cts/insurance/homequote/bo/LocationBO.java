/**
 * This Business Object class is used to for Location Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;

import java.util.ArrayList;
import java.util.List;

import com.cts.insurance.homequote.dao.LocationDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Location;

public class LocationBO {

	/**
	 * @param location
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public int saveHomeLocation(final Location location) throws HomequoteBusinessException{

		final LocationDAO locationDAO = new LocationDAO();
		//Fill code here
        int int3g3r ;
        
        try {
        int3g3r = locationDAO.saveLocation(location);        
        
        }catch(HomequoteSystemException e){
        	throw new HomequoteBusinessException(e.getMessage());          
        
        }
        
        return int3g3r; //return integer
	}
	
	/**
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public Location getHomeLocation(int quoteId) throws HomequoteBusinessException{

		final LocationDAO locationDAO = new LocationDAO();
		//Fill code here
		Location loc = new Location();
        
        try{
        loc = locationDAO.getLocation(quoteId);    
        
        }catch(HomequoteSystemException e){
        	throw new HomequoteBusinessException(e.getMessage());    
        
        }
        return loc; //return Object
	}
	
	/**
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public List<Location> getQuoteIds(String userName) throws HomequoteBusinessException{

		final LocationDAO locationDAO = new LocationDAO();
		//Fill code here
        List<Location>loclist= new ArrayList<Location>();
        
        try {
            loclist = locationDAO.getQuoteIds(userName);
        
        }catch (HomequoteSystemException e) {
            throw new HomequoteBusinessException("error man");
        }                       
        return loclist; //return    lst of Object
	}
	
}
