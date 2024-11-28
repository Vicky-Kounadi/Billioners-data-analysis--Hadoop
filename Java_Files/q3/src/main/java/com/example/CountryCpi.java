package com.example;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;
import org.eclipse.jetty.io.EofException;

public class CountryCpi implements WritableComparable<CountryCpi>{

    private String country;
    private String cpi;

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCpi() {
        return cpi;
    }
    public void setCpi(String cpi) {
        this.cpi = cpi;
    }

    @Override
    public void write(DataOutput out) throws IOException {
       if(country != null && cpi != null){
           out.writeUTF(country);
           out.writeUTF(cpi);
       }
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        try{
            country = in.readUTF();
            cpi = in.readUTF();
        }
        catch (EofException e){
            
        }
    }

    @Override
    public int compareTo(CountryCpi cc) {
        int compare = country.compareTo(cc.getCountry());
        if (compare == 0) {
            return cpi.compareTo(cc.getCpi());
        }
        return compare;
    }

    
    
}
