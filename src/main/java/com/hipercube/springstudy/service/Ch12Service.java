package com.hipercube.springstudy.service;

import com.hipercube.springstudy.dao.Ch12BoardDao;
import com.hipercube.springstudy.dto.Ch12Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
public class Ch12Service {
    @Autowired
    private Ch12BoardDao boardDao;

    public List<Ch12Board> getBoardList() {
        return boardDao.selectAll();
    }

    public Ch12Board getBoard(int bno) {
        return boardDao.selectByBno(bno);
    }

    public Integer boardWrite(Ch12Board board) {
        return boardDao.insert(board);
    }

    public int boardUpdate(Ch12Board board) {
        return boardDao.update(board);
    }

    public int boardDelete(int bno) {
        return boardDao.delete(bno);
    }
}
