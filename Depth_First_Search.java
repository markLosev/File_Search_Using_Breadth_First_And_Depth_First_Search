
import java.io.File;
import java.util.LinkedList;
import static Graphs.AppSettings.trace;

/**
 *
 * @author Mark
 */
public class depthFirstSearch {
      
    public static void findMathcingFileDFS(String fileName){
        File file = new File("C:\\");
        File[] files = file.listFiles();
        LinkedList<File> foundList = new LinkedList<>();
        depthFirst(fileName, files, foundList);
        if (!(foundList.isEmpty())){
            System.out.println("These are the files that match your search");
            for(int i = 0; i < foundList.size(); i++)
                System.out.println(foundList.get(i));
        }
        else{
            System.out.println("no files match your search");
        }
    }     
    public static void depthFirst(String fileName, File[] files, LinkedList<File> foundList){
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory() && files[i].listFiles() != null){
               File[] directoryFiles = files[i].listFiles();
                depthFirst(fileName, directoryFiles, foundList);
            }
            if (files[i].getName().equals(fileName)) { 
                foundList.add(files[i]);
            }
        }
    }
    public static void main(String[] args) {
        findMathcingFileDFS("depthFirstSearch.docx");
    }
}
