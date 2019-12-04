package util;




import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge
 */
public class PostgresRestore {
    JFileChooser open; 
    final List<String> comandos = new ArrayList<String>(); 
    public PostgresRestore()
    {
        open = new JFileChooser(new File("C:/BKPRESARGUD")); 
            int op = open.showOpenDialog(null);   
            if(op == JFileChooser.APPROVE_OPTION){
               File arq = open.getSelectedFile(); 
               String nomeDoArquivo = open.getName(arq);//aqui pega somente o nome do arquivo
               //String pathDoArquivo = arq.toString(); //aqui pega o caminho do backup  
                      //aqui você testa se a string recebeu o caminho do arquivo   
           final List<String> comandos = new ArrayList<String>();      
           comandos.add("C:\\Program Files\\PostgreSQL\\12\\bin\\pg_restore.exe");
           //comandos.add("C:\\Program Files (x86)\\PostgreSQL\\9.4\\bin\\pg_restore.exe");
           //comandos.add("C:\\Program Files\\PostgreSQL\\9.2\\bin\\pg_restore.exe");  //cecom win 7
           //comandos.add("C:\\Arquivos de programas\\PostgreSQL\\9.4\\bin\\pg_restore.exe");  // windows XP notebook
           
           //comandos.add("C:\\Arquivos de programas\\PostgreSQL\\9.2\\bin\\pg_restore.exe");
           //comandos.add("DROP SCHEMA public CASCADE;"); 
           //comandos.add("-i");      
           comandos.add("-h");      
           comandos.add("localhost");      
           comandos.add("-p");      
           comandos.add("5432");      
           comandos.add("-U");      
           comandos.add("postgres");
           comandos.add("-c");
           comandos.add("-d");
           comandos.add("teste");     
           comandos.add("-v");      
             
           //comandos.add("C:\\BOHib3.6.4\\Backups do Banco de Dados\\bkpBolOcor04102012.backup");   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.  
           comandos.add("C:\\BKPARGUD\\"+nomeDoArquivo);
           ProcessBuilder pb = new ProcessBuilder(comandos);      
           pb.environment().put("PGPASSWORD", "java");        
           try {      
               final Process process = pb.start();      
               final BufferedReader r = new BufferedReader(      
                   new InputStreamReader(process.getErrorStream()));      
               String line = r.readLine();      
               while (line != null) {      
               System.err.println(line);      
               line = r.readLine();    
               
               }      
               r.close();      
               
               process.waitFor();    
               process.destroy();                
         JOptionPane.showMessageDialog(null,"Restauração realizado com sucesso!");
           } catch (IOException e) {      
               e.printStackTrace();      
           } catch (InterruptedException ie) {      
               ie.printStackTrace();      
           }         
            } else{
                
            }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                PostgresRestore execRestore = new PostgresRestore();
            }
        });
    }
    
}
