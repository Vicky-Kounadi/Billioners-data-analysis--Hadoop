package com.example;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Q1bMapper extends MapReduceBase implements Mapper<LongWritable,Text, Text, IntWritable> {

	public void map(LongWritable key, Text value, OutputCollector<Text,IntWritable> output, Reporter rep) throws IOException{

		String line = value.toString();
		String table[] = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
		if (table[4].length() > 0)
		{
			int age = 0;
			age = Integer.parseInt(table[4]);
		
			output.collect(new Text("age"), new IntWritable(age));
		}
	}
}
