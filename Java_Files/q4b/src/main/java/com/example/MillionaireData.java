package com.example;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.*;

public class MillionaireData implements Writable {
    private String finalWorth;
    private String fullName;

    public String getFinalWorth() {
        return finalWorth;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(finalWorth);
        out.writeUTF(fullName);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        finalWorth = in.readUTF();
        fullName = in.readUTF();
    }

    public void setFinalWorth(String finalWorth) {
        this.finalWorth = finalWorth;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
