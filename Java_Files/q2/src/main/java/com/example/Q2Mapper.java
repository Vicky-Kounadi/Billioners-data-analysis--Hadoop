package com.example;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Q2Mapper extends MapReduceBase implements Mapper<LongWritable,Text, Text, IntWritable> {

	public void map(LongWritable key, Text value, OutputCollector<Text,IntWritable> output, Reporter rep) throws IOException{

		String line = value.toString();
		String table[] = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
		int age = 0;
		if (table[4].length() > 0)
		{
			age = Integer.parseInt(table[4]);
		}
		
		if(age > 15 && age <24){
			output.collect(new Text("15-24"), new IntWritable(age));
		}
		else if(age > 25 && age <34){
			output.collect(new Text("25-34"), new IntWritable(age));
		}
		else if(age > 35 && age <44){
			output.collect(new Text("35-44"), new IntWritable(age));
		}
		else if(age > 45 && age <54){
			output.collect(new Text("45-54"), new IntWritable(age));
		}
		else if(age > 55 && age <64){
			output.collect(new Text("55-64"), new IntWritable(age));
		}
		else if(age > 65 && age <74){
			output.collect(new Text("65-74"), new IntWritable(age));
		}
		else if(age > 75 && age <84){
			output.collect(new Text("75-84"), new IntWritable(age));
		}
		else if(age > 85 && age <94){
			output.collect(new Text("85-94"), new IntWritable(age));
		}
		else if(age > 95 && age <104){
			output.collect(new Text("95-104"), new IntWritable(age));
		}

	}
}
