package com.cg.payroll.daoservices;
import java.util.Arrays;
import com.cg.payroll.beans.Associate;
public class PayrollDAOServicesImpl implements PayrollDAOServices {
	private static Associate[] associateList = new Associate[10];
	private static int ASSOCIATE_ID_COUNTER=111;
	private static int ASSOCIATE_IDX_COUNTER=0;
	@Override
	public int insertAssociate(Associate associate){
		if(ASSOCIATE_IDX_COUNTER>70*associateList.length/100){
			Associate[]tempList;
			tempList=Arrays.copyOf(associateList, 10+associateList.length);
			associateList=tempList;
		}
		associate.setAssociateID(ASSOCIATE_ID_COUNTER++);
		associateList[ASSOCIATE_IDX_COUNTER++]=associate;
		return associate.getAssociateID();
	}

	@Override
	public boolean updateAssociate(Associate associate){
		for(int i=0;i<associateList.length;i++)
			if(associateList[i]!=null && associateList[i].getAssociateID()==associate.getAssociateID()){
				associateList[i]=associate;
				return true;
			}
		return false;
	}

	@Override
	public boolean deleteAssociate(int associateId){
		for(int i=0;i<associateList.length;i++)
			if(associateList[i]!=null && associateId==associateList[i].getAssociateID()){
				associateList[i]=null;
				//for(int j=0;j<associateList.length&&(j+1)!=associateList.length;j++){
				for(int j=i;j<associateList.length-1;j++){
					associateList[j]=associateList[j+1];
					associateList[j+1]=null;
				}
				ASSOCIATE_ID_COUNTER--;
				System.out.println(ASSOCIATE_ID_COUNTER);
				return true;
			}
		return false;
	}

	@Override
	public Associate getAssociate(int associateId){
		for(Associate associate :associateList)
			if(associate!=null && associateId==associate.getAssociateID()){
				return associate;
			}
		return null;
	}

	@Override
	public Associate[] getAssociate(){
		return associateList;
	}
}

