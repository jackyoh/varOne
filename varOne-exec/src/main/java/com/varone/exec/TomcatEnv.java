package com.varone.exec;

import java.io.File;

import com.varone.web.util.VarOneEnv;

public class TomcatEnv {
	public static String WEBAPPROOTNAME = "varOne-web";
	public static String WAR = "war";
	public static String TEMPJAR = "jar";
	public static String TOMCATCONF = "tomcatconf";
	
	public File getVarOneWarPath(){
		File warPath = new File(this.getVarOneHomePath(), WAR);
		return warPath;
	}
	
	public File createVarOneWarPath(){
		File warPath = getVarOneWarPath();
		this.mkdir(warPath);
		return warPath;
	}
	
	public File getVarOneTempJarPath(){
		File jarPath = new File(this.getVarOneHomePath(), TEMPJAR);
		return jarPath;
	}
	
	public File createVarOneTempJarPath(){
		File jarPath = getVarOneTempJarPath();
		this.mkdir(jarPath);
		return jarPath;
	}
	
	public File getVarOneTempTomcatConf(){
		File confPath = new File(this.getVarOneHomePath(), TOMCATCONF);
		return confPath;
	}
	
	public File createVarOneTempTomcatConfPath(){
		File tomcatConfPath = getVarOneTempTomcatConf();
		this.mkdir(tomcatConfPath);
		return tomcatConfPath;
	}
	
	public String getVarOneHomePath(){
		VarOneEnv varOneEnv = new VarOneEnv();
		return varOneEnv.getVarOneHomePath().getAbsolutePath();
	}
	
	private void mkdir(File folderPath){
		if(!folderPath.exists()){
			folderPath.mkdir();
		}
	}

}