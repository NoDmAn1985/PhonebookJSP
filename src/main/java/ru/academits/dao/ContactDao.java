package ru.academits.dao;

import ru.academits.model.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ContactDao {
    private HashMap<Integer, Contact> contactList = new HashMap<>();
    private AtomicInteger idSequence = new AtomicInteger(0);

    public ContactDao() {
        Contact contact = new Contact();
        contact.setId(getNewId());
        contact.setFirstName("Иван");
        contact.setLastName("Иванов");
        contact.setPhone("9123456789");
        contactList.put(contact.getId(), contact);
    }

    private int getNewId() {
        return idSequence.addAndGet(1);
    }

    public List<Contact> getAllContacts() {
        return new ArrayList<>(contactList.values());
    }

    public void add(Contact contact) {
        int index = getNewId();
        contact.setId(index);
        contactList.put(index, contact);
    }

    public void remove(int index) {
        contactList.remove(index);
    }
}
