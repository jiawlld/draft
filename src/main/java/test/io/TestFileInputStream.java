package test.io;

import java.io.*;

/**
 * User: jiawenlong
 * Date: 16-8-3
 * Time: 上午10:39
 */
public class TestFileInputStream {

    private static final String FILE_PATH = "E:\\workspace\\other\\Draft\\src\\main\\java\\test\\io\\file.txt";

    public static void main(String[] args){
//        fileInputStream();
//        fileReader();
//        bufferedReaderMark();
        bufferedInputStream();
    }

    private static void bufferedInputStream(){
        BufferedInputStream bufferedInputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(FILE_PATH));
            byte[] bytes = new byte[2];
            int hasReadNum;
            while((hasReadNum = bufferedInputStream.read(bytes)) > 0){
                System.out.println(new String(bytes, 0, hasReadNum));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bufferedReader(){
        System.out.println("bufferedReader:");

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static void bufferedReaderMark(){
        System.out.println("bufferedReaderMark:");

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(FILE_PATH));
            System.out.println("support:" + bufferedReader.markSupported());

            char[] chars = new char[2];
            bufferedReader.read(chars);
            System.out.println(chars);

            bufferedReader.mark(10000);
            System.out.println("mark here!");

            while ((bufferedReader.read(chars)) > 0){
                System.out.println(chars);
            }

            bufferedReader.reset();
            System.out.println("reset here!");

            while ((bufferedReader.read(chars)) > 0){
                System.out.println(chars);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void fileReader(){
        System.out.println("fileReader:");

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(FILE_PATH);
            char[] chars = new char[1];
            while(fileReader.read(chars) > 0){
                System.out.println(chars);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    private static void fileInputStream() {
        System.out.println("fileInputStream:");

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(FILE_PATH);
            byte[] bytes = new byte[1];
            int hasReadNum;
            while((hasReadNum = fileInputStream.read(bytes)) > 0) {
                System.out.println(new String(bytes, 0, hasReadNum));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
