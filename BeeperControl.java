import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BeeperControl {
  private static final String FILENAME = "/home/edessale/Desktop/receiverInfo.txt";
	public static void main(String[] args) {
		ScheduledExecutorService execService
						=	Executors.newScheduledThreadPool(5);
		execService.scheduleAtFixedRate(()->{
			//The repetitive task, say to update Database
		try {
                BufferedWriter bw = null;
                FileWriter fw = null;

                String content = "4/3x  BottomQuadrantBlue TopQuadrantRed\n";

                fw = new FileWriter(FILENAME);
                bw = new BufferedWriter(fw);
                bw.write(content);

                System.out.println("Sending random command in a single line");
                    if (bw != null)
                        bw.close();

                    if (fw != null)
                        fw.close();

            } catch (IOException e) {

                e.printStackTrace();

            }
		}, 0, 1000L, TimeUnit.MILLISECONDS);
	}
}

