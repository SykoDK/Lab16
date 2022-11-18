import java.io.File;
import java.io.IOException;
import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class wordCount {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the file name:");
        String filename = input.next();
        System.out.println("Please enter the number of words to view:");
        int numWords = input.nextInt();
        String currentDir="C:\\Users\\iangr\\IdeaProjects\\CompSci240-Lab16-Hashtables\\src\\";
        File file = new File (currentDir + filename);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String str;
        HashMap<String,Integer> map= new HashMap<>();
        while ((str = br.readLine()) != null) {
            String[] words = str.split(" ");
            for(String eachWord:words) {
                if(eachWord.length()>0) {
                    if(map.containsKey(eachWord)) {
                        map.put(eachWord,map.get(eachWord)+1);
                    }else{
                        map.put(eachWord,1);
                    }

                }
            }

        }

        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Sort());
        int count = 0;
        for(Map.Entry<String,Integer> a:list) {
            System.out.println("#" + (count + 1) + ":" + a.getKey() + " " + "(" + a.getValue() + " uses)");
            count++;
            if (count == numWords) {
                break;
            }
        }

    }
}
class Sort implements Comparator<Entry<String, Integer>> {
    public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2)
    {
        return o2.getValue().compareTo(o1.getValue());
    }
}

