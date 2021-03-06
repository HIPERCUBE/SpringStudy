package com.hipercube.springstudy.dao;

import com.hipercube.springstudy.dto.Ch12Board;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
public class Ch12BoardDaoMyBatisImpl implements Ch12BoardDao {
    private static final Logger logger = LoggerFactory.getLogger(Ch12BoardDaoMyBatisImpl.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<Ch12Board> selectAll() {
        return sqlSessionTemplate.selectList("BoardMapper.selectAll");
    }

    @Override
    public Ch12Board selectByBno(int bno) {
        return sqlSessionTemplate.selectOne("BoardMapper.selectByBno", bno);
    }

    @Override
    public Integer insert(Ch12Board board) {
        return sqlSessionTemplate.insert("BoardMapper.insert", board);
    }

    @Override
    public int update(Ch12Board board) {
        return sqlSessionTemplate.update("BoardMapper.update", board);
    }

    @Override
    public int delete(int bno) {
        return sqlSessionTemplate.delete("BoardMapper.update", bno);
    }
}
