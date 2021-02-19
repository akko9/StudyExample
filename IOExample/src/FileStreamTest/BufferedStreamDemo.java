package FileStreamTest;


import java.io.*;

public class BufferedStreamDemo {
    public static void main(String[] args) {
        String inputFile="IOExample\\0.jpg";
        String outputFile="IOExample\\2.jpg";
        BufferedCopyFile(inputFile,outputFile);
    }

    private static void BufferedCopyFile(String inputFile,String outputFile) {
        //新建文件
        File infile=new File(inputFile);
        File outfile=new File(outputFile);
        //节点流
        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;
        //缓冲流
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;

        try {
            fileInputStream=new FileInputStream(infile);
            fileOutputStream=new FileOutputStream(outfile);

            bufferedInputStream=new BufferedInputStream(fileInputStream);
            bufferedOutputStream=new BufferedOutputStream(fileOutputStream);

            byte[] bytes=new byte[1024];
            int len=0;
            while ((len=bufferedInputStream.read(bytes))!=-1){
                bufferedOutputStream.write(bytes,0,len);
                //刷新缓冲区 bufferedOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream!=null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream!=null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
