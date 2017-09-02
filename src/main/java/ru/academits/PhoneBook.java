package ru.academits;

import ru.academits.dao.ContactDao;
import ru.academits.service.ContactService;

/**
 * Created by Anna on 14.06.2017.
 */
public class PhoneBook {

    public static ContactDao contactDao = new ContactDao();

    public static ContactService phoneBookService = new ContactService();
}
