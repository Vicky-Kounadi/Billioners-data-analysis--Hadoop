package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class Q3Reducer extends MapReduceBase implements Reducer<CountryCpi,IntWritable, Text, Text> {

	public void reduce(CountryCpi key, Iterator<IntWritable> value,OutputCollector<Text, Text> output,Reporter rep) throws IOException{
        int sum = 0;
        ArrayList<Integer> valueList = new ArrayList<>();
        while (value.hasNext()) {
            IntWritable values = value.next();
            valueList.add(values.get());
            sum += values.get();
        }
        //country, cpi, sumFinalWorth, numOfMillioners
		output.collect(new Text(key.getCountry()),new Text(key.getCpi() + " "+ sum + " " + valueList.size()));
	}
}

