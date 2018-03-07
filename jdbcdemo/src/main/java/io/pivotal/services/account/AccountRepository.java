package io.pivotal.services.account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class AccountRepository {

	private final JdbcTemplate jdbcTemplate;
	
	private final String SQL_FINDALL = "select * from account";
	private final String SQL_FIND_BY_ID = "select * from account where id=?";
	private final String SQL_FIND_BY_TYPE = "select * from account where type=?";
	private final String SQL_INSERT = "insert into account(id, type, status, balance) values (?,?,?,?)";
	private final String SQL_DELETE = "delete account where id=?";
	
    private final RowMapper<Account> rowMapper = (ResultSet rs, int row) -> {
    		Account account = new Account();
    		account.setId(rs.getLong("id"));
    		account.setType(rs.getString("type"));
    		account.setStatus(rs.getString("status"));
    		account.setBalance(rs.getBigDecimal("balance"));
        return account;
    };

	@Autowired
	public AccountRepository(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}
	
	List<Account> findAll() {
		return this.jdbcTemplate.query(SQL_FINDALL, rowMapper);
	}
	
	Account findOne(long id) {
		return this.jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[] {id}, rowMapper);
	}
	
	List<Account> findByType(String type) {
		return this.jdbcTemplate.query(SQL_FIND_BY_TYPE, new Object[] {type}, rowMapper);
	}
	
	Account save(Account account) {
		assert account.getType() != null;
		assert account.getStatus() != null;

		account.setId(java.lang.Math.abs(java.util.UUID.randomUUID().getLeastSignificantBits()));

        this.jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
            ps.setLong(1, account.getId().longValue());
            ps.setString(2, account.getType());
            ps.setString(3, account.getStatus());
            ps.setBigDecimal(4, account.getBalance());
            return ps;
        });
        
        return account;
	}
	
	void delete(long id) {
        this.jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE);
            ps.setLong(1, id);
            return ps;
        });
        
	}
	
	
}
