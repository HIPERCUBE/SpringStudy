package com.hipercube.springstudy.dao;

import com.hipercube.springstudy.ApplicationContextLoader;
import com.hipercube.springstudy.dto.Ch14Account;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
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

public class Ch14AccountDaoTest extends ApplicationContextLoader {
    private static final Logger logger = LoggerFactory.getLogger(Ch14AccountDaoTest.class);

    @Autowired
    private Ch14AccountDao accountDao;

    @Test
    public void testInsert() {
        Ch14Account account = new Ch14Account();
        account.setOwner("홍길동");
        account.setBalance(1000000);
        Integer bno = accountDao.insert(account);

        assertThat(bno, notNullValue());
    }

    @Test
    public void testSelectByAno() {
        Ch14Account account = new Ch14Account();
        account.setOwner("홍길동");
        account.setBalance(1000000);
        Integer ano = accountDao.insert(account);

        Ch14Account accountFromDB = accountDao.selectByAno(ano);

        assertThat(accountFromDB, notNullValue());
        assertThat(accountFromDB.getAno(), equalTo(ano));
        assertThat(accountFromDB.getOwner(), equalTo(account.getOwner()));
        assertThat(accountFromDB.getBalance(), equalTo(account.getBalance()));
    }

    @Test
    public void testUpdateBalance() {
        Ch14Account account = new Ch14Account();
        account.setOwner("홍길동");
        account.setBalance(1000000);
        Integer ano = accountDao.insert(account);

        int row = accountDao.updateBalance(ano, 500000);
        assertThat(row, is(1));

        Ch14Account accountFromDB = accountDao.selectByAno(ano);
        assertThat(accountFromDB.getBalance(), is(500000));
    }
}
