package com.velotn.entity;

/*import org.supercsv.cellprocessor.FmtDate;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;*/

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Don {
    private int id;
    private double somme;
    private LocalDate date;

    public Don(int id) {
        this.id = id;
    }

    public Don(int id, double somme) {
        this.id = id;
        this.somme = somme;
    }

    public Don(double somme) {
        this.date = LocalDate.now().plusDays(1);
        this.somme = somme;
    }

    public Don(int id, double somme, LocalDate date) {
        this.id = id;
        this.somme = somme;
        this.date = date;
    }

    public Don(double somme, LocalDate date) {
        this.somme = somme;
        this.date = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSomme() {
        return somme;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "com.velotn.Entite.Don{" +
                "id=" + id +
                ", somme=" + somme +
                ", date='" + date + '\'' +
                '}';
    }

    /*CellProcessor[] processors = new CellProcessor[] {
            new ParseDouble(), // price
            new FmtDate("MM/dd/yyyy"), // published date
    };*/

    /*static void writeCSVFile(String csvFileName, List<Don> listDons) {
        ICsvBeanWriter beanWriter = null;
        CellProcessor[] processors = new CellProcessor[] {
                new ParseDouble(), // price, // publisher
                new FmtDate("MM/dd/yyyy") // published date

        };

        try {
            beanWriter = new CsvBeanWriter(new FileWriter(csvFileName),
                    CsvPreference.STANDARD_PREFERENCE);
            String[] header = {"date", "somme"};
            beanWriter.writeHeader(header);

            for (com.velotn.Entite.Don aBook : listDons) {
                beanWriter.write(aBook, header, processors);
            }

        } catch (IOException ex) {
            System.err.println("Error writing the CSV file: " + ex);
        } finally {
            if (beanWriter != null) {
                try {
                    beanWriter.close();
                } catch (IOException ex) {
                    System.err.println("Error closing the writer: " + ex);
                }
            }
        }
    }*/
}
