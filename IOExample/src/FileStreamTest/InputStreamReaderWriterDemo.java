package FileStreamTest;
/*
InputStreamReader
OutputStreamWriter
 */

import java.io.*;

public class InputStreamReaderWriterDemo {
    public static void main(String[] args) {
            transferChar();
    }

    private static void transferChar()  {
        FileInputStream inputStream=null;
        InputStreamReader inputStreamReader=null;
        FileOutputStream fileOutputStream=null;
        OutputStreamWriter outputStreamWriter=null;
        try {
            inputStream=new FileInputStream("IOExample\\helloWorld.txt");
            inputStreamReader=new InputStreamReader(inputStream,"UTF-8");
            fileOutputStream=new FileOutputStream("IOExample\\fileOutputStream.txt");
            outputStreamWriter=new OutputStreamWriter(fileOutputStream,"GBK");
            char[] chars=new char[3];
            int len=0;
            while ((len=inputStreamReader.read(chars))!=-1){
//                String s=new String(chars,0,len);
//                System.out.print(s);
                outputStreamWriter.write(chars,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStreamReader!=null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStreamWriter!=null){
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
