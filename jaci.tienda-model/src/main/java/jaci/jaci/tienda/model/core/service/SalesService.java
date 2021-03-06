package jaci.jaci.tienda.model.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import jaci.jaci.tienda.api.core.service.ISalesService;
import jaci.jaci.tienda.model.core.dao.SalesDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;


@Service("SalesService")
@Lazy

public class SalesService implements ISalesService {
	
	 @Autowired private SalesDao salesDao;
	 @Autowired private DefaultOntimizeDaoHelper daoHelper;
	 
	 @Override
	 public EntityResult salesQuery(Map<String, Object> keyMap, List<String> attrList)
	   throws OntimizeJEERuntimeException {
	  return this.daoHelper.query(this.salesDao, keyMap, attrList);
	 }

	 @Override
	 public EntityResult salesInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
	  return this.daoHelper.insert(this.salesDao, attrMap);
	 }

	 @Override
	 public EntityResult salesUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
	   throws OntimizeJEERuntimeException {
	  return this.daoHelper.update(this.salesDao, attrMap, keyMap);
	 }

	 @Override
	 public EntityResult salesDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
	  return this.daoHelper.delete(this.salesDao, keyMap);
	 }

	 public EntityResult saleChartQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException {
	 	return this.daoHelper.query(this.salesDao, keyMap, attrList, SalesDao.QUERY_CHART);
	 }

	public EntityResult incomeChartQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.salesDao, keyMap, attrList, SalesDao.QUERY_AMOUNT_CHART);
	}

	public EntityResult productChartQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.salesDao, keyMap, attrList, SalesDao.QUERY_PRODUCT);
	}
	// --------- CLIENTS QUERRY IN SALES -----------
	@Override
	public EntityResult vSalesClientsQuery(Map<String, Object> keysValues, List<String> attributes)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.salesDao, keysValues, attributes, SalesDao.QUERY_VSALESCLIENTS);
	}

	@Override
	public EntityResult vSalesClientsDelete(Map<String, Object> keyValues) throws OntimizeJEERuntimeException {
		  return this.daoHelper.delete(this.salesDao, keyValues);
	}

	@Override
	public EntityResult vSalesProductQuery(Map<String, Object> keysValues, List<String> attributes)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.salesDao, keysValues, attributes, SalesDao.QUERY_VSALESPRODUCT);
	}

	@Override
	public EntityResult vSalesProductDelete(Map<String, Object> keyValues) throws OntimizeJEERuntimeException {
		 return this.daoHelper.delete(this.salesDao, keyValues);

	}
	
	//------------ CHECK SALES FROM CLIENTS --------------------

	@Override
	public EntityResult vClientSalesQuery(Map<String, Object> keysValues, List<String> attributes)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.salesDao, keysValues, attributes, SalesDao.QUERY_VCLIENTSALES);
	}

	@Override
	public EntityResult vClientSalesDelete(Map<String, Object> keyValues) throws OntimizeJEERuntimeException {
		  return this.daoHelper.delete(this.salesDao, keyValues);
	}

	// ------------- COMPLEX ---------------------
	@Override
	public EntityResult vSalesComplexQuery(Map<String, Object> keysValues, List<String> attributes)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.salesDao, keysValues, attributes, SalesDao.QUERY_SALESCOMPLEX);
	}

	@Override
	public EntityResult vSalesComplexDelete(Map<String, Object> keyValues) throws OntimizeJEERuntimeException {
		 return this.daoHelper.delete(this.salesDao, keyValues);
	}

	@Override
	public EntityResult vSalesComplexUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(this.salesDao, attrMap, keyMap);
	}

	@Override
	public EntityResult vSalesComplexInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		 return this.daoHelper.insert(this.salesDao, attrMap);
	}

}
