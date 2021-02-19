package FileStreamTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
FileInputStream FileOutputStream
 */
public class FileInputOuputStreamDemo {
    public static void main(String[] args) {
        //FileInputStreamReadTxt();
        String inputFile="IOExample\\0.jpg";
        String outputFile="IOExample\\1.jpg";
        CopyPicture(inputFile,outputFile);
    }
    /*
    通过stream 来实现图片复制
     */
    private static void CopyPicture(String inputFile,String outputFile) {
        File infile=new File(inputFile);
        File outfile=new File(outputFile);
        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;

        try {
            fileInputStream=new FileInputStream(infile);
            fileOutputStream=new FileOutputStream(outfile);

            byte[] bytes=new byte[1024];
            int len=0;
            while ((len=fileInputStream.read(bytes))!=-1){
                fileOutputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //该方法读取txt文本时会出现乱码。
    private static void FileInputStreamReadTxt() {
        File file=new File("IOExample\\helloWorld.txt");
        FileInputStream fileInputStream=null;
        try {
            fileInputStream=new FileInputStream(file);
            byte[] bytes=new byte[3];
            int len=0;
            while ((len=fileInputStream.read(bytes))!=-1){
                String s=new String(bytes,0,len);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
