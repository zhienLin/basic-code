package IOStream;

import org.junit.Test;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/*
        获取文木上每个字符出现的次数
        提示:遍历文木的每一个字符;字符及出现的次数保存在Map中;
        将Map中数据写入文件
*/


public class NumberOfChar {
    @Test
    public void numOfChar() {

        BufferedReader bis = null;
        BufferedWriter bos = null;
        try {
            Map<Character, Integer> map = new TreeMap<>();
            StringBuilder sb = new StringBuilder();
            bis = null;
            bos = null;
            File fRead = new File("xixi.txt");
            File fWrite = new File("xixi1.txt");

            FileReader fr = new FileReader(fRead);
            FileWriter fw = new FileWriter(fWrite);

            bis = new BufferedReader(fr);
            bos = new BufferedWriter(fw);

            String read;
            while ((read = bis.readLine()) != null) {
                for (int i = 0; i < read.length(); i++) {
                    char c = read.charAt(i);
                    boolean flag = map.containsKey(c);
                    if (flag == true) {
                        Integer num = map.get(c);
                        map.put(c, ++num);
                    } else
                        map.put(c, 1);
                }
            }

            Set<Map.Entry<Character, Integer>> entries = map.entrySet();
            for (Map.Entry<Character, Integer> entry : entries) {
                Character key = entry.getKey();
                Integer value = entry.getValue();
                sb.append(key);
                sb.append(":");
                sb.append(value);
                sb.append(" ");
            }

            bos.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




        long end = System.currentTimeMillis();
    }
}
