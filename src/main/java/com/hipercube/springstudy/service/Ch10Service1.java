package com.hipercube.springstudy.service;

import com.hipercube.springstudy.dto.Ch10Board;

import java.util.Arrays;
import java.util.Date;
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

public class Ch10Service1 {
    public List<Ch10Board> getBoardList() {
        List<Ch10Board> boardList = Arrays.asList(
                new Ch10Board(1, "제목1", "내용1", "홍길동", new Date()),
                new Ch10Board(2, "제목2", "내용2", "홍길동", new Date()),
                new Ch10Board(3, "제목3", "내용3", "홍길동", new Date()),
                new Ch10Board(4, "제목4", "내용4", "홍길동", new Date()),
                new Ch10Board(5, "제목5", "내용5", "홍길동", new Date())
        );
        return boardList;
    }
}
