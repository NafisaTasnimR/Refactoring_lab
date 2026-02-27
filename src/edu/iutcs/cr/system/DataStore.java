package edu.iutcs.cr.system;

import edu.iutcs.cr.Invoice;
import edu.iutcs.cr.persons.Buyer;
import edu.iutcs.cr.persons.Seller;
import edu.iutcs.cr.vehicles.Vehicle;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class DataStore {

    public void saveInvoices(Set<Invoice> invoices) {
        saveData("invoices.txt", invoices);
    }

    public Set<Invoice> loadInvoices() {
        return loadData("invoices.txt");
    }

    public void saveBuyers(Set<Buyer> buyers) {
        saveData("buyers.txt", buyers);
    }

    public Set<Buyer> loadBuyers() {
        return loadData("buyers.txt");
    }

    public void saveSellers(Set<Seller> sellers) {
        saveData("sellers.txt", sellers);
    }

    public Set<Seller> loadSellers() {
        return loadData("sellers.txt");
    }

    public void saveVehicles(Set<Vehicle> vehicles) {
        saveData("cars.txt", vehicles);
    }

    public Set<Vehicle> loadVehicles() {
        return loadData("cars.txt");
    }

    private <T> void saveData(String filename, Set<T> data) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private <T> Set<T> loadData(String filename) {
        Set<T> data = new HashSet<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            data = (Set<T>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            saveData(filename, data);
        }
        return data;
    }
}
