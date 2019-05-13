/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.wscadcliente.util;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
/**
 *
 * @author gustavo
 */
public final class DateUtil {
 
    private static SimpleDateFormat formatador = new SimpleDateFormat();
    public static final String PATTERN_DEFAULT = "dd/MM/yyyy";
    public static final String PATTERN_SEM_MASCARA = "ddMMyyyy";
    public static final String PATTERN_FIREBIRD = "dd-MM-yyyy";
    public static final String PATTERN_POSTGRES = "yyyy-MM-dd";
    public static final String PATTERN_DDMMYY = "ddMMyy";
    public static final String PATTERN_DDMMYYYY_HHMMSS = "dd/MM/yyyy - HH:mm:ss";
    public static final String PATTERN_HHMMSS = "HH:mm:ss";

    private DateUtil() {
    }

    /**
     * Transforma uma objeto java.util.Date em uma String. <br>
     * A String retornada vai assumir o formato do argumento formato, caso o
     * mesmo seja v?lido, <br>
     * caso o mesmo n?o veja v?lido uma Exception ser? retornada.
     *
     * @param data (java.util.Date), objeto que ser? convertido para String.
     * @param formato (String), formato que a data assumira quando for
     * transformado em String.
     * @return uma String contendo a data passada como argumento no formatado
     * passado como argumento tamb?m.
     * @throws IllegalArgumentException, caso os argumentos passados sejam
     * inv?lidos, uma exce??o <br>
     * vai ser lan?ada.
     */
    public static String dateToString(Date date, String pattern) throws IllegalArgumentException {
        if (date == null || pattern == null) {
            throw new IllegalArgumentException("Argumento(s) nulo(s)");
        }

        formatador.applyPattern(pattern);

        return formatador.format(date);
    }

    /**
     * Transforma uma String em uma Data(java.util.Date), desde que a String
     * tenha um formato v?lido e <br>
     * corresponda ao formato da data, tamb?m passado como argumento.
     *
     * @param dataStr (String), cont?m a data a ser convertida.
     * @param formatoAtual (String), cont?m o formato que a data (String)
     * passada como argumento se encontra. <br>
     * Ex: Data a ser convertida: 10/12/2009, o formatoAtual deve indicar
     * dd/MM/yyyy.
     * @return Objeto data (java.util.Date) contendo a data que estava sendo
     * representada por uma String.
     * @throws ParseException caso os argumentos passados sejam inv?lidos, uma
     * exce??o vai ser<br>
     * lan?ada.
     */
    public static Date stringToData(String dateStr, String pattern) throws ParseException {
        if (dateStr == null || pattern == null) {
            throw new IllegalArgumentException("Argumento(s) nulo(s)");
        }

        if (formatador.isLenient()) {
            formatador.setLenient(false);
        }

        formatador.applyLocalizedPattern(pattern);

        return formatador.parse(dateStr);
    }

    /**
     * Converte um objeto Time em uma String no formato (00:00:00 - HH:mm:ss)
     *
     * @param hora (java.sql.Time), objeto a ser convertido em uma String com a
     * nota??o acima descrita.
     * @return uma String contendo a representa??o da hora (Time).
     * @throws IllegalArgumentException caso o argumento passado seja inv?lido,
     * uma exece??o vai ser <br>
     * lan?ada.
     */
    public static String timeToString(Time time) throws IllegalArgumentException {
        if (time == null) {
            throw new IllegalArgumentException("Argumento nulo");
        }

        return time.toString();
    }

    /**
     * Converte um long, no qual representa uma nota??o de hora em uma <br>
     * String no formato (00:00:00 - HH:mm:ss)
     *
     * @param hora (Long), objeto a ser convertido em uma String com a nota??o
     * acima descrita.
     * @return uma String contendo a representa??o da hora (Long).
     * @throws IllegalArgumentException caso o argumento passado seja inv?lido,
     * uma exece??o vai ser <br>
     * lan?ada.
     */
    public static String timeToString(Long hora) throws IllegalArgumentException {
        return timeToString(new Time(hora));
    }

    /**
     * Converte uma String em um objeto do Time.
     *
     * @param hora (String) que cont?m a a representa??o da hora que vai ser
     * transformada <br>
     * em um objeto Time. <br>
     * ATEN??O: a String que representa a hora deve estar obrigatoriamente no
     * formato (00:00:00 - HH:mm:ss).
     * @return uma objeto Time.
     * @throws IllegalArgumentException caso o argumento passado sej? inv?lido,
     * uma exce??o vai ser <br>
     * lan?ada.
     */
    public static Time stringToTime(String time) throws IllegalArgumentException {
        if (time == null) {
            throw new IllegalArgumentException("Argumento nulo");
        }

        return Time.valueOf(time);
    }

    /**
     * Converte um objeto Date (java.util.Date) para um objeto Date
     * (java.sql.Date).
     *
     * @param data (java.util.Date), objeto que vai ser transformado em uma
     * java.sql.Date.
     * @return um objeto java.sql.Date representando data passada como
     * argumento.
     */
    public static java.sql.Date dateUtilToDateSql(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Argumento nulo.");
        }

