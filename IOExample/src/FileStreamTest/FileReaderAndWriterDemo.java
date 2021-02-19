package FileStreamTest;

import java.io.*;

/*
文件字符流Reader Writer
 */
public class FileReaderAndWriterDemo {
    public static void main(String[] args) {
        //FileReaderDemo1();
        //FileReaderDemo2();
        //FileWriterDemo();
        FileWriterAndReader();
    }

    private static void FileWriterAndReader() {
        File WriterFile=new File("IOExample\\helloWriter.txt");
        File ReaderFile=new File("IOExample\\helloWorld.txt");
        FileReader fileReader=null;
        FileWriter fileWriter=null;
        try {
            fileReader=new FileReader(ReaderFile);
            fileWriter=new FileWriter(WriterFile,true);

            char[] chars=new char[3];
            int len=0;
            while ((len=fileReader.read(chars))!=-1){
                String s = new String(chars, 0, len);
                fileWriter.write(s);
            }
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void FileWriterDemo()  {
        File file=new File("IOExample\\helloWriter.txt");
        // FileWriter(file,true)为在原有文件后面就绪append
        // FileWriter(file,false) 或 FileWriter(file) 则重新写入
        FileWriter fileWriter=null;
        try {
            fileWriter=new FileWriter(file,true);
            String str="Hello World！ Writer";
            fileWriter.write(str);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    private static void FileReaderDemo2() {
        //1.file实例化
        File file=new File("IOExample\\helloWorld.txt");
        //2.fileReader流实例化
        FileReader fileReader=null;
        //3.流操作
        char[] chars=new char[3];

        int len;
        try {
            fileReader=new FileReader(file);
            while ((len=fileReader.read(chars))!=-1) {
                String s = new String(chars, 0, len);//单读取到最后时,字符长度小于char数组长度,该char数组里只替换了字符长度的值
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        //4.关闭流
    }

    private static void FileReaderDemo1() {
        File file=new File("IOExample\\helloWorld.txt");
        FileReader fileReader=null;
        try {
            fileReader=new FileReader(file);
            int data=0;
            while ((data=fileReader.read())!=-1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileReader!=null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
