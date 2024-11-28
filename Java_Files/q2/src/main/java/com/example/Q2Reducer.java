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

public class Q2Reducer extends MapReduceBase implements Reducer<Text,IntWritable, Text, IntWritable> {

	public void reduce(Text key, Iterator<IntWritable> value,OutputCollector<Text, IntWritable> output,Reporter rep) throws IOException{
		ArrayList<Integer> valueList = new ArrayList<>();

        while (value.hasNext()) {
            IntWritable values = value.next();
            valueList.add(values.get());
        }

		output.collect(key, new IntWritable(valueList.size()));
	}
}

