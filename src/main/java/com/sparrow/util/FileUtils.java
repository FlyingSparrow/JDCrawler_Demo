package com.sparrow.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.apache.commons.lang3.StringUtils;

import com.sparrow.constants.SysConst;

public class FileUtils {

	private FileUtils(){}
	
	/**
	 * 使用指定的字符集读取文件的内容并返回
	 * 说明：如果指定的字符集为空，那么默认将使用UTF-8字符集读取文件内容
	 * @param file
	 * @param charset
	 * @return
	 */
	public static String readFile(File file, String charset){
		StringBuilder sd = new StringBuilder();
		BufferedReader br = null;
		try {
			if(file != null && file.isFile()){
				String line = null;
				if(StringUtils.isNotBlank(charset)){
					br = new BufferedReader(new InputStreamReader(new FileInputStream(file), 
							charset));
				}else{
					br = new BufferedReader(new InputStreamReader(new FileInputStream(file), 
							SysConst.ENCODING_UTF_8));
				}
				while ((line = br.readLine()) != null) {
					sd.append(line);
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null){
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sd.toString();
	}
	
	/**
	 * 使用指定的字符集读取输入流的内容并返回
	 * 说明：如果指定的字符集为空，那么默认将使用UTF-8字符集读取文件内容
	 * @param inputStream
	 * @param charset
	 * @return
	 */
	public static String readContent(InputStream inputStream, String charset){
		StringBuilder sd = new StringBuilder();
		BufferedReader br = null;
		try {
			if(inputStream != null){
				String line = null;
				if(StringUtils.isNotBlank(charset)){
					br = new BufferedReader(new InputStreamReader(inputStream, charset));
				}else{
					br = new BufferedReader(new InputStreamReader(inputStream, SysConst.ENCODING_UTF_8));
				}
				while ((line = br.readLine()) != null) {
					sd.append(line);
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null){
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sd.toString();
	}
	
	/**
	 * 将内容写到文档中，如果文件为空或者内容为空，那么不会执行写入操作
	 * @param file
	 * @param data
	 */
	public static void writeFile(File file, String data) {
		FileOutputStream out = null;
		try {
			if(file != null && StringUtils.isNotBlank(data)){
				out = new FileOutputStream(file);
				out.write(data.getBytes());
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != out) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 将内容使用指定的字符集写到文档中，如果文件为空或者内容为空，那么不会执行写入操作
	 * 说明：如果指定的字符集为空，那么默认将使用UTF-8字符集写入文件内容
	 * @param file
	 * @param data
	 * @param charset
	 */
	public static void writeFile(File file, String data, String charset) {
		Writer writer = null;
		try {
			if(file != null && StringUtils.isNotBlank(data)){
				if(StringUtils.isNotBlank(charset)){
					writer = new BufferedWriter(new OutputStreamWriter(
							new FileOutputStream(file), charset));
				}else{
					writer = new BufferedWriter(new OutputStreamWriter(
							new FileOutputStream(file), SysConst.ENCODING_UTF_8));
				}
				writer.write(data);
				writer.flush();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != writer) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * <p>Description: 将指定的数据写入到指定的输出流中</p>
	 * @param os
	 * @param data
	 * @param chartset
	 * @author wjc
	 * @date 2017年2月7日
	 */
	public static void write(OutputStream os, String data, String chartset){
		OutputStreamWriter writer = null;
		try {
			writer = new OutputStreamWriter(os, chartset);
			if (data == null)
				data = "";
			writer.write(data);
			writer.flush();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void write(OutputStream os, String data){
		BufferedOutputStream out = null;
		try {
			out = new BufferedOutputStream(os);
			out.write(data.getBytes());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(out != null){
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
