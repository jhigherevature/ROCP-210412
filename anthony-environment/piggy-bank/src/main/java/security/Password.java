package security;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public final class Password {
    private static byte[] saltShaker() throws NoSuchAlgorithmException {
        SecureRandom r = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        r.nextBytes(salt);
        return salt;
    }

    private static String hexer(byte[] bytes) throws NoSuchAlgorithmException {
        BigInteger i = new BigInteger(1, bytes);
        String hex = i.toString(16);
        int padding = (bytes.length * 2) - hex.length();
        if (padding > 0) {
            return String.format("%0" + padding + "d", 0) + hex;
        } else {
            return hex;
        }
    }

    private static byte[] byter(String hex) throws NoSuchAlgorithmException {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }

    public static String[] hashGriddle(String passText) throws NoSuchAlgorithmException, InvalidKeySpecException {
        char[] passChars = passText.toCharArray();
        byte[] passSalt = saltShaker();

        PBEKeySpec s = new PBEKeySpec(passChars, passSalt, 65536, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] passHash = f.generateSecret(s).getEncoded();
        return new String[] { hexer(passHash), hexer(passSalt) };
    }

    public static boolean checkPass(String passText, String passHash, String passSalt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] hash = byter(passHash);
        byte[] salt = byter(passSalt);

        PBEKeySpec s = new PBEKeySpec(passText.toCharArray(), salt, 65536, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] pass = f.generateSecret(s).getEncoded();

        int diff = 0;
        if (hash.length != pass.length) {
            diff++;
        }
        for (int i = 0; i < hash.length && i < pass.length; i++) {
            if (hash[i] != pass[i]) {
                diff++;
            }
        }
        return diff == 0;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String passText = "password";
        String[] passHash = hashGriddle(passText);
        System.out.println(String.format("%s:%s", passHash[0], passHash[1]));

        boolean check = checkPass("password", passHash[0], passHash[1]);
        System.out.println(check);

        check = checkPass("wrong_password", passHash[0], passHash[1]);
        System.out.println(check);
    }
}