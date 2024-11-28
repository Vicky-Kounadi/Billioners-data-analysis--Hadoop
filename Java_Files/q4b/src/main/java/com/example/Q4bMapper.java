package com.example;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Q4bMapper extends MapReduceBase implements Mapper<LongWritable,Text, Text, MillionaireData> {
    private MillionaireData mills = new MillionaireData();
	public void map(LongWritable key, Text value, OutputCollector<Text,MillionaireData> output, Reporter rep) throws IOException{

		String[] fields = value.toString().split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
		String category = fields[2];
		String finalWorth = fields[1];
		String fullName = fields[3];

		mills.setFinalWorth(finalWorth);
		mills.setFullName(fullName);

		output.collect(new Text(category), mills);
		
	}
}
