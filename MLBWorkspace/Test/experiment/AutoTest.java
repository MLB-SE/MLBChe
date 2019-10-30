import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AutoTest {
	public static void readFileByLines(String fileName,String pm, String comp) {
		String str = "";
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
            	if(tempString.contains("mlpm")) tempString = pm;
            	if(tempString.contains("complex")) tempString = comp;
            	str+="\n"+tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }  
       file.delete();
       appendMethodB(fileName,str);
    }
	
	public static void appendMethodB(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	public static void main(String[] args) throws IOException{
		int[] pm = {400,600,800,1000,2000,3000,4000,5000,6000,7000,8000,9000,10000};
		int[] comp = {2};
		for(int i = 0;i<pm.length;i++){
			for(int j = 0;j<comp.length;j++){
					readFileByLines(System.getProperty("user.dir")+"/arguments-MLB-samplesize.xml","+symbolic.mlpm="+pm[i],"+symbolic.complex="+comp[j]);

				Process p =  Runtime.getRuntime().exec("./run-experiments-samplesize.sh");
				try{
					p.waitFor();
				}catch (InterruptedException e) {  
		            System.err.println(e);

		        }
			}
		}
		System.out.println("end");
		
	}

}
