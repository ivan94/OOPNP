package edu.newpaltz.cs.fernandi2.hw1oop;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class RandomStringGeneratorTester {

	@SuppressWarnings("static-access")
	public static Options createOptions() {
		Options opt = new Options();

		Option intOpt = OptionBuilder.withArgName("positive integer").hasArg()
				.withDescription("size of the generated string").create('i');

		Option strOpt = OptionBuilder.withArgName("string").hasArg()
				.withDescription("seed for the generated strings").create('s');

		opt.addOption(intOpt);
		opt.addOption(strOpt);
		opt.addOption("help", false, "show this message");
		return opt;
	}

	public static void main(String[] args) {
		try {
			Options o = createOptions();
			CommandLine cmdLine = new BasicParser().parse(o, args);
			
			RandomStringGenerator rsg = new RandomStringGenerator();
			rsg.addRange(new Range('a', 'z'));
			rsg.addRange(new Range('A', 'Z'));
			rsg.addRange(new Range('0', '9'));
			
			if(cmdLine.hasOption('i')){
				String opt = cmdLine.getOptionValue('i');
				try{
					int size = Integer.parseInt(opt);
					if(size < 0) throw new NumberFormatException();
					System.out.println(rsg.nextString(size));
				}catch(NumberFormatException ex){
					printHelp(o);
				}
			}else if(cmdLine.hasOption('s')){
				try{
					System.out.println(rsg.nextString(cmdLine.getOptionValue('s')));
				} catch(Exception ex){
					printHelp(o);
				}
			}else{
				printHelp(o);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void printHelp(Options o) {
		HelpFormatter hf = new HelpFormatter();
		hf.printHelp("java RandomStringGenerator", o, true);
	}

}
