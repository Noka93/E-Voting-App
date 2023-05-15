package semicolon.africa.votersApp.utils;

import java.math.BigInteger;
import java.util.UUID;

public class GenerateIdUsingUUID {

    public static void main(String[] args) {
        System.out.println(generateVoterIdentificationNumber());
    }
    public static final int ZERO = BigInteger.ZERO.intValue();

    public static final int ONE = BigInteger.ONE.intValue();

    public static final int FIVE = BigInteger.valueOf(5).intValue();

    public static final int EIGHT = BigInteger.valueOf(8).intValue();

    public static String generateVoterIdentificationNumber() {
        String uuid = generateUUID();
        String validUUID = stripInvalidCharactersFrom(uuid);
        return buildVoterIdentificationNumberFrom(validUUID);
    }

    private static String buildVoterIdentificationNumberFrom(String validUuid) {
        String result = "";
        for (int index = ZERO; index < validUuid.length(); index++) {
            if (index % FIVE == ZERO) result += " ";
            else result += validUuid.charAt(index);
        }
        int endIndex = result.length() - EIGHT;
        return result.substring(ZERO, endIndex).strip();
    }

    private static String stripInvalidCharactersFrom(String randomUUID) {
        String validUuid = "";
        for (int index = ZERO; index < randomUUID.length(); index++) {
            char currentCharacter = randomUUID.charAt(index);
            if ( currentCharacter != '-')validUuid += randomUUID.charAt(index);
        }
        return validUuid;
    }

    private static  String generateUUID(){
        UUID randomUuid = UUID.randomUUID();
        String uuid = randomUuid.toString();
        return uuid.toUpperCase();
    }
}
