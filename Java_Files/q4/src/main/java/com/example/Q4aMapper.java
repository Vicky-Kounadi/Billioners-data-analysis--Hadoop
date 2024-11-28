package com.example;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Q4aMapper extends MapReduceBase implements Mapper<LongWritable,Text, Text, IntWritable> {
	
	public void map(LongWritable key, Text value, OutputCollector<Text,IntWritable> output, Reporter rep) throws IOException{

		String fields[] = value.toString().split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
		int finalWorth = Integer.parseInt(fields[1]);
		output.collect(new Text("TotalWorth"), new IntWritable(finalWorth));

	}
}
