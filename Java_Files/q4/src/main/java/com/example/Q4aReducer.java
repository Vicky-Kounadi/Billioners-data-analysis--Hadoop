package com.example;

import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class Q4aReducer extends MapReduceBase implements Reducer<Text,IntWritable, Text, IntWritable> {
    
    public void reduce(Text key, Iterator<IntWritable> value,OutputCollector<Text, IntWritable> output,Reporter rep) throws IOException{
        int totalWorth = 0;
        while (value.hasNext()) {
            totalWorth += value.next().get();
        }
        output.collect(new Text("TotalWorth"),new IntWritable(totalWorth));
	}
}
