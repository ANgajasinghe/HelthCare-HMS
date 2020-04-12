package auth;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import com.google.gson.Gson;
import dto.TokenAuthDTO;



public class AuthToken {
	
	private static final String MYKEY = "PAF2020NAYANAJITH";
	private static SecretKeySpec secretKey;
    private static byte[] key;
 
    
    
    public  String getToken(String userName,String password,String role) {
    
    	TokenAuthDTO tDto = new TokenAuthDTO();
    	tDto.setUserName(encrypt(userName,MYKEY));
    	tDto.setPassword(encrypt(password,MYKEY));
    	tDto.setRole(encrypt(role,MYKEY));
    	tDto.setValidDate(encrypt(GetValideTime(),MYKEY));
    	
    	tDto.setUserName(userName);
    	tDto.setPassword(password);
    	tDto.setRole(role);
    	tDto.setValidDate(GetValideTime());
    	
    	Gson gson = new Gson();
    	return encrypt(gson.toJson(tDto),MYKEY);
    	 	
    }
    
    public  String VerifyToken(String token) {
    	return decrypt(token, MYKEY);
    }
    
    
    
    
    
    private  void setKey(String myKey) 
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    
    private  String encrypt(String strToEncrypt, String secret) 
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
    
    private  String decrypt(String strToDecrypt, String secret) 
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
    
    private  String GetValideTime() {
    	
    	 Date currentDate = new Date();
    	 
    	 Calendar cal = Calendar.getInstance(); // creates calendar
    	 cal.setTime(new Date()); // sets calendar time/date
    	 cal.add(Calendar.HOUR_OF_DAY, 3); // adds one hour
    	 currentDate.compareTo(cal.getTime());
    	 SimpleDateFormat sdf = new SimpleDateFormat( "HH:mm:ss" );
    	 
    	 
    	 Calendar calendar = Calendar.getInstance(); 
    	 calendar.setTime(new Date());
    	 
		 return sdf.format(cal.getTime());
		
//    	 return Integer.toString(currentDate.compareTo(cal.getTime()));
    	
    	 
    }
    
    
    

}
