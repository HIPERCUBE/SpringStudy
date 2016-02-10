package com.hipercube.springstudy.dao;

import com.hipercube.springstudy.dto.Ch14Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

/**
 * Copyright (c) 2/7/16 Joowon Ryoo
 * <p/>
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

@Component
public class Ch14AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Ch14Account> selectAll() {
        String sql = "select * from account";
        return jdbcTemplate.query(sql, new RowMapper<Ch14Account>() {
            @Override
            public Ch14Account mapRow(ResultSet rs, int i) throws SQLException {
                Ch14Account account = new Ch14Account();
                account.setAno(rs.getInt("ano"));
                account.setOwner(rs.getString("owner"));
                account.setBalance(rs.getInt("balance"));
                return account;
            }
        });
    }

    public Ch14Account selectByAno(int ano) {
        String sql = "select * from account where ano=?";
        List<Ch14Account> list = jdbcTemplate.query(sql, new Object[]{ano}, new RowMapper<Ch14Account>() {
            @Override
            public Ch14Account mapRow(ResultSet rs, int i) throws SQLException {
                Ch14Account account = new Ch14Account();
                account.setAno(rs.getInt("ano"));
                account.setOwner(rs.getString("owner"));
                account.setBalance(rs.getInt("balance"));
                return account;
            }
        });
        if (list.size() != 0) return list.get(0);
        else return null;
    }

    public Integer insert(final Ch14Account account) {
        final String sql = "insert into account (owner, balance) value (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, account.getOwner());
                pstmt.setInt(2, account.getBalance());
                return pstmt;
            }
        }, keyHolder);
        Integer bno = keyHolder.getKey().intValue();
        return bno;
    }

    public int updateBalance(int ano, int balance) {
        String sql = "update account set balance=? where ano=?";
        return jdbcTemplate.update(sql, balance, ano);
    }
}
