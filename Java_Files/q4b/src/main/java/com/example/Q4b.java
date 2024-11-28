package com.example;

import java.io.IOException;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class Q4b extends Configured implements Tool {
	public int run(String args[]) throws IOException
	{
		if (args.length < 2)
		{
			System.out.println("Please give valid inputs");
			return -1;
		}

        JobConf conf2 = new JobConf(Q4b.class);
        FileInputFormat.setInputPaths(conf2, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf2, new Path(args[1]));
        conf2.setMapperClass(Q4bMapper.class);
        conf2.setReducerClass(Q4bReducer.class);
        conf2.setMapOutputKeyClass(Text.class);
        conf2.setMapOutputValueClass(MillionaireData.class);
        conf2.setOutputKeyClass(Text.class);
        conf2.setOutputValueClass(Text.class);
        JobClient.runJob(conf2);
		return 0;
	}

	public static void main(String args[]) throws Exception
	{
		int exitCode = ToolRunner.run(new Q4b(), args);
		System.out.println(exitCode);
	}

}
