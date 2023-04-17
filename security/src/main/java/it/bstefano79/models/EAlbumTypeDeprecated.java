package it.bstefano79.models;

import java.util.Arrays;

@Deprecated
public enum EAlbumTypeDeprecated {
	GENERICO("GENERICO"), SPORT("SPORT"), SERIE_TV("SERIE_TV"), CARTONI("CARTONI"), CALCIO("CALCIO");
	
	String value;
	
	private EAlbumTypeDeprecated(String value){
		this.value=value;
	}
	
	public static EAlbumTypeDeprecated getEAlbumTypeFromString(String name) {
		
		for (EAlbumTypeDeprecated t : Arrays.asList(EAlbumTypeDeprecated.values())) {
			if(t.value.equals(name)){
				return t;
			}
		}
		return null;
	}
}
