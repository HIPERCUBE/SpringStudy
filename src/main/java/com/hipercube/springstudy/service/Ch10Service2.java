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

public class Ch10Service2 {
    public List<Ch10Board> getBoardList() {
        List<Ch10Board> boardList = Arrays.asList(
                new Ch10Board(6, "제목6", "내용6", "홍길동", new Date()),
                new Ch10Board(7, "제목7", "내용7", "홍길동", new Date()),
                new Ch10Board(8, "제목8", "내용8", "홍길동", new Date()),
                new Ch10Board(9, "제목9", "내용9", "홍길동", new Date()),
                new Ch10Board(10, "제목10", "내용10", "홍길동", new Date())
        );
        return boardList;
    }
}
