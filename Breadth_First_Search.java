
import static Graphs.breadthFirstSearch.findMathcingFileBFS;
import java.io.File;
import java.util.LinkedList;

/**
 *
 * @author Mark
 */
public class BreadthFirstSearch2 {
    public static void queueSearch (String searchFile) {
        File file = new File("C:\\");
        File[] temp = file.listFiles();
        LinkedList<File> searchQueue = new LinkedList<>();
        for (int i = 0; i < temp.length; i++) {
            if(temp[i].isDirectory()) {
                searchQueue.add(temp[i]);
            }
        }
        while (!searchQueue.isEmpty()) {
           File tempFile = searchQueue.pop();
           File [] dircectoryContents = tempFile.listFiles();
           if (!(dircectoryContents == null)) {
             for (File dircectoryContent : dircectoryContents) {
                if (dircectoryContent.isDirectory()) {
                    searchQueue.push(dircectoryContent);
                }
                if(dircectoryContent.getName().equals(searchFile)) {
                    System.out.println("the file" + dircectoryContent + "has been found in your computer.");
                }
             }
           }
                
         }
    }
    
    public static void main(String[] arg) {
          queueSearch("depthFirstSearch.docx");
    }
 }
