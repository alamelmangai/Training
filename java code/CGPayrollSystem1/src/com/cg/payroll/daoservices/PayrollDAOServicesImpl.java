package com.cg.payroll.daoservices;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.cg.payroll.beans.Associate;

public class PayrollDAOServicesImpl implements PayrollDAOServices{
	public static HashMap<Integer,Associate> associates = new HashMap<>();
//private static int ASSOCIATE_ID_COUNTER=111;
public static int ASSOCIATE_ID_COUNTER=111;
	@Override
	public int insertAssociate(Associate associate) {
		associate.setAssociateID(ASSOCIATE_ID_COUNTER++);
		associates.put(associate.getAssociateID(),associate);
		return associate.getAssociateID();
	}

	@Override
	public boolean updateAssociate(Associate associate) {
		if(associates.containsKey(associate.getAssociateID())==true){
		associates.put(associate.getAssociateID(),associate);
		associate.setAssociateID(associate.getAssociateID());
		return true;
		}
		return false;
	}

	@Override
	public boolean deleteAssociate(int associateId) {
		associates.remove(associateId);
		return true;
	}

	@Override
	public Associate getAssociate(int associateId) {
		return associates.get(associateId);
	}

	@Override
	public List<Associate> getAssociate() {
		List<Associate>associateList=new ArrayList<Associate>(associates.values());
		return associateList;
	}

}
