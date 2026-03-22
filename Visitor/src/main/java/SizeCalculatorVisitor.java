public class SizeCalculatorVisitor implements FileSystemVisitor {
    private double totalSize = 0;

    public double getTotalSize() {
        return totalSize;
    }

    @Override
    public void visit(MyFile file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
    }
}