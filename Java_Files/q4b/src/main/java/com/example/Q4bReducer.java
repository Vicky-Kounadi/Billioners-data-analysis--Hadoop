package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class Q4bReducer extends MapReduceBase implements Reducer<Text,MillionaireData, Text, Text> {

	public void reduce(Text key, Iterator<MillionaireData> value,OutputCollector<Text, Text> output,Reporter rep) throws IOException{
        int sumFinalWorth = 0;
        int totalWorth = 12206800;
        ArrayList<MillionaireData> valueList = new ArrayList<>();
        int max = 0;
        String best="";

        while (value.hasNext()) {
            MillionaireData values = value.next();
            valueList.add(values);
            sumFinalWorth += Integer.parseInt(values.getFinalWorth());
            if(Integer.parseInt(values.getFinalWorth()) > max){
                best = values.getFullName();
            }
        }
        double percentage = (sumFinalWorth * 100.0)/totalWorth;
        String formattedPercentage = String.format("%.2f", percentage);
        //category, percentage, numOfMillioners, categoryFinalWorth, categoryAverageFinalWorth, categoryRichestMillioner                
        output.collect(key, new Text(formattedPercentage + "%" + " " + valueList.size() + " " + sumFinalWorth + " " + (sumFinalWorth/valueList.size()) + " " + best));
	}
    
}

