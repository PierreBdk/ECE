	public static class Map extends Mapper<LongWritable, Text, Text, IntWritable> 
	{
	       public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
	              String[] tokens = value.toString().split(";");
	              String cle = tokens[0].substring(0,1);
	              int valeur = Integer.parseInt(tokens[1]);
	              context.write(new Text(cle), new IntWritable(valeur));
	       }   
	}
	public static class Reduce extends Reducer<Text, IntWritable, Text, IntWritable> 
	{
	       public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException,InterruptedException {
	              int sum = 0;
	              for (IntWritable val : values) {
	                   sum += val.get();
	              }
	       context.write(key, new IntWritable(sum));
	       }
	}