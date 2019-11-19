package jplag;


import java.io.File;
import jplag.options.OptionContainer;

public class JPlag {

  public static void main(String[] args) {
//		if (args.length == 0)
//			CommandLineOptions.usage();
//		else {
    try {


      long t1 = System.currentTimeMillis();
      OptionContainer options = new OptionContainer();
      options.setLanguage("python3");
      options.min_token_match = 6;
      options.verbose_quiet = true;

      Program program = new Program(options);
      File dir = new File("~/work/tmp");
      Submission submission1 = new Submission("a.py", dir, program, program.get_language());
      submission1.parse();

      Submission submission2 = new Submission("b.py", dir, program, program.get_language());
      submission2.parse();
      float score = program.compare_two(submission1, submission2);

      long t2 = System.currentTimeMillis();

      System.out.println( (t2 - t1)  + "ms" + ", score is " + score);
      System.exit(0);


//      System.out.println("initialize ok");
      //program.run();
    } catch (ExitException ex) {
      System.out.println("Error: " + ex.getReport());
      System.exit(1);
    }
  }
//	}
}
