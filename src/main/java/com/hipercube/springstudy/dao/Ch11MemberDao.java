package com.hipercube.springstudy.dao;

import com.hipercube.springstudy.dto.Ch11Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Copyright (c) 2/8/16 Joowon Ryoo
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
public class Ch11MemberDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Ch11Member selectByMid(String mid) {
        List<Ch11Member> list = jdbcTemplate.query("select * from member where mid=?", new Object[]{mid}, new RowMapper<Ch11Member>() {
            @Override
            public Ch11Member mapRow(ResultSet resultSet, int i) throws SQLException {
                Ch11Member member = new Ch11Member();
                member.setMid(resultSet.getString("mid"));
                member.setMname(resultSet.getString("mname"));
                member.setMpassowrd(resultSet.getString("mpassword"));
                return member;
            }
        });
        if (list.size() != 0) return list.get(0);
        else return null;
    }

    public String insert(Ch11Member member) {
        int rows = jdbcTemplate.update("insert into member values (?, ?, ?)", member.getMid(), member.getMname(), member.getMpassowrd());
        if (rows == 1) return member.getMid();
        else return null;
    }
}
