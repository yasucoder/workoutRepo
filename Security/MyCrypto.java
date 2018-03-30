package security;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.HashMap;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MyCrypto {
	private static final int BUFF_LEN = 256;
	private static final int CLEARTEXT = Cipher.DECRYPT_MODE;
	private static final String AES_ALGO = "AES";
	private static final String OUT_PLAIN = "_PLAIN";
	private static final String OUT_CRYPT = "_CRYPT";
	private static final String DOT = ".";
	private static final String AES_CBC_PKCS5_PADDING = "AES/CBC/PKCS5Padding";
	private static final String REF_OUT = "RefUtil.txt";
	private static final String DEF_EXTN = ".txt";
	private ArrayList randomNamesList = null;
	public HashMap inputMap = null;
	

	/**
	 * 
	 * @param fileName
	 * @param mode
	 * @return
	 * @throws IOException
	 */
	public InputStream crypt(final String keyfile, final String fileName,
			final int mode) throws IOException {

		Cipher cipher;
		SecretKeySpec skeySpec = null;
		String key = getKey(keyfile);
		AlgorithmParameterSpec paramSpec = getSpec();
		InputStream in = getInputStream(fileName);
		InputStream inputStream = null;

		try {
			skeySpec = getKeySpec(key);
			cipher = getCipher(skeySpec, paramSpec, mode);
			inputStream = getStream(in, cipher);

		} catch (Exception exception) {
			System.out.println(exception.toString());
		}
		return inputStream;
	}

	private InputStream getInputStream(String fileName)
			throws FileNotFoundException {
		File inputFile = new File(fileName);
		return new FileInputStream(inputFile);
	}

	/**
	 * Method to get the input
	 * 
	 * @param in
	 * @param cipher
	 * @return
	 */
	private InputStream getStream(InputStream in, Cipher cipher) {
		InputStream inputStream = new CipherInputStream(in, cipher);
		return inputStream;
	}

	/**
	 * Method to get the cipher text
	 * 
	 * @param skeySpec
	 * @param paramSpec
	 * @param mode
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 */
	private Cipher getCipher(SecretKeySpec skeySpec,
			AlgorithmParameterSpec paramSpec, int mode)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, InvalidAlgorithmParameterException {

		Cipher cipher;

		// Initializes the Cipher Instance based on the Agent Type
		java.security.Security.insertProviderAt(
				new org.bouncycastle.jce.provider.BouncyCastleProvider(), 0);
		cipher = Cipher.getInstance(AES_CBC_PKCS5_PADDING,
				new org.bouncycastle.jce.provider.BouncyCastleProvider());
		cipher.init(mode, skeySpec, paramSpec);
		return cipher;
	}

	/**
	 * 
	 * @param key
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private SecretKeySpec getKeySpec(String key)
			throws UnsupportedEncodingException {
		SecretKeySpec skeySpec;
		byte[] keyBytes = key.getBytes();
		byte[] raw = new byte[16];
		int len = getLength(key, raw);
		System.arraycopy(keyBytes, 0, raw, 0, len);
		skeySpec = new SecretKeySpec(raw, AES_ALGO);
		return skeySpec;
	}

	/**
	 * 
	 * @param key
	 * @param raw
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private int getLength(String key, byte[] raw)
			throws UnsupportedEncodingException {
		byte[] keyBytes = key.getBytes();
		int len = keyBytes.length;
		if (len > raw.length) {
			len = raw.length;
		}
		return len;
	}

	/**
	 * 
	 * @return
	 */
	private AlgorithmParameterSpec getSpec() {
		// Create an 8-byte initialization vector
		byte[] iv = new byte[] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06,
				0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f };
		IvParameterSpec IVspec = new IvParameterSpec(iv);
		return IVspec;

	}

	/**
	 * 
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private String getKey(final String keyFilenm) throws FileNotFoundException,
			IOException {
		String key = "";
		String key1;
		File keyFile = new File(keyFilenm);
		BufferedReader keyInputbr = new BufferedReader(new FileReader(keyFile));
		while ((key1 = keyInputbr.readLine()) != null) {
			key = key1.trim();
		}
		keyInputbr.close();
		return key;
	}

	/**
	 * 
	 * @param bfr
	 * @throws IOException
	 */
	public void print(InputStream inputStream) throws IOException {

		byte[] buffer = new byte[BUFF_LEN];
		int bytesread = -1;
		StringBuffer sbuffer = new StringBuffer();

		while ((bytesread = inputStream.read(buffer)) != -1) {
			if (bytesread == BUFF_LEN) {
				sbuffer.append(new String(buffer));
			} else {
				sbuffer.append(new String(buffer, 0, bytesread));
			}
		}

		// StringTokenizer strTokens = new StringTokenizer(sbuffer.toString(),
		// "\n");
		String strTokens[] = sbuffer.toString().split("\n");

		boolean isStd = false;
		randomNamesList = new ArrayList();
		inputMap = new HashMap();

		/*
		 * System.out.println(sbuffer.toString());
		 * System.out.println(sbuffer.toString().length());
		 */int tokenlen = strTokens.length;
		for (int i = 0; i < tokenlen; i++) {
			if (isStd || strTokens[i].indexOf("====") == -1) {
				randomNamesList.add(strTokens[i].trim());
				isStd = true;
			} else {
				String[] arr = strTokens[i].split("====");
				inputMap.put(arr[0], arr[1]);
				isStd = false;
			}
		}

	}

	public void printToFile(InputStream inputStream, String fPath,
			String inFile, int mode) throws IOException {
		String outFile = getOutputFileName(inFile, mode);

		File outputFile = new File(fPath + File.separator + outFile);
		FileOutputStream foutStream = new FileOutputStream(outputFile);

		byte[] buffer = new byte[BUFF_LEN];
		int bytesread = -1;

		while ((bytesread = inputStream.read(buffer)) != -1) {
			if (bytesread == BUFF_LEN) {
				foutStream.write(buffer);
			} else {
				foutStream.write(buffer, 0, bytesread);
			}
			foutStream.flush();
		}

		if (foutStream != null) {
			foutStream.close();
		}

	}

	private String getOutputFileName(String inFile, int mode) {
		String outFile = REF_OUT;
		int extensionIndex = inFile.indexOf(DOT);
		if (mode == CLEARTEXT) {
			outFile = inFile.substring(0, extensionIndex) + OUT_PLAIN
					+ DEF_EXTN;
		} else {
			outFile = inFile.substring(0, extensionIndex) + OUT_CRYPT
					+ DEF_EXTN;
		}
		return outFile;
	}

	/**
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void encrypt(String keyFile, String fPath, String fname,
			int cipherMode) throws FileNotFoundException, IOException {

		MyCrypto util = new MyCrypto();
		InputStream inputStream = util.crypt(keyFile, fPath
				+ File.separator + fname, cipherMode);

		util.printToFile(inputStream, fPath, fname, cipherMode);
		if (inputStream != null) {
			inputStream.close();
		}
	}
	
	public static void main(String[] args) {
		try {
			MyCrypto.encrypt("C:\\key.txt", "C:\\data", "dataFile.txt", Cipher.ENCRYPT_MODE);
			MyCrypto.encrypt("C:\\key.txt", "C:\\data", "dataFile_CRYPT.txt", Cipher.DECRYPT_MODE);
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
