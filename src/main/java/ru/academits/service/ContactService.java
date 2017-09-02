package ru.academits.service;

import ru.academits.PhoneBook;
import ru.academits.dao.ContactDao;
import ru.academits.model.Contact;

import java.util.List;


public class ContactService {
    private ContactDao contactDao = PhoneBook.contactDao;

    private boolean isExistContactWithPhone(String phone) {
        List<Contact> contactList = contactDao.getAllContacts();
        for (Contact contact : contactList) {
            if (contact.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    private ContactValidation validateContact(Contact contact) {
        ContactValidation contactValidation = new ContactValidation();
        contactValidation.setValid(true);
        if (contact.getLastName().isEmpty()) {
            contactValidation.setValid(false);
            contactValidation.setError(Errors.LAST_NAME);
            return contactValidation;
        }

        if (contact.getFirstName().isEmpty()) {
            contactValidation.setValid(false);
            contactValidation.setError(Errors.FIRST_NAME);
            return contactValidation;
        }

        if (contact.getPhone().isEmpty()) {
            contactValidation.setValid(false);
            contactValidation.setError(Errors.PHONE);
            return contactValidation;
        }

        if (isExistContactWithPhone(contact.getPhone())) {
            contactValidation.setValid(false);
            contactValidation.setError(Errors.PHONE_EXIST);
            return contactValidation;
        }
        return contactValidation;
    }

    public ContactValidation addContact(Contact contact) {
        ContactValidation contactValidation = validateContact(contact);
        if (contactValidation.isValid()) {
            contactDao.add(contact);
        }
        return contactValidation;
    }

    public void removeContact(int index) {
        contactDao.remove(index);
    }

    public List<Contact> getAllContacts() {
        return contactDao.getAllContacts();
    }
}
