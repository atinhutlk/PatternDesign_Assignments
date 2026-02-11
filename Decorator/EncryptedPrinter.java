public class EncryptedPrinter implements Printer {
    private final Printer printer;

    public EncryptedPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String message) {
        String encrypted = toAsciiCodes(message);
        printer.print(encrypted);
    }

    
    private String toAsciiCodes(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            sb.append((int) text.charAt(i));
            if (i < text.length() - 1) sb.append(" ");
        }
        return sb.toString();
    }
}
