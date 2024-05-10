package useful_functions;

import java.util.UUID;

public class UUIDConverterForMySQL_BINARY_16 {
    public static void main(String[] args) {
        // Приклад UUID для демонстрації
        String uuidString = "123e4567-e89b-12d3-a456-426614174000";

        // Конвертуємо UUID у бінарний формат та виводимо результат
        byte[] binaryUUID = convertUUIDToBinary(uuidString);
        System.out.println("Binary representation:");
        for (byte b : binaryUUID) {
            System.out.format("%02x ", b);
        }

        // Конвертуємо назад із бінарного формату в рядок UUID
        UUID uuidFromBinary = convertBinaryToUUID(binaryUUID);
        System.out.println("\nRecovered UUID: " + uuidFromBinary);
    }

    public static byte[] convertUUIDToBinary(String uuidString) {
        UUID uuid = UUID.fromString(uuidString);
        long mostSigBits = uuid.getMostSignificantBits();
        long leastSigBits = uuid.getLeastSignificantBits();
        byte[] buffer = new byte[16];
        for (int i = 0; i < 8; i++) {
            buffer[i] = (byte) (mostSigBits >>> (8 * (7 - i)));
            buffer[i + 8] = (byte) (leastSigBits >>> (8 * (7 - i)));
        }
        return buffer;
    }

    public static UUID convertBinaryToUUID(byte[] binaryUUID) {
        if (binaryUUID.length != 16) {
            throw new IllegalArgumentException("Invalid binary UUID length");
        }
        long mostSigBits = 0;
        long leastSigBits = 0;

        // Відновлюємо most Significant та least Significant bits з байтів
        for (int i = 0; i < 8; i++) {
            mostSigBits = (mostSigBits << 8) | (binaryUUID[i] & 0xff);
            leastSigBits = (leastSigBits << 8) | (binaryUUID[i + 8] & 0xff);
        }

        return new UUID(mostSigBits, leastSigBits);
    }
}
