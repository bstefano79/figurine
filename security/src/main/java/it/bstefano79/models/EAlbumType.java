package it.bstefano79.models;

import java.util.Arrays;

public enum EAlbumType {
	GENERICO("GENERICO"), SPORT("SPORT"), SERIE_TV("SERIE_TV"), CARTONI("CARTONI"), CALCIO("CALCIO");
	
	String value;
	
	private EAlbumType(String value){
		this.value=value;
	}
	
	public static EAlbumType getEAlbumTypeFromString(String name) {
		
		for (EAlbumType t : Arrays.asList(EAlbumType.values())) {
			if(t.value.equals(name)){
				return t;
			}
		}
		return null;
	}
}
