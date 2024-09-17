import java.util.Random;
import java.util.Scanner;

public class MessageEncoderDecoder {

    private static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("WHAT DO YOU WANT TO DO?");
            System.out.println("1. ENCODE");
            System.out.println("2. DECODE");
            System.out.println("3. QUIT");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        encode();
                        break;
                    case 2:
                        decode();
                        break;
                    case 3:
                        System.out.println("THANK YOU FOR USING OUR MESSAGING SERVICE");
                        return;
                    default:
                        System.out.println("SORRY, YOU HAVE ENTERED THE WRONG VALUE. PLEASE TRY AGAIN.");
                }
            } catch (NumberFormatException e) {
                System.out.println("INVALID INPUT. PLEASE ENTER A NUMBER.");
            }
        }
    }

    private static void encode() {
        System.out.print("ENTER YOUR MESSAGE: ");
        String message = scanner.nextLine();
        String[] words = message.split("\\s+");
        StringBuilder encodedMessage = new StringBuilder();

        for (String word : words) {
            if (word.length() < 3) {
                encodedMessage.append(new StringBuilder(word).reverse().toString()).append(" ");
            } else {
                String pre = getRandomString(3);
                String post = getRandomString(3);
                String transformedWord = word.substring(1) + word.charAt(0);
                String encodedWord = pre + transformedWord + post;
                encodedMessage.append(encodedWord).append(" ");
            }
        }

        System.out.println("Encoded Message: " + encodedMessage.toString().trim());
    }

    private static void decode() {
        System.out.print("ENTER THE ENCODED MESSAGE: ");
        String message = scanner.nextLine();
        String[] words = message.split("\\s+");
        StringBuilder decodedMessage = new StringBuilder();

        for (String word : words) {
            if (word.length() < 3) {
                decodedMessage.append(new StringBuilder(word).reverse().toString()).append(" ");
            } else {
                String coreWord = word.substring(3, word.length() - 3);
                String originalWord = coreWord.charAt(coreWord.length() - 1) + coreWord.substring(0, coreWord.length() - 1);
                decodedMessage.append(originalWord).append(" ");
            }
        }

        System.out.println("Decoded Message: " + decodedMessage.toString().trim());
    }

    private static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ALPHA.charAt(random.nextInt(ALPHA.length())));
        }
        return sb.toString();
    }
}
