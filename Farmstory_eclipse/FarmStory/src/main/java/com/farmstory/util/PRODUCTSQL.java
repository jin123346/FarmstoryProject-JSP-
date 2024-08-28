package com.farmstory.util;

public class PRODUCTSQL {


	//product
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//file
	
	public final static String Select_List_File_fno = "select pList_fNo from pListimgfile where pno=?";
	
	public final static String Select_basic_File_fno = "select pBasic_fNo from pBasicimgfile where pno=?";

	public final static String Select_Desc_File_fno = "select pDesc_fNo from pDescimgfile where pno=?";

	public final static String INSERT_LIST_IMG_FILE= "insert into `pListImgFile` set pno=?, pList_oName =? , pList_sName=?, rdate = now()";
	public final static String INSERT_BASIC_IMG_FILE= "insert into `pBasicImgFile` set pno=?, pBasic_oName =? , pBasic_sName=?, rdate = now()";
	public final static String INSERT_DESC_IMG_FILE= "insert into `pDescImgFile` set pno=?, pDesc_oName =? , pDesc_sName=?, rdate = now()";
	

}
