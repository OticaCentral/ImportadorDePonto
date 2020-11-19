/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package importadordeponto;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static java.util.Calendar.DAY_OF_MONTH;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author Moises
 */
public class DataHora
{

    private static String timezone="GMT-3:00";

    private static String Local="pt_BR";

    public static String getHoraAtual()
    {
        

           Calendar agora = Calendar.getInstance(TimeZone.getTimeZone(timezone), new Locale(Local) );
	   // horas, minutos e segundos
	   int horas = agora.get(Calendar.HOUR_OF_DAY);
	   int minutos = agora.get(Calendar.MINUTE);
	   int segundos = agora.get(Calendar.SECOND);

	   System.out.println("Hora Atual: " + horas +
              ":" + minutos + ":" + segundos);

           String hora = horas + ":" + minutos + ":" + segundos;
           return hora;

    }


        public static String getHoraDodia()
    {
           Calendar agora = Calendar.getInstance(TimeZone.getTimeZone(timezone) , new Locale(Local));
	   // horas, minutos e segundos
	   int minutos = agora.get(Calendar.HOUR_OF_DAY);
           String hora = String.valueOf(minutos);
           return hora;

    }
           public static String getMinutosDahora()
    {

           Calendar agora = Calendar.getInstance(TimeZone.getTimeZone(timezone) , new Locale(Local));
	   // horas, minutos e segundos
	   int horas = agora.get(Calendar.MINUTE);
           String hora = String.valueOf(horas);
           return hora;

    }
          public static String getSegundosDodia()
    {

           Calendar agora = Calendar.getInstance(TimeZone.getTimeZone(timezone) , new Locale(Local));
	   // horas, minutos e segundos
	   int segundos = agora.get(Calendar.SECOND);
           String hora = String.valueOf(segundos);
           return hora;
    }
          
          

    public static String getDataAtual()
    {

        
        GregorianCalendar calendario = new GregorianCalendar( TimeZone.getTimeZone(timezone) , new Locale(Local));
        //calendario.add(GregorianCalendar.DATE , diasasomar);
        Date dt =  calendario.getTime();
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        String dataatualizada = df.format(dt);
        System.out.println("hoje é  " + dataatualizada);
        return dataatualizada;
               
        
        
    }

        public static String getDataAtualIso()
    {

        GregorianCalendar calendario = new GregorianCalendar( TimeZone.getTimeZone(timezone) , new Locale(Local));
        //calendario.add(GregorianCalendar.DATE , diasasomar);
        Date dt =  calendario.getTime();
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        String dataatualizada = df.format(dt);
        formataData f = new formataData(dataatualizada, "dd/MM/yyyy", "yyyy-MM-dd");
        System.out.println("hoje iso é  " + f.getStringFormatada());
        return f.getStringFormatada();

    }

    public static void setTimeZoneDefult()
    {
            TimeZone.setDefault(TimeZone.getTimeZone(timezone));
            Date d = new Date();
            System.out.println(d.toString());
            Calendar  c = Calendar.getInstance();
            System.out.println(c.getTime().toString());
    }


    //retorna o dia da semana dada uma data
      public static String getDiaSemana(int ano, int mes, int dia)
      {

        Calendar calendario = new GregorianCalendar(ano, mes - 1, dia);
        int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
        return pesquisarDiaSemana(diaSemana);
        
      }

    //faz a pesquisa, dado um inteiro de 1 a 7
     public static String pesquisarDiaSemana(int _diaSemana)
     {
       String diaSemana = null;

       switch (_diaSemana)
       {

       case 1:
       {
         diaSemana = "Domingo";
         break;
       }
       case 2:
       {
         diaSemana = "Segunda";
         break;
       }
       case 3:
       {
         diaSemana = "Terça";
         break;
       }
       case 4:
       {
         diaSemana = "Quarta";
         break;
       }
       case 5:
       {
         diaSemana = "Quinta";
         break;
       }
       case 6:
       {
         diaSemana = "Sexta";
         break;
       }
       case 7:
       {
         diaSemana = "Sábado";
         break;
       }

       }
       return diaSemana;

     }

public static String somadataDias(int ano, int mes, int dia, int intervaloDias)
 {
    
    String data = null;
    try
    {

        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = new GregorianCalendar(ano, mes, dia);
        System.out.println("Data: " + sd.format(c.getTime()));
        c.add(Calendar.DAY_OF_MONTH, intervaloDias);
        System.out.println(intervaloDias + " dias depois: " + sd.format(c.getTime()));
        data = sd.format(c.getTime());

    }catch(Exception erro){System.out.println(erro.getMessage());data=null;}
    finally
    {
        return data;
    }


}

public static String somadataMes(int ano, int mes, int dia, int intervaloMes)
 {
    
    String data = null;
    try
    {
    SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
    Calendar c = new GregorianCalendar(ano, mes, dia);
    System.out.println("Data: " + sd.format(c.getTime()));
    c.add(Calendar.MONTH, intervaloMes);
    System.out.println(intervaloMes + " resultado mês: " + sd.format(c.getTime()));
        data = sd.format(c.getTime());

    }catch(Exception erro){System.out.println(erro.getMessage());data=null;}
    finally
    {
        return data;
    }


}



public static void  somadata(int ano, int mes, int dia, int intervaloDia)
 {
    SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
    Calendar c = new GregorianCalendar(ano, mes, dia);
    System.out.println("Data: " + sd.format(c.getTime()));
    c.add(Calendar.DAY_OF_MONTH, intervaloDia);
    System.out.println(intervaloDia + " dias depois: " + sd.format(c.getTime()));
    c.add(Calendar.DAY_OF_MONTH, -1);
    System.out.println("Um dia antes: " + sd.format(c.getTime()));
    c.add(Calendar.MONTH, -1);
    System.out.println("Um mês antes: " + sd.format(c.getTime()));
    c = new GregorianCalendar(2003, Calendar.MARCH, 3);
    System.out.println("Data: " + sd.format(c.getTime()));
    c.add(Calendar.DAY_OF_MONTH, -1);
    System.out.println("Um dia antes: " + sd.format(c.getTime()));
    c.add(Calendar.MONTH, -1);
    System.out.println("Um mês antes: " + sd.format(c.getTime()));
}


public static boolean DataValida(String texto) {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setLenient(false);
    
        try 
        {
        sdf.parse(texto);
        return true;
        }
        catch (ParseException ex) 
        {
        return false;
        }


} 


public static int getUltimoDiaMesAtual(){
	GregorianCalendar cal = new GregorianCalendar();
	cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
	int ultimoDia = cal.get(Calendar.DAY_OF_MONTH);
	return ultimoDia;
}


public static int getUltimoDiaMesDMA(String data){
    
        Integer dia = Integer.valueOf(data.substring(0, 2));
        Integer mes = Integer.valueOf(data.substring(3, 5));
        Integer ano = Integer.valueOf(data.substring(6, 10));
        mes = mes -1;
    
	GregorianCalendar cal = new GregorianCalendar( ano,mes,dia);
	cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
	int ultimoDia = cal.get(Calendar.DAY_OF_MONTH);
	return ultimoDia;
}



public static void main(String args[])
{

   
    
}






}
