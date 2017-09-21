

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
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Criptografia  implements Serializable{

    

    public static void main(String[] args) throws IOException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, ClassNotFoundException {

		
    
		
		//CRIA SOCKET NA PORTA 3333
		Socket s = new Socket("localhost", 3233);
		System.out.println("Conectado... à Aguardando Chave Pública....");

		
		        //  Recebe a chave pública
				InputStream in = s.getInputStream();
				ObjectInputStream oin = new ObjectInputStream(in);
				ObjetoTroca obj = (ObjetoTroca) oin.readObject();
				System.out.println("Chave Pública Recebida");
		
				//  cria a chave simétrica AES
				KeyGenerator keyG = KeyGenerator.getInstance("DES");
				keyG.init(2048);
				SecretKey chaveSessao = keyG.generateKey();

				
				//CIFRA A CHAVE SIMETRICA COM RSA
				/*Cipher rsaCipher = Cipher.getInstance("RSA");
				rsaCipher.init(Cipher.ENCRYPT_MODE, obj.getChaveSecreta());
				byte[] chaveSessaoCifrada = rsaCipher.doFinal(chaveSessao.getEncoded());
		
				JFileChooser jfc = new JFileChooser();		
				int returnVal = jfc.showOpenDialog(new JFrame());
				
				
		if(returnVal == JFileChooser.APPROVE_OPTION){
			File fc = jfc.getSelectedFile();
			JOptionPane.showMessageDialog(new JFrame(), fc.toString());
			
			FileInputStream fin = new FileInputStream(fc);
			byte[] arquivo = new byte[(int) fin.getChannel().size()];
			fin.read(arquivo);
			
			KeyGenerator keyGen = KeyGenerator.getInstance("RSA");
			SecretKey key = keyGen.generateKey();
			
			//CIFRA O ARQUIVO com  a chave da sessao
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, chaveSessao);
			byte[] criptografado = cipher.doFinal(arquivo);
			
			
			//ENVIAR O ARQUIVO CIFRADO
            ObjetoTroca obj2 = new ObjetoTroca();
			obj2.setArquivo(criptografado);
			obj2.setChaveSessaoCifrada(chaveSessaoCifrada);
			obj2.setNomeArquivo(fc.getName());
			//obj2.setChaveSecreta(key);
			
			ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
			
			/*
			
			//---------------------AULA DIA 29-------------------------------------
			
			//Socket s = new Socket("localhost", 3333);

			//ObjetoTroca obj = new ObjetoTroca();
			
			//obj.setArquivo(criptografado);
			//obj.setChaveSecreta(key);
			//obj.setNomeArquivo(fc.getName());
			
			//ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
			
			//----- FECHANDO CONEXAO / ESVAZIANDO BUFFER
			
			out.writeObject(obj2);
			out.close();
			s.close();
			fin.close(); 
		}*/
      }
   }

