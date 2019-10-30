import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AutoTest {
	public static void main(String[] args){
		String pro = "csp";
		String pack = "poly";
		add_JpfTarget("/home/lyra/bench/"+pro+"/src/"+pack,pack);
		changefile("/home/lyra/bench/"+pro+"/src/"+pack,pack);
	}
	public static void changefile(String filepath,String pack){
		File file = new File(filepath);
    	//判断文件目录是否存在，且是文件目录，非文件
    	if(file.exists() && file.isDirectory()){
    		File[] childFiles = file.listFiles();
    		String path = file.getAbsolutePath();
    		for(File childFile : childFiles){
    			if(childFile.isFile()){
    				String oName = childFile.getName();
    				String className = oName.substring(0,oName.indexOf("."));
    				String testName = className.substring(9);
    				if(oName.contains(".java")){
    					String solve = "";
    			        BufferedReader reader = null;
    			        try {
    			            System.out.println("以行为单位读取文件内容，一次读一整行：");
    			            reader = new BufferedReader(new FileReader(childFile));
    			            String tempString = null;
    			            int line = 1;
    			            // 一次读入一行，直到读入null为文件结束
    			            while ((tempString = reader.readLine()) != null) {
    			                // 显示行号
    			               // System.out.println("line " + line + ": " + tempString);
    			                if(tempString.contains("solve")) {
    			                	solve = tempString.substring(tempString.indexOf("solve"));
    			                	break;
    			                }
    			                line++;
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
    			        FileWriter fw;
						try {
							fw = new FileWriter(childFile,false);
							 fw.write("public class "+className+"{\n");
							 fw.write("\tpublic static void main(String[]  args){\n");
		    			        fw.write("\t\t"+pack+"."+testName+"."+solve+"\n");
		    			        fw.write("\t}\n");
		    			        fw.write("}\n");
		    			        fw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
    			       
    				}else if(oName.contains(".jpf")){
    					String method = "";
    			        BufferedReader reader = null;
    			        try {
    			            System.out.println("以行为单位读取文件内容，一次读一整行：");
    			            reader = new BufferedReader(new FileReader(childFile));
    			            String tempString = null;
    			            int line = 1;
    			            // 一次读入一行，直到读入null为文件结束
    			            while ((tempString = reader.readLine()) != null) {
    			                // 显示行号
    			               // System.out.println("line " + line + ": " + tempString);
    			                if(tempString.contains("method")) {
    			                	method = tempString;
    			                	break;
    			                }
    			                line++;
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
    			        FileWriter fw;
						try {
							fw = new FileWriter(childFile,false);
							fw.write("@include ../common-jpf.properties\n");
							 fw.write("target="+className+"\n");
		    			        fw.write(method);
		    			        fw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
    				}
    					
    			}
    		}
    	}
	}
	public static void add_JpfTarget(String filepath,String pack){
		File file = new File(filepath);
    	//判断文件目录是否存在，且是文件目录，非文件
    	if(file.exists() && file.isDirectory()){
    		File[] childFiles = file.listFiles();
    		String path = file.getAbsolutePath();
    		for(File childFile : childFiles){
    			if(childFile.isFile()){
    				String oldName = childFile.getName();
    				String newName =  "JpfTarget"+oldName;
    				System.out.println(path+"/"+newName);
    			childFile.renameTo(new File(path+"/"+newName));
    			}
    		}
    	}
	}
}
