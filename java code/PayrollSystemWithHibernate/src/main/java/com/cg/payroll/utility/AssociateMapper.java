package com.cg.payroll.utility;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import com.cg.payroll.beans.Associate;
public class AssociateMapper implements RowMapper<Associate>{

	public Associate mapRow(ResultSet rs, int rowNum) throws SQLException {
		Associate associate=new Associate();
		associate.setAssociateID(rs.getInt(1));
			return associate;
	}
	
}