        return new java.sql.Date(date.getTime());
    }

    public static boolean isValidDate(String dateStr, String pattern) throws IllegalArgumentException {
        if (dateStr == null || pattern == null) {
            throw new IllegalArgumentException("Argumento nulo");
        }

        boolean isValid = true;

        try {
            if (formatador.isLenient()) {
                formatador.setLenient(false);
            }

            formatador.applyLocalizedPattern(pattern);

            formatador.parse(dateStr);
        } catch (ParseException ex) {
            isValid = false;
        }

        return isValid;
    }

    public static boolean isBeforeDate(String dateStr, String pattern) throws ParseException {
        if (dateStr == null || pattern == null) {
            throw new IllegalArgumentException("Argumento nulo");
        }

        boolean isBeforeDate = false;

        formatador.applyLocalizedPattern(pattern);

        if (formatador.parse(dateStr).before(new Date())) {
            isBeforeDate = true;
        }

        return isBeforeDate;
    }

    public static boolean isBeforeDate(String dateStr, String dateComparacao, String pattern)
            throws ParseException {
        if (dateStr == null || dateComparacao == null || pattern == null) {
            throw new IllegalArgumentException("Argumento nulo");
        }

        boolean isBeforeDate = false;

        formatador.applyLocalizedPattern(pattern);

        if (formatador.parse(dateStr).before(formatador.parse(dateComparacao))) {
            isBeforeDate = true;
        } else if (dateStr.equals(dateComparacao)) {
            isBeforeDate = true;
        }

        return isBeforeDate;
    }

    public static String getDataAtualStr(TipoFormato formato, boolean hora) {

        String format = "";

        if (hora) {
            format = formato.getFormato() + " HH:mm:ss";
        } else {
            format = formato.getFormato();
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    public static Date getData(TipoFormato formato, boolean hora) throws ParseException {

        String format = "";

        if (hora) {
            format = formato.getFormato() + " HH:mm:ss";
        } else {
            format = formato.getFormato();
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(getDataAtualStr(formato, hora));
    }

    public static GregorianCalendar getDataAtual(TipoFormato formato, boolean hora) throws ParseException {

        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTime(getData(formato, hora));

        return calendar;
    }

    public static XMLGregorianCalendar getDataAtualXml(TipoFormato formato, boolean hora) throws Exception {

        XMLGregorianCalendar calendar = DatatypeFactory.newInstance().
                newXMLGregorianCalendar(DateUtil.getDataAtual(formato, hora));

        return calendar;

    }

    public static GregorianCalendar getDataGreg(String data, TipoFormato formato) throws ParseException {

        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTime(stringToData(data, formato.getFormato()));

        return calendar;
    }

    public static XMLGregorianCalendar dateUtilToXmlGreg(String data, TipoFormato formato) throws ParseException, DatatypeConfigurationException {

        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTime(stringToData(data, formato.getFormato()));

        XMLGregorianCalendar xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);

        return xmlCalendar;
    }

    public static Date dateXmlGregTodateUtil(XMLGregorianCalendar xmlCalendar) throws ParseException, DatatypeConfigurationException {

        return xmlCalendar.toGregorianCalendar().getTime();
    }

    public static String formatarData(String data, String formatoAtual, String novoFormato) throws Exception {

        Date dt = new SimpleDateFormat(formatoAtual).parse(data);

        return new SimpleDateFormat(novoFormato).format(dt);

    }


    public static String extractDayDate(Date data){
        
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(data);
        
        int retorno = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        
        
        return String.format("%02d", retorno);
    }
    
    public static String extractMonthDate(Date data){
        
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(data);
        
        int retorno = calendar.get(GregorianCalendar.MONTH);
        
        String mes = String.format("%02d", retorno+1);
        return nomeMes(mes);
    }    

    public static String extractYearDate(Date data){
        
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(data);
        
        int retorno = calendar.get(GregorianCalendar.YEAR);
        
        
        return String.valueOf(retorno);
    }        
    public enum TipoFormato {

        DDMMAAAA_COM_BARRAS("dd/MM/yyyy"),
        AAAAMMDD_COM_BARRAS("yyyy/MM/dd"),
        MMDDAAAA_COM_BARRAS("MM/dd/yyyy"),
        DDMMAAAA_COM_HIFEN("dd-MM-yyyy"),
        AAAAMMDD_COM_HIFEN("yyyy-MM-dd"),
        MMDDAAAA_COM_HIFEN("MM-dd-yyyy"),
        DDMMAAAA("ddMMyyyy"),
        AAAAMMDD("yyyyMMdd"),
        MMDDAAAA("MMddyyyy"),
        HHMMSS("HH:mm:ss");
        private String formato;

        private TipoFormato(String formato) {
            this.formato = formato;
        }

        public String getFormato() {
            return this.formato;
        }
    }
    
    private static String nomeMes(String mes)
    {
        String retMes = "01";
        Map<String,String> mapMes = new HashMap<String,String>();
        
        mapMes.put("01", "Janeiro");
        mapMes.put("02", "Fevereiro");
        mapMes.put("03", "Marco");
        mapMes.put("04", "Abril");
        mapMes.put("05", "Maio");
        mapMes.put("06", "Junho");
        mapMes.put("07", "Julho");
        mapMes.put("08", "Agosto");
        mapMes.put("09", "Setembro");
        mapMes.put("10", "Outubro");
        mapMes.put("11", "Novembro");
        mapMes.put("12", "Dezembro");
        
        if(mapMes.containsKey(mes))
        {
            retMes = mapMes.get(mes);
        }
        
        return retMes;
    }    
}
