package com.dew.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.dew.training.dao.EmailLogDAO;
import com.dew.training.dao.JDBCDaoSupport;
import com.dew.training.dto.EmailLog;

public class EmailLogDAOImpl extends JDBCDaoSupport implements EmailLogDAO{

	@Override
	public long addEmailLog(final EmailLog emailLog) {
		final String sql = "INSERT INTO email_log (from_address, to_address, cc_address, bcc_address, replyto_address, subject, body, sent, sent_on, created_on, created_by) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, now(), ?)";
		//logger.println(IMessage.DEBUG, "EmailLogDAOImpl.addEmailLog() sql: " + sql);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) {
				PreparedStatement pstmt = null;
				try {
					pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
					pstmt.setString(1, emailLog.getFromAddress());
					pstmt.setString(2, emailLog.getToAddress());
					pstmt.setString(3, emailLog.getCcAddress());
					pstmt.setString(4, emailLog.getBccAddress());
					pstmt.setString(5, emailLog.getReplyToAddress());
					pstmt.setString(6, emailLog.getSubject());
					pstmt.setString(7, emailLog.getBody());
					pstmt.setBoolean(8, emailLog.isSent());
					if (emailLog.getSentOn() != null) {
						pstmt.setTimestamp(9, new java.sql.Timestamp(emailLog.getSentOn().getTime()));
					} else {
						pstmt.setTimestamp(9, null);
					}

					pstmt.setString(10, "SYSTEM_USER");
					
				} catch (SQLException e) {
					//logger.println(IMessage.ERROR, "EmailLogDAOImpl.addEmailLog() : ", e);
				}

				return pstmt;
			}
		}, keyHolder);

		return keyHolder.getKey().longValue();
	}

	@Override
	public List<EmailLog> getAllUnsentEmails() {
		String sql = "SELECT * FROM email_log WHERE sent = ?";
		//logger.println(IMessage.DEBUG, "EmailLogDAOImpl.getAllUnsentEmails() sql: " + sql);
		List<EmailLog> emails = getJdbcTemplate().query(sql, BeanPropertyRowMapper.newInstance(EmailLog.class), Boolean.FALSE);
		return emails;
	}
}
