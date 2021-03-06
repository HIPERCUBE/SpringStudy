package com.hipercube.springstudy.dao;

import com.hipercube.springstudy.dto.Ch11Board;
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
 * <p>
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 * <p>
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * <p>
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
public class Ch11BoardDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Ch11Board> selectAll() {
        String sql = "select * from board";
        return jdbcTemplate.query(sql, new RowMapper<Ch11Board>() {
            @Override
            public Ch11Board mapRow(ResultSet rs, int i) throws SQLException {
                Ch11Board board = new Ch11Board();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBcontent(rs.getString("bcontent"));
                board.setBdate(rs.getDate("bdate"));
                board.setMid(rs.getString("mid"));
                return board;
            }
        });
    }

    public Ch11Board selectByBno(int bno) {
        String sql = "select * from board where bno=?";
        List<Ch11Board> list = jdbcTemplate.query(sql, new Object[]{bno}, new RowMapper<Ch11Board>() {
            @Override
            public Ch11Board mapRow(ResultSet rs, int i) throws SQLException {
                Ch11Board board = new Ch11Board();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBcontent(rs.getString("bcontent"));
                board.setBdate(rs.getDate("bdate"));
                board.setMid(rs.getString("mid"));
                return board;
            }
        });
        if (list.size() != 0) return list.get(0);
        else return null;
    }

    public Integer insert(final Ch11Board board) {
        final String sql = "insert into board (btitle, bcontent, bdate, mid) values(?, ?, sysdate, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, board.getBtitle());
                pstmt.setString(2, board.getBcontent());
                pstmt.setString(3, board.getMid());
                return pstmt;
            }
        }, keyHolder);
        Integer bno = keyHolder.getKey().intValue();
        return bno;
    }
}
