package com.hipercube.springstudy.service;

import com.hipercube.springstudy.dao.Ch13AccountDao;
import com.hipercube.springstudy.dto.Ch13Account;
import com.hipercube.springstudy.exception.Ch13NotFoundAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Copyright (c) 2/10/16 Joowon Ryoo
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
public class Ch13Service {
    @Autowired
    private Ch13AccountDao accountDao;

    public List<Ch13Account> getAccountList() {
        List<Ch13Account> list = accountDao.selectAll();
        return list;
    }

    @Transactional
    public void transfer(int fromAno, int toAno, int amount) {
        Ch13Account fromAccount = accountDao.selectByAno(fromAno);
        accountDao.updateBalance(fromAno, fromAccount.getBalance() - amount);

        Ch13Account toAccount = accountDao.selectByAno(toAno);
        if (toAccount == null) {
            throw new Ch13NotFoundAccountException();
        }
        accountDao.updateBalance(toAno, toAccount.getBalance() + amount);
    }
}
