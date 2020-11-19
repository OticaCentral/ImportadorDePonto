/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package importadordeponto;

    import javax.crypto.*;
    import javax.crypto.spec.*;

    public final class cripitografiaBlowFish
    {
       private static String passfrase="achavedeveter16";

       public static final String cript(String str)
       {
         String strCript = str;
         try
         {
            Cipher ch = Cipher.getInstance("Blowfish");
            SecretKey k1 = new SecretKeySpec(passfrase.getBytes(), "Blowfish");

            //criptografando
            ch.init( Cipher.ENCRYPT_MODE, k1);
            byte b[] = ch.doFinal(strCript.getBytes());
            System.out.println("B: " + b);
            String s1 = cripitografiaBlowFishConversion.byteArrayToBase64String(b);
            strCript = s1;
         }
         catch( Exception e)
         {
            System.out.println(e.getMessage());
            e.printStackTrace();
         }

         return strCript;
      }

      public static final String decript(String str)
      {
         String strDecript = str;

         try
         {
            Cipher ch = Cipher.getInstance("Blowfish");
            SecretKey k1 = new SecretKeySpec(passfrase.getBytes(), "Blowfish");

            //decriptografando
            ch.init( Cipher.DECRYPT_MODE, k1);
            byte b[] = cripitografiaBlowFishConversion.base64StringToByteArray(strDecript);
            byte b1[] = ch.doFinal(b);
            String s1 = new String(b1);
            strDecript = s1;
         }  
         catch(Exception e)
         {
            //System.out.println(e.getMessage());
           // e.printStackTrace();
         }
         return strDecript;
      }

      static public void main(String[] args)
      {
          
         cripitografiaBlowFish s = new cripitografiaBlowFish();
         String cript = cripitografiaBlowFish.cript("usuario123");
         String decript = cripitografiaBlowFish.decript(cript);
         String decriptoutro = cripitografiaBlowFish.decript("ZRY0ID3N7n/pbowE87vxQA==n");
         System.out.println("Cripto: " + cript);
         System.out.println("Decripto: " + decript);
         System.out.println("Descripitografia somente  : " + decriptoutro);

      }
   }