package com.example;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Q3Mapper extends MapReduceBase implements Mapper<LongWritable,Text, CountryCpi, IntWritable> {
	private CountryCpi cc = new CountryCpi();
	
	public void map(LongWritable key, Text value, OutputCollector<CountryCpi,IntWritable> output, Reporter rep) throws IOException{

		String line = value.toString();
		String table[] = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
		if(table.length > 19){
			for(int i=0; i<table.length; i++){
				if(i==24){
					if(table[24].length() > 0){
						cc.setCountry(table[5]);
						cc.setCpi(table[24]);
					}
					if(table[1].length() > 0){
						output.collect(cc, new IntWritable(Integer.parseInt(table[1])));
					}
					break;
				}
			}
		}
		

	}
}
