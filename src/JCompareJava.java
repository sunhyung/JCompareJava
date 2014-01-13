import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JCompareJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String srcPath = "Sample Source File Path";
		String dstPath = "Sample Destination File Path";

		JCompareCore core = new JCompareCore();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(srcPath));
			String lineStr = "";
			while((lineStr = br.readLine()) != null)	{
				core.AddSourceLine(lineStr);
			}
			br.close();
		}
		catch(IOException e) {
			System.out.println(e);
			System.exit(1);
		}

		try {
			BufferedReader br = new BufferedReader(new FileReader(dstPath));
			String lineStr = "";
			while((lineStr = br.readLine()) != null)	{
				core.AddDestinationLine(lineStr);
			}
			br.close();
		}
		catch(IOException e) {
			System.out.println(e);
			System.exit(1);
		}
		
		core.DoCompare();
		for(int i = 0; i < core.GetResultCount(); i++) {
			JCompareCore.CompareElement item = core.GetResultItem(i);
			System.out.printf("Source line : %d, Destination line : %d, Line count of same contents : %d\n",
					item.srcStartIndex, item.dstStartIndex, item.lineCountOfSameContext);
		}
	}

}
