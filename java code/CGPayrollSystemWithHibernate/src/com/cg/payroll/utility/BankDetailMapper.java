package com.cg.payroll.utility;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.cg.payroll.beans.Associate;
public class BankDetailMapper implements RowMapper<Associate>{
	@Override
	public Associate mapRow(ResultSet arg0, int arg1) throws SQLException {
	
		return null;
	}

}
