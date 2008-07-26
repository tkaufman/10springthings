package org.cinjug.dbtesting;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class StupidDAO {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
	}

	public void insertRows(int numOfRows) {

		String sql = "INSERT INTO stupid_data (name, inserted_date) VALUES(:name, :ins_date)";

		for (int i = 0; i < numOfRows; i++) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("name", "blah"+i);
			params.put("ins_date", new Date());

			namedParameterJdbcTemplate.update(sql, params);
		}
	}
}
