/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.wscadcliente.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

/**
 *
 * @author gustavo
 */
public class UtilLog {
    
    public static void regLogErro(String nomeArquivo, Exception erro)
    {
        try
        {
            String DIRETORIO_LOG = "";
            
            if(TipoSO.isLinux())
                DIRETORIO_LOG = "/app/log/";
            else
                DIRETORIO_LOG = "C:/app/log/";
                    
            FileOutputStream objSaida = null;

            File diretorioLog = new File(DIRETORIO_LOG);

            if (diretorioLog.isDirectory() == false)
            {
                diretorioLog.mkdirs();
            }

            //cria o nome do arquivo no formato app/log/ibatch/nomeArquivo_00/00/0000.log
            String nomeArquivoLog = String.format("%s%s%s.log", DIRETORIO_LOG, nomeArquivo,
                    DateUtil.dateToString(new Date(), "_dd_MM_yyyy"));

            File arquivo = new File(nomeArquivoLog);

            //verifica se o arquivo existe
            if (arquivo.exists() == false)
            {
                arquivo.createNewFile();
            }

            objSaida = new FileOutputStream(arquivo, true);

            //constroe a mensagem de erro
            StringBuilder msgErro = new StringBuilder();
            msgErro.append(erro.getClass().getName());

            StackTraceElement[] traces = erro.getStackTrace();

            for (StackTraceElement trace : traces)
            {
                msgErro.append(String.format("\n\tat %s", trace));
            }

            String erroLog = String.format("%s: %s \n %s",
                    DateUtil.dateToString(new Date(), "dd/MM/yyyy HH:mm:ss"), erro.getMessage(), msgErro);
            erroLog += "\n----------------------------------------------------------------\n";

            objSaida.write(erroLog.getBytes());
            objSaida.close();
        }
        catch (Exception ex)
        {
            System.out.println("Erro .. ");
        }
    }    
    
}
