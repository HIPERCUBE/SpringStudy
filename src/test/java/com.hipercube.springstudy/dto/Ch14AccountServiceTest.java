package com.hipercube.springstudy.dto;

import com.hipercube.springstudy.ApplicationContextLoader;
import com.hipercube.springstudy.dao.Ch14AccountDao;
import com.hipercube.springstudy.service.Ch14Service;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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

public class Ch14AccountServiceTest extends ApplicationContextLoader {
    private static final Logger logger = LoggerFactory.getLogger(Ch14AccountServiceTest.class);

    @Autowired
    private Ch14Service accountService;

    @Autowired
    private Ch14AccountDao accountDao;

    @Test
    public void testTransfer() {
        Ch14Account fromAccount = new Ch14Account();
        fromAccount.setOwner("홍길동");
        fromAccount.setBalance(1000000);
        Integer fromAno = accountDao.insert(fromAccount);

        Ch14Account toAccount = new Ch14Account();
        toAccount.setOwner("스프링");
        toAccount.setBalance(0);
        Integer toAno = accountDao.insert(toAccount);

        // 정상
        accountService.transfer(fromAno, toAno, 100000);

        fromAccount = accountDao.selectByAno(fromAno);
        assertThat(fromAccount.getBalance(), is(900000));

        toAccount = accountDao.selectByAno(toAno);
        assertThat(toAccount.getBalance(), is(100000));

        // 비정상
        try {
            accountService.transfer(fromAno, 20, 100000);
        } catch(Exception e) {
            logger.info(e.toString());
        }

        fromAccount = accountDao.selectByAno(fromAno);
        assertThat(fromAccount.getBalance(), is(900000));

        toAccount = accountDao.selectByAno(toAno);
        assertThat(toAccount.getBalance(), is(100000));
    }
}
