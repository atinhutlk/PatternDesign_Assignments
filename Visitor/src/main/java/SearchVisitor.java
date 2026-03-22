import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String keyword;
    private List<MyFile> foundFiles = new ArrayList<>();

    public SearchVisitor(String keyword) {
        this.keyword = keyword;
    }

    public List<MyFile> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public void visit(MyFile file) {
        if (file.getName().contains(keyword)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
    }
}