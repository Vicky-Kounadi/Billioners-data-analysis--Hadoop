package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class Q1bReducer extends MapReduceBase implements Reducer<Text,IntWritable, Text, Text> {

	public void reduce(Text key, Iterator<IntWritable> value,OutputCollector<Text, Text> output,Reporter rep) throws IOException{

		int q1 = 0;
		int q3 = 0;
		double median = 0;
		
		//creating and sorting list
		ArrayList<Integer> valueList = new ArrayList<>();

        while (value.hasNext()) {
            IntWritable values = value.next();
            valueList.add(values.get());
        }

        Collections.sort(valueList);

		//Finding the values
		int min = valueList.get(0);
		int max = valueList.get(valueList.size()-1);
		int range = max-min;

		if(valueList.size()%2 != 0){
			q1 = valueList.get(valueList.size()/4);
			q3 = valueList.get(valueList.size()*3/4);
			median = valueList.get(valueList.size()/2);
		}
		else{
			q1 = valueList.get(valueList.size()/4-1);
			q3 = valueList.get(valueList.size()*3/4-1);
			median = (valueList.get(valueList.size()/2) + valueList.get(valueList.size()/2-1))/2;
		}

		int IQR = q3-q1;
		double lowerBound = q1 - 1.5 * IQR;
		double upperBound = q3 + 1.5 * IQR;

		String Outliers = "";
		for(int i=0; i<valueList.size(); i++){
			if(valueList.get(i) < lowerBound || valueList.get(i) > upperBound){
				if(Outliers.equalsIgnoreCase("")){
					Outliers = "" + valueList.get(i);
				}
				else{
					Outliers = Outliers +" "+ valueList.get(i);
				}
			}
		}
		
		output.collect(new Text("Min"), new Text(""+min));
		output.collect(new Text("Max"), new Text(""+max));
		output.collect(new Text("Range"), new Text(""+range));
		output.collect(new Text("Q1"), new Text(""+q1));
		output.collect(new Text("Median"), new Text(""+median));
		output.collect(new Text("Q3"), new Text(""+q3));
		output.collect(new Text("LowerBound"), new Text(""+lowerBound));
		output.collect(new Text("UpperBound"), new Text(""+upperBound));
		output.collect(new Text("Outlier"), new Text(Outliers));
	}
}

