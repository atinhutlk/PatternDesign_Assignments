public class Main {
    public static void main(String[] args) {
        Directory root = getDirectory();

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size: " + sizeVisitor.getTotalSize() + " MB");

        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        root.accept(searchVisitor);

        System.out.println("Found files:");
        for(MyFile file : searchVisitor.getFoundFiles()) {
            System.out.println(file.getName() + " - " + file.getSize() + " MB");
        }
    }

    private static Directory getDirectory() {
        Directory root = new Directory("root");
        Directory documents = new Directory("documents");
        Directory images = new Directory("images");

        MyFile file1 = new MyFile("report.txt", 2.5);
        MyFile file2 = new MyFile("notes.txt", 1.2);
        MyFile file3 = new MyFile("photo.jpg", 3.8);
        MyFile file4 = new MyFile("program.java", 4.1);

        documents.addElement(file1);
        documents.addElement(file2);
        images.addElement(file3);
        root.addElement(documents);
        root.addElement(images);
        root.addElement(file4);
        return root;
    }
}