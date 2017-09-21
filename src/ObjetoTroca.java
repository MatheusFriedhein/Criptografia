import java.io.Serializable;
import java.security.PublicKey;

import javax.crypto.SecretKey;

public class ObjetoTroca implements Serializable {
	
	private  byte [] arquivo;
	private String nomeArquivo;
	private PublicKey ChaveSecreta;
	private byte[] chaveSessaoCifrada;
	
	public byte[] getChaveSessaoCifrada() {
		return chaveSessaoCifrada;
	}
	public void setChaveSessaoCifrada(byte[] chaveSessaoCifrada) {
		this.chaveSessaoCifrada = chaveSessaoCifrada;
	}
	public PublicKey getChaveSecreta() {
		return ChaveSecreta;
	}
	public void setChaveSecreta(PublicKey chaveSecreta) {
		ChaveSecreta = chaveSecreta;
	}
	public byte[] getArquivo() {
		return arquivo;
	}
	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}
	
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
}
