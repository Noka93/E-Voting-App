package semicolon.africa.votersApp.utils;

import javax.swing.plaf.PanelUI;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class AppUtils {
    private static  int currentId;

    private final static Map<String, String>userInformationJointTable = new HashMap<>();

    private static final int NINE = BigInteger.valueOf(9).intValue();

    public static String generateId(){
        currentId+=1;
        int generatedId = currentId;
        return String.valueOf(generatedId);
    }

    public static void linkedUserToUserInformation(String userId, String userInformationId){
        userInformationJointTable.put(userId, userInformationId);
    }

    public static String getUserInformationId(String userId){
        String userInformationId = userInformationJointTable.get(userId);
        return userInformationId;
    }
}
