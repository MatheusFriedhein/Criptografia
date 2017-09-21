
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Descriptografia implements Serializable {



    public static void main(String[] args) throws Exception {

    	//CRIA A CONEXAO
    	ServerSocket ss = new ServerSocket(3233);
    	Socket s = ss.accept();
    	InputStream in = s.getInputStream();
    	
    	// manda para criptografia o socket
    	OutputStream out = s.getOutputStream();
    	System.out.println("Criando o par de chaves...");
    			
    	
    	//GERA O PAR DE CHAVES PARA O ALGORITMO RSA
    	KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(2048);
		
		//PAR DE CHAVES
		KeyPair kp = kpg.generateKeyPair();
		System.out.println("Par de Chaves Criado...");
		
		//ENVIA CHAVE PUBLICA
		ObjetoTroca obj = new ObjetoTroca();
		obj.setChaveSecreta(kp.getPublic());
	    ObjectOutputStream out1 = new  ObjectOutputStream (out);
		out1.writeObject(obj);
		System.out.println("Chave pública enviada...");
		out1.flush();

		ObjectInputStream recebe = new ObjectInputStream(in);
		
    	ObjetoTroca recebeobj= (ObjetoTroca) recebe.readObject();
    	
    	/*Cipher cipher = Cipher.getInstance("RSA");
    	cipher.init(Cipher.DECRYPT_MODE, kp.getPrivate());//pega a chave privada para decriptar
    	byte[] descriptografado = cipher.doFinal(recebeobj.getArquivo());
  
    	
    	SecretKeySpec spec = new SecretKeySpec(barrayChaveDecifrada, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, spec);
		byte[] barrayMensagemDecifrada = cipher.doFinal(recebeObj.);

    	
    	
    	File file = new File(obj.getNomeArquivo());
    	FileOutputStream fout = new FileOutputStream(new File(recebeobj.getNomeArquivo()));
    	
    	fout.write(descriptografado);
    	fout.close();
    	//recebe.close();
    	s.close();
    	
    	System.out.println("SERVIDOR recebeu e escreveu o arquivo"+ obj.getNomeArquivo( )); */
    } 

}