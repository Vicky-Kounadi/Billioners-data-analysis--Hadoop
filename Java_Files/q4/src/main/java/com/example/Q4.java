package com.example;

import java.io.IOException;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class Q4 extends Configured implements Tool {
	public int run(String args[]) throws IOException
	{
		if (args.length < 2)
		{
			System.out.println("Please give valid inputs");
			return -1;
		}

        JobConf conf1 = new JobConf(Q4.class);
        FileInputFormat.setInputPaths(conf1, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf1, new Path(args[1]));
        conf1.setMapperClass(Q4aMapper.class);
        conf1.setReducerClass(Q4aReducer.class);
        conf1.setMapOutputKeyClass(Text.class);
        conf1.setMapOutputValueClass(IntWritable.class);
        conf1.setOutputKeyClass(Text.class);
        conf1.setOutputValueClass(IntWritable.class);
        JobClient.runJob(conf1);
		return 0;
	}

	public static void main(String args[]) throws Exception
	{
		int exitCode = ToolRunner.run(new Q4(), args);
		System.out.println(exitCode);
	}

}
